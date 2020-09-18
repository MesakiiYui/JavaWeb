package leetcode.medium.combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: jintienan
 * @Date: 2020/9/10 14:28
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        // 临时单个的答案数组
        List<Integer> ansEle = new ArrayList<>();
        dfs(candidates,0, ans, target, ansEle, false);

        return clearTwoDimondArr(ans);

    }

    public void dfs(int[] candidates,int index, List<List<Integer>> ans, int target, List<Integer> ansEle, boolean lastPicked){
        if(target == 0){
            ans.add(new ArrayList<>(ansEle));
            return;
        }
        if(target < 0 || index > candidates.length - 1){
            return;
        }
        // 跳过
        dfs(candidates,index+1, ans, target, ansEle, false);
        if(!lastPicked){
            //不跳过
            ansEle.add(candidates[index]);
            dfs(candidates, index, ans, target - candidates[index], ansEle, true);
            ansEle.remove(ansEle.size()-1);
        }
    }

    public List<List<Integer>> clearTwoDimondArr(List<List<Integer>> arr){
        List<List<Integer>> filtedArr = new ArrayList<>();
        HashMap<List<Integer>, Boolean> hashMap = new HashMap<>();
        for(int i = 0; i < arr.size(); i += 1){
            Collections.sort(arr.get(i));
            if(!hashMap.containsKey(arr.get(i))){
                hashMap.put(arr.get(i), true);
                filtedArr.add(arr.get(i));
            }
        }
        return filtedArr;
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        CombinationSum2 solution = new CombinationSum2();
        List<List<Integer>> res = solution.combinationSum2(candidates, target);
        System.out.println("输出 => " + res);
    }
}
