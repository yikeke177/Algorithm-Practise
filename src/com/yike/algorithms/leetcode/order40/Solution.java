package com.yike.algorithms.leetcode.order40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> path = new ArrayList();
        List<List<Integer>> res = new ArrayList();
        int remain = target; // 剩余目标值
        // 给nums排序 为剪枝做准备
        Arrays.sort(candidates);
        
        backtrace(0, remain, path, res, candidates);
        
        return res;
    }

    private void backtrace(int idx, int remain, List<Integer> path, List<List<Integer>> res, int[] nums){
        // 终止条件 剪枝
        if(remain == 0){
            // 保存结果
            res.add(new ArrayList<>(path));
            return;

        }

        for(int i = idx; i < nums.length;i ++){
            // 剪枝
            if(nums[i] > remain) break;
            // 同层去重
            if(i > idx && nums[i] == nums[i - 1]) continue;
            // 选择当前数
            path.add(nums[i]);
            remain = remain - nums[i];
            // 可重复选择 所以传i
            backtrace(i + 1, remain, path, res, nums);
            // 恢复现场
            path.remove(path.size() - 1);
            remain = remain + nums[i];
        }

    }
}
