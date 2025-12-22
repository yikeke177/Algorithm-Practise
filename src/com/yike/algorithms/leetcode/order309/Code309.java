package com.yike.algorithms.leetcode.order309;

/**
 * @author: jyk
 * @description: 309. 买卖股票的最佳时机含冷冻期
 * @date: 2025/12/21 16:13
 * @version: 1.0
 */
public class Code309 {
    /*
    加了限制条件“卖出股票后第二天不能立刻买入”，有一天冷冻期限。
那么状态转移就减少了
第i天持有股票的状态：
1. 前一天也持有，然后当前无操作
2. 前一天不持有，今天买入。但前一天不准卖出，也就是不能从“卖出导致的不持有状态转移过来”，那前一天“不卖出导致的不持有状态”只能由从2天前不持有的状态转移过来。所以`dp[i][1] = dp[i-2][0]`
     */
    class Solution {
        public int maxProfit(int[] prices) {
            //
            int n = prices.length;

            int[][] dp = new int[n+2][2];
            // 对于第一天持有的情况dp[1][1] 只能是买入操作 毕竟最开始的状态是不持有 所以只能从不持有转移过来 利润-price[0]
            dp[1][1] = Integer.MIN_VALUE; // 最初状态不能是不持有 为了在取max时不选择持有这个状态 就把持有这个状态变得足够小
            // 对于第一天不持有的情况 只能是不操作 因为最初状态是不持有 只能从不持有状态转移过来 利润不变
            dp[0][0] = 0; // 最初状态是不持有状态 最大利润为0；

            for(int i = 0;i < n;i ++){
                dp[i + 2][0] = Math.max(dp[i+1][0], dp[i+1][1] + prices[i]);
                dp[i + 2][1] = Math.max(dp[i][0] - prices[i], dp[i+1][1]);
            }

//            return Math.max(dp[n][0], dp[n][1]);
            // 直接返回dp[n][0]即可 因为持有的情况利润一定更低 因为完全可以把持有的卖出去
            return dp[n+1][0];

        }
    }


}
