package com.yike.algorithms.leetcode.order78;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jyk
 * @description: 78. 子集
 * @date: 2025/11/28 15:54
 * @version: 1.0
 */
public class Solution2 {
    /*
    i 表示当前位置的数字要从下标>=当前下标的数字里面选
     */
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        dfs(0, nums,  result, ans);

        return ans;

    }

    private void dfs(int i, int[] nums, List<Integer> result, List<List<Integer>> ans) {
        // 每个结点都是一种结果，包括根节点
        ans.add(new ArrayList<>(result));

        // 从下标j > i的数字中选
        for(int j = i; j < nums.length; j ++){
            result.add(nums[j]);
            // 递归到下一个 比当前下标大的下标对应的数字里面选
            dfs(j + 1, nums,  result, ans);
            // 恢复现场
            result.remove(result.size() - 1);
        }
    }
}
