package com.yike.algorithms.leetcode.order122;

/**
 * @author: jyk
 * @description: 122. 买卖股票的最佳时机 II
 * @date: 2025/12/21 15:31
 * @version: 1.0
 */
public class Code122 {

    /*
    每天有两种状态 持有股票/不持有股票
    对于不持有：
    1. 前一天也不持有，今天不操作 dp[i][0] = dp[i-1][0]
    2. 前一天持有，今天卖出 利润增加 dp[i][0] = dp[i-1][1] + price[i]
    对于持有：
    1. 前一天不持有，今天买入 买入要花钱 利润减少 dp[i][1] = dp[i-1][0] - price[i]
    2. 前一天持有，今天不操作 dp[i][1] = dp[i-1][1]
     */
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;

            int[][] dp = new int[n+1][2];
            // 对于第一天持有的情况dp[1][1] 只能是买入操作 毕竟最开始的状态是不持有 所以只能从不持有转移过来 利润-price[0]
            dp[0][1] = Integer.MIN_VALUE; // 最初状态不能是不持有 为了在取max时不选择持有这个状态 就把持有这个状态变得足够小
            // 对于第一天不持有的情况 只能是不操作 因为最初状态是不持有 只能从不持有状态转移过来 利润不变
            dp[0][0] = 0; // 最初状态是不持有状态 最大利润为0；

            for(int i = 1;i <= n;i ++){
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][0] - prices[i-1], dp[i-1][1]);
            }

//            return Math.max(dp[n][0], dp[n][1]);
            // 直接返回dp[n][0]即可 因为持有的情况利润一定更低 因为完全可以把持有的卖出去
            return dp[n][0];
        }

    }
    /*
    优化空间
    每个状态只从上面两个状态转移过来
    所以用两个变量存储上一次两个状态值即可
     */
    class Solution2 {
        public int maxProfit(int[] prices) {
            int n = prices.length;

            int pre1 = 0, pre2 = Integer.MIN_VALUE;


            for(int i = 1;i <= n;i ++){
                int tmp1 = Math.max(pre1, pre2 + prices[i-1]);
                pre2 = Math.max(pre1 - prices[i-1], pre2);
                pre1 = tmp1;
            }

            return pre1;
        }

    }
}
