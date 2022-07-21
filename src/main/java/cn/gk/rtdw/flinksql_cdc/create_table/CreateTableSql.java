package cn.gk.rtdw.flinksql_cdc.create_table;

import cn.gk.rtdw.utils.ConfigName;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/**
 * @Date：2022/7/1
 * @Description：flink-sql解析mysql数据
 */
public class CreateTableSql {

    // TODO 加载配置文件
    public static Config config = ConfigFactory.load("config.properties");

    public static final String create_mdl_groups =
            "CREATE TABLE mdl_groups (  " +
                    "  id                  BIGINT     " +
                    " ,courseid            BIGINT     " +
                    " ,idnumber            STRING     " +
                    " ,name                STRING     " +
                    " ,description         STRING     " +
                    " ,descriptionformat   INT        " +
                    " ,enrolmentkey        STRING     " +
                    " ,picture             BIGINT     " +
                    " ,hidepicture         INT        " +
                    " ,timecreated         BIGINT     " +
                    " ,timemodified        BIGINT     " +
                    " ,PRIMARY KEY(id) NOT ENFORCED   " +
                    ") WITH ( " +
                    " 'connector' = 'mysql-cdc'  ," +
                    " 'scan.startup.mode' = '" + config.getString(ConfigName.MYSQL_SCAN_MODE) + "'   ," +
                    " 'hostname' = '" + config.getString(ConfigName.MYSQL_HOSTNAME) + "'             ," +
                    " 'port' = '" + config.getString(ConfigName.MYSQL_PORT) + "'                     ," +
                    " 'username' = '" + config.getString(ConfigName.MYSQL_JDBC_USER) + "'            ," +
                    " 'password' = '" + config.getString(ConfigName.MYSQL_JDBC_PASSWORD) + "'        ," +
                    " 'database-name' = '" + config.getString(ConfigName.MYSQL_DATABASE) + "'        ," +
                    " 'table-name' = 'mdl_groups' " +
                    ")";


    public static final String create_mdl_course_modules_completion =
            "CREATE TABLE mdl_course_modules_completion (  " +
                    "  id                BIGINT     " +
                    " ,coursemoduleid    BIGINT     " +
                    " ,userid            BIGINT     " +
                    " ,completionstate   INT        " +
                    " ,viewed            INT        " +
                    " ,overrideby        BIGINT     " +
                    " ,timemodified      BIGINT     " +
                    " ,PRIMARY KEY(id) NOT ENFORCED " +
                    ") WITH ( " +
                    " 'connector' = 'mysql-cdc', " +
                    " 'scan.startup.mode' = '" + config.getString(ConfigName.MYSQL_SCAN_MODE) + "'   ," +
                    " 'hostname' = '" + config.getString(ConfigName.MYSQL_HOSTNAME) + "'             ," +
                    " 'port' = '" + config.getString(ConfigName.MYSQL_PORT) + "'                     ," +
                    " 'username' = '" + config.getString(ConfigName.MYSQL_JDBC_USER) + "'            ," +
                    " 'password' = '" + config.getString(ConfigName.MYSQL_JDBC_PASSWORD) + "'        ," +
                    " 'database-name' = '" + config.getString(ConfigName.MYSQL_DATABASE) + "'        ," +
                    " 'table-name' = 'mdl_course_modules_completion' " +
                    ")";


    public static final String create_mdl_course_modules =
            "CREATE TABLE mdl_course_modules (   " +
                    "  id                             BIGINT  " +
                    " ,course                         BIGINT  " +
                    " ,`module`                       BIGINT  " +
                    " ,instance                       BIGINT  " +
                    " ,section                        BIGINT  " +
                    " ,idnumber                       STRING  " +
                    " ,added                          BIGINT  " +
                    " ,`score`                        INT     " +
                    " ,indent                         INT     " +
                    " ,visible                        INT     " +
                    " ,visibleoncoursepage            INT     " +
                    " ,visibleold                     INT     " +
                    " ,groupmode                      INT     " +
                    " ,groupingid                     BIGINT  " +
                    " ,completion                     INT     " +
                    " ,completiongradeitemnumber      BIGINT  " +
                    " ,completionview                 INT     " +
                    " ,completionexpected             BIGINT  " +
                    " ,showdescription                INT     " +
                    " ,availability                   STRING  " +
                    " ,deletioninprogress             INT     " +
                    " ,PRIMARY KEY(id) NOT ENFORCED           " +
                    ") WITH ( " +
                    " 'connector' = 'mysql-cdc', " +
                    " 'scan.startup.mode' = '" + config.getString(ConfigName.MYSQL_SCAN_MODE) + "'   ," +
                    " 'hostname' = '" + config.getString(ConfigName.MYSQL_HOSTNAME) + "'             ," +
                    " 'port' = '" + config.getString(ConfigName.MYSQL_PORT) + "'                     ," +
                    " 'username' = '" + config.getString(ConfigName.MYSQL_JDBC_USER) + "'            ," +
                    " 'password' = '" + config.getString(ConfigName.MYSQL_JDBC_PASSWORD) + "'        ," +
                    " 'database-name' = '" + config.getString(ConfigName.MYSQL_DATABASE) + "'        ," +
                    " 'table-name' = 'mdl_course_modules' " +
                    ")";


    public static final String create_mdl_course =
            "CREATE TABLE mdl_course  (   " +
                    "  cacherev                BIGINT  " +
                    " ,calendartype            STRING  " +
                    " ,category                BIGINT  " +
                    " ,completionnotify        INT     " +
                    " ,defaultgroupingid       BIGINT  " +
                    " ,enablecompletion        INT     " +
                    " ,enddate                 BIGINT  " +
                    " ,`format`                STRING  " +
                    " ,fullname                STRING  " +
                    " ,groupmode               INT     " +
                    " ,groupmodeforce          INT     " +
                    " ,id                      BIGINT  " +
                    " ,idnumber                STRING  " +
                    " ,`lang`                  STRING  " +
                    " ,legacyfiles             INT     " +
                    " ,marker                  BIGINT  " +
                    " ,maxbytes                BIGINT  " +
                    " ,newsitems               INT     " +
                    " ,relativedatesmode       INT     " +
                    " ,requested               INT     " +
                    " ,shortname               STRING  " +
                    " ,showgrades              INT     " +
                    " ,showreports             INT     " +
                    " ,sortorder               BIGINT  " +
                    " ,startdate               BIGINT  " +
                    " ,summary                 STRING  " +
                    " ,summaryformat           INT     " +
                    " ,theme                   STRING  " +
                    " ,timecreated             BIGINT  " +
                    " ,timemodified            BIGINT  " +
                    " ,visible                 INT     " +
                    " ,visibleold              INT     " +
                    " ,PRIMARY KEY(id) NOT ENFORCED    " +
                    ") WITH ( " +
                    " 'connector' = 'mysql-cdc', " +
                    " 'scan.startup.mode' = '" + config.getString(ConfigName.MYSQL_SCAN_MODE) + "'   ," +
                    " 'hostname' = '" + config.getString(ConfigName.MYSQL_HOSTNAME) + "'             ," +
                    " 'port' = '" + config.getString(ConfigName.MYSQL_PORT) + "'                     ," +
                    " 'username' = '" + config.getString(ConfigName.MYSQL_JDBC_USER) + "'            ," +
                    " 'password' = '" + config.getString(ConfigName.MYSQL_JDBC_PASSWORD) + "'        ," +
                    " 'database-name' = '" + config.getString(ConfigName.MYSQL_DATABASE) + "'        ," +
                    " 'table-name' = 'mdl_course' " +
                    ")";


    public static final String create_mdl_logstore_standard_log =
            "CREATE TABLE mdl_logstore_standard_log  (   " +
                    "  action             STRING  " +
                    " ,anonymous          INT     " +
                    " ,component          STRING  " +
                    " ,contextid          BIGINT  " +
                    " ,contextinstanceid  BIGINT  " +
                    " ,contextlevel       BIGINT  " +
                    " ,courseid           BIGINT  " +
                    " ,crud               STRING  " +
                    " ,edulevel           INT     " +
                    " ,eventname          STRING  " +
                    " ,id                 BIGINT  " +
                    " ,ip                 STRING  " +
                    " ,objectid           BIGINT  " +
                    " ,objecttable        STRING  " +
                    " ,origin             STRING  " +
                    " ,other              STRING  " +
                    " ,realuserid         BIGINT  " +
                    " ,relateduserid      BIGINT  " +
                    " ,target             STRING  " +
                    " ,timecreated        BIGINT  " +
                    " ,PRIMARY KEY(id) NOT ENFORCED  " +
                    ") WITH ( " +
                    " 'connector' = 'mysql-cdc', " +
                    " 'scan.startup.mode' = '" + config.getString(ConfigName.MYSQL_SCAN_MODE) + "'   ," +
                    " 'hostname' = '" + config.getString(ConfigName.MYSQL_HOSTNAME) + "'             ," +
                    " 'port' = '" + config.getString(ConfigName.MYSQL_PORT) + "'                     ," +
                    " 'username' = '" + config.getString(ConfigName.MYSQL_JDBC_USER) + "'            ," +
                    " 'password' = '" + config.getString(ConfigName.MYSQL_JDBC_PASSWORD) + "'        ," +
                    " 'database-name' = '" + config.getString(ConfigName.MYSQL_DATABASE) + "'        ," +
                    " 'table-name' = 'mdl_logstore_standard_log' " +
                    ")";


    public static final String create_mdl_forum_posts =
            "CREATE TABLE mdl_forum_posts  (   " +
                    "  attachment        STRING  " +
                    " ,charcount         BIGINT  " +
                    " ,created           BIGINT  " +
                    " ,deleted           INT     " +
                    " ,discussion        BIGINT  " +
                    " ,id                BIGINT  " +
                    " ,mailed            INT     " +
                    " ,mailnow           BIGINT  " +
                    " ,message           STRING  " +
                    " ,messageformat     INT     " +
                    " ,messagetrust      INT     " +
                    " ,modified          BIGINT  " +
                    " ,parent            BIGINT  " +
                    " ,privatereplyto    BIGINT  " +
                    " ,`subject`         STRING  " +
                    " ,totalscore        INT     " +
                    " ,userid            BIGINT  " +
                    " ,wordcount         BIGINT  " +
                    " ,PRIMARY KEY(id) NOT ENFORCED  " +
                    ") WITH ( " +
                    " 'connector' = 'mysql-cdc', " +
                    " 'scan.startup.mode' = '" + config.getString(ConfigName.MYSQL_SCAN_MODE) + "'   ," +
                    " 'hostname' = '" + config.getString(ConfigName.MYSQL_HOSTNAME) + "'             ," +
                    " 'port' = '" + config.getString(ConfigName.MYSQL_PORT) + "'                     ," +
                    " 'username' = '" + config.getString(ConfigName.MYSQL_JDBC_USER) + "'            ," +
                    " 'password' = '" + config.getString(ConfigName.MYSQL_JDBC_PASSWORD) + "'        ," +
                    " 'database-name' = '" + config.getString(ConfigName.MYSQL_DATABASE) + "'        ," +
                    " 'table-name' = 'mdl_forum_posts' " +
                    ")";


    public static final String create_mdl_forum_discussions =
            "CREATE TABLE mdl_forum_discussions  (   " +
                    "  assessed         INT     " +
                    " ,course           BIGINT  " +
                    " ,firstpost        BIGINT  " +
                    " ,forum            BIGINT  " +
                    " ,groupid          BIGINT  " +
                    " ,id               BIGINT  " +
                    " ,name             STRING  " +
                    " ,pinned           INT     " +
                    " ,timeend          BIGINT  " +
                    " ,timelocked       BIGINT  " +
                    " ,timemodified     BIGINT  " +
                    " ,timestart        BIGINT  " +
                    " ,userid           BIGINT  " +
                    " ,usermodified     BIGINT  " +
                    " ,PRIMARY KEY(id) NOT ENFORCED  " +
                    ") WITH ( " +
                    " 'connector' = 'mysql-cdc', " +
                    " 'scan.startup.mode' = '" + config.getString(ConfigName.MYSQL_SCAN_MODE) + "'   ," +
                    " 'hostname' = '" + config.getString(ConfigName.MYSQL_HOSTNAME) + "'             ," +
                    " 'port' = '" + config.getString(ConfigName.MYSQL_PORT) + "'                     ," +
                    " 'username' = '" + config.getString(ConfigName.MYSQL_JDBC_USER) + "'            ," +
                    " 'password' = '" + config.getString(ConfigName.MYSQL_JDBC_PASSWORD) + "'        ," +
                    " 'database-name' = '" + config.getString(ConfigName.MYSQL_DATABASE) + "'        ," +
                    " 'table-name' = 'mdl_forum_discussions' " +
                    ")";


    public static final String create_mdl_forum =
            "CREATE TABLE mdl_forum  (   " +
                    "  assessed                BIGINT  " +
                    " ,assesstimefinish        BIGINT  " +
                    " ,assesstimestart         BIGINT  " +
                    " ,blockafter              BIGINT  " +
                    " ,blockperiod             BIGINT  " +
                    " ,completiondiscussions   INT     " +
                    " ,completionposts         INT     " +
                    " ,completionreplies       INT     " +
                    " ,course                  BIGINT  " +
                    " ,cutoffdate              BIGINT  " +
                    " ,displaywordcount        INT     " +
                    " ,duedate                 BIGINT  " +
                    " ,forcesubscribe          INT     " +
                    " ,grade_forum             BIGINT  " +
                    " ,grade_forum_notify      INT     " +
                    " ,id                      BIGINT  " +
                    " ,INTro                   STRING  " +
                    " ,INTroformat             INT     " +
                    " ,lockdiscussionafter     BIGINT  " +
                    " ,maxattachments          BIGINT  " +
                    " ,maxbytes                BIGINT  " +
                    " ,name                    STRING  " +
                    " ,rssarticles             INT     " +
                    " ,rsstype                 INT     " +
                    " ,scale                   BIGINT  " +
                    " ,timemodified            BIGINT  " +
                    " ,trackingtype            INT     " +
                    " ,`type`                  STRING  " +
                    " ,warnafter               BIGINT  " +
                    " ,PRIMARY KEY(id) NOT ENFORCED    " +
                    ") WITH ( " +
                    " 'connector' = 'mysql-cdc', " +
                    " 'scan.startup.mode' = '" + config.getString(ConfigName.MYSQL_SCAN_MODE) + "'   ," +
                    " 'hostname' = '" + config.getString(ConfigName.MYSQL_HOSTNAME) + "'             ," +
                    " 'port' = '" + config.getString(ConfigName.MYSQL_PORT) + "'                     ," +
                    " 'username' = '" + config.getString(ConfigName.MYSQL_JDBC_USER) + "'            ," +
                    " 'password' = '" + config.getString(ConfigName.MYSQL_JDBC_PASSWORD) + "'        ," +
                    " 'database-name' = '" + config.getString(ConfigName.MYSQL_DATABASE) + "'        ," +
                    " 'table-name' = 'mdl_forum' " +
                    ")";


    public static final String create_mdl_user =
            "CREATE TABLE mdl_user  (   " +
                    "  address              STRING  " +
                    " ,aim                  STRING  " +
                    " ,alternatename        STRING  " +
                    " ,`auth`               STRING  " +
                    " ,autosubscribe        INT     " +
                    " ,calendartype         STRING  " +
                    " ,city                 STRING  " +
                    " ,confirmed            INT     " +
                    " ,country              STRING  " +
                    " ,currentlogin         BIGINT  " +
                    " ,deleted              INT     " +
                    " ,department           STRING  " +
                    " ,description          STRING  " +
                    " ,descriptionformat    INT     " +
                    " ,email                STRING  " +
                    " ,emailstop            INT     " +
                    " ,firstaccess          BIGINT  " +
                    " ,firstname            STRING  " +
                    " ,firstnamephonetic    STRING  " +
                    " ,icq                  STRING  " +
                    " ,id                   BIGINT  " +
                    " ,idnumber             STRING  " +
                    " ,imagealt             STRING  " +
                    " ,institution          STRING  " +
                    " ,`lang`               STRING  " +
                    " ,lastaccess           BIGINT  " +
                    " ,lastip               STRING  " +
                    " ,lastlogin            BIGINT  " +
                    " ,lastname             STRING  " +
                    " ,lastnamephonetic     STRING  " +
                    " ,maildigest           INT     " +
                    " ,maildisplay          INT     " +
                    " ,mailformat           INT     " +
                    " ,middlename           STRING  " +
                    " ,mnethostid           BIGINT  " +
                    " ,moodlenetprofile     STRING  " +
                    " ,msn                  STRING  " +
                    " ,`username`           STRING  " +
                    " ,`password`           STRING  " +
                    " ,phone1               STRING  " +
                    " ,phone2               STRING  " +
                    " ,picture              BIGINT  " +
                    " ,policyagreed         INT     " +
                    " ,secret               STRING  " +
                    " ,skype                STRING  " +
                    " ,suspended            INT     " +
                    " ,theme                STRING  " +
                    " ,timecreated          BIGINT  " +
                    " ,timemodified         BIGINT  " +
                    " ,`timezone`           STRING  " +
                    " ,trackforums          INT  " +
                    " ,PRIMARY KEY(id) NOT ENFORCED  " +
                    ") WITH ( " +
                    " 'connector' = 'mysql-cdc', " +
                    " 'scan.startup.mode' = '" + config.getString(ConfigName.MYSQL_SCAN_MODE) + "'   ," +
                    " 'hostname' = '" + config.getString(ConfigName.MYSQL_HOSTNAME) + "'             ," +
                    " 'port' = '" + config.getString(ConfigName.MYSQL_PORT) + "'                     ," +
                    " 'username' = '" + config.getString(ConfigName.MYSQL_JDBC_USER) + "'            ," +
                    " 'password' = '" + config.getString(ConfigName.MYSQL_JDBC_PASSWORD) + "'        ," +
                    " 'database-name' = '" + config.getString(ConfigName.MYSQL_DATABASE) + "'        ," +
                    " 'table-name' = 'mdl_user' " +
                    ")";


    public static final String create_mdl_role_assignments =
            "CREATE TABLE mdl_role_assignments  (   " +
                    " component       STRING  " +
                    " ,contextid      BIGINT  " +
                    " ,id             BIGINT  " +
                    " ,itemid         BIGINT  " +
                    " ,modifierid     BIGINT  " +
                    " ,roleid         BIGINT  " +
                    " ,sortorder      BIGINT  " +
                    " ,timemodified   BIGINT  " +
                    " ,userid         BIGINT  " +
                    " ,PRIMARY KEY(id) NOT ENFORCED  " +
                    ") WITH ( " +
                    " 'connector' = 'mysql-cdc', " +
                    " 'scan.startup.mode' = '" + config.getString(ConfigName.MYSQL_SCAN_MODE) + "'   ," +
                    " 'hostname' = '" + config.getString(ConfigName.MYSQL_HOSTNAME) + "'             ," +
                    " 'port' = '" + config.getString(ConfigName.MYSQL_PORT) + "'                     ," +
                    " 'username' = '" + config.getString(ConfigName.MYSQL_JDBC_USER) + "'            ," +
                    " 'password' = '" + config.getString(ConfigName.MYSQL_JDBC_PASSWORD) + "'        ," +
                    " 'database-name' = '" + config.getString(ConfigName.MYSQL_DATABASE) + "'        ," +
                    " 'table-name' = 'mdl_role_assignments' " +
                    ")";


    public static final String create_mdl_context =
            "CREATE TABLE mdl_context  (  " +
                    "  contextlevel   BIGINT  " +
                    " ,depth          INT     " +
                    " ,id             BIGINT  " +
                    " ,instanceid     BIGINT  " +
                    " ,locked         INT     " +
                    " ,`path`         STRING  " +
                    " ,PRIMARY KEY(id) NOT ENFORCED  " +
                    ") WITH ( " +
                    " 'connector' = 'mysql-cdc', " +
                    " 'scan.startup.mode' = '" + config.getString(ConfigName.MYSQL_SCAN_MODE) + "'   ," +
                    " 'hostname' = '" + config.getString(ConfigName.MYSQL_HOSTNAME) + "'             ," +
                    " 'port' = '" + config.getString(ConfigName.MYSQL_PORT) + "'                     ," +
                    " 'username' = '" + config.getString(ConfigName.MYSQL_JDBC_USER) + "'            ," +
                    " 'password' = '" + config.getString(ConfigName.MYSQL_JDBC_PASSWORD) + "'        ," +
                    " 'database-name' = '" + config.getString(ConfigName.MYSQL_DATABASE) + "'        ," +
                    " 'table-name' = 'mdl_context' " +
                    ")";


    public static final String create_mdl_grade_grades =
            "CREATE TABLE mdl_grade_grades  (   " +
                    "   aggregationstatus     STRING   " +
                    "  ,aggregationweight     decimal  " +
                    "  ,excluded              BIGINT   " +
                    "  ,exported              BIGINT   " +
                    "  ,feedback              STRING   " +
                    "  ,feedbackformat        BIGINT   " +
                    "  ,finalgrade            decimal  " +
                    "  ,hidden                BIGINT   " +
                    "  ,id                    BIGINT   " +
                    "  ,information           STRING   " +
                    "  ,informationformat     BIGINT   " +
                    "  ,itemid                BIGINT   " +
                    "  ,locked                BIGINT   " +
                    "  ,locktime              BIGINT   " +
                    "  ,overridden            BIGINT   " +
                    "  ,rawgrade              decimal  " +
                    "  ,rawgrademax           decimal  " +
                    "  ,rawgrademin           decimal  " +
                    "  ,rawscaleid            BIGINT   " +
                    "  ,timecreated           BIGINT   " +
                    "  ,timemodified          BIGINT   " +
                    "  ,userid                BIGINT   " +
                    "  ,usermodified          BIGINT   " +
                    " ,PRIMARY KEY(id) NOT ENFORCED    " +
                    ") WITH ( " +
                    " 'connector' = 'mysql-cdc', " +
                    " 'scan.startup.mode' = '" + config.getString(ConfigName.MYSQL_SCAN_MODE) + "'   ," +
                    " 'hostname' = '" + config.getString(ConfigName.MYSQL_HOSTNAME) + "'             ," +
                    " 'port' = '" + config.getString(ConfigName.MYSQL_PORT) + "'                     ," +
                    " 'username' = '" + config.getString(ConfigName.MYSQL_JDBC_USER) + "'            ," +
                    " 'password' = '" + config.getString(ConfigName.MYSQL_JDBC_PASSWORD) + "'        ," +
                    " 'database-name' = '" + config.getString(ConfigName.MYSQL_DATABASE) + "'        ," +
                    " 'table-name' = 'mdl_grade_grades' " +
                    ")";


    public static final String create_mdl_grade_items =
            "CREATE TABLE mdl_grade_items  (   " +
                    "   aggregationcoef       decimal  " +
                    "  ,aggregationcoef2      decimal  " +
                    "  ,calculation           STRING   " +
                    "  ,categoryid            BIGINT   " +
                    "  ,courseid              BIGINT   " +
                    "  ,decimals              INT      " +
                    "  ,display               BIGINT   " +
                    "  ,grademax              decimal  " +
                    "  ,grademin              decimal  " +
                    "  ,gradepass             decimal  " +
                    "  ,gradetype             INT      " +
                    "  ,hidden                BIGINT   " +
                    "  ,id                    BIGINT   " +
                    "  ,idnumber              STRING   " +
                    "  ,iteminfo              STRING   " +
                    "  ,iteminstance          BIGINT   " +
                    "  ,itemmodule            STRING   " +
                    "  ,itemname              STRING   " +
                    "  ,itemnumber            BIGINT   " +
                    "  ,itemtype              STRING   " +
                    "  ,locked                BIGINT   " +
                    "  ,locktime              BIGINT   " +
                    "  ,multfactor            decimal  " +
                    "  ,needsupdate           BIGINT   " +
                    "  ,outcomeid             BIGINT   " +
                    "  ,plusfactor            decimal  " +
                    "  ,scaleid               BIGINT   " +
                    "  ,sortorder             BIGINT   " +
                    "  ,timecreated           BIGINT   " +
                    "  ,timemodified          BIGINT   " +
                    "  ,weightoverride        INT      " +
                    " ,PRIMARY KEY(id) NOT ENFORCED    " +
                    ") WITH ( " +
                    " 'connector' = 'mysql-cdc', " +
                    " 'scan.startup.mode' = '" + config.getString(ConfigName.MYSQL_SCAN_MODE) + "'   ," +
                    " 'hostname' = '" + config.getString(ConfigName.MYSQL_HOSTNAME) + "'             ," +
                    " 'port' = '" + config.getString(ConfigName.MYSQL_PORT) + "'                     ," +
                    " 'username' = '" + config.getString(ConfigName.MYSQL_JDBC_USER) + "'            ," +
                    " 'password' = '" + config.getString(ConfigName.MYSQL_JDBC_PASSWORD) + "'        ," +
                    " 'database-name' = '" + config.getString(ConfigName.MYSQL_DATABASE) + "'        ," +
                    " 'table-name' = 'mdl_grade_items' " +
                    ")";

    public static final String create_mdl_groups_members =
            "CREATE TABLE mdl_groups_members  (   " +
                    "   component  STRING  " +
                    "  ,groupid    BIGINT  " +
                    "  ,id         BIGINT  " +
                    "  ,itemid     BIGINT  " +
                    "  ,timeadded  BIGINT  " +
                    "  ,userid     BIGINT  " +
                    " ,PRIMARY KEY(id) NOT ENFORCED    " +
                    ") WITH ( " +
                    " 'connector' = 'mysql-cdc', " +
                    " 'scan.startup.mode' = '" + config.getString(ConfigName.MYSQL_SCAN_MODE) + "'   ," +
                    " 'hostname' = '" + config.getString(ConfigName.MYSQL_HOSTNAME) + "'             ," +
                    " 'port' = '" + config.getString(ConfigName.MYSQL_PORT) + "'                     ," +
                    " 'username' = '" + config.getString(ConfigName.MYSQL_JDBC_USER) + "'            ," +
                    " 'password' = '" + config.getString(ConfigName.MYSQL_JDBC_PASSWORD) + "'        ," +
                    " 'database-name' = '" + config.getString(ConfigName.MYSQL_DATABASE) + "'        ," +
                    " 'table-name' = 'mdl_groups_members' " +
                    ")";


    public static final String create_mdl_assign =
            "CREATE TABLE mdl_assign  (   " +
                    "  allowsubmissionsfromdate      BIGINT " +
                    " ,alwaysshowdescription         INT    " +
                    " ,attemptreopenmethod           STRING " +
                    " ,blindmarking                  INT    " +
                    " ,completionsubmit              INT    " +
                    " ,course                        BIGINT " +
                    " ,cutoffdate                    BIGINT " +
                    " ,duedate                       BIGINT " +
                    " ,grade                         BIGINT " +
                    " ,gradingduedate                BIGINT " +
                    " ,hidegrader                    INT    " +
                    " ,id                            BIGINT " +
                    " ,INTro                         STRING " +
                    " ,INTroformat                   INT    " +
                    " ,markingallocation             INT    " +
                    " ,markingworkflow               INT    " +
                    " ,maxattempts                   INT    " +
                    " ,name                          STRING " +
                    " ,nosubmissions                 INT    " +
                    " ,preventsubmissionnotingroup   INT    " +
                    " ,requireallteammemberssubmit   INT    " +
                    " ,requiresubmissionstatement    INT    " +
                    " ,revealidentities              INT    " +
                    " ,sendlatenotifications         INT    " +
                    " ,sendnotifications             INT    " +
                    " ,sendstudentnotifications      INT    " +
                    " ,submissiondrafts              INT    " +
                    " ,teamsubmission                INT    " +
                    " ,teamsubmissiongroupingid      BIGINT " +
                    " ,timemodified                  BIGINT " +
                    " ,PRIMARY KEY(id) NOT ENFORCED    " +
                    ") WITH ( " +
                    " 'connector' = 'mysql-cdc', " +
                    " 'scan.startup.mode' = '" + config.getString(ConfigName.MYSQL_SCAN_MODE) + "'   ," +
                    " 'hostname' = '" + config.getString(ConfigName.MYSQL_HOSTNAME) + "'             ," +
                    " 'port' = '" + config.getString(ConfigName.MYSQL_PORT) + "'                     ," +
                    " 'username' = '" + config.getString(ConfigName.MYSQL_JDBC_USER) + "'            ," +
                    " 'password' = '" + config.getString(ConfigName.MYSQL_JDBC_PASSWORD) + "'        ," +
                    " 'database-name' = '" + config.getString(ConfigName.MYSQL_DATABASE) + "'        ," +
                    " 'table-name' = 'mdl_assign' " +
                    ")";


    public static final String create_mdl_assign_submission =
            "CREATE TABLE mdl_assign_submission  (   " +
                    "  assignment     BIGINT" +
                    " ,attemptnumber  BIGINT" +
                    " ,groupid        BIGINT" +
                    " ,id             BIGINT" +
                    " ,latest         INT   " +
                    " ,`status`       STRING" +
                    " ,timecreated    BIGINT" +
                    " ,timemodified   BIGINT" +
                    " ,userid         BIGINT" +
                    " ,PRIMARY KEY(id) NOT ENFORCED " +
                    ") WITH ( " +
                    " 'connector' = 'mysql-cdc', " +
                    " 'scan.startup.mode' = '" + config.getString(ConfigName.MYSQL_SCAN_MODE) + "'   ," +
                    " 'hostname' = '" + config.getString(ConfigName.MYSQL_HOSTNAME) + "'             ," +
                    " 'port' = '" + config.getString(ConfigName.MYSQL_PORT) + "'                     ," +
                    " 'username' = '" + config.getString(ConfigName.MYSQL_JDBC_USER) + "'            ," +
                    " 'password' = '" + config.getString(ConfigName.MYSQL_JDBC_PASSWORD) + "'        ," +
                    " 'database-name' = '" + config.getString(ConfigName.MYSQL_DATABASE) + "'        ," +
                    " 'table-name' = 'mdl_assign_submission' " +
                    ")";


    public static final String create_mdl_assign_grades =
            "CREATE TABLE mdl_assign_grades  (   " +
                    "  assignment      BIGINT  " +
                    " ,attemptnumber   BIGINT  " +
                    " ,grade           decimal " +
                    " ,grader          BIGINT  " +
                    " ,id              BIGINT  " +
                    " ,timecreated     BIGINT  " +
                    " ,timemodified    BIGINT  " +
                    " ,userid          BIGINT  " +
                    " ,PRIMARY KEY(id) NOT ENFORCED " +
                    ") WITH ( " +
                    " 'connector' = 'mysql-cdc', " +
                    " 'scan.startup.mode' = '" + config.getString(ConfigName.MYSQL_SCAN_MODE) + "'   ," +
                    " 'hostname' = '" + config.getString(ConfigName.MYSQL_HOSTNAME) + "'             ," +
                    " 'port' = '" + config.getString(ConfigName.MYSQL_PORT) + "'                     ," +
                    " 'username' = '" + config.getString(ConfigName.MYSQL_JDBC_USER) + "'            ," +
                    " 'password' = '" + config.getString(ConfigName.MYSQL_JDBC_PASSWORD) + "'        ," +
                    " 'database-name' = '" + config.getString(ConfigName.MYSQL_DATABASE) + "'        ," +
                    " 'table-name' = 'mdl_assign_grades' " +
                    ")";


    public static final String create_mdl_role =
            "CREATE TABLE mdl_role  (   " +
                    "  archetype    STRING  " +
                    " ,description  STRING  " +
                    " ,id           BIGINT  " +
                    " ,name         STRING  " +
                    " ,shortname    STRING  " +
                    " ,sortorder    BIGINT  " +
                    " ,PRIMARY KEY(id) NOT ENFORCED    " +
                    ") WITH ( " +
                    " 'connector' = 'mysql-cdc', " +
                    " 'scan.startup.mode' = '" + config.getString(ConfigName.MYSQL_SCAN_MODE) + "'   ," +
                    " 'hostname' = '" + config.getString(ConfigName.MYSQL_HOSTNAME) + "'             ," +
                    " 'port' = '" + config.getString(ConfigName.MYSQL_PORT) + "'                     ," +
                    " 'username' = '" + config.getString(ConfigName.MYSQL_JDBC_USER) + "'            ," +
                    " 'password' = '" + config.getString(ConfigName.MYSQL_JDBC_PASSWORD) + "'        ," +
                    " 'database-name' = '" + config.getString(ConfigName.MYSQL_DATABASE) + "'        ," +
                    " 'table-name' = 'mdl_role' " +
                    ")";


    public static final String create_mdl_page =
            "CREATE TABLE mdl_page  (   " +
                    "   content            STRING  " +
                    "  ,contentformat      INT     " +
                    "  ,course             BIGINT  " +
                    "  ,display            INT     " +
                    "  ,displayoptions     STRING  " +
                    "  ,id                 BIGINT  " +
                    "  ,INTro              STRING  " +
                    "  ,INTroformat        INT     " +
                    "  ,legacyfiles        INT     " +
                    "  ,legacyfileslast    BIGINT  " +
                    "  ,name               STRING  " +
                    "  ,revision           BIGINT  " +
                    "  ,timemodified       BIGINT  " +
                    "  ,PRIMARY KEY(id) NOT ENFORCED " +
                    ") WITH ( " +
                    " 'connector' = 'mysql-cdc', " +
                    " 'scan.startup.mode' = '" + config.getString(ConfigName.MYSQL_SCAN_MODE) + "'   ," +
                    " 'hostname' = '" + config.getString(ConfigName.MYSQL_HOSTNAME) + "'             ," +
                    " 'port' = '" + config.getString(ConfigName.MYSQL_PORT) + "'                     ," +
                    " 'username' = '" + config.getString(ConfigName.MYSQL_JDBC_USER) + "'            ," +
                    " 'password' = '" + config.getString(ConfigName.MYSQL_JDBC_PASSWORD) + "'        ," +
                    " 'database-name' = '" + config.getString(ConfigName.MYSQL_DATABASE) + "'        ," +
                    " 'table-name' = 'mdl_page' " +
                    ")";

    public static final String create_mdl_url =
            "CREATE TABLE mdl_url  (   " +
                    "  course           BIGINT   " +
                    " ,display          INT      " +
                    " ,displayoptions   STRING   " +
                    " ,externalurl      STRING   " +
                    " ,id               BIGINT   " +
                    " ,INTro            STRING   " +
                    " ,INTroformat      INT      " +
                    " ,name             STRING   " +
                    " ,parameters       STRING   " +
                    " ,timemodified     BIGINT   " +
                    " ,PRIMARY KEY(id) NOT ENFORCED " +
                    ") WITH ( " +
                    " 'connector' = 'mysql-cdc', " +
                    " 'scan.startup.mode' = '" + config.getString(ConfigName.MYSQL_SCAN_MODE) + "'   ," +
                    " 'hostname' = '" + config.getString(ConfigName.MYSQL_HOSTNAME) + "'             ," +
                    " 'port' = '" + config.getString(ConfigName.MYSQL_PORT) + "'                     ," +
                    " 'username' = '" + config.getString(ConfigName.MYSQL_JDBC_USER) + "'            ," +
                    " 'password' = '" + config.getString(ConfigName.MYSQL_JDBC_PASSWORD) + "'        ," +
                    " 'database-name' = '" + config.getString(ConfigName.MYSQL_DATABASE) + "'        ," +
                    " 'table-name' = 'mdl_url' " +
                    ")";


    public static final String create_mdl_quiz =
            "CREATE TABLE mdl_quiz  (   " +
                    "  allowofflineattempts         INT     " +
                    " ,attemptonlast                INT     " +
                    " ,attempts                     INT     " +
                    " ,browsersecurity              STRING  " +
                    " ,canredoquestions             INT     " +
                    " ,completionattemptsexhausted  INT     " +
                    " ,completionpass               INT     " +
                    " ,course                       BIGINT  " +
                    " ,decimalpoINTs                INT     " +
                    " ,delay1                       BIGINT  " +
                    " ,delay2                       BIGINT  " +
                    " ,graceperiod                  BIGINT  " +
                    " ,grade                        decimal " +
                    " ,grademethod                  INT     " +
                    " ,id                           BIGINT  " +
                    " ,INTro                        STRING  " +
                    " ,INTroformat                  INT     " +
                    " ,name                         STRING  " +
                    " ,navmethod                    STRING  " +
                    " ,overduehandling              STRING  " +
                    " ,`password` `                 STRING  " +
                    " ,preferredbehaviour           STRING  " +
                    " ,questiondecimalpoINTs        INT     " +
                    " ,questionsperpage             BIGINT  " +
                    " ,reviewattempt                INT     " +
                    " ,reviewcorrectness            INT     " +
                    " ,reviewgeneralfeedback        INT     " +
                    " ,reviewmarks                  INT     " +
                    " ,reviewoverallfeedback        INT     " +
                    " ,reviewrightanswer            INT     " +
                    " ,reviewspecificfeedback       INT     " +
                    " ,showblocks                   INT     " +
                    " ,showuserpicture              INT     " +
                    " ,shuffleanswers               INT     " +
                    " ,subnet                       STRING  " +
                    " ,sumgrades                    decimal " +
                    " ,timeclose                    BIGINT  " +
                    " ,timecreated                  BIGINT  " +
                    " ,timelimit                    BIGINT  " +
                    " ,timemodified                 BIGINT  " +
                    " ,timeopen                     BIGINT  " +
                    " ,PRIMARY KEY(id) NOT ENFORCED  " +
                    ") WITH ( " +
                    " 'connector' = 'mysql-cdc', " +
                    " 'scan.startup.mode' = '" + config.getString(ConfigName.MYSQL_SCAN_MODE) + "'   ," +
                    " 'hostname' = '" + config.getString(ConfigName.MYSQL_HOSTNAME) + "'             ," +
                    " 'port' = '" + config.getString(ConfigName.MYSQL_PORT) + "'                     ," +
                    " 'username' = '" + config.getString(ConfigName.MYSQL_JDBC_USER) + "'            ," +
                    " 'password' = '" + config.getString(ConfigName.MYSQL_JDBC_PASSWORD) + "'        ," +
                    " 'database-name' = '" + config.getString(ConfigName.MYSQL_DATABASE) + "'        ," +
                    " 'table-name' = 'mdl_quiz' " +
                    ")";


    public static final String create_mdl_videofile =
            "CREATE TABLE mdl_videofile  (   " +
                    "  course        BIGINT   " +
                    " ,height        INT      " +
                    " ,id            BIGINT   " +
                    " ,INTro         STRING   " +
                    " ,INTroformat   INT      " +
                    " ,name          STRING   " +
                    " ,responsive    INT      " +
                    " ,timecreated   BIGINT   " +
                    " ,timemodified  BIGINT   " +
                    " ,width         INT      " +
                    " ,PRIMARY KEY(id) NOT ENFORCED " +
                    ") WITH ( " +
                    " 'connector' = 'mysql-cdc', " +
                    " 'scan.startup.mode' = '" + config.getString(ConfigName.MYSQL_SCAN_MODE) + "'   ," +
                    " 'hostname' = '" + config.getString(ConfigName.MYSQL_HOSTNAME) + "'             ," +
                    " 'port' = '" + config.getString(ConfigName.MYSQL_PORT) + "'                     ," +
                    " 'username' = '" + config.getString(ConfigName.MYSQL_JDBC_USER) + "'            ," +
                    " 'password' = '" + config.getString(ConfigName.MYSQL_JDBC_PASSWORD) + "'        ," +
                    " 'database-name' = '" + config.getString(ConfigName.MYSQL_DATABASE) + "'        ," +
                    " 'table-name' = 'mdl_videofile' " +
                    ")";

    public static final String create_mdl_quiz_attempts =
            "CREATE TABLE mdl_quiz_attempts  (   " +
                    "  attempt                INT     " +
                    " ,currentpage            BIGINT  " +
                    " ,id                     BIGINT  " +
                    " ,layout                 STRING  " +
                    " ,preview                INT     " +
                    " ,quiz                   BIGINT  " +
                    " ,`state`                STRING  " +
                    " ,sumgrades              decimal " +
                    " ,timecheckstate         BIGINT  " +
                    " ,timefinish             BIGINT  " +
                    " ,timemodified           BIGINT  " +
                    " ,timemodifiedoffline    BIGINT  " +
                    " ,timestart              BIGINT  " +
                    " ,uniqueid               BIGINT  " +
                    " ,userid                 BIGINT  " +
                    " ,PRIMARY KEY(id) NOT ENFORCED " +
                    ") WITH ( " +
                    " 'connector' = 'mysql-cdc', " +
                    " 'scan.startup.mode' = '" + config.getString(ConfigName.MYSQL_SCAN_MODE) + "'   ," +
                    " 'hostname' = '" + config.getString(ConfigName.MYSQL_HOSTNAME) + "'             ," +
                    " 'port' = '" + config.getString(ConfigName.MYSQL_PORT) + "'                     ," +
                    " 'username' = '" + config.getString(ConfigName.MYSQL_JDBC_USER) + "'            ," +
                    " 'password' = '" + config.getString(ConfigName.MYSQL_JDBC_PASSWORD) + "'        ," +
                    " 'database-name' = '" + config.getString(ConfigName.MYSQL_DATABASE) + "'        ," +
                    " 'table-name' = 'mdl_quiz_attempts' " +
                    ")";


    public static final String create_mdl_course_sections =
            "CREATE TABLE mdl_course_sections  (   " +
                    "  availability    STRING  " +
                    " ,course          BIGINT  " +
                    " ,id              BIGINT  " +
                    " ,name            STRING  " +
                    " ,section         BIGINT  " +
                    " ,sequence        STRING  " +
                    " ,summary         STRING  " +
                    " ,summaryformat   INT     " +
                    " ,timemodified    BIGINT  " +
                    " ,visible         INT     " +
                    " ,PRIMARY KEY(id) NOT ENFORCED " +
                    ") WITH ( " +
                    " 'connector' = 'mysql-cdc', " +
                    " 'scan.startup.mode' = '" + config.getString(ConfigName.MYSQL_SCAN_MODE) + "'   ," +
                    " 'hostname' = '" + config.getString(ConfigName.MYSQL_HOSTNAME) + "'             ," +
                    " 'port' = '" + config.getString(ConfigName.MYSQL_PORT) + "'                     ," +
                    " 'username' = '" + config.getString(ConfigName.MYSQL_JDBC_USER) + "'            ," +
                    " 'password' = '" + config.getString(ConfigName.MYSQL_JDBC_PASSWORD) + "'        ," +
                    " 'database-name' = '" + config.getString(ConfigName.MYSQL_DATABASE) + "'        ," +
                    " 'table-name' = 'mdl_course_sections' " +
                    ")";

    public static final String create_mdl_modules =
            "CREATE TABLE mdl_modules  (   " +
                    "  cron     BIGINT " +
                    " ,id       BIGINT " +
                    " ,lastcron BIGINT " +
                    " ,name     STRING " +
                    " ,`search` STRING " +
                    " ,visible  INT    " +
                    " ,PRIMARY KEY(id) NOT ENFORCED " +
                    ") WITH ( " +
                    " 'connector' = 'mysql-cdc', " +
                    " 'scan.startup.mode' = '" + config.getString(ConfigName.MYSQL_SCAN_MODE) + "'   ," +
                    " 'hostname' = '" + config.getString(ConfigName.MYSQL_HOSTNAME) + "'             ," +
                    " 'port' = '" + config.getString(ConfigName.MYSQL_PORT) + "'                     ," +
                    " 'username' = '" + config.getString(ConfigName.MYSQL_JDBC_USER) + "'            ," +
                    " 'password' = '" + config.getString(ConfigName.MYSQL_JDBC_PASSWORD) + "'        ," +
                    " 'database-name' = '" + config.getString(ConfigName.MYSQL_DATABASE) + "'        ," +
                    " 'table-name' = 'mdl_modules' " +
                    ")";


 /*   测试代码
 public static final String create_mdl_modules2 =
            "CREATE TABLE mdl_modules2  (   " +
                    "  cron     BIGINT " +
                    " ,id       BIGINT " +
                    " ,lastcron BIGINT " +
                    " ,name     STRING " +
                    " ,`search` STRING " +
                    " ,visible  INT    " +
                    " ,PRIMARY KEY(id) NOT ENFORCED " +
                    ") WITH ( " +
                    " 'connector' = 'mysql-cdc', " +
                    " 'scan.startup.mode' = 'initial'  ," +
                    " 'hostname' = '114.115.169.37' ," +
                    " 'port' = '3306' ," +
                    " 'username' = 'root' ," +
                    " 'password' = 'Ouc#1234' ," +
                    " 'database-name' = 'syxy_test' ," +
                    " 'table-name' = 'mdl_modules' " +
                    ")";*/

}
