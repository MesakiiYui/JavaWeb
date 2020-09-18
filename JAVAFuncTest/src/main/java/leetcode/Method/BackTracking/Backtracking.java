package leetcode.Method.BackTracking;

import java.util.LinkedList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: jintienan
 * @Date: 2020/9/15 13:45
 * 回溯算法
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484709&idx=1&sn=1c24a5c41a5a255000532e83f38f2ce4&chksm=9bd7fb2daca0723be888b30345e2c5e64649fc31a00b05c27a0843f349e2dd9363338d0dac61&scene=178#rd
 */
@Slf4j
public class Backtracking {

    /**
     * 全排列问题的核心
     * for 选择 in 选择列表:
     *     # 做选择
     *     将该选择从选择列表移除
     *     路径.add(选择)
     *     backtrack(路径, 选择列表)
     *     # 撤销选择
     *     路径.remove(选择)
     *     将该选择再加入选择列表
     */


    /**
     * 全排序问题,比如列出[1,2,3]的所有排序组合
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        // 最终得出的答案，是一个二维数组
        List<List<Integer>> res = new LinkedList<>();
        // 记录「路径」，是res中的一条数据
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track, res);
        log.info(JSON.toJSONString(res));
        return res;
    }

    public void backtrack(int[] nums, LinkedList<Integer> track, List<List<Integer>> res){
        // 这是递归第一步一般是剔除和满足条件直接结束
        // 这个路径已经全部加载，结束这一轮
        if(track.size() == nums.length){
            res.add(new LinkedList<>(track));
           return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i]))
                continue;
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track, res);
            // 取消选择
            track.removeLast();
        }
    }

    public static void main(String[] args){
        Backtracking backtracking = new Backtracking();
        int[] nums = new int[]{1,2,3};
        backtracking.permute(nums);
    }
}
