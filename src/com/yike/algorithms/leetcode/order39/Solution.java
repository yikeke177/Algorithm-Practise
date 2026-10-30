package com.yike.algorithms.leetcode.order39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        /**
         * 组合问题
         * 允许重复元素
         */
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

        }else if(remain < 0){
            return;
        }

        for(int i = idx; i < nums.length;i ++){
            // 剪枝
            if(nums[i] > remain) break;
            // 选择当前数
            path.add(nums[i]);
            remain = remain - nums[i];
            // 可重复选择 所以传i
            backtrace(i, remain, path, res, nums);
            // 恢复现场
            path.remove(path.size() - 1);
            remain = remain + nums[i];
        }

    }
}
