package leetcode.easy.twosum;

import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

    // 暴力解法
    private  Integer[] BruteForce(Integer[] arr, Integer target){
        Integer[] ansArr = new Integer[2];
        for(Integer i = 0; i < arr.length; i += 1) {
            Integer temp1 = arr[i];
            for(Integer j = i + 1; j < arr.length; j += 1){
                if(temp1 + arr[j] == target) {
                    ansArr[0] = i;
                    ansArr[1] = j;
                    return (ansArr);
                }

            }
        }
        return null;
    }
    // 两步循环法
    private Integer[] DoubleStep(Integer[] arr, Integer target){
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(Integer i = 0; i < arr.length; i += 1) {
            hm.put(arr[i], i);
        }
        for(Integer i = 0; i < arr.length; i += 1) {
            Integer restVal = target - arr[i];
            if(hm.containsKey(restVal) & (hm.get(restVal) != i)) {
                return new Integer[]{i, hm.get(restVal)};
            }
        }
        return null;
    }



    // 一步循环法
    private Integer[] SingleStep(Integer[] arr, Integer target){
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(Integer i = 0; i < arr.length; i += 1) {
            Integer restVal = target - arr[i];
            if(hm.containsKey(restVal)) {
                return (new Integer[]{i, hm.get(restVal)});
            } else {
                hm.put(arr[i], i);
            }
        }
        return null;
    }


    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2,7,11,15};
        Integer target = 17;
        TwoSum twoSum = new TwoSum();

        // Integer[] ansArr = twoSum.BruteForce(arr, target);
        // Integer[] ansArr = twoSum.DoubleStep(arr, target);
        Integer[] ansArr = twoSum.SingleStep(arr, target);

        if(ansArr != null & ansArr.length > 0) {
            for(Integer index : ansArr){
                System.out.println(index);
            }
        }




    }
}
