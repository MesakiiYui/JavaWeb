package functest.map;

import java.util.HashMap;

/**
 * @Author: jintienan
 * @Date: 2020/9/4 13:46
 */
public class HashMapBasicMethod {

    public static void main(String[] args){

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
}
