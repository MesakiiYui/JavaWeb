package functest.date;

import java.util.Calendar;

/**
 * @Author: jintienan
 * @Date: 2020/9/2 16:16
 */
public class DateNow {
    public static void main(String[] args){
        // 通过getInstance获取当前日期calendar实例
        Calendar calendar = Calendar.getInstance();
// Month需要+1才是目标月
        System.out.println(calendar.get(Calendar.YEAR) + "年"
                + (calendar.get(Calendar.MONTH) + 1) + "月"
                + calendar.get(Calendar.DAY_OF_MONTH) + "日");
// 加6天
        calendar.add(Calendar.DATE, 6);
        System.out.println(calendar.get(Calendar.YEAR) + "年"
                + (calendar.get(Calendar.MONTH) + 1) + "月"
                + calendar.get(Calendar.DAY_OF_MONTH) + "日");

        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

    }
}
