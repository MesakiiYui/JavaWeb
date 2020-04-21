package functest.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCompare {
    public static void main(String[] args)throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date oldDate1 = format.parse("2018-05-12 15:16:00"); //这里时间可以自己定
        Date oldDate2 = format.parse("2011-05-12 15:16:00"); //这里时间可以自己定
        System.out.println(oldDate1.compareTo(oldDate2)); //判断,如果时间在这时间后,就执行后面操作
        }
}
