package functest.array;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: jintienan
 * @Date: 2021/4/27 10:16
 */
@Slf4j
public class ArrayBasicSkill {

    public static void randomShuffle(){
        int[] nums = new int[100];

        for(int i = 0; i < nums.length; ++i) {
            nums[i] = i + 1;
        }

        Random generator = new Random();
        for(int i = 0; i < nums.length; ++i) {
            int arrayIndex = generator.nextInt(nums.length - i);
            int tmp = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = nums[arrayIndex];
            nums[arrayIndex] = tmp;
        }
        System.out.println(Arrays.toString(nums));
    }

    // 如何找到二维数组的中值。
    public static void findValinArray2d(){
        int[][] array2d = { { 21, 14, 13, 12, 15 }, { 4, 25, 23, 22, 9 },
                { 4, 7, 8, 98, 24 } };
        int[] list = new int[array2d.length * array2d[0].length];

        int listPos = 0;
        for (int i = 0; i < array2d.length; i++) {
            for (int j = 0; j < array2d.length; j++) {
                list[listPos++] = array2d[i][j];
            }
        }
        Arrays.sort(list);
        System.out.println(median(list));
    }

    public static double median(int[] m) {
        int middle = m.length / 2;
        if (m.length % 2 == 1) {
            return m[middle];
        } else {
            return (m[middle - 1] + m[middle]) / 2.0;
        }
    }

    /**
     * 数组比较
     */
    public static void arrayCompare(){
        int[] arr1= new int[]{1,3,5,7};
        int[] arr2= new int[]{1,3,5,7};
        int[] arr3= new int[]{1,3,5,7,9};
        log.info("arr1 == arr2?" + Arrays.equals(arr1, arr2));
        log.info("arr1 == arr3?" + Arrays.equals(arr1, arr3));
    }


    public static void main(String[] args) {
//        randomShuffle();
//        findValinArray2d();
        arrayCompare();
    }
}
