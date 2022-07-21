package cn.gk.rtdw.custom_method;

import org.apache.flink.table.functions.AggregateFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: HT
 * @Date: 2022/5/26
 * @Description: 自定义CollectList
 */
public class CollectList extends AggregateFunction<String[], List<String>> {

    public void retract(List acc,String str){
        acc.remove(str);
    }

    public void accumulate(List acc,String str){
        // 将数据添加到累加器中
        acc.add(str);
    }

    @Override
    public String[] getValue(List list) {
        // 获取累加器
        return (String[]) list.toArray(new String[0]);
    }

    @Override
    public List createAccumulator() {
        // 创建累加器
        return new ArrayList<>();
    }

    public void resetAccumulator(List list){
        // 重置累加器
        list.clear();
    }
}
