package functest.iterator;


import functest.Serializable.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 迭代器是一种模式,可以使得序列类型的数据结构的遍历行为与被遍历的对象分离，
 * 即我们无需关心该序列的底层结构是什么样子的。只要拿到这个对象,使用迭代器就可以遍历这个对象的内部。
 */

/**
 * 使用for循环还是迭代器Iterator对比：
 * 采用ArrayList对随机访问比较快，而for循环中的get()方法，采用的即是随机访问的方法，因此在ArrayList里，for循环较快
 * 采用LinkedList则是顺序访问比较快，iterator中的next()方法，采用的即是顺序访问的方法，因此在LinkedList里，使用iterator较快
 * 从数据结构角度分析,for循环适合访问顺序结构,可以根据下标快速获取指定元素.而Iterator 适合访问链式结构,因为迭代器是通过next()和Pre()来定位的.可以访问没有顺序的集合.
 * 而使用 Iterator 的好处在于可以使用相同方式去遍历集合中元素，而不用考虑集合类的内部实现（只要它实现了 java.lang.Iterable 接口），
 * 如果使用 Iterator 来遍历集合中元素，一旦不再使用 List 转而使用 Set 来组织数据，那遍历元素的代码不用做任何修改，
 * 如果使用 for 来遍历，那所有遍历此集合的算法都得做相应调整,因为List有序,Set无序,结构不同,他们的访问算法也不一样.（还是说明了一点遍历和集合本身分离了）
 */
public class MyIterator {
    private static void arrayListIterator(){
        ArrayList<Person> array = new ArrayList<>();

        Person p1 = new Person("Tom1");
        Person p2 = new Person("Tom2");
        Person p3 = new Person("Tom3");
        Person p4 = new Person("Tom4");

        array.add(p1);
        array.add(p2);
        array.add(p3);
        array.add(p4);

        /**
         * 迭代出来的元素都是原来集合元素的拷贝。
         * Java集合中保存的元素实质是对象的引用，而非对象本身。
         * 迭代出的对象也是引用的拷贝，结果还是引用。
         * 那么如果集合中保存的元素是可变类型的，那么可以通过迭代出的元素修改原集合中的对象。
         */
        Iterator<Person> iterator = array.iterator();
        // boolean hasNext();    //每次next之前，先调用此方法探测是否迭代到终点
        while(iterator.hasNext()){
            System.out.println(iterator.next().getName());
        }

        System.out.println("\r\n" + "-----foreach-----" + "\r\n");
        // 对比1
        for (Person pp : array){
            System.out.println(pp.getName());
        }

        System.out.println("\r\n" + "-----利用Lambda表达式的foreach-----" + "\r\n");
        array.forEach(obj -> System.out.println(obj.getName()));

        // 对比2
        System.out.println("\r\n" + "-----利用for循环-----" + "\r\n");
        for(Person p : array){
            p.setName("wang");
        }
    }

    private static void mapIterator(){
        HashMap<Integer, String> map = new HashMap<>();
        for(int i = 0; i < 10; i ++){
            map.put(i, String.valueOf("map" + i));
        }
        Iterator iterMap = map.entrySet().iterator();
        // Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        while(iterMap.hasNext()){
            Map.Entry strMap = (Map.Entry)iterMap.next();
            System.out.println("key为:" + strMap.getKey() +
                    ", value为:" + strMap.getValue());
        }

    }


    public static void main(String[] args) {
        arrayListIterator();
        mapIterator();



    }

}
