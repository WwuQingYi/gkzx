package cn.gk.rtdw.custom_method;

import org.apache.flink.table.functions.ScalarFunction;

import java.text.ParseException;

/**
 * @Author: HT
 * @Date: 2022/5/2
 * @Description: 判断数组中是否包含一个字符串
 */
public class ContainsString extends ScalarFunction {

    public String eval(String[] arr, String str) throws ParseException {

        try {
            for (int i = 0; i < arr.length; i++) {
                if (str.equals(arr[i])) {
                    return arr[i];
                }
            }
        } catch (Exception e) {
            //
        }
        return null;
    }

    /*public static void main(String[] args) throws ParseException {
        String[] str = {"vod","live"};

        System.out.println(eval(str, "kk"));

    }*/
}
