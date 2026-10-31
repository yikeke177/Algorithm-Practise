package com.yike.algorithms.leetcode.order62;

class Solution {
    public int uniquePaths(int m, int n) {
        /*
        不同路径
        当位置i,j的不同路径数量
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        */
        //初始化
        int[][] dp = new int[m+1][n+1];
        // 第一列只能从上面来
        for(int i = 1;i <= m;i ++){
            dp[i][1] = 1;
        }
        // 第一行只能从左边来
        for(int i = 1;i <= n;i ++){
            dp[1][i] = 1;
        }

        for(int i = 2;i <= m;i ++){
            for(int j = 2;j <= n;j ++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m][n];
        


    }
}
