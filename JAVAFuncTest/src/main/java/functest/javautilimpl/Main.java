package functest.javautilimpl;

import java.util.ArrayList;
import java.util.Iterator;
public class Main {
    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        al.add(new People(11));
        Iterator it = al.iterator();
        while(it.hasNext()) {
            System.out.println(((People)it.next()).getAge());
        }
        String a = "";


    }
}
