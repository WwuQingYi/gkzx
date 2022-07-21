package cn.gk.rtdw.custom_method;

import org.apache.flink.table.functions.ScalarFunction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: HT
 * @Date: 2022/4/23
 * @Description: 自定义函数处理   时间戳
 */
public class AnalysisTime extends ScalarFunction {

    /**
     * 方法名必须是 eval
     */
    public String eval(String str) throws ParseException {
        if (str == null) return null;
        SimpleDateFormat format = null;
        long longTime = 0;
        try {
            // 2022-04-14T20:11:51+08:00
            String[] split = str.split("\\+");
            // 2022-04-14T20:11:51  -->  2022-04-14 20:11:51
            String strTime = split[0].replace('T', ' ');
            format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = format.parse(strTime);
            // 时间戳
            longTime = date.getTime() + 8 * 60 * 60 * 1000;
        } catch (ParseException e) {
            //
        }
        // yyyy-MM-dd HH:mm:ss
        return format.format(longTime);
    }

}
