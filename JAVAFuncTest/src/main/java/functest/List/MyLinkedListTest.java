package functest.List;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;

public class MyLinkedListTest {
    private static void generateLinkedList() {
        LinkedList<String> lList = new LinkedList<String>();
        lList.add("1");
        lList.add("2");
        lList.add("3");
        lList.add("4");
        lList.add("5");
        System.out.println("链表的第一个元素是 : " + lList.getFirst());
        System.out.println("链表最后一个元素是 : " + lList.getLast());
        LinkedList<String> lList2 = new LinkedList<>(lList);
        lList2.add(2,"xxxxx");
        lList2.addAll(lList2.size(),lList);
        System.out.println(lList2);
    }
    public static void main(String[] args) {
        generateLinkedList();

    }
}
