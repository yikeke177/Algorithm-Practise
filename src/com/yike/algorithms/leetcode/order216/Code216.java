package com.yike.algorithms.leetcode.order216;

import java.util.ArrayList;
import java.util.List;

/*
找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：

只使用数字1到9
每个数字 最多使用一次
返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 */

/**
 * @author: jyk
 * @description: 216. 组合总和 III
 * @date: 2025/12/12 16:57
 * @version: 1.0
 */
public class Code216 {

    /**
     * 方式1:正序选
     * 与 77.组合 的区别在于，这里多了约束条件 也就是和为n
     */
    static class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            // ans
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            dfs(1, n, 0, k, path, ans);
            return ans;
        }

        public void dfs(int i, int n, int sum, int k, List<Integer> path,  List<List<Integer>> ans){
            // 当path长度== k 且 和为n时 说明所有位置已经选完了且满足一个结果的条件
            if(path.size() == k && sum == n){
                ans.add(new ArrayList<>(path));
                return;
            }
            // 减枝1: 如果剩余位置>剩余可选数字 跳过
            // k - path.size() > n - i + 1
            if(k - path.size() > n - i + 1) return;

            // 减枝2: 如果当前累计和已经>=n 后面也没必要再选了
            if(sum >= n)return;

            // 剪枝3：如果剩余所有最大可选值都选了，和还是不够n 也没必要再选了
            // 剩余位置长度为d
            // 剩余可选的最大值为<=9的d个连续的值
            // 等差数列求和 (9 + (9 - d + 1)) * d / 2
            int d = k - path.size();
            if(sum + (9 + (9 - d + 1)) * d / 2 < n)return;

            // 从i~9个数字里面选
            for(int j = i; j <= 9;j ++){

                path.add(j);
                sum += j;
                dfs(j + 1, n, sum,k, path, ans);
                // 恢复现场
                sum -= j;
                path.remove(path.size() - 1);
            }
        }
    }

    /**
     * 方式2:逆序选
     * 不需要刻意掌握
     */
    static class Solution2 {
        public List<List<Integer>> combinationSum3(int k, int n) {
            // ans
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            // 从9～1里开始选
            dfs(9, n, k, path, ans);
            return ans;
        }

        /**
         *
         * @param i
         * @param target : 表示剩余需要选的数字和
         * @param k
         * @param path
         * @param ans
         */
        public void dfs(int i, int target, int k, List<Integer> path,  List<List<Integer>> ans){
            // 剩余位置
            int d = k - path.size();
            // 如果已经选完k个位置 且满足了要求
            if(path.size() == k && target == 0){
                ans.add(new ArrayList<>(path));
                return;
            }
            // 剪枝1:剩余可选的数字个数i < 剩余位置数
            if(i < k - path.size()) return;

            // 剪枝2: target已经<= 0 也没必要往后选了
            if(target <= 0) return;
            // 剪枝3：如果剩余所有最大可选值都选了，和还是不够n 也没必要再选了
            // 剩余位置长度为d
            // 剩余可选的最大值为>=i的d个连续的值
            // 等差数列求和 (i + (i - d + 1)) * d / 2
            if(target - (i + i - d + 1)* d / 2 > 0) return;

            for(int j = i;j >= 1;j --){
                target -= j;
                path.add(j);
                dfs(j - 1, target, k, path, ans);
                // 恢复现场
                target += j;
                path.remove(path.size() - 1);
            }
        }
    }

}










