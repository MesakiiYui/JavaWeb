package functest.kmp;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: jintienan
 * @Date: 2020/11/19 9:31
 */
@Slf4j
public class KMPTest {

    public static int[] findNext(String ptr){
        int ptrLen = ptr.length();
        int[] nextInt = new int[ptrLen];
        nextInt[0] = -1;
        for(int i = 1; i < ptrLen; i +=1){
//            int sameEleIndexA = 0;
//            int sameEleIndexB = i;
            // 看一下前一位的值，如果前一位的值不为-1，且当前正好匹配，则累加，否则该干嘛干嘛
            if(nextInt[i - 1] != -1){
                if(ptr.charAt(i) == ptr.charAt(nextInt[i-1] + 1)){
                    nextInt[i] = nextInt[i-1] + 1;
                }else{
                    nextInt[i] = -1;
                }
            }else{
                if(ptr.charAt(i) == ptr.charAt(0)){
                    nextInt[i] = 0;
                }else{
                    nextInt[i] = -1;
                }
            }
        }
        return nextInt;
    }

    public static void main(String[] args){
        String ptr = "abxabwabxad";//-1,-1,-1,0,1,-1,0,1,2,3,-1
        int[] nextArr = findNext(ptr);
        log.info(JSON.toJSONString(nextArr));
    }
}
