package cn.gk.rtdw.query_sql;

/**
 * @Date：2022/7/4
 * @Description：查询结果sql的封装类
 */
public class QueryResultSQLString {

    // TODO 课程查询
    public static String course_info =
            "SELECT " +
                    " idnumber AS id,      " +
                    " fullname AS name,    " +
                    " \"open\" AS platform " +
                    "FROM mdl_course";


    // TODO  成绩设置 查询
    public static String score_info =
            "SELECT " +
                    " idnumber AS id,              " +
                    " itemname AS name,            " +
                    " \"open\" AS platform,        " +
                    " SemesterId  ,                " +   // 不存在
                    " courseid ,                   " +
                    " grademax AS maxScore,        " +
                    " grademin AS minScore,        " +
                    " 60 AS PassingScore,          " +  // 及格线
                    " gradetype AS `type`,         " +  // 0 和 1 [0:Course,1:Item ???]
                    "FROM mdl_grade_items ";


    // TODO  项目（专业） 查询
    public static String project_info =
            "SELECT " +
                    "   id,                     " +
                    "   name,                   " +
                    "   Platform                " +
                    " FROM                      " +
                    " (                         " +
                    "   SELECT                  " +
                    "     mgg.itemid AS  id,    " +
                    "     mgi.itemname AS name, " +
                    "     \"open\" AS Platform  " +
                    "   FROM                    " +
                    "   mdl_grade_grades mgg    " +
                    "     left join             " +
                    "   mdl_grade_items mgi     " +
                    "   on mgi.id = mgg.itemid  " +
                    " ) joined                  " +
                    " group by id,name,Platform ";


    // TODO  机构信息 查询

    public static String organization_info =
            "SELECT Id,Name,ParentId,Level,Platform FROM mdl_organization";


    // TODO  学生基础信息 查询
    public static String student_info =
            "SELECT " +
                    "   mu.idnumber  AS Id,           " +
                    "   mu.username  AS Name,         " +
                    "   mgm.groupid  AS GroupId,      " +
                    "   Status,                       " +  // 没有
                    "   mgg.itemid   AS ProjectId,    " +
                    "   OrganizationId,               " +  // 实验学院 (具体代码没有
                    "   \"open\"       AS Platform,   " +
                    " FROM                            " +
                    " mdl_user mu                     " +
                    "  JOIN                           " +
                    " mdl_groups_members mgm          " +
                    " on userid = idnumber            " +
                    "  JOIN                           " +
                    " mdl_grade_grades mgg            " +
                    " on userid = idnumber            ";


    // TODO  分组信息 查询
    public static String group_info =
            "SELECT " +
                    "   idnumber AS id,         " +
                    "   name     AS name,       " +
                    "   OrganizationId,         " + // 实验学院 (具体代码没有
                    "   \"open\" AS Platform    " +
                    " FROM                      " +
                    " mdl_groups                ";


    // TODO  课程分组信息 查询
    public static String courseGroup_info =
            "SELECT " +
                    " id,                    " +  // ? 分组id
                    " idnumber,              " +  // ? 分组id
                    " courseid,              " +
                    " name,                  " +
                    " OrganizationId,        " + // 实验学院 (具体代码没有
                    " \"open\" AS Platform   " +
                    "FROM mdl_groups ";


    // TODO  学生学期课程 统计
    public static String studentSemesterCourseCount =
            " SELECT    " +
                    "   concat(220,vs.CourseCode,\"open\",vs.StudentNumber) id    " +
                    "   110                           AS OrganizationId           " +
                    "   \"open\"                        AS Platform               " +
                    "   vs.CourseCode                 AS CourseId                 " +
                    "   220                           AS SemesterId               " +
                    "   vs.StudentNumber              AS StudentId                " +
                    "   mg.idnumber                   AS groupId                  " +
                    "   Progress                      AS                          " +
                    "   score                         AS                          " +
                    "   Duration                      AS                          " +
                    "   vsl.CourseId                  AS vsl_CourseId             " +
                    "   vsl.date                      AS logInDt                  " +
                    "   vb.ResourceCount              AS ResourceCount            " +
                    "   vbc.completionQuizCount       AS completionQuizCount      " +
                    "   vbc.completionActivityCount   AS completionActivityCount  " +
                    "   vb1.completionAssignCount     AS completionAssignCount    " +
                    "   vf.TopicCount                 AS TopicCount               " +
                    "   vf.ReplyCount                 AS ReplyCount               " +
                    "   vabs.LearnBehaviorNUm         AS BehaviorNum              " +
                    "   vabs.BrowseNum                AS BrowseNum                " +
                    "   selectCourseTime              AS selectCourseTime         " +   // 拿不到
                    " FROM                                                        " +
                    "  v_studentusers vs                                          " +
                    "   left join                                                 " +
                    " v_behavior_completion vbc                                   " +
                    " on vb.StudentNumber = vs.StudentNumber                      " +
                    " and vs.CourseCode = vb.CourseCode                           " +
                    "   left join                                                 " +
                    " v_forum vf                                                  " +
                    " on vf.StudentNumber = vs.StudentNumber                      " +
                    " and vs.CourseCode = vf.CourseCode                           " +
                    "   left join                                                 " +
                    " v_studentlogindetails  vsl                                  " +
                    " on vsl.StudentNumber = vs.StudentNumber                     " +
                    " and vs.CourseCode = vsl.CourseCode                          " +
                    "   left join                                                 " +
                    " mdl_groups mg                                               " +
                    " on mg.courseid = vs.CourseId                                " +
                    "   left join                                                 " +
                    " v_allbehaviorandbrowse vabs                                 " +
                    " on vsl.StudentNumber = vabs.StudentNumber                   " +
                    " and vs.CourseCode = vabs.CourseCode                         ";


    // TODO   学期课程
    public static String semesterCourseCount =
            "SELECT\n" +
                    "   mc.id\n" +
                    "  ,mc.idnumber\n" +
                    "  ,mc.fullname\n" +
                    "  ,\"open\"\n" +
                    "  ,OrganizationId\n" +
                    "  ,220 AS SemesterId\n" +
                    "  ,mcm.module   -- 拿到模块信息\n" +
                    "  ,mcm.score     -- 拿到模块成绩\n" +
                    "  ,vb.StudentNumber,           --  可以判断 完成过活动 或者 选了课访问过但未完成过活动的学生数\n" +
                    "  ,vb.AssignCount,             -- 作业统计 \n" +
                    "  ,vb.QuizCount,               -- 测验统计 \n" +
                    "  ,vb.ActivityCount,           -- 活动统计 \n" +
                    "  ,vt.TeacherId                -- 教师id\n" +
                    "  ,vs.StudentNumber            -- 选课人数  v_studentusers 可以拿到学生和课程的关系 [一个课程对应多个学生]\n" +
                    "  ,mg.name                     -- 分组名称\n" +
                    "  ,mcmc.completionstate        -- 课程完成情况\n" +
                    "  ,mcmc.coursemoduleid         -- 课程完成情况\n" +
                    "  ,vs.StudentNumber  -- 可以判断 选了课没有访问的\n" +
                    "FROM \n" +
                    "( SELECT * FROM mdl_course WHERE LENGTH(idnumber) = 5 ) mc\n" +
                    "left join\n" +
                    " (SELECT course,module FROM mdl_course_modules group by course,module) mcm  // 一个课程多个模块  这个表包含一个分数 score\n" +
                    "on  mc.id = mcm.course\n" +
                    "left join\n" +
                    " v_behavior vb\n" +
                    "on  mc.id = vb.CourseCode\n" +
                    "left join\n" +
                    " v_teacherusers vt\n" +
                    "on mc.id = vt.CourseId\n" +
                    "left join\n" +
                    " v_studentusers vs \n" +
                    "on mc.id = vs.CourseId\n" +
                    "left join\n" +
                    " mdl_groups mg\n" +
                    "on mc.id = mg.courseid\n" +
                    "left join \n" +
                    " mdl_course_modules_completion mcmc\n" +
                    "on mcmc.coursemoduleid = mcm.id\n" +
                    "left join\n" +
                    "// 需要获取每个课程的选课人以及每个学生的得分情况[怎么算?]\n" +
                    "// mdl_course_modules 表中 一个课程多个模块[是把每个模块的加起来?]\n" +
                    "// 获取 最高分 最低分 平均分 及格分 成绩项模块 [分数相关的没法算只有最低分和最高分]\n" +
                    "mdl_grade_items mgi\n" +
                    "on mgi.courseid = mc.id" +
                    "课程被学习的行为次数 :每天的,还有每小时的  courseid \n" +
                    "mdl_logstore_standard_log" +
                    "group by";


    // TODO  学生课程模块完成情况
    public static String studentCourseModuleCount =
            "select\n" +
                    "  \"open\" as Platform\n" +
                    "  vss.CourseId\n" +
                    "  mcmc.coursemoduleid as ModuleId\n" +
                    "  mm.name as ModuleType\n" +
                    "  Duration  -- 不知道咋算\n" +
                    "  vss.StudentId \n" +
                    "  Progress   -- 不确定\n" +
                    "  mcm.score    -- 最大 最小都可以拿到\n" +
                    "  mcmc.completionstate as CompletionStatus\n" +
                    "from\n" +
                    "v_studentusers   vss\n" +
                    "join \n" +
                    "mdl_course_modules_completion mcmc\n" +
                    "on mcmc.id = vss.CourseId\n" +
                    "join\n" +
                    "on mdl_modules mm.id = mcmc.id\n" +
                    "join \n" +
                    "mdl_course_modules mcm\n" +
                    "on mcm.course = vss.CourseId\n" +
                    "group by ";

}
