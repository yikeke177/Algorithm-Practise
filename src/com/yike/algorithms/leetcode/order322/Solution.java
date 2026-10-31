package com.yike.algorithms.leetcode.order322;

import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        /*
        凑出目标金额的最少硬币个数
        完全背包问题
        每个物品可以选多次
        dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i]] + 1)

        */
        // 初始化 从前i个硬币中选 凑出金额为amount的最少硬币个数
        int[] dp = new int[amount + 1];
        int n = coins.length;
        // 先全部初始化为不可达 这样即使是父问题在求min时也就不会选择这个不可达的子问题
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        
        
        for(int i = 1;i <= n;i ++){
            for(int j = 1;j <= amount;j ++){
                if(j >= coins[i-1]) dp[j] = Math.min(dp[j], dp[j - coins[i-1]] + 1);
            }
        }

        return dp[amount] != amount + 1 ? dp[amount] : -1;

        
    }
}