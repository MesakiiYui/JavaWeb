package functest.set;

import java.util.HashSet;
import java.util.Set;

public class SetBasic {
    public static void main(String[] args) {
        Set<String> set=new HashSet<String>();

        set.add("1");
        set.add("2");
        set.add("3");
        set.add("1");
        for(String i : set){
            System.out.println(i);
        }
        if(set.contains("2")){
            System.out.println("contains 2");
        }

        Set<Integer> setInt = new HashSet<Integer>();
        int a = 1;
        setInt.add(a);

    }
}
