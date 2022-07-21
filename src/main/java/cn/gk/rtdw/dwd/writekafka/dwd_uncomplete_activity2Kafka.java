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
public class dwd_uncomplete_activity2Kafka {
    public static void main(String[] args) throws Exception {
        // TODO 设置表环境的配置
        EnvironmentSettings settings = EnvironmentSettings.newInstance()
                .inStreamingMode()
                .useBlinkPlanner()
                .build();

        TableEnvironment tableEnv = TableEnvironment.create(settings);

        // TODO 注册表
        tableEnv.executeSql(CreateTableSql.create_mdl_logstore_standard_log);
//        tableEnv.executeSql(QueryNeedView.dwd_student_choose_course_info);
//        tableEnv.executeSql(QueryNeedView.dwd_uncomp_activity_uv);

        // TODO 注册函数

        // TODO
        tableEnv.executeSql(
                "CREATE TABLE sink_kafka18 ( " +
                        "courseid bigint,"+
                        "NoCompleteActivityCount bigint,"+
                         "PRIMARY KEY (course_id) NOT ENFORCED " +
                        ") with ( " +
                        "  'connector' = 'upsert-kafka',  " +
                        "  'topic' = 'dwd_uncomplete_activity'," +
                        "  'properties.bootstrap.servers' = '192.168.42.126:9092,192.168.42.109:9092,192.168.42.133:9092', " +
                        "  'sink.parallelism' = '3'," +
                        "  'key.format' = 'json'," +
                        "  'value.format' = 'json' " +
                        ")"
        );


        tableEnv.executeSql(DWD_QuerySQL.dwd_uncomplete_activity);

        FlinkUtils.env.execute();
    }
}
