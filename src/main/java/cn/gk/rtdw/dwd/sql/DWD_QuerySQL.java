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

    public static String dwd_course_behavior_info =
            " insert into sink_kafka15 " +
                    " SELECT																									"+
                    "     courseid,                                                                                             "+
/*                    "     count(if(day_for_week = '1' ,timecreated,null)) week1,                                                         "+
                    "     count(if(day_for_week = '2' ,timecreated,null)) week2,                                                         "+
                    "     count(if(day_for_week = '3' ,timecreated,null)) week3,                                                         "+
                    "     count(if(day_for_week = '4' ,timecreated,null)) week4,                                                         "+
                    "     count(if(day_for_week = '5' ,timecreated,null)) week5,                                                         "+
                    "     count(if(day_for_week = '6' ,timecreated,null)) week6,                                                         "+
                    "     count(if(day_for_week = '0' ,timecreated,null)) week7,                                                         "+
                    "     count(if(hour_for_day = '1' ,timecreated,null)) hour1,                                                         "+
                    "     count(if(hour_for_day = '2' ,timecreated,null)) hour2,                                                         "+
                    "     count(if(hour_for_day = '3' ,timecreated,null)) hour3,                                                         "+
                    "     count(if(hour_for_day = '4' ,timecreated,null)) hour4,                                                         "+
                    "     count(if(hour_for_day = '5' ,timecreated,null)) hour5,                                                         "+
                    "     count(if(hour_for_day = '6' ,timecreated,null)) hour6,                                                         "+
                    "     count(if(hour_for_day = '7' ,timecreated,null)) hour7,                                                         "+
                    "     count(if(hour_for_day = '8' ,timecreated,null)) hour8,                                                         "+
                    "     count(if(hour_for_day = '9' ,timecreated,null)) hour9,                                                         "+
                    "     count(if(hour_for_day = '10',timecreated,null)) hour10,                                                        "+
                    "     count(if(hour_for_day = '11',timecreated,null)) hour11,                                                        "+
                    "     count(if(hour_for_day = '12',timecreated,null)) hour12,                                                        "+
                    "     count(if(hour_for_day = '13',timecreated,null)) hour13,                                                        "+
                    "     count(if(hour_for_day = '14',timecreated,null)) hour14,                                                        "+
                    "     count(if(hour_for_day = '15',timecreated,null)) hour15,                                                        "+
                    "     count(if(hour_for_day = '16',timecreated,null)) hour16,                                                        "+
                    "     count(if(hour_for_day = '17',timecreated,null)) hour17,                                                        "+
                    "     count(if(hour_for_day = '18',timecreated,null)) hour18,                                                        "+
                    "     count(if(hour_for_day = '19',timecreated,null)) hour19,                                                        "+
                    "     count(if(hour_for_day = '20',timecreated,null)) hour20,                                                        "+
                    "     count(if(hour_for_day = '21',timecreated,null)) hour21,                                                        "+
                    "     count(if(hour_for_day = '22',timecreated,null)) hour22,                                                        "+
                    "     count(if(hour_for_day = '23',timecreated,null)) hour23,                                                        "+
                    "     count(if(hour_for_day = '0' ,timecreated,null)) hour24                                                         "+*/
                    "     count(case day_for_week = '1'  when timecreated then null end) week1,                                                         "+
                    "     count(case day_for_week = '2'  when timecreated then null end) week2,                                                         "+
                    "     count(case day_for_week = '3'  when timecreated then null end) week3,                                                         "+
                    "     count(case day_for_week = '4'  when timecreated then null end) week4,                                                         "+
                    "     count(case day_for_week = '5'  when timecreated then null end) week5,                                                         "+
                    "     count(case day_for_week = '6'  when timecreated then null end) week6,                                                         "+
                    "     count(case day_for_week = '0'  when timecreated then null end) week7,                                                         "+
                    "     count(case hour_for_day = '1'  when timecreated then null end) hour1,                                                         "+
                    "     count(case hour_for_day = '2'  when timecreated then null end) hour2,                                                         "+
                    "     count(case hour_for_day = '3'  when timecreated then null end) hour3,                                                         "+
                    "     count(case hour_for_day = '4'  when timecreated then null end) hour4,                                                         "+
                    "     count(case hour_for_day = '5'  when timecreated then null end) hour5,                                                         "+
                    "     count(case hour_for_day = '6'  when timecreated then null end) hour6,                                                         "+
                    "     count(case hour_for_day = '7'  when timecreated then null end) hour7,                                                         "+
                    "     count(case hour_for_day = '8'  when timecreated then null end) hour8,                                                         "+
                    "     count(case hour_for_day = '9'  when timecreated then null end) hour9,                                                         "+
                    "     count(case hour_for_day = '10' when timecreated then null end) hour10,                                                        "+
                    "     count(case hour_for_day = '11' when timecreated then null end) hour11,                                                        "+
                    "     count(case hour_for_day = '12' when timecreated then null end) hour12,                                                        "+
                    "     count(case hour_for_day = '13' when timecreated then null end) hour13,                                                        "+
                    "     count(case hour_for_day = '14' when timecreated then null end) hour14,                                                        "+
                    "     count(case hour_for_day = '15' when timecreated then null end) hour15,                                                        "+
                    "     count(case hour_for_day = '16' when timecreated then null end) hour16,                                                        "+
                    "     count(case hour_for_day = '17' when timecreated then null end) hour17,                                                        "+
                    "     count(case hour_for_day = '18' when timecreated then null end) hour18,                                                        "+
                    "     count(case hour_for_day = '19' when timecreated then null end) hour19,                                                        "+
                    "     count(case hour_for_day = '20' when timecreated then null end) hour20,                                                        "+
                    "     count(case hour_for_day = '21' when timecreated then null end) hour21,                                                        "+
                    "     count(case hour_for_day = '22' when timecreated then null end) hour22,                                                        "+
                    "     count(case hour_for_day = '23' when timecreated then null end) hour23,                                                        "+
                    "     count(case hour_for_day = '0'  when timecreated then null end) hour24                                                         "+
                    " FROM                                                                                                      "+
                    "     (                                                                                                     "+
                    "         SELECT                                                                                            "+
                    "             courseid,                                                                                     " +
                    "             timecreated,                                                                                  "+
                    "             CAST(FROM_UNIXTIME(timecreated, '%w') AS DECIMAL) day_for_week,                               "+
                    "             CAST(FROM_UNIXTIME(timecreated, '%H') AS DECIMAL) hour_for_day                                "+
                    "         FROM                                                                                              "+
                    "             mdl_logstore_standard_log                                                                     "+
                    "         WHERE userid > 3 and action IN ('viewed','complete','graded','assigned','submitted','loggedin')   "+
                    "     ) tmp1																								"+
                    " GROUP BY courseid																							";

    public static String dwd_sc_learn_duration =
            " insert into sink_kafka16 " +
                    "SELECT																															"+
                    "  userid,                                                                                                                      "+
                    "  courseid,                                                                                                                    "+
                    "  sum(dh_duration) AS `duration`                                                                                                 "+
                    "FROM                                                                                                                           "+
                    "(                                                                                                                              "+
                    "  SELECT                                                                                                                       "+
                    "    mlsl.dh           AS dh,                                                                                                   "+
                    "    mlsl.userid       AS userid,                                                                                               "+
                    "    mlsl.courseid     AS courseid,                                                                                             "+
                    "    mlsl.timecreated  AS timecreated,                                                                                          "+
                    "    (lead(timecreated, 1, NULL) over(PARTITION BY userid, courseid, dh ORDER BY timecreated ) - timecreated) AS dh_duration    "+
                    "  FROM                                                                                                                         "+
                    "  (                                                                                                                            "+
                    "    SELECT                                                                                                                     "+
                    "      userid,                                                                                                                  "+
                    "      courseid,                                                                                                                "+
                    "      timecreated,                                                                                                             "+
                    "      FROM_UNIXTIME(timecreated, '%Y-%m-%d %H') AS dh                                                                          "+
                    "    FROM mdl_logstore_standard_log WHERE userid > 3                                                                            "+
                    "    AND action IN ( 'viewed', 'complete', 'graded', 'assigned', 'submitted' )   -- 学习行为                                     "+
                    "    AND substr(dh,1,10) >= '2021-09-01' AND substr(dh,1,10) <= '2022-03-01'  -- 确定学期                                        "+
                    "  ) mlsl                                                                                                                       "+
                    "  JOIN                                                                                                                         "+
                    "  dwd_student_info dsi                                                                                                         "+
                    "  ON mlsl.userid = dsi.student_id                                                                                              "+
                    ") tb1                                                                                                                          "+
                    "WHERE ltime IS NOT NULL                                                                                                        "+
                    "group by userid, courseid                                                                                                      ";

    public static String dwd_course_completions_info =
            " insert into sink_kafka17 " +
                    " SELECT																											"+
                    "   mcmc.userid,                                                                                                    "+
                    "   mcm.course,                                                                                                     "+
                    "   IF( sum(mcmc.completionstate) = sum(1), '完成', '未完成' ) completionstatus,                                     "+
                    "   round( count( IF ( mcmc.completionstate = 1, 1, NULL )) / count( mcmc.completionstate ), 2 ) * 100 AS progress  "+
                    " FROM                                                                                                              "+
                    " mdl_course_modules_completion mcmc                                                                                "+
                    "  JOIN                                                                                                             "+
                    " mdl_course_modules mcm ON mcm.id = mcmc.coursemoduleid                                                            "+
                    " GROUP BY                                                                                                          "+
                    " mcm.course,mcmc.userid                                                                                            ";

    public static String dwd_uncomplete_activity =
            " insert into sink_kafka18 " +
                    "SELECT																				    "+
                    "  scvc.courseid,                                                                     " +
                    "  cuau.unaccomplished_activity_uv AS NoCompleteActivityCount                          " +
                    "FROM                                                                                  " +
                    "(                                                                                     " +
                    "  SELECT                                                                              " +
                    "    sc.courseid as courseid                                                          " +
                    "  FROM                                                                                " +
                    "  dwd_student_choose_course_info  sc                                                  " +
                    "      join                                                                            " +
                    "  (SELECT userid FROM mdl_logstore_standard_log WHERE contextlevel = 50 ) mlsl        " +
                    "  ON mlsl.userid = mra.userid                                                         " +
                    "  group by sc.courseid                                                                " +
                    ") scvc                                                                                " +
                    "JOIN                                                                                  " +
                    "dwd_uncomp_activity_uv cuau                                                           " +
                    "ON scvc.course_id = cuau.course_id                                                    " ;

    public static String dwd_uncomp_activity_uv=
            " insert into sink_kafka19 " +
                    " SELECT  																"+
                    "  courseid,                                                                                                "+
                    "  count(1) as unaccomplished_activity_uv                                                                   "+
                    "FROM                                                                                                       "+
                    "(                                                                                                          "+
                    "   SELECT                                                                                                  "+
                    "     courseid,                                                                                            "+
                    "     userid                                                                                               "+
                    "   FROM                                                                                                    "+
                    "   (                                                                                                       "+
                    "      SELECT                                                                                               "+
                    "        mcm.course  AS courseid,                                                                          "+
                    "        mcmc.userid AS userid                                                                             "+
                    "      FROM                                                                                                 "+
                    "      (SELECT userid, coursemoduleid FROM mdl_course_modules_completion where completionstate = 0) mcmc    "+
                    "             JOIN                                                                                          "+
                    "      mdl_course_modules AS mcm                                                                            "+
                    "        ON mcmc.coursemoduleid = mcm.id                                                                    "+
                    "          JOIN                                                                                             "+
                    "      (                                                                                                    "+
                    "          SELECT id FROM mdl_modules WHERE visible = 1                                                     "+
                    "          AND name IN ('advmindmap', 'assignment', 'bigbluebuttonbn',                                      "+
                    "                       'choice', 'choicegroup', 'feedback', 'languagelab',                                 "+
                    "                       'lightboxgallery', 'lti', 'tab', 'assign','chat',                                   "+
                    "                       'data', 'forum', 'lesson', 'quiz','survey', 'wiki', 'workshop')                     "+
                    "      ) mc                                                                                                 "+
                    "        ON mcm.`module` = mc.id                                                                              "+
                    "   ) tb1 group by courseid, userid                                                                       "+
                    ") tb2 group by courseid ";

}
