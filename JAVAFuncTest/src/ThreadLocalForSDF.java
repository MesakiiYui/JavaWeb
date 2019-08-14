import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
* 利用ThreadLocal解决SimpleDateFormat的并发冲突问题
* */
public class ThreadLocalForSDF {
    private static ThreadLocal<DateFormat> threadLocalYMD = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static Date parse(String dateStr) throws ParseException {
        return threadLocalYMD.get().parse(dateStr);
    }

    public static String format(Date date) {
        return threadLocalYMD.get().format(date);
    }
    public static void main(String[] args) {
        Date now=new Date();
        System.out.println(format(now));




    }

}
