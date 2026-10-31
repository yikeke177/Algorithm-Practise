package com.yike.algorithms.leetcode.order70;

import java.util.Arrays;

public class Solution2 {
    public int climbStairs(int n) {
        /*
        自底向上计算 
        */
        // 初始化
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        
        for(int i = 2;i <= n;i ++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }


    
}
