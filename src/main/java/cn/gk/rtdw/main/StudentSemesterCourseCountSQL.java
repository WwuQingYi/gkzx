package cn.gk.rtdw.main;

import cn.gk.rtdw.flinksql_cdc.create_table.CreateTableSql;
import cn.gk.rtdw.query_sql.QueryResultSQLString;
import cn.gk.rtdw.utils.FlinkUtils;
import cn.gk.rtdw.view.QueryNeedView;
import org.apache.flink.api.common.RuntimeExecutionMode;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.types.Row;

/**
 * @Date：2022/7/5
 * @Description：学生学期课程完成情况统计
 */
public class StudentSemesterCourseCountSQL {
    public static void main(String[] args) throws Exception {
        // 获取 执行对象
        StreamExecutionEnvironment env = FlinkUtils.env;
        StreamTableEnvironment tableEnv = FlinkUtils.getTableEnv();

        // TODO 设置运行模式 STREAMING, BATCH, AUTOMATIC
        env.setRuntimeMode(RuntimeExecutionMode.BATCH);

        // 注册表
        tableEnv.executeSql(QueryNeedView.create_view_student_course);
        tableEnv.executeSql(QueryNeedView.create_view_behavior);
        tableEnv.executeSql(QueryNeedView.create_view_forum);
        tableEnv.executeSql(QueryNeedView.create_view_student_login_details);
        tableEnv.executeSql(QueryNeedView.create_view_behavior_browse);
        tableEnv.executeSql(QueryNeedView.create_view_behavior_browse);
        tableEnv.executeSql(CreateTableSql.create_mdl_groups);

        // 执行查询
        Table sqlQuery = tableEnv.sqlQuery(QueryResultSQLString.studentSemesterCourseCount);

        tableEnv.toRetractStream(sqlQuery, Row.class).print();

        env.execute();

    }
}
