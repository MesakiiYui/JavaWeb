package functest.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: jintienan
 * @Date: 2020/12/15 17:03
 */
public class ListReverse {

    public static void main(String[] args) {
        List<String> lists = new ArrayList<String>();
        // 初始化10个测试数据
        lists.add("20200128");
        lists.add("20201208");
        lists.add("20200101");
        lists.add("20201201");
        lists.add("20200201");
        lists.add("20180246");

        // 打印测试数据
        for (String n : lists) {
            System.out.print(n + " ");
        }
        System.out.println();

        // 反转lists
        Collections.sort(lists);
        for (String n : lists) {
            System.out.print(n + " ");
        }
        System.out.println();
        Collections.reverse(lists);

        // 换行打印
        System.out.println();

        // 打印测试数据
        for (String n : lists) {
            System.out.print(n + " ");
        }System.out.println();

    }

}
