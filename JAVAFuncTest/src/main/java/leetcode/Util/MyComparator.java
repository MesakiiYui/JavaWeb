package leetcode.Util;

import java.util.Comparator;

public class MyComparator implements Comparator {

    public int compare(Object o1, Object o2) {
       String str1 = (String) o1;
       String str2 = (String) o2;
       if(str1.length() < str2.length()) {
           return 1;
       }
        if(str2.length() < str1.length()) {
            return -1;
        }
        return 0;
    }
}

