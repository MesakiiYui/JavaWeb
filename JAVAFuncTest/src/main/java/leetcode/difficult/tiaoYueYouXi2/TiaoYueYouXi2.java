package leetcode.difficult.tiaoYueYouXi2;

/**
 * @Author: jintienan
 * @Date: 2020/9/10 13:26
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TiaoYueYouXi2 {
    // 贪心算法，从后往前跳跃,例如最后一步的时候，我们从左向右取最远的位置
    public int jump(int[] nums) {
        int step = 0;// 统计最终需要的步数
        int position = nums.length-1;
        while(position > 0){
            for(int i = 0;i < position; i += 1){
                int resLen = position - i;
                if(nums[i] >= resLen){
                    position = i;
                    step ++;
                    break;
                }
            }
        }
        return step;
    }
}
