package cn.gk.rtdw.flinksql_cdc;

import cn.gk.rtdw.query_sql.QuerySQL;
import cn.gk.rtdw.tools.CreateTableSql;
import cn.gk.rtdw.utils.*;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.types.Row;


/**
 * @Date：2022/6/30
 * @Description： flink-cdc-sql 解析数据
 */
public class FlinkSql_AnalysisData {
    public static void main(String[] args) throws Exception {

        // 获取 执行对象
        StreamExecutionEnvironment env = FlinkUtils.env;
        StreamTableEnvironment tableEnv = FlinkUtils.getTableEnv();

        /**
         * 解析mysql表
         */

        tableEnv.executeSql(CreateTableSql.create_mdl_groups); // mdl_groups
        Table mdl_groupSqlQuery = tableEnv.sqlQuery("select * from mdl_groups");
        tableEnv.toRetractStream(mdl_groupSqlQuery, Row.class).print();


        tableEnv.executeSql(CreateTableSql.create_mdl_course_modules_completion); // mdl_course_modules_completion
        Table mdl_course_modules_completionSqlQuery = tableEnv.sqlQuery("select * from mdl_course_modules_completion");
        tableEnv.toRetractStream(mdl_course_modules_completionSqlQuery, Row.class).print();


        tableEnv.executeSql(CreateTableSql.create_mdl_course_modules);   // mdl_course_modules
        Table mdl_course_modules_SqlQuery = tableEnv.sqlQuery("select * from mdl_course_modules");
        tableEnv.toRetractStream(mdl_course_modules_SqlQuery, Row.class).print();


        tableEnv.executeSql(CreateTableSql.create_mdl_course);   // mdl_course_modules
        Table mdl_course_SqlQuery = tableEnv.sqlQuery("select * from mdl_course");
        tableEnv.toRetractStream(mdl_course_SqlQuery, Row.class).print();


        tableEnv.executeSql(CreateTableSql.create_mdl_logstore_standard_log);   // mdl_logstore_standard_log
        Table mdl_logstore_standard_log_SqlQuery = tableEnv.sqlQuery("select * from mdl_logstore_standard_log");
        tableEnv.toRetractStream(mdl_logstore_standard_log_SqlQuery, Row.class).print();


        tableEnv.executeSql(CreateTableSql.create_mdl_forum_posts);   // mdl_forum_posts
        Table mdl_forum_posts_SqlQuery = tableEnv.sqlQuery("select * from mdl_forum_posts");
        tableEnv.toRetractStream(mdl_forum_posts_SqlQuery, Row.class).print();


        tableEnv.executeSql(CreateTableSql.create_mdl_forum_discussions);   // mdl_forum_discussions
        Table mdl_forum_discussions_SqlQuery = tableEnv.sqlQuery("select * from mdl_forum_discussions");
        tableEnv.toRetractStream(mdl_forum_discussions_SqlQuery, Row.class).print();


        tableEnv.executeSql(CreateTableSql.create_mdl_forum);   // mdl_forum
        Table mdl_forum_SqlQuery = tableEnv.sqlQuery("select * from mdl_forum");
        tableEnv.toRetractStream(mdl_forum_SqlQuery, Row.class).print();


        tableEnv.executeSql(CreateTableSql.create_mdl_user);   // mdl_user
        Table mdl_user_SqlQuery = tableEnv.sqlQuery("select * from mdl_user");
        tableEnv.toRetractStream(mdl_user_SqlQuery, Row.class).print();


        tableEnv.executeSql(CreateTableSql.create_mdl_role_assignments);   // mdl_role_assignments
        Table mdl_role_assignments_SqlQuery = tableEnv.sqlQuery("select * from mdl_role_assignments");
        tableEnv.toRetractStream(mdl_role_assignments_SqlQuery, Row.class).print();


        tableEnv.executeSql(CreateTableSql.create_mdl_context);   //  mdl_context
        Table mdl_context_SqlQuery = tableEnv.sqlQuery("select * from mdl_context");
        tableEnv.toRetractStream(mdl_forum_posts_SqlQuery, Row.class).print();


        tableEnv.executeSql(CreateTableSql.create_mdl_grade_grades);   //  mdl_grade_grades
        Table mdl_grade_grades_SqlQuery = tableEnv.sqlQuery("select * from mdl_grade_grades");
        tableEnv.toRetractStream(mdl_grade_grades_SqlQuery, Row.class).print();


        tableEnv.executeSql(CreateTableSql.create_mdl_grade_items);   //  mdl_grade_items
        Table mdl_grade_items_SqlQuery = tableEnv.sqlQuery("select * from mdl_grade_items");
        tableEnv.toRetractStream(mdl_grade_items_SqlQuery, Row.class).print();


        tableEnv.executeSql(CreateTableSql.create_mdl_groups_members);   //  mdl_groups_members
        Table mdl_groups_members_SqlQuery = tableEnv.sqlQuery("select * from mdl_groups_members");
        tableEnv.toRetractStream(mdl_groups_members_SqlQuery, Row.class).print();


        tableEnv.executeSql(CreateTableSql.create_mdl_assign);   //  mdl_assign
        Table mdl_assign_SqlQuery = tableEnv.sqlQuery("select * from mdl_assign");
        tableEnv.toRetractStream(mdl_assign_SqlQuery, Row.class).print();


        tableEnv.executeSql(CreateTableSql.create_mdl_assign_submission);   //  mdl_assign_submission
        Table mdl_assign_submission_SqlQuery = tableEnv.sqlQuery("select * from mdl_assign_submission");
        tableEnv.toRetractStream(mdl_assign_submission_SqlQuery, Row.class).print();


        tableEnv.executeSql(CreateTableSql.create_mdl_assign_grades);   //  mdl_assign_grades
        Table mdl_assign_grades_SqlQuery = tableEnv.sqlQuery("select * from mdl_assign_grades");
        tableEnv.toRetractStream(mdl_assign_submission_SqlQuery, Row.class).print();


        tableEnv.executeSql(CreateTableSql.create_mdl_role);   //  mdl_role
        Table mdl_role_SqlQuery = tableEnv.sqlQuery("select * from mdl_role");
        tableEnv.toRetractStream(mdl_role_SqlQuery, Row.class).print();


        tableEnv.executeSql(CreateTableSql.create_mdl_page);   //  mdl_page
        Table mdl_page_SqlQuery = tableEnv.sqlQuery("select * from mdl_page");
        tableEnv.toRetractStream(mdl_page_SqlQuery, Row.class).print();


        tableEnv.executeSql(CreateTableSql.create_mdl_url);   //  mdl_url
        Table mdl_url_SqlQuery = tableEnv.sqlQuery("select * from mdl_url");
        tableEnv.toRetractStream(mdl_url_SqlQuery, Row.class).print();


        tableEnv.executeSql(CreateTableSql.create_mdl_quiz);   //  mdl_quiz
        Table mdl_quiz_SqlQuery = tableEnv.sqlQuery("select * from mdl_quiz");
        tableEnv.toRetractStream(mdl_quiz_SqlQuery, Row.class).print();


        tableEnv.executeSql(CreateTableSql.create_mdl_videofile);   //  mdl_videofile
        Table mdl_videofile_SqlQuery = tableEnv.sqlQuery("select * from mdl_videofile");
        tableEnv.toRetractStream(mdl_videofile_SqlQuery, Row.class).print();


        tableEnv.executeSql(CreateTableSql.create_mdl_quiz_attempts);   //  mdl_quiz_attempts
        Table mdl_quiz_attempts_SqlQuery = tableEnv.sqlQuery("select * from mdl_quiz_attempts");
        tableEnv.toRetractStream(mdl_quiz_attempts_SqlQuery, Row.class).print();


        tableEnv.executeSql(CreateTableSql.create_mdl_course_sections);   //  mdl_course_sections
        Table mdl_course_sections_SqlQuery = tableEnv.sqlQuery("select * from mdl_course_sections");
        tableEnv.toRetractStream(mdl_course_sections_SqlQuery, Row.class).print();


        tableEnv.executeSql(CreateTableSql.create_mdl_modules);   //  mdl_modules
        Table mdl_modules_SqlQuery = tableEnv.sqlQuery("select * from mdl_modules");
        tableEnv.toRetractStream(mdl_modules_SqlQuery, Row.class).print();

        /**   25 个表
         * mdl_course_modules_completion
         * mdl_course_modules
         * mdl_modules
         * mdl_course
         * mdl_logstore_standard_log
         * mdl_forum_posts
         * mdl_forum_discussions
         * mdl_forum
         * mdl_user
         * mdl_role_assignments
         * mdl_context
         * mdl_grade_grades
         * mdl_grade_items
         * mdl_groups
         * mdl_groups_members
         * mdl_assign
         * mdl_assign_submissions
         * mdl_assign_grades
         * mdl_role
         * mdl_page
         * mdl_url
         * mdl_quiz
         * mdl_videofile
         * mdl_quiz_attempts
         * mdl_course_sections
         */

        //   QuerySQL
        Table behavior_view = tableEnv.sqlQuery(QuerySQL.v_behavior);
        tableEnv.toRetractStream(behavior_view, Row.class).print();

        env.execute();

    }
}
