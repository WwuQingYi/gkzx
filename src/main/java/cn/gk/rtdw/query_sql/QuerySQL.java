package cn.gk.rtdw.query_sql;

/**
 * @Date：2022/7/1
 * @Description： 查询 sql 的封装类
 */
public class QuerySQL {
    // TODO 测试
    public static String v_behavior =
            " SELECT     " +
                    "    cmc.MoodleProvince,                                                                    " +
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
                    "    SUM(CASE WHEN m.name in ('glossary', -- 模块类型属于这几个的做计算                        " +
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
                    " JOIN ( SELECT id,idnumber,MoodleProvince FROM mdl_course WHERE LENGTH(c.idnumber) = 5 and c.visible = 1 ) as c " +
                    "      on cm.course = c.id                                                                  " +
                    "          and cm.MoodleProvince = c.MoodleProvince                                         " +
                    " group by                                                                                  " +
                    "    cmc.MoodleProvince,u.idnumber,c.idnumber                                               ";
}
