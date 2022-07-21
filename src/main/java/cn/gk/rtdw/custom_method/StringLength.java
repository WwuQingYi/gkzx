package cn.gk.rtdw.custom_method;

import org.apache.flink.table.functions.ScalarFunction;

import java.text.ParseException;

/**
 * @Author: HT
 * @Date: 2022/5/2
 * @Description:
 */
public class StringLength extends ScalarFunction {

    public int eval(String arr) throws ParseException {
        if (arr == null) return 0;
        return arr.length();
    }
}