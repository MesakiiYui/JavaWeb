<<<<<<< HEAD
package functest.Date;

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

        System.out.println("Current Date: " + ft.format(dateNow));

        SimpleDateFormat ft2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        System.out.println("Current Datetime: " + ft2.format(dateNow));

        String str = String.format("Current Date/Time : %tc", dateNow);

        System.out.printf(str);


    }

    private void dateCompare() {

    }
    public static void main(String[] args) {
        MyDate md = new MyDate();
        md.dateParser();

    }
}

=======
package functest.Date;

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

        System.out.println("Current Date: " + ft.format(dateNow));

        SimpleDateFormat ft2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        System.out.println("Current Datetime: " + ft2.format(dateNow));

        String str = String.format("Current Date/Time : %tc", dateNow);

        System.out.printf(str);


    }
    public static void main(String[] args) {
        MyDate md = new MyDate();
        md.dateParser();

    }
}

>>>>>>> 88753f20a8c6141a51d913abc17cf0994eb3a2b4
