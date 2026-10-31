package com.yike.algorithms.leetcode.order279;


import java.util.Arrays;

class Solution {
    public int numSquares(int n) {
        /*
        从前i个数里选 完全平方和不超过n的最少数量 可以重复选择
        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - i * i] + 1)
        */

        int m = (int)Math.sqrt(n) + 1;

        int[] dp = new int[n + 1];
        // 都可达 所以应该不用初始化
        // 不对 现在都是0 取最小永远是0 还是得初始化为一个大数
        Arrays.fill(dp, n + 1);
        dp[0] = 0;

        for(int i = 1;i <= m;i ++){
            for(int j = 1;j <= n;j ++){
                if(j >= i * i) dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }

        return dp[n];

    }
}
