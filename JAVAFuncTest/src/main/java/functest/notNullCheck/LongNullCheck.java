package functest.notNullCheck;

import java.util.List;

public class LongNullCheck {

    public static void main(String[] args) {
        String three = "0";
        System.out.println(three.substring(0, three.length()));

        List<String> strList = null;
        // strList.get(0);

        System.out.println(strList == null);
        }
    }