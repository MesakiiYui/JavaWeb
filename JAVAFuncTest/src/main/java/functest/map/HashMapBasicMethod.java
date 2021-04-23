package functest.map;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * @Author: jintienan
 * @Date: 2020/9/4 13:46
 */
@Slf4j
public class HashMapBasicMethod {

    public static void main(String[] args){
        int[] arr = new int[]{3,2,4};
        int[] ans = twoSum(arr, 6);
        log.info(JSON.toJSONString(ans));
    }

    public void basicMethod(){
        /**
         * HashMap的声明初始化
         */
        HashMap<Integer, Integer> intMap = new HashMap<>();
        for(int i = 0; i< 10; i +=1){
            intMap.put(i , i * i);
        }
        /**
         * 取value值，或采用默认值
         */
        int valueDefault = intMap.getOrDefault(11, 0);
        /**
         * 为HashMap赋值
         */
        // map.put(ele1, map.getOrDefault(ele1, 0) + 1);
    }

    public static int[] twoSum (int[] numbers, int target) {
        // write code here
        HashMap<Integer, Integer> remainMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; i ++){
            int remain = target - numbers[i];
            if(remainMap.containsKey(remain)){
                int index2 = remainMap.get(remain) + 1;
                return new int[]{index2, i + 1};
            }
            remainMap.put(numbers[i], i);
        }
        return null;
    }


}
