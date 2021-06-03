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



    /**
     * https://www.cnblogs.com/MOBIN/p/5374217.html
     * 堆排序
     * 原则就是在一个数组的存储结构下实现一个满二叉树，需要从小到大排序就输出小顶堆，反之大顶堆
     *
     * 关于满二叉树的原则：以头节点下标为0记
     * 1.含有子节点的最大节点是n/2-1，例如0，1，2，3，4中只有0和1有子节点
     * 2.如果某个节点i含有子节点，那么它的左孩子下标为2*1+1
     * @param nums
     * @return
     */
    public int[] heapSort(int[] nums){
        // 对原始数组进行对排序的初级调整，满足左小右大的原则，
        // 按照注释中特性1我们知道，只需要对n/2-1~0这几个节点进行处理即可(按照右下至左上的顺序)
        // 注：所有的i,j,len等全部为下标值，从0开始
        int len = nums.length -1;//
        // 进行初始的堆调整，包含两个for循环
        for(int i = len/2-1; i >=0;i--){
            heapAdjust(nums, i, len);
        }
        while (len >=0){
            swap(nums,0,len--);    //将堆顶元素与尾节点交换后，长度减1，尾元素最大
            heapAdjust(nums,0,len);    //再次对堆进行调整
        }
        return nums;
    }

    private static void heapAdjust(int[] arr, int i,int len){
        int left,right,j ;
        while((left = 2*i+1) <= len){    //判断当前父节点有无左节点（即有无孩子节点，left为左节点）
            right = left + 1;  //右节点
            j = left;   //j"指针指向左节点"
            if(j < len && arr[left] < arr[right])    //右节点大于左节点
                j ++;     //当前把"指针"指向右节点
            if(arr[i] < arr[j])    //将父节点与孩子节点交换（如果上面if为真，则arr[j]为右节点，如果为假arr[j]则为左节点）
                swap(arr,i,j);
            else         //说明比孩子节点都大，直接跳出循环语句
                break;
            i = j; // 为什么有这一步？可以预想到单次循环结束后i会有变为它的左孩子，
            // 即一个中间节点，它的后代节点中有x个非叶子节点，那么它就要接受x次调整，
            // 目的就是把下层的最大数全部往上提
        }

    }

    private int[] quickSort(int[] arr){
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }
    // 快速排序
    private static void quickSort(int[] arr, int low, int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];

        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);

    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 生成原始数组
     * @return
     */
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

        int[] heapNums = basicSort.generateArr();
        log.info("堆排序before"+JSON.toJSONString(heapNums));
        int[] heapSort = basicSort.heapSort(heapNums);
        log.info("堆排序after"+JSON.toJSONString(heapSort));

        int[] quickNums = basicSort.generateArr();
        log.info("快速排序before"+JSON.toJSONString(quickNums));
        int[] quickSort = basicSort.quickSort(quickNums);
        log.info("快速排序after"+JSON.toJSONString(quickSort));
    }
}
