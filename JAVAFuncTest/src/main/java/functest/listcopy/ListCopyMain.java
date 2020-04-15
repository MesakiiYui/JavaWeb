package functest.listcopy;

import java.util.ArrayList;
import java.util.List;

/**
 * 浅拷贝
 */
public class ListCopyMain {

    public static void main(String[] args) {
        List<People> peopleList = new ArrayList<People>();
        List<People> peopleList2 = new ArrayList<People>();
        List<People> peopleList3 = new ArrayList<People>();
        People people1 = new People();
        people1.setAge(20);
        people1.setName("joke");
        People people2 = new People();
        people2.setAge(30);
        people2.setName("sa");
        peopleList.add(people1);
        peopleList.add(people2);
        for(People people : peopleList){
            peopleList2.add(people);
        }
        peopleList3.addAll(peopleList);
        List<People> peopleList4 = new ArrayList<People>(peopleList);
        for(People people : peopleList) {
            people.setAge(88);
        }
        System.out.println(peopleList4.toString());
        People people3 = new People("rose", 18);
        peopleList.add(people3);
        peopleList.remove(0);
        System.out.println(peopleList);
        System.out.println(peopleList2);
        System.out.println(peopleList3);
        System.out.println(peopleList4);
    }
}
