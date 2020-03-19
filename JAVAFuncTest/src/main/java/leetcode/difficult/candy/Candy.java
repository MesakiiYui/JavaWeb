package leetcode.difficult.candy;
//老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
//
//        你需要按照以下要求，帮助老师给这些孩子分发糖果：
//
//        每个孩子至少分配到 1 个糖果。
//        相邻的孩子中，评分高的孩子必须获得更多的糖果。
//        那么这样下来，老师至少需要准备多少颗糖果呢？
//
//        示例 1:
//
//        输入: [1,0,2]
//        输出: 5
//        解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
//        示例 2:
//
//        输入: [1,2,2]
//        输出: 4
//        解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
//        第三个孩子只得到 1 颗糖果，这已满足上述两个条件。

import java.lang.reflect.Array;
import java.util.Arrays;

// [1,5,2,4]=>[1,2,1,2]
// https://leetcode-cn.com/problems/candy/
public class Candy {
    // 暴力解法
    // 每当i-1的评分高于i，则多给i一个糖果，
    // 每当i+1的评分高于i，则多给i一个糖果，
    // 直到这两个条件不再出现
    public static int calCandy(int[] ratings) {
        int[] resultArr = new int[ratings.length];
        Arrays.fill(resultArr, 1);
        int result = 0;
        boolean flag = true;
        while(flag) {
            flag = false;
            for(int i = 0; i < ratings.length; i ++) {
                System.out.println("1");
                if(i != 0 && ratings[i] > ratings[i-1] && resultArr[i] <= resultArr[i-1]) {
                    resultArr[i] = resultArr[i-1] + 1;
                    flag = true;
                }
                if(i != ratings.length - 1 && ratings[i] > ratings[i+1] && resultArr[i] <= resultArr[i+1]){
                    resultArr[i] = resultArr[i+1];
                    flag = true;
                }
            }
        }
        for(int i = 0; i < resultArr.length; i++) {
            result = result + resultArr[i];
        }
        return result;

    }

    // 有更优解，待续
    public static void main(String[] args) {
        int[] ratings = new int[]{1,2,1};
        int result = calCandy(ratings);
        System.out.println(result);
    }

}
