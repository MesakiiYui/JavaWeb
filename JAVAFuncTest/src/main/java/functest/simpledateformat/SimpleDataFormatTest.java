package functest.simpledateformat;

import java.util.Date;
import java.util.TimeZone;

public class SimpleDataFormatTest {
    public static void main(String[] args) {
        Date now=new Date();
        java.text.SimpleDateFormat sdfYMD = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdfYMD.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        System.out.println(sdfYMD.format(now));
        System.out.println(sdfYMD.getClass().getName().toString());
    }
}
