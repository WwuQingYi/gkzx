package cn.gk.rtdw.dwd.sql;

/**
 * @Date：2022/7/5
 * @Description：创建查询需要的视图
 */
public class DWD_QuerySQL {

    public static String dwd_student_choose_course =
            " insert into sink_kafka " +
                    "SELECT                                  " +
                    "   u.id        AS user_id,               " +
                    "   u.username  AS student_number,        " +
                    "   co.id       AS course_id,             " +
                    "   co.idnumber AS course_code            " +
                    " FROM                                    " +
                    " (SELECT contextid, userid FROM mdl_role_assignments WHERE roleid = 5) AS ra                     " +
                    "     JOIN                                                                                        " +
                    " (SELECT id, instanceid FROM mdl_context WHERE contextlevel = 50) AS cn                          " +
                    " ON ra.contextid = cn.id                                                                         " +
                    "     JOIN                                                                                        " +
                    " (SELECT id, username FROM mdl_user WHERE str_length(username) = 13 GROUP BY id, username) AS u  " +
                    " ON u.id = ra.userid                                                                             " +
                    "     JOIN                                                                                        " +
                    " (SELECT id,idnumber FROM mdl_course WHERE str_length(idnumber) = 5) AS co                       " +
                    " ON cn.instanceid = co.id                                                                        ";

}
