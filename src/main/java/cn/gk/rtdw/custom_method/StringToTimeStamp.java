package cn.gk.rtdw.custom_method;

import org.apache.flink.table.functions.ScalarFunction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: HT
 * @Date: 2022/5/26
 * @Description:
 */
public class StringToTimeStamp extends ScalarFunction {

    public long eval(String str) {
        if (str == null) return 0L;
        String replace = str.replace('T', ' ');
        // 2022-05-22 11:00:00
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date p1 = null;
        try {
            p1 = dateFormat.parse(replace);
        } catch (ParseException e) {
            //
        }

        Calendar ca1 = Calendar.getInstance();
        if (p1 == null) return 0L;
        ca1.setTime(p1);

        return ca1.getTimeInMillis();
    }
}
