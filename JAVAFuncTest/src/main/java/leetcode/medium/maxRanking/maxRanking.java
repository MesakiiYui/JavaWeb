package leetcode.medium.maxRanking;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: jintienan
 * @Date: 2021/3/31 9:27
 */
@Slf4j
public class maxRanking {
    public static int maxLength (int[] arr) {
        // write code here
        int len =  arr.length;
        int max = 0;
        int j = 1;
        int i = 0;
        Set<Integer> valSet = new HashSet<Integer>();
        valSet.add(arr[i]);
        max = 1;
        while(j < len){
            int addVal = arr[j];
            // 是否含有重复值
            if(valSet.contains(addVal)){
                // 有重复值，左边窗口右移，每右移一次，检查右移的数据是否为欲加入的值
                while(arr[i] != arr[j]){
                    valSet.remove(arr[i]);
                    i ++;
                }
                i++;// 把i也+一下
                j++;
                max = Math.max(max, valSet.size());
            }else{
                // 无重复值，直接插入
                valSet.add(arr[j]);
                j++;
                max = Math.max(max, valSet.size());
            }

        }
        return max;
    }

    public static void main(String[] args){
        int[] arr = new int[]{2,3,4,5,2};
        int ans  = maxLength(arr);
        log.info(String.valueOf(ans));
    }


}
