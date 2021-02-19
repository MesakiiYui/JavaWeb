package functest.javautilimpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class CollectionImpl {
    private static void collectionFunc() {
        Collection<Integer> clc = new ArrayList<>();
        clc.add(1);
        clc.add(2);

        Iterator it = clc.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

    }
    private static void collectUtil() {
        ArrayList<String>list=new ArrayList<>();
        list.add("1");
        list.add("make");//add是将传入的参数当String看，哪怕传入一个很长的list，也只算一个
        list.add("2");
        System.out.println("巅峰时期的list"+list);
        list.remove(0);//list中，remove后接的是索引
        System.out.println("失去了第一个数的list"+list);
        HashSet<String> set=new HashSet<>();
        set.add("make");
        System.out.println("set包含了"+set);
        System.out.println("list是否包含set   "+list.containsAll(set));//list和set是可以相互包含的
        list.removeAll(set);
        System.out.println("removeAll(set)之后的list"+list);
        list.addAll(set);//addAll是将传入的参数当list看，有多少加多少,类似的removeAll,containsAll都如此
        System.out.println("addAll(set)之后的list"+list);

        list.add("jack");//add只表示加入一个字符串
        list.add("howk");
        //在java集合中，使用专门的迭代器进行遍历
        Iterator<String>it=list.iterator();
        System.out.println("添加了jack和howk后，现在list的元素包含：");
//		以前老套的迭代器做法
//		while(it.hasNext()) {
//			System.out.print(it.next()+" ");
//		}
        System.out.println("非常高逼格的使用迭代器Lambda表达式遍历");
        it.forEachRemaining(String->System.out.print(String+" "));
        System.out.println();

        System.out.println("第二次高逼格，显然已经输不出来了");
        it.forEachRemaining(String->System.out.print(String+" "));
        System.out.println(list.size());
        System.out.println(it.hasNext());

        System.out.println();
        System.out.println("我foreach的迭代元素为");
        //对于list中的每一个String，我都要输出,帅！

        list.forEach(String->System.out.print(String+" "));//Lambda表达式
        list.forEach((ele)->{
           System.out.println("ele"+ele);
           System.out.println("ele still is :   "+ele);
        });
        System.out.println();
//		forEach和forEachRemaining区别不大，可以换着用，但是这个第二次能输出来
        System.out.println("我Foreach还可以来第二次");
        list.forEach(String->System.out.print(String+" "));//Lambda表达式
        System.out.println();

        System.out.println(list.get(0)+"的长度是"+list.get(0).length());
        System.out.println(list.get(1)+"的长度是"+list.get(1).length());
        System.out.println(list.get(2)+"的长度是"+list.get(2).length());

        //删除list中的所有长度大于2的字符串型元素
        list.removeIf(ele->((String)ele).length()>2);

        System.out.println("用removeIf取出长度大于2的字符串后list为"+list);

//      可以看到，foreach与forEachRemaining是可以依托于迭代器通过Lamdba遍历的，其中forEachRemaining只能用一次
//      it.forEachRemaining(string->System.out.print(string+" "));表示用迭代器遍历list中的String元素，适合用于容器的遍历
//      add与addAll,remove与removeAll有类似的区别，add后面接具体的字符串，addAll后面接list,set等
//      System.out.println("list是否包含set "+list.containsAll(set));判断容器间是否互相包含用contains
//      list.removeIf(ele->((string)ele).length()>2);这是另一种Lamdba表达式，ele表示元素，效果是去掉list中所有长度大于2的元素

    }

    public static void main(String[] args) {
        collectionFunc();
        collectUtil();
    }
}
