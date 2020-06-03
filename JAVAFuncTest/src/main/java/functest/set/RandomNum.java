package functest.set;

import java.util.HashSet;
import java.util.Random;

public class RandomNum {

//    public static void main(String[] args) {
////        Random random = new Random();
////
////        int[] oldAreaIdList = new int[]{0,1,2,3,4,5,6,7,8,9};
////        int[] newAreaIdList = new int[oldAreaIdList.length];
////        HashSet<Integer> hashSet = new HashSet<Integer>();
////        while(hashSet.size() < newAreaIdList.length){
////            int randomIndex = random.nextInt(oldAreaIdList.length);
////            System.out.println(randomIndex);
////            if(!hashSet.contains(randomIndex)){
////                hashSet.add(randomIndex);
////            }
////        }
////        Integer[] temp = hashSet.toArray(new Integer[] {});
////        for (int i = 0; i < temp.length; i++) {
////            newAreaIdList[i] = temp[i].intValue();
////        }
////        System.out.println(newAreaIdList.length);
//
//
//
////        Object[] values = new Object[20];
////        HashSet<Integer> hashSet = new HashSet<Integer>();
////
////        // 生成随机数字并存入HashSet
////        while(hashSet.size() < values.length){
////            hashSet.add(random.nextInt(100) + 1);
////        }
////
////        values = hashSet.toArray();
////
////        // 遍历数组并打印数据
////        for(int i = 0;i < values.length;i++){
////            System.out.print(values[i] + "\t");
////
////            if(( i + 1 ) % 10 == 0){
////                System.out.println("\n");
////            }
////        }
//    }


    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        RandomNum t = new RandomNum();
        arr = t.m3(arr);
        print(arr);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public int []  m3(int [] arr) {
        int runCount =0;//用于记录方法运算次数
        int [] arr2 =new int[arr.length];
        int count = arr.length;
        int cbRandCount = 0;// 索引
        int cbPosition = 0;// 位置
        int k =0;
        do {
            runCount++;
            Random rand = new Random();
            int r = count - cbRandCount;
            cbPosition = rand.nextInt(r);
            arr2[k++] = arr[cbPosition];
            cbRandCount++;
            arr[cbPosition] = arr[r - 1];// 将最后一位数值赋值给已经被使用的cbPosition
        } while (cbRandCount < count);
        System.out.println("m3运算次数  = "+runCount);
        return arr2;
    }
}
