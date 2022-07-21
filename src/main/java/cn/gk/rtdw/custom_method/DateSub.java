package cn.gk.rtdw.custom_method;

import org.apache.flink.table.functions.ScalarFunction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: HT
 * @Date: 2022/5/16
 * @Description:
 */
public class DateSub extends ScalarFunction {

    public int eval(String startTime, String endTime) {
        String replace1 = startTime.replace('T', ' ');
        String replace2 = endTime.replace('T', ' ');
        Date parse1 = null;
        Date parse2 = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            parse1 = format.parse(replace1);
            parse2 = format.parse(replace2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar ca1 = Calendar.getInstance();
        Calendar ca2 = Calendar.getInstance();

        if (parse1 == null || parse2 == null) {
            return 0;
        }
        ca1.setTime(parse1);
        ca2.setTime(parse2);

        long l = (ca2.getTimeInMillis() - ca1.getTimeInMillis()) / 1000 / 60;

        return (int) l;
    }


}
