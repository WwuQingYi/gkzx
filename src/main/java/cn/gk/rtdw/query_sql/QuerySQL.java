package cn.gk.rtdw.query_sql;

/**
 * @Date：2022/7/1
 * @Description： 查询 sql 的封装类
 */
public class QuerySQL {
    /**
     * TODO 学生行为信息
     */
    public static String v_behavior =  // MoodleProvince 不存在
            "SELECT " +
                    "    cmc.MoodleProvince,              AS MoodleProvince                                     " +
                    "    u.idnumber                       AS StudentNumber,                                     " +
                    "    c.idnumber                       AS CourseCode,                                        " +
                    "    Count(*)                         AS FormativeTestCount,                                " +
                    "    SUM(IF(m.name = 'assign', 1, 0)) AS AssignCount,                                       " +
                    "    SUM(IF(m.name = 'quiz', 1, 0))   AS QuizCount,                                         " +
                    "    SUM(CASE WHEN m.name in ('advmindmap',                                                 " +
                    "                            'assignment',                                                  " +
                    "                            'bigbluebuttonbn',                                             " +
                    "                            'choice',                                                      " +
                    "                            'choicegroup',                                                 " +
                    "                            'feedback',                                                    " +
                    "                            'languagelab',                                                 " +
                    "                            'lightboxgallery',                                             " +
                    "                            'lti',                                                         " +
                    "                            'tab',                                                         " +
                    "                            'assign',                                                      " +
                    "                            'chat',                                                        " +
                    "                            'data',                                                        " +
                    "                            'forum',                                                       " +
                    "                            'lesson',                                                      " +
                    "                            'quiz',                                                        " +
                    "                            'survey',                                                      " +
                    "                            'wiki',                                                        " +
                    "                            'workshop' ) THEN 1 ELSE 0 END) AS ActivityCount,              " +
                    "    SUM(CASE WHEN m.name in ('glossary', -- 模块类型属于这几个的做计算                          " +
                    "                            'scorm',                                                       " +
                    "                            'subpage',                                                     " +
                    "                            'book',                                                        " +
                    "                            'folder',                                                      " +
                    "                            'imscp',                                                       " +
                    "                            'label',                                                       " +
                    "                            'page',                                                        " +
                    "                            'resource',                                                    " +
                    "                            'url',                                                         " +
                    "                            'videofile') THEN 1 ELSE 0 END) AS ResourceCount               " +
                    " FROM                                                                                      " +
                    "   mdl_course_modules_completion cmc                                                       " +
                    " JOIN mdl_user as u                                                                        " +
                    "      on cmc.userid = u.id                                                                 " +
                    "          and cmc.MoodleProvince = u.MoodleProvince                                        " +
                    " JOIN mdl_course_modules as cm                                                             " +
                    "      on cmc.coursemoduleid = cm.id                                                        " +
                    "          and cmc.MoodleProvince = cm.MoodleProvince                                       " +
                    " JOIN mdl_modules as m                                                                     " +
                    "      on cm.module = m.id                                                                  " +
                    "          and cm.MoodleProvince = m.MoodleProvince                                         " +
                    " JOIN ( SELECT id,idnumber,MoodleProvince FROM mdl_course WHERE LENGTH(idnumber) = 5 and visible = 1 ) as c " +
                    "      on cm.course = c.id                                                                  " +
                    "          and cm.MoodleProvince = c.MoodleProvince                                         " +
                    " group by                                                                                  " +
                    "    cmc.MoodleProvince,u.idnumber,c.idnumber                                               ";

    /**
     * 教师人数信息
     */
    public static String v_teacherusers =  // MoodleProvince 不存在
            "SELECT " +
                    "     u.id AS UserId,                            " +
                    "     u.username as TeacherId,                   " +
                    "     co.id AS CourseId,                         " +
                    "     co.idnumber AS CourseCode,                 " +
                    "     ra.MoodleProvince                          " +
                    " FROM                                           " +
                    "  (SELECT contextid,MoodleProvince,userid FROM mdl_role_assignments WHERE roleid IN (3, 4) )AS ra  " +
                    "     JOIN                                       " +
                    "     (SELECT id,MoodleProvince,instanceid FROM mdl_context WHERE contextlevel = 50 ) AS cn         " +
                    "     ON ra.contextid = cn.id                    " +
                    "     and ra.MoodleProvince = cn.MoodleProvince  " +
                    "     JOIN (SELECT id,username FROM mdl_user GROUP BY id,username) AS u                             " +
                    "         ON u.id = ra.userid                    " +
                    "     and ra.MoodleProvince = u.MoodleProvince   " +
                    "     JOIN (SELECT id,MoodleProvince FROM course WHERE LENGTH(idnumber) = 5) AS co                  " +
                    "         ON cn.instanceid = co.id               " +
                    "     and co.MoodleProvince = cn.MoodleProvince  ";


    /**
     * 学生人数信息
     */
    public static String v_studentusers =
            "SELECT " +
                    "     u.id AS UserId,                            " +
                    "     u.username as StudentNumber,               " +
                    "     co.id AS CourseId,                         " +
                    "     co.idnumber AS CourseCode,                 " +
                    "     ra.MoodleProvince                          " +
                    " FROM                                           " +
                    "  (SELECT contextid,MoodleProvince,userid FROM mdl_role_assignments WHERE roleid = 5 )AS ra        " +
                    "     JOIN                                       " +
                    "     (SELECT id,MoodleProvince,instanceid FROM mdl_context WHERE contextlevel = 50 ) AS cn         " +
                    "     ON ra.contextid = cn.id                    " +
                    "     and ra.MoodleProvince = cn.MoodleProvince  " +
                    "     JOIN (SELECT id,username FROM mdl_user WHERE length(username) = 13 GROUP BY id,username) AS u " +
                    "         ON u.id = ra.userid                    " +
                    "     and ra.MoodleProvince = u.MoodleProvince   " +
                    "     JOIN (SELECT id,MoodleProvince FROM course WHERE LENGTH(idnumber) = 5) AS co                  " +
                    "         ON cn.instanceid = co.id               " +
                    "     and co.MoodleProvince = cn.MoodleProvince  ";


    /**
     * 学生登录信息
     */
    public static String v_studentlogindetails =
            "SELECT " +
                    "  group2.StudentNumber,                                                                                                              " +
                    "  group2.CourseCode,                                                                                                                 " +
                    "  group1.UserId,                                                                                                                     " +
                    "  group1.CourseId,                                                                                                                   " +
                    "  group1.MoodleProvince,                                                                                                             " +
                    "  group1.Date                                                                                                                        " +
                    "FROM                                                                                                                                 " +
                    "    (                                                                                                                                " +
                    "      SELECT                                                                                                                         " +
                    "         userid,                                                                                                                     " +
                    "         courseid,                                                                                                                   " +
                    "         FROM_UNIXTIME(max(timecreated), 'YYYY-MM-dd') AS Date                                                                       " +
                    "      FROM                                                                                                                           " +
                    "        mdl_logstore_standard_log                                                                                                    " +
                    "      GROUP BY userid,courseid                                                                                                       " +
                    "    ) group1                                                                                                                         " +
                    "    JOIN (                                                                                                                           " +
                    "        SELECT                                                                                                                       " +
                    "            MoodleProvince,                                                                                                          " +
                    "            CourseCode,                                                                                                              " +
                    "            UserName as StudentNumber,                                                                                               " +
                    "            UserId,                                                                                                                  " +
                    "            CourseId                                                                                                                 " +
                    "        FROM                                                                                                                         " +
                    "            (                                                                                                                        " +
                    "                SELECT                                                                                                               " +
                    "                  *,                                                                                                                 " +
                    "                  row_number() over(partition by userid, courseid, MoodleProvince order by userid) num                               " +
                    "                FROM                                                                                                                 " +
                    "                    (                                                                                                                " +
                    "                     SELECT                                                                                                          " +
                    "                          u.MoodleProvince,                                                                                          " +
                    "                          u.id AS userid,                                                                                            " +
                    "                          u.username,                                                                                                " +
                    "                          co.id AS courseid,                                                                                         " +
                    "                          co.idnumber AS coursecode                                                                                  " +
                    "                     FROM                                                                                                            " +
                    "                       (SELECT contextid,MoodleProvince,userid FROM mdl_role_assignments WHERE contextlevel = 50 AND roleid = 5) ra  " + // roleid 角色id
                    "                       JOIN                                                                                                          " +
                    "                       mdl_context cn                                                                                                " +
                    "                           ON ra.contextid = cn.id AND ra.MoodleProvince = cn.MoodleProvince                                         " +
                    "                       JOIN                                                                                                          " +
                    "                       (SELECT id,MoodleProvince FROM mdl_user WHERE LENGTH(username) = 13 ) u                                       " +// username 13位的才是学号
                    "                           ON u.id = ra.userid AND AND u.MoodleProvince = ra.MoodleProvince                                          " +
                    "                       JOIN                                                                                                          " +
                    "                       (SELECT id,MoodleProvince FROM mdl_course WHERE LENGTH(idnumber) = 5) co                                      " +// idnumber 或者 shortname 五位的才是课程编号
                    "                           ON cn.instanceid = co.id AND cn.MoodleProvince = co.MoodleProvince                                        " +
                    "                    ) t2                                                                                                             " +
                    "            ) t3                                                                                                                     " +
                    "        WHERE t3.num = 1                                                                                                             " +
                    "    ) as group2                                                                                                                      " +
                    " on group1.userid = group2.userid                                                                                                    " +
                    " AND group1.courseid = group2.courseid                                                                                               " +
                    " AND group1.MoodleProvince = group2.MoodleProvince                                                                                   ";


    /**
     * 论坛信息
     */
    public static String v_forum =
            "SELECT " +
                    "     u.idnumber AS StudentNumber,                                                                " +
                    "     co.idnumber AS CourseCode,                                                                  " +
                    "     fp.MoodleProvince AS MoodleProvince,                                                        " +
                    "     SUM( if(fp.parent = '0',1,0) ) AS TopicCount,                                               " +
                    "     SUM( if(fp.parent = '0',0,1) ) AS ReplyCount,                                               " +
                    " FROM                                                                                            " +
                    "   ( SELECT userid,discussion,MoodleProvince, FROM mdl_forum_posts WHERE fp.parent = 0 ) AS fp   " +  // 论坛帖子 where  fp.parent = 0   父帖子
                    "   JOIN                                                                                          " +
                    "   mdl_forum_discussions AS fd      -- 论坛讨论                                                   " +
                    "       ON fp.discussion = fd.id  -- 话题id                                                       " +
                    "       and fp.MoodleProvince = fd.MoodleProvince  -- 省校id                                      " +
                    "   JOIN                                                                                          " +
                    "   mdl_forum AS fo        -- 论坛                                                                " +
                    "       ON fd.forum = fo.id                                                                       " +
                    "       and fd.MoodleProvince = fo.MoodleProvince  -- 省校id                                      " +
                    "   JOIN                                                                                          " +
                    "   mdl_user AS u                                                                                 " +
                    "       ON fp.userid = u.id                                                                       " +
                    "   and fp.MoodleProvince = u.MoodleProvince                                                      " +
                    "   JOIN course AS co                                                                             " +
                    "       ON fo.course = co.id        -- forum 论坛表进行关联 课程id                                   " +
                    "       and co.MoodleProvince = fo.MoodleProvince   -- 省校id                                      " +
                    " group by                                                                                        " +
                    "     u.idnumber,            -- 学号                                                               " +
                    "     co.idnumber,           -- 课程编号                                                           " +
                    "     fp.MoodleProvince      -- 省校id                                                            ";


    /**
     * 所有行为和浏览信息统计
     */
    public static String v_allbehaviorandbrowse =
            "SELECT " +
                    "    allnum.MoodleProvince,                                                             " +
                    "    msc.StudentNumber,                                                                 " +
                    "    msc.CourseCode,                                                                    " +
                    "    allnum.BehaviorNum,                                                                " +
                    "    allnum.BrowseNum                                                                   " +
                    "FROM                                                                                   " +
                    "    (                                                                                  " +
                    "        SELECT                                                                         " +
                    "            MoodleProvince,                                                            " +
                    "            userid AS userid,                                                          " +
                    "            courseid AS courseid,                                                      " +
                    "            SUM(1) AS BehaviorNum,                                                     " +
                    "            SUM(if(userid > 3 AND crud = 'r' AND action = 'viewed',1,0) as BrowseNum   " +
                    "        FROM                                                                           " +
                    "          mdl_logstore_standard_log                                                    " +
                    "        WHERE                                                                          " +
                    "          relateduserid = userid  OR relateduserid IS NULL                             " + // 受影响用户 relateduserid = userid 用户id
                    "        GROUP BY                                                                       " +
                    "            userid,                                                                    " +
                    "            courseid,                                                                  " +
                    "            MoodleProvince                                                             " +
                    "    ) allnum                                                                           " +
                    "    join (                                                                             " +
                    "        SELECT                                                                         " +
                    "            DISTINCT *                                                                 " +
                    "        FROM                                                                           " +
                    "            moodleselectcourse                                                         " +   // TODO 拿不到学生选课
                    "    ) msc                                                                              " +
                    " on allnum.courseid = msc.courseid                                                     " +
                    "  and allnum.MoodleProvince = msc.MoodleProvince                                       " +
                    "  and allnum.userid = msc.userid                                                       ";

}
