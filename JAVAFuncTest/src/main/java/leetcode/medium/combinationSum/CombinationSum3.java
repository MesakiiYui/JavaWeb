package leetcode.medium.combinationSum;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jintienan
 * @Date: 2020/9/11 9:39
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ansEle = new ArrayList<>();
        dfs(k,n,1, ans, ansEle);
        return ans;
    }
    public void dfs(int k, int target, int currentIndex, List<List<Integer>> ans, List<Integer> ansEle){
        if(k < 0){
            return;
        }
        if(currentIndex > 10){
            return;
        }
        if(target == 0){
            if(k == 0){
                ans.add(new ArrayList<>(ansEle));
            }
            return;
        }
        // 跳过当前这个数
        dfs(k,target,currentIndex + 1, ans, ansEle);
        //使用当前这个数
        if(target - currentIndex >= 0){
            ansEle.add(currentIndex);
            dfs(k-1,target - currentIndex,currentIndex + 1, ans, ansEle);
            ansEle.remove(ansEle.size() -1);
        }
    }
}
