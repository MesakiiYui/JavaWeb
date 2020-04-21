package functest.array;

public class arrayMerge {

    public static void main(String[] args) {
        int[] arr1 = new int[]{0};
        int[] arr2 = new int[]{1,2,3};
        int[] arr3 = new int[]{0};
        int[] arrAll = new int[arr1.length + arr2.length + arr3.length];
        System.arraycopy(arr1, 0, arrAll, 0, arr1.length);
        System.arraycopy(arr2, 0, arrAll, arr1.length, arr2.length);
        System.arraycopy(arr3, 0, arrAll, arr1.length + arr2.length, arr3.length);
        for(int ele : arrAll) {
            System.out.print(ele);
        }
        System.out.println("!");

    }
}
