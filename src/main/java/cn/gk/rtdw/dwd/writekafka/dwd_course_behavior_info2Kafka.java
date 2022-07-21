package cn.gk.rtdw.dwd.writekafka;

import cn.gk.rtdw.dwd.sql.DWD_QuerySQL;
import cn.gk.rtdw.flinksql_cdc.CreateTableSql;
import cn.gk.rtdw.utils.FlinkUtils;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.TableEnvironment;

/**
 * @Author: qyw
 * @Date: 2022/07/21
 **/
public class dwd_course_behavior_info2Kafka {
    public static void main(String[] args) throws Exception {
        // TODO 设置表环境的配置
        EnvironmentSettings settings = EnvironmentSettings.newInstance()
                .inStreamingMode()
                .useBlinkPlanner()
                .build();

        TableEnvironment tableEnv = TableEnvironment.create(settings);

        // TODO 注册表
        tableEnv.executeSql(CreateTableSql.create_mdl_logstore_standard_log);

        //  注册函数

        // TODO

        tableEnv.executeSql(
                "CREATE TABLE sink_kafka15 ( " +
                        "  courseid bigint,               " +
                        "  week1 bigint,                  " +
                        "  week2 bigint,                  " +
                        "  week3 bigint,                  " +
                        "  week4 bigint,                  " +
                        "  week5 bigint,                  " +
                        "  week6 bigint,                  " +
                        "  week7 bigint,                  " +
                        "  hour1 bigint,                  " +
                        "  hour2 bigint,                  " +
                        "  hour3 bigint,                  " +
                        "  hour4 bigint,                  " +
                        "  hour5 bigint,                  " +
                        "  hour6 bigint,                  " +
                        "  hour7 bigint,                  " +
                        "  hour8 bigint,                  " +
                        "  hour9 bigint,                  " +
                        "  hour10 bigint,                 " +
                        "  hour11 bigint,                 " +
                        "  hour12 bigint,                 " +
                        "  hour13 bigint,                 " +
                        "  hour14 bigint,                 " +
                        "  hour15 bigint,                 " +
                        "  hour16 bigint,                 " +
                        "  hour17 bigint,                 " +
                        "  hour18 bigint,                 " +
                        "  hour19 bigint,                 " +
                        "  hour20 bigint,                 " +
                        "  hour21 bigint,                 " +
                        "  hour22 bigint,                 " +
                        "  hour23 bigint,                 " +
                        "  hour24 bigint,                  " +
                        "  PRIMARY KEY (courseid) NOT ENFORCED " +
                        ") with ( " +
                        "  'connector' = 'upsert-kafka',  " +
                        "  'topic' = 'dwd_course_behavior_info'," +
                        "  'properties.bootstrap.servers' = '192.168.42.126:9092,192.168.42.109:9092,192.168.42.133:9092', " +
                        "  'sink.parallelism' = '3'," +
                        "  'key.format' = 'json'," +
                        "  'value.format' = 'json' " +
                        ")"
        );

        tableEnv.executeSql(DWD_QuerySQL.dwd_course_behavior_info);

        FlinkUtils.env.execute();
    }
}
