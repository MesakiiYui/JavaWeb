package functest.Date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QueryDate {

    public static void main(String[] args){
        Date date1 = new Date();
        System.out.println(date1);
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        dataFormat = dataFormat.substring(0,19).trim().replaceAll(" ", "T");
        System.out.println(dataFormat);

    }
}
