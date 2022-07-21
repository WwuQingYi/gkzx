package cn.gk.rtdw.custom_method;

import org.apache.flink.table.functions.AggregateFunction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: HT
 * @Date: 2022/5/1
 * @Description: 收集去重函数
 */
public class CollectSet extends AggregateFunction<String[], List<String>> {

        public void accumulate(List acc,String column){
            acc.add(column);
        }

        public void retract(List acc,String column){
            acc.remove(column);
        }

        @Override
        public String[] getValue(List list) {
            Set set= new HashSet(list);
            return (String[]) set.toArray(new String[0]);
        }

        @Override
        public List createAccumulator() {
            List list = new ArrayList();
            return list;
        }

        public void resetAccumulator(List acc){
            acc.clear();
        }

}
