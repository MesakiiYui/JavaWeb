package leetcode.easy.set;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Learn2UseSet {
//    给定两个数组，编写一个函数来计算它们的交集。
//    输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//    输出: [9,4]


    /**
     * 自己想的办法
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> setRes = new HashSet<>();
        // 先将第一个数组放入set
        for (int i : nums1) {
            set1.add(i);
        }
        //如果j不在set中，不放入，
        for (int j : nums2) {
            if(set1.contains(j)){
                setRes.add(j);
            }
        }
        //Set-->数组
        Integer[] array = setRes.toArray(new Integer[0]);
        System.out.println(Arrays.toString(array));
        // java，高效优雅的将Integer[]转换int[]？
        // You can use Stream APIs of Java 8
        int[] intArray = Arrays.stream(array).mapToInt(Integer::intValue).toArray();
        return intArray;
    }

    /**
     * 利用set和apache的工具
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersectionWithTool(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();
        // int[] 数组转 Integer[]数组
        Integer[] newArray1 = ArrayUtils.toObject(nums1);
        Integer[] newArray2 = ArrayUtils.toObject(nums2);
        // Integer[]数组转HashSet
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(newArray1));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(newArray2));
        // 先将第一个数组放入set
        for (int i : nums1) {
            set1.add(i);
        }
        //如果j不在set中，不放入，
        for (int j : nums2) {
            set2.add(j);
        }

        result.clear();
        result.addAll(set1);
        result.removeAll(set2);
        System.out.println("差集：" + result);

        result.clear();
        result.addAll(set1);
        result.addAll(set2);
        System.out.println("并集：" + result);

        result.clear();
        result.addAll(set1);
        result.retainAll(set2);
        System.out.println("交集：" + result);

        // 下面的方法一样
        //Set-->数组
        Integer[] array = result.toArray(new Integer[0]);
        System.out.println(Arrays.toString(array));
        // java，高效优雅的将Integer[]转换int[]？
        // You can use Stream APIs of Java 8
        int[] intArray = Arrays.stream(array).mapToInt(Integer::intValue).toArray();
        return intArray;

    }

    public static void main(String[] args) {
        Learn2UseSet learn2UseSet = new Learn2UseSet();
        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};
        int[] result = learn2UseSet.intersection(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
}
