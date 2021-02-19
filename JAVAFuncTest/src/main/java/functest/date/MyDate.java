package functest.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * https://www.yiibai.com/java/java_date_time.html
 */
public class MyDate {
    private void dateParser() {
        Date dateNow = new Date();
        System.out.println(dateNow.toString());//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/java/java_date_time.html
        SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd (E)'at' hh:mm:ss a zzz");

        System.out.println("Current date: " + ft.format(dateNow));

        SimpleDateFormat ft2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        System.out.println("Current Datetime: " + ft2.format(dateNow));

        String str = String.format("Current date/Time : %tc", dateNow);

        System.out.printf(str);


    }

    private void dateCompare() {

    }
    public static void main(String[] args) {
        MyDate md = new MyDate();
        md.dateParser();

    }
}