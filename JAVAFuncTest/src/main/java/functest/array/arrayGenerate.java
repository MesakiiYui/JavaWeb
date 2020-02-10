package functest.array;

public class arrayGenerate {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        // String[] c= new String[a.length+b.length];
        // System.arraycopy(a, 0, c, 0, a.length);
        // System.arraycopy(b, 0, c, a.length, b.length);
        // return c;
        int[] arrAll = new int[flowerbed.length+2];
        arrAll[0] = arrAll[arrAll.length - 1] = 0;
        System.arraycopy(flowerbed, 0, arrAll, 1, flowerbed.length);
        int canPlaceNum = 0;
        for(int i = 1; i < arrAll.length-1; i++) {
            if(arrAll[i] == 0 && arrAll[i+1] == 0 && arrAll[i-1] == 0){
                canPlaceNum ++;
                arrAll[i] = 1;
            }
        }
        if(canPlaceNum >= n){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        int[] arr1 = {1,0,0,0,1};
        System.out.print(canPlaceFlowers(arr1, 2));

    }

}
