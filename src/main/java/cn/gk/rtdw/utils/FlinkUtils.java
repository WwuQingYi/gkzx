package cn.gk.rtdw.utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.apache.flink.api.common.restartstrategy.RestartStrategies;
import org.apache.flink.api.common.serialization.DeserializationSchema;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.common.time.Time;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.contrib.streaming.state.EmbeddedRocksDBStateBackend;
import org.apache.flink.streaming.api.CheckpointingMode;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.CheckpointConfig;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;

import java.util.Properties;

/**
 * @Date：2022/6/30
 * @Description： flink 工具类
 */
public class FlinkUtils {
    // TODO  构建流处理环境对象
    public static final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

    // TODO  加载配置文件
    public static Config config = ConfigFactory.load("config.properties");

    /**
     * 获取配置参数的执行环境 env
     * 注意,需要配置到 flink-conf.yaml, 否则只有该任务生效
     */
    public static StreamExecutionEnvironment getEnv() {

        // TODO 设置用户为 hadoop 访问 hdfs
        System.setProperty("HADOOP_USER_NAME", "hadoop");

        // TODO 设置任务停掉时,保存checkpoint的目录
        env.getCheckpointConfig().enableExternalizedCheckpoints(CheckpointConfig.ExternalizedCheckpointCleanup.RETAIN_ON_CANCELLATION);

        // TODO 设置状态后端, 设置为 true 可以增量的做ck
        EmbeddedRocksDBStateBackend rocksDBStateBackend = new EmbeddedRocksDBStateBackend(config.getBoolean(ConfigName.FLINK_ENABLE_INCREMENTAL_CHECKPOINTING));

        // TODO 设置状态后端为 rocksDB
        env.setStateBackend(rocksDBStateBackend);

        // TODO 15 分钟 做一次ck , 选择 ck的模式
        // TODO 使用状态 做ck才会容错, 如果在ck之前出错,则不会容错
        env.enableCheckpointing(config.getLong(ConfigName.FLINK_JOB_CHECKPOINT_INTERVAL), CheckpointingMode.EXACTLY_ONCE);

        /**
         *  设置这个参数才有意义
         *  Checkpoint 在默认的情况下仅用于恢复失败的作业，并不保留，当程序取消时 checkpoint 就会被删除
         * 设置任务停掉时, checkpoint 仍会被保留
         * 可以将检查点的元数据信息定期写入外部系统，这样当job失败时，检查点不会被清除。这样如果job失败，可以从检查点恢复job
         * ExternalizedCheckpointCleanup.RETAIN_ON_CANCELLATION：当作业取消时，保留作业的 checkpoint。注意，这种情况下，需要手动清除该作业保留的 checkpoint。
         * ExternalizedCheckpointCleanup.DELETE_ON_CANCELLATION：当作业取消时，删除作业的 checkpoint。仅当作业失败时，作业的 checkpoint 才会被保留。
         */
        env.getCheckpointConfig().enableExternalizedCheckpoints(CheckpointConfig.ExternalizedCheckpointCleanup.RETAIN_ON_CANCELLATION);

        // TODO 状态保存在hdfs上位置 注意是一个文件夹路劲
        env.getCheckpointConfig().setCheckpointStorage(config.getString(ConfigName.FLINK_CHECKPOINT_DIR));

        // TODO 设置savepoint的存储位置 在 flink-conf.yaml中设置,或者是停掉任务时设置

        // TODO 设置重启策略  [故障率重启] 重启3次,60s内,每个5s重启一次
        env.setRestartStrategy(RestartStrategies.failureRateRestart(
                config.getInt(ConfigName.FLINK_JOB_RESTART_NUMBER),  // 3
                Time.seconds(config.getInt(ConfigName.FLINK_JOB_FAILURE_INTERVAL_TIME)), // 60
                Time.seconds(config.getInt(ConfigName.FLINK_JOB_DELAY_INTERVAL_TIME)))); // 5

        // TODO 两个 checkpoint 之间的时间间隔 1ms  设置为 100ms
        env.getCheckpointConfig().setMinPauseBetweenCheckpoints(config.getLong(ConfigName.FLINK_JOB_TWO_CHECKPOINT_BETWEEN_TIME));

        // TODO 同一时间只允许 1个 checkpoint 进行 [ck的并发数] maxConcurrentCheckpoints
        env.getCheckpointConfig().setMaxConcurrentCheckpoints(config.getInt(ConfigName.FLINK_MAX_CONCURRENT_CHECKPOINTS));

        // TODO 开启后检查点不会等待对其,提高性能[减少背压], 但是只有在精确一次的检查点并且允许的最大检查点并发数量为1的情况下才能使用
        env.getCheckpointConfig().enableUnalignedCheckpoints();

        // TODO Checkpoint 必须在60分钟内完成，否则就会被抛弃 [默认是10分钟
        env.getCheckpointConfig().setCheckpointTimeout(config.getLong(ConfigName.FLINK_CHECKPOINT_TIMEOUT));

        // TODO 允许 两个 连续的 checkpoint 错误
        env.getCheckpointConfig().setTolerableCheckpointFailureNumber(config.getInt(ConfigName.FLINK_CHECKPOINT_FAILURE_NUMBER));

        return env;
    }

    /**
     * 获取配置参数 表执行环境对象
     */
    public static StreamTableEnvironment getTableEnv() {
        // TODO 设置表环境的配置
        EnvironmentSettings settings = EnvironmentSettings.newInstance()
                .inStreamingMode()
                .useBlinkPlanner()
                .build();

        StreamTableEnvironment tableEnv = StreamTableEnvironment.create(env, settings);
        // TODO  设置table状态 5s清空一次状态 [那样的写法,ttl时间只能比查询时间短,否则会累计计算导致结果错误]
        Configuration configuration = tableEnv.getConfig().getConfiguration();

        // TODO 设置table状态 60s 清空一次
        // configuration.setString("table.exec.state.ttl", "3000");

        // TODO 防止 OOM 设置每个批次最多缓存数据的条数,可以设为 2 万条
        configuration.setString("table.exec.mini.batch.size", "50000");
        // TODO 开启 Split Distinct
        configuration.setString("table.optimizer.distinct agg.split.enabled", "true");
        // TODO 第一层打散的 bucket 数量
        configuration.setString("table.optimizer.distinct agg.split.bucket.num", "3072");

        return tableEnv;
    }

    /**
     * 获取Source kafkaConsumer
     * public static <T> DataStream<T> createKafkaDataStream(ParameterTool parameters, String topics, String groupId, Class<? extends DeserializationSchema<T>> clazz) throws Exception
     */
    public static DataStream<String> createKafkaStream(String topics, String groupID, SimpleStringSchema schema) throws Exception {
        // TODO 设置读取参数
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", config.getString(ConfigName.KAFKA_BOOTSTRAP_SERVERS));
        properties.setProperty("group.id", groupID);
        // TODO latest / earliest
        properties.setProperty("auto.offset.reset", config.getString(ConfigName.KAFKA_OFFSET_EARLIEST));

        // TODO 创建kafka的消费者
        FlinkKafkaConsumer<String> kafkaConsumer = new FlinkKafkaConsumer<>(topics, schema, properties);

        // TODO 设置不将偏移量提交到 kafka 【特殊的topic( __consumer_offsets )】
        kafkaConsumer.setCommitOffsetsOnCheckpoints(false);
        // TODO 返回结果
        return env.addSource(kafkaConsumer);
    }

    /**
     * 获取 kafkaConsumerSource
     */
    public static <T> DataStream<T> createKafkaDataStream(String topics, String groupId, Class<? extends DeserializationSchema<T>> clazz) throws Exception {
        // TODO 设置读取参数
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", config.getString(ConfigName.KAFKA_BOOTSTRAP_SERVERS));
        properties.setProperty("group.id", groupId);

        // TODO latest / earliest
        properties.setProperty("auto.offset.reset", config.getString(ConfigName.KAFKA_OFFSET_EARLIEST));

        // TODO 创建kafka的消费者
        FlinkKafkaConsumer<T> kafkaConsumer = new FlinkKafkaConsumer<>(topics, clazz.newInstance(), properties);

        // TODO 设置不将偏移量提交到 kafka 【特殊的topic( __consumer_offsets )】
        kafkaConsumer.setCommitOffsetsOnCheckpoints(false);

        return env.addSource(kafkaConsumer);
    }



}
