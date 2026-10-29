package com.yike.algorithms.leetcode.order46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        /*
        全排列 需要考虑顺序问题
        通过used数组来控制候选数字
        */
        // 初始化
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);

        backtrace(path, res, nums, used);

        return res;
    }

    private void backtrace(List<Integer> path, List<List<Integer>> res, int[] nums, boolean[] used){
        // 递归退出条件
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }


        // 选择数字
        for(int i = 0;i < nums.length;i ++){
            if(used[i]) continue;
            path.add(nums[i]);
            used[i] = true;

            // 递归
            backtrace(path, res, nums, used);
            // 恢复现场
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
