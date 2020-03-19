package leetcode.medium.numberOfSubarraysWithBoundedMaximum;
//给定一个元素都是正整数的数组A ，正整数 L 以及 R (L <= R)。
//
//        求连续、非空且其中最大元素满足大于等于L 小于等于R的子数组个数。
//
//        例如 :
//        输入:
//        A = [2, 1, 4, 3]
//        L = 2
//        R = 3
//        输出: 3
//        解释: 满足条件的子数组: [2], [2, 1], [3].

// 注意，当第一个值小于L时不能马上放弃，因为下一个值可能就会大于L
public class NumSubarrayBoundedMax {
    // 用两个指针进行队列检测
    public static int numSubarrayBoundedMax(int[] A, int L, int R) {
        int result = 0;

        outLoop : for(int i = 0; i < A.length; i++) {
            if(A[i] <= R) {
                int max = A[i];
                innerLoop : for(int j = i; j < A.length; j++){
                    if(A[j] > max) {
                        max = A[j];
                    }
                    if(max >=L && max <= R) {
                        result ++;
                    }else if(max > R) {
                        break innerLoop;
                    }
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{73,55,36,5,55,14,9,7,72,52};
        int l = 32,r = 69;
        int result = numSubarrayBoundedMax(arr1, l, r);
        System.out.println(result);
    }

    // 存在更优解

}
