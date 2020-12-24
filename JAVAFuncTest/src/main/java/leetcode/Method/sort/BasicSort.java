package leetcode.Method.sort;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: jintienan
 * @Date: 2020/9/15 16:18
 */
@Slf4j
public class BasicSort {

    /**
     * 冒泡排序
     * 一轮冒完获得最大的或者最小的
     * @param nums
     * @return
     */
    public int[] bubbleSort(int[] nums){
        for(int i = 0; i < nums.length; i += 1){
            for(int j = 0; j < nums.length - i - 1; j +=1){
                if(nums[j] < nums[j + 1]){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }

    /**
     * 选择排序
     * 每次找最大的或最小的，放在最左边或者最右边
     * @param nums
     * @return
     */
    public int[] selectionSort(int[] nums){
        for(int i = 0; i < nums.length; i += 1){
            int maxIndex =0;
            for(int j = 0; j < nums.length - i; j +=1){
                if(nums[j] > nums[maxIndex]){
                    maxIndex = j;
                }
            }
            int temp = nums[maxIndex];
            nums[maxIndex] = nums[nums.length - i -1];
            nums[nums.length - i - 1] = temp;
        }
        return nums;
    }

    /**
     * 插入排序
     * 将数组右边的数据一个个插入到左边
     * 如果用linklist会比较好做，用数组也是可以的
     *
     *
     * 将第一个元素标记为已排序
     *
     * 遍历每个没有排序过的元素
     *
     *   “提取” 元素 X
     *
     *   i = 最后排序过元素的指数 到 0 的遍历
     *
     *     如果现在排序过的元素 > 提取的元素
     *
     *       将排序过的元素向右移一格
     *
     *     否则：插入提取的元素
     * @param nums
     * @return
     */
    public int[] insertionSort(int[] nums){

        for(int i = 1; i < nums.length; i += 1){
            for(int j = i; j > 0; j --){
                if(nums[j] > nums[j -1]){
                    int temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                }
            }
            log.info("插入排序，一轮for循环结束:"+ JSON.toJSONString(nums));
        }
        return nums;
    }

    /**
     * 希尔排序，又称缩小增量排序
     * @param nums
     * @return
     */
    public int[] shellSort(int[] nums){
        int len = nums.length;
        for(int gap  = (int)Math.floor(len/2); gap > 0; gap = (int)Math.floor(gap/2)){
            //接下来开始进行插入排序
            // 为什么i从gap开始？假设gap=5,则nums[0]->nums[gap-1]分别是5个序列的第一个值
            for(int i = gap; i < nums.length; i += 1){
                int temp = nums[i];
                int j = i - gap;
                log.info("while即将开始j={}, i={},gap={}",j, i, gap);
                while(j >= 0 && nums[j] > temp){
                    // 这个while里面其实是插入排序的过程，以temp为基准，在它左边的且比它大的都会往往右插，直到遇见比它小的
                    nums[j + gap] = nums[j];// 插入排序的重要中间过程，temp存储的待插入的值，我们要将序列中的值逐个的往后移动，将temp插到这样一个位置，左边的比它小，右边的比它大
                    j -= gap;
                    log.info("while内插入后 "+JSON.toJSONString(nums));
                }
                nums[j + gap] = temp;
                log.warn("while结束     "+JSON.toJSONString(nums)+ "j=" + j +", gap=" + gap);
            }
        }
        return nums;
    }

    public int[] generateArr(){
        int[] nums = new int[10];
        SecureRandom rand = new SecureRandom();
        for(int i=0; i<10; i++) {
            nums[i] = rand.nextInt(9) + 1;
        }
        return nums;
    }

    public static void main(String[] args){
        BasicSort basicSort = new BasicSort();

        int[] bubbleNums = basicSort.generateArr();
        log.info("冒泡排序before"+JSON.toJSONString(bubbleNums));
        int[] bubbleRes = basicSort.bubbleSort(bubbleNums);
        log.info("冒泡排序after"+JSON.toJSONString(bubbleRes));

        int[] selectionNums = basicSort.generateArr();
        log.info("选择排序before"+JSON.toJSONString(selectionNums));
        int[] selectionRes = basicSort.selectionSort(selectionNums);
        log.info("选择排序after"+JSON.toJSONString(selectionRes));

        int[] insertionNums = basicSort.generateArr();
        log.info("插入排序before"+JSON.toJSONString(insertionNums));
        int[] insertionSort = basicSort.insertionSort(insertionNums);
        log.info("插入排序after"+JSON.toJSONString(insertionSort));

        int[] shellNums = basicSort.generateArr();
        log.info("希尔排序before"+JSON.toJSONString(shellNums));
        int[] shellSort = basicSort.shellSort(shellNums);
        log.info("希尔排序after"+JSON.toJSONString(shellSort));
    }
}
