package com.yike.algorithms.leetcode.order77;
import java.util.ArrayList;
import java.util.List;


/*
给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
你可以按 任何顺序 返回答案。
 */

/**
 * @author: jyk
 * @description: 77. 组合
 * @date: 2025/11/30 18:08
 * @version: 1.0
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> path = new ArrayList<>();

        dfs(1, n, k, path, ans);

        
        return ans;
        
    }
    /**
     * 
     * @param i :表示从>=i的数字里面选 不代表选到第i个位置了
     * @param n
     * @param k
     * @param path
     * @param ans
     */
    private void dfs(int i, int n, int k, List<Integer> path, List<List<Integer>> ans){
        // 剪枝 当 剩余可选的数字个数(n - i + 1)) < 当前path剩余的所需数字个数(k - path.size()) 时，就没必要再往下递归了
        if(n - i + 1 < k - path.size()) return;

        // 退出条件
        if(path.size() == k){ // 当path长度等于k时结束
            ans.add(new ArrayList<Integer>(path));
            return;
        }

        // 从[i, n]的数中选
        for(int j = i;j <= n;j ++){
            path.add(j);
            dfs(j + 1, n, k, path, ans);
            // 恢复现场
            path.remove(path.size() - 1);
        }
    }
}
