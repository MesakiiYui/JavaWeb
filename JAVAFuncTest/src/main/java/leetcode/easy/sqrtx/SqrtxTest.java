package leetcode.easy.sqrtx;

/**
 * @Author: jintienan
 * @Date: 2020/9/10 17:03
 */
public class SqrtxTest {
    public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        Long start = 1L;
        Long end = new Long((long)x /2 + 1);
        while(start < end){
            if(start + 1L == end){
                return start.intValue();
            }
            Long mid = (start + end)/2;
            if(mid * mid > x) {
                end = mid;
            }
            if(mid * mid < x){
                start = mid;
            }
            if(mid * mid == x){
                return mid.intValue();
            }
        }
        return start.intValue();
    }
    public static void main(String[] args){
        SqrtxTest sqrtxTest = new SqrtxTest();
        int ans  = sqrtxTest.mySqrt(2147395599);
        System.out.println(ans);
    }
}
