package cn.gk.rtdw.flinksql_cdc;

import cn.gk.rtdw.utils.*;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;


/**
 * @Date：2022/6/30
 * @Description： flink-sql解析数据
 */
public class FlinkSql_AnalysisData {
    public static void main(String[] args) throws Exception {
        // 获取 执行对象
        StreamExecutionEnvironment env = FlinkUtils.env;
        StreamTableEnvironment tableEnv = FlinkUtils.getTableEnv();

        System.out.println("hello");



    }
}
