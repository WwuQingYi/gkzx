package cn.gk.rtdw.view;

/**
 * @Date：2022/7/5
 * @Description：创建查询需要的视图
 */
public class QueryNeedView {

    /**
     * 学生课程统计
     */
    public static String create_view_student_course =
            "CREATE TEMPORARY VIEW v_student_course AS " +
                    " SELECT " +
                    "   u.id        AS UserId,                                                                    " +
                    "   u.username  AS StudentNumber,                                                             " +
                    "   co.id       AS CourseId,                                                                  " +
                    "   co.idnumber AS CourseCode                                                                 " +
                    " FROM                                                                                        " +
                    " (SELECT contextid, userid FROM mdl_role_assignments WHERE roleid = 5) AS ra                 " +
                    "     JOIN                                                                                    " +
                    " (SELECT id, instanceid FROM mdl_context WHERE contextlevel = 50) AS cn                      " +
                    " ON ra.contextid = cn.id                                                                     " +
                    "     JOIN                                                                                    " +
                    " (SELECT id, username FROM mdl_user WHERE length(username) = 13 GROUP BY id, username) AS u  " +
                    " ON u.id = ra.userid                                                                         " +
                    "     JOIN                                                                                    " +
                    " (SELECT id,idnumber FROM mdl_course WHERE LENGTH(idnumber) = 5) AS co                       " +
                    " ON cn.instanceid = co.id                                                                    ";


    /**
     * TODO  学生,课程的 作业,测试,浏览资源,活动 统计等情况
     */
    public static String create_view_behavior =
            " CREATE TEMPORARY VIEW v_behavior AS " +
                    "SELECT                                                                                                                                                      " +
                    "   u.idnumber  as StudentNumber,                                                                                                                     " +
                    "   c.idnumber  as CourseCode,                                                                                                                        " +
                    "   Count(*)   as FormativeTestCount,                                                                                                                 " +
                    "   SUM( CASE m.name WHEN 'assign' THEN 1 ELSE 0 END ) AS AssignCount,                                                                                " +
                    "   SUM( CASE m.name WHEN 'quiz' THEN 1 ELSE 0 END ) AS QuizCount,                                                                                    " +
                    "   SUM(CASE WHEN m.name in ('advmindmap','assignment','bigbluebuttonbn','choice',                                                                    " +
                    "                            'choicegroup','feedback','languagelab','lightboxgallery',                                                                " +
                    "                            'lti','tab','assign','chat','data','forum',                                                                              " +
                    "                            'lesson','quiz','survey','wiki','workshop') THEN 1 ELSE 0 END) AS ActivityCount,                                         " +
                    "   SUM(CASE WHEN m.name in ('glossary','scorm','subpage',                                                                                            " +
                    "                            'book','folder','imscp',                                                                                                 " +
                    "                            'label','page','resource','url','videofile') THEN 1 ELSE 0 END) AS ResourceCount,                                        " +
                    "   SUM( if(m.name = 'assign' and cmc.completionstate = 1 , 1, 0)) AS completionAssignCount,                                                          " +  // TODO 完成情况
                    "   SUM( if(m.name = 'quiz' and cmc.completionstate = 1 , 1, 0)) AS completionQuizCount,                                                              " +
                    "   SUM(CASE WHEN m.name in ('advmindmap','assignment','bigbluebuttonbn','choice',                                                                    " +
                    "                            'choicegroup','feedback','languagelab','lightboxgallery',                                                                " +
                    "                            'lti','tab','assign','chat','data','forum',                                                                              " +
                    "                            'lesson','quiz','survey','wiki','workshop') and  cmc.completionstate = 1 THEN 1 ELSE 0 END) AS completionActivityCount   " +
                    " FROM                                                                                                                                                " +
                    " mdl_course_modules_completion cmc                                                                                                                   " +
                    " JOIN                                                                                                                                                " +
                    " (SELECT * FROM mdl_user WHERE LENGTH(idnumber) = 13 AND idnumber <> '')  as u                                                                       " +
                    "   on cmc.userid = u.id                                                                                                                              " +
                    " JOIN                                                                                                                                                " +
                    " mdl_course_modules as cm                                                                                                                            " +
                    "   on cmc.coursemoduleid = cm.id                                                                                                                     " +
                    " JOIN                                                                                                                                                " +
                    " mdl_modules as m                                                                                                                                    " +
                    "   on cm.module = m.id                                                                                                                               " +
                    " JOIN                                                                                                                                                " +
                    " (select id,idnumber,visible from mdl_course where LENGTH(idnumber) = 5 and visible = 1 ) as c                                                       " +
                    " on cm.course = c.id                                                                                                                                 " +
                    " group by u.idnumber, c.idnumber                                                                                                                     ";


    /**
     * 论坛信息
     */
    public static String create_view_forum =
            " CREATE TEMPORARY VIEW v_forum AS " +
                    "SELECT " +
                    "   u.idnumber AS StudentNumber,                                                  " +
                    "   co.idnumber AS CourseCode,                                                    " +
                    "   SUM( if(fp.parent = '0',1,0) ) AS TopicCount,                                 " +
                    "   SUM( if(fp.parent = '0',0,1) ) AS ReplyCount,                                 " +
                    " FROM                                                                            " +
                    "   ( SELECT userid,discussion, FROM mdl_forum_posts WHERE fp.parent = 0 ) AS fp  " +  // 论坛帖子 where  fp.parent = 0   父帖子
                    "   JOIN                                                                          " +
                    "   mdl_forum_discussions AS fd                                                   " + // 论坛讨论
                    "       ON fp.discussion = fd.id                                                  " +//   话题id
                    "   JOIN                                                                          " +
                    "   mdl_forum AS fo                                                               " +   // -- 论坛
                    "       ON fd.forum = fo.id                                                       " +
                    "   JOIN                                                                          " +
                    "   mdl_user AS u                                                                 " +
                    "       ON fp.userid = u.id                                                       " +
                    "   JOIN course AS co                                                             " +
                    "       ON fo.course = co.id                                                      " +  //    -- forum 论坛表进行关联 课程id
                    " group by  u.idnumber, co.idnumber  ";  //  -- 课程编号


    /**
     * 学生登录信息
     */
    public static String create_view_student_login_details =
            " CREATE TEMPORARY VIEW v_student_login_details AS " +
                    " SELECT                                                                                                                 " +
                    "   group2.StudentNumber,                                                                                                " +
                    "   group2.CourseCode,                                                                                                   " +
                    "   group1.UserId,                                                                                                       " +
                    "   group1.CourseId,                                                                                                     " +
                    "   group1.Date                                                                                                          " +
                    " FROM                                                                                                                   " +
                    " (                                                                                                                      " +
                    "   SELECT                                                                                                               " +
                    "       userid,                                                                                                          " +
                    "       courseid,                                                                                                        " +
                    "       FROM_UNIXTIME(max(timecreated), 'YYYY-MM-dd') AS Date                                                            " +
                    "   FROM                                                                                                                 " +
                    "       mdl_logstore_standard_log                                                                                        " +
                    "   GROUP BY userid,courseid                                                                                             " +
                    " ) group1                                                                                                               " +
                    " join (                                                                                                                 " +
                    "   SELECT                                                                                                               " +
                    "       CourseCode,                                                                                                      " +
                    "       UserName as StudentNumber,                                                                                       " +
                    "       UserId,                                                                                                          " +
                    "       CourseId                                                                                                         " +
                    "   FROM                                                                                                                 " +
                    "       (                                                                                                                " +
                    "         SELECT                                                                                                         " +
                    "           *,                                                                                                           " +
                    "           row_number() over(partition by userid,courseid order by userid) num                                          " +
                    "         FROM                                                                                                           " +
                    "             (                                                                                                          " +
                    "                 SELECT                                                                                                 " +
                    "                     mu.id AS userid,                                                                                   " +
                    "                     mu.username,                                                                                       " +
                    "                     co.id AS courseid,                                                                                 " +
                    "                     co.idnumber AS coursecode                                                                          " +
                    "                 FROM                                                                                                   " +
                    "                     (SELECT contextid,userid FROM mdl_role_assignments WHERE contextlevel = 50 AND roleid = 5) ra      " +
                    "                         JOIN                                                                                           " +
                    "                     mdl_context cn                                                                                     " +
                    "                     ON ra.contextid = cn.id                                                                            " +
                    "                         JOIN                                                                                           " +
                    "                     (SELECT id FROM mdl_user WHERE LENGTH(username) = 13 ) mu                                          " +
                    "                     ON u.id = ra.userid                                                                                " +
                    "                         JOIN                                                                                           " +
                    "                     (SELECT id,idnumber FROM mdl_course WHERE LENGTH(idnumber) = 5) co                                 " +
                    "                     ON cn.instanceid = co.id                                                                           " +
                    "             ) t2                                                                                                       " +
                    "    ) t3 WHERE t3.num = 1                                                                                               " +
                    "  ) as group2                                                                                                           " +
                    " ON group1.userid = group2.userid                                                                                       " +
                    "  AND group1.courseid = group2.courseid                                                                                 ";


    /**
     * 学生: 课程浏览、行为统计
     */
    public static String create_view_behavior_browse =
            " CREATE TEMPORARY VIEW v_behavior_browse AS " +
                    "SELECT                                                        " +
                    "   msc.StudentNumber,                                         " +
                    "   msc.CourseCode,                                            " +
                    "   allnum.BehaviorNum,                                        " +
                    "   allnum.BrowseNum,                                          " +
                    "   allnum.LearnBehaviorNUm                                    " +
                    " FROM                                                         " +
                    "  (                                                           " +
                    "      SELECT                                                  " +
                    "        userid AS userid,                                     " +
                    "        courseid AS courseid,                                 " +
                    "        SUM(1) AS BehaviorNum,                                " +
                    "        SUM( if(userid > 3 AND crud = 'r' AND action = 'viewed' , 1 , 0 ) ) as BrowseNum, " +
                    "        SUM( if(userid > 3 AND action in ('Viewed','Complete','Graded','Assigned','Submitted','Login'), 1 , 0 ) ) as LearnBehaviorNUm " +
                    "      FROM                                                    " +
                    "          mdl_logstore_standard_log                           " +
                    "      WHERE relateduserid = userid  OR relateduserid IS NULL  " +
                    "      GROUP BY userid, courseid                               " +
                    "  ) allnum                                                    " +
                    "  join                                                        " +
                    " v_studentcourse msc                                          " +
                    " on allnum.courseid = msc.CourseId                            " +
                    " and allnum.userid = msc.UserId                               ";


}
