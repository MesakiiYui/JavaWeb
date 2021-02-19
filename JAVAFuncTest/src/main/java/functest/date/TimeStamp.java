package functest.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStamp {

    public static void main(String[] args){
        String time = "1588583589000";
        Long timeLong = Long.parseLong(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//要转换的时间格式
        Date date;
        try {
            date = sdf.parse(sdf.format(timeLong));
            System.out.println(sdf.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
