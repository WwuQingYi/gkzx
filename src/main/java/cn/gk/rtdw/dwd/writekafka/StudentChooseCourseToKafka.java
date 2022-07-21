package cn.gk.rtdw.dwd.writekafka;

import cn.gk.rtdw.custom_method.StringLength;
import cn.gk.rtdw.dwd.sql.DWD_QuerySQL;
import cn.gk.rtdw.flinksql_cdc.CreateTableSql;
import cn.gk.rtdw.utils.FlinkUtils;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.TableEnvironment;

/**
 * @Author：HT
 * @Date：2022/7/21
 * @Description：写kafka
 */
public class StudentChooseCourseToKafka {

    public static void main(String[] args) throws Exception {
        // TODO 设置表环境的配置
        EnvironmentSettings settings = EnvironmentSettings.newInstance()
                .inStreamingMode()
                .useBlinkPlanner()
                .build();

        TableEnvironment tableEnv = TableEnvironment.create(settings);


        // TODO 注册表
        tableEnv.executeSql(CreateTableSql.create_mdl_role_assignments);
        tableEnv.executeSql(CreateTableSql.create_mdl_context);
        tableEnv.executeSql(CreateTableSql.create_mdl_user);
        tableEnv.executeSql(CreateTableSql.create_mdl_course);

        //  注册函数
        tableEnv.createFunction("str_length", StringLength.class);

        // TODO kafka 接受表 注册表
        tableEnv.executeSql(
                "CREATE TABLE sink_kafka ( " +
                        "  user_id            BIGINT," +
                        "  student_number     STRING," +
                        "  course_id          BIGINT," +
                        "  course_code        STRING," +
                        "  PRIMARY KEY (user_id,course_id) NOT ENFORCED " +
                        ") with ( " +
                        "  'connector' = 'upsert-kafka',  " +
                        "  'topic' = 'dwd_student_choose_course'," +
                        "  'properties.bootstrap.servers' = '192.168.42.126:9092,192.168.42.109:9092,192.168.42.133:9092', " +
                        "  'sink.parallelism' = '3'," +
                        "  'key.format' = 'json'," +     // 主键格式
                        "  'value.format' = 'json' " +  // 数据格式
                        ")"
        );

        tableEnv.executeSql(DWD_QuerySQL.dwd_student_choose_course);

        FlinkUtils.env.execute();

    }
}
