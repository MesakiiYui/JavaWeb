package leetcode.medium.kokoEatingBananas;
//珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
//珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
//珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
//返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
//示例 1：
//输入: piles = [3,6,7,11], H = 8
//输出: 4

//示例 2：
//输入: piles = [30,11,23,4,20], H = 5
//输出: 30

//示例 3：
//输入: piles = [30,11,23,4,20], H = 6
//输出: 23

// 每一堆至少要花1小时，1小时内的消耗为1K
public class kokoEatingBananas {
    public static int minEatingSpeed(int[] piles, int H) {
        int lo = 1;
        int hi = 1_000_000_000;
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (!possible(piles, H, mi))
                lo = mi + 1;
            else
                hi = mi;
        }

        return lo;
    }

    // Can Koko eat all bananas in H hours with eating speed K?
    public static boolean possible(int[] piles, int H, int K) {
        int time = 0;
        for (int p: piles)
            time += (p-1) / K + 1;
        return time <= H;
    }

    public static void main(String[] args) {
        int[] piles = new int[]{3,6,7,11};
        int H = 8;
        int K = minEatingSpeed(piles, H);
        System.out.println(K);
    }
}
