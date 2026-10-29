package com.yike.algorithms.leetcode.order47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        /*
        
        */
        /*
        全排列 需要考虑顺序问题
        通过used数组来控制候选数字
        */
        // 初始化
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        // 排序 为去重做准备
        Arrays.sort(nums);

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
            // 去重判断（剪枝）
            if(i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false){
                // 说明当前已经是在以第二个重复数字作为首数字开头进行选择，继续往下会重复
                continue;
            }

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
