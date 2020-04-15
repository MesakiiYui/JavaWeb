package leetcode.easy.set;

public class HappyNum {

    //    编写一个算法来判断一个数 n 是不是快乐数。
    //    「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，
    //    也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
    //    如果 n 是快乐数就返回 True ；不是，则返回 False 。
    //    输入：19
    //    输出：true
    //    解释：
    //    1^2 + 9^2 = 82
    //    8^2 + 2^2 = 68
    //    6^2 + 8^2 = 100
    //    1^2 + 0^2 + 0^2 = 1
    public boolean isHappy(int n) {
        while (true) {
            // flag的值就是该数各给位置的平方和，如果为1，怎判为空，为89终止，否则将n的值置为flag继续计算
            int flag = getNext(n);
            if (flag == 1) {
                return true;
            } else {
                n = flag;
                if (n == 89) {
                    return false;
                }
            }
        }
    }


    public int getNext(int num){//取得各个位上，数的平方和
        int result = 0;
        result = result+((num%10)*(num%10));
        num = num / 10;
        if(num == 0){
            return result;
        }else{
            return result + getNext(num);
        }
    }

    public static void main(String[] args){
        HappyNum hn = new HappyNum();
        System.out.println(hn.isHappy(19));

    }
}

// 19 -> 1^2 + 9^2 = 82 = (19 % 10)*(19 % 10) + (19/10)
// 234 -> 2^2 + 3^2 + 4^2 = 16 = (234 % 10) * (234 % 10) + (234/10)%10 * (234/10)%10 +  ((234/10/10)%10) * ((234/10/10)%10)
