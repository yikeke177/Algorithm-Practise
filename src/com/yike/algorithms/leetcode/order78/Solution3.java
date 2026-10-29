package com.yike.algorithms.leetcode.order78;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    public List<List<Integer>> subsets(int[] nums) {
        /*
        和组合问题的遍历其实一样
        但是保存结果的时机不同
        */
       // 初始化
       List<List<Integer>> res = new ArrayList<>();
       List<Integer> path = new ArrayList<>();

       backtrace(0, path, res, nums);
       return res;
    }
    /**
     * 
     * @param idx 决定了当前能选择的数据范围
     * @param path
     * @param res
     * @param nums
     */
    private void backtrace(int idx, List<Integer> path, List<List<Integer>> res, int[] nums){
        // 每次递归都要保存结果 第一次的空集也要保存
        res.add(new ArrayList<>(path));

        // 选择
        for(int i = idx; i < nums.length;i ++){
            // 选择当前数
            path.add(nums[i]);
            backtrace(i + 1, path, res, nums);
            // 回溯 恢复现场
            path.remove(path.size() - 1);
        }
    }
}
