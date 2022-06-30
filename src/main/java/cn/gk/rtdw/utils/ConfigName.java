package cn.gk.rtdw.utils;


/**
 * @Date: 2022/06/30
 * @Description: 配置文件封装类, 参数名统一管理
 */
public class ConfigName {

    // TODO flink的配置
    public static final String FLINK_JOB_CHECKPOINT_INTERVAL = "flink.checkpoint.interval";
    public static final String FLINK_JOB_RESTART_NUMBER = "flink.job.restart_attempts";
    public static final String FLINK_JOB_FAILURE_INTERVAL_TIME = "flink.job.failure.interval";
    public static final String FLINK_JOB_DELAY_INTERVAL_TIME = "flink.job.delay.interval";
    public static final String FLINK_JOB_TWO_CHECKPOINT_BETWEEN_TIME = "flink.job.minPauseBetweenCheckpoints";
    public static final String FLINK_CHECKPOINT_DIR = "flink.checkpoint.dir";
    public static final String FLINK_CHECKPOINT_TIMEOUT = "flink.checkpoint.timeout";
    public static final String FLINK_CHECKPOINT_FAILURE_NUMBER = "flink.checkpoint.failure.number";
    public static final String FLINK_MAX_CONCURRENT_CHECKPOINTS = "flink.max.concurrent.checkpoints";
    public static final String FLINK_ENABLE_INCREMENTAL_CHECKPOINTING = "flink.enable.incremental.checkpointing";

    // TODO kafka的配置
    public static final String KAFKA_BOOTSTRAP_SERVERS = "kafka.bootstrap.servers";
    public static final String KAFKA_TABLE_OFFSET_EARLIEST = "kafka.table.offset.reset";
    public static final String KAFKA_OFFSET_EARLIEST = "kafka.auto.offset.reset";
    public static final String KAFKA_GROUP_ID = "kafka.group.id";
    public static final String SQL_KAFKA_GROUP_ID = "sql.kafka.group.id";


    // TODO redis的配置
    public static final String REDIS_HOST = "redis.host";
    public static final String REDIS_PORT = "redis.port";
    public static final String REDIS_PASSWORD = "redis.password";
    public static final String REDIS_SELECT_DB = "redis.select.db";

    // TODO clickHouse的配置
    public static final String ClickHouse_JDBC_DRIVER = "clickHouse.driver";
    public static final String ClickHouse_JDBC_URL = "clickHouse.url";
    public static final String ClickHouse_JDBC_USER = "clickHouse.user";
    public static final String ClickHouse_JDBC_PASSWORD = "clickHouse.password";
    public static final String ClickHouse_JDBC_BatchIntervalMs = "clickHouse.intervalMs";
    public static final String ClickHouse_JDBC_BatchSize = "clickHouse.batchSize";
    public static final String ClickHouse_JDBC_MaxRetries = "clickHouse.maxRetries";


    // TODO mysql的配置
    public static final String MYSQL_JDBC_DRIVER = "mysql.driver";
    public static final String MYSQL_JDBC_URL = "mysql.url";
    public static final String MYSQL_JDBC_USER = "mysql.user";
    public static final String MYSQL_JDBC_PASSWORD = "mysql.password";

}
