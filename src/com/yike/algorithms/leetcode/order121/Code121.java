package com.yike.algorithms.leetcode.order121;

/**
 * 题目：
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */

/**
 * @author: jyk
 * @description: 121. 买卖股票的最佳时机
 * @date: 2025/9/15 15:21
 * @version: 1.0
 */
public class Code121 {
    class Solution {
        public int maxProfit(int[] prices) {
            /**
             * 找所有满足 a < b 的数对(a, b)中使得b-a最大的那对
             * 特点：a一定在b之前，所以人肉眼来找，a肯定在数组前段，b在后段，且a一定在b之前
             * 建议画出折线图或者柱状图进行分析
             * 最简单的思路是对于每个价格，与它之前的最低价格进行计算。
             * 记录当前这天之前的最低价格使用双指针(快慢指针)
             */

            /**
             * 快慢指针
             * 慢指针永远指向最小的那个价格 快指针一直向前走
             */
            int n = prices.length;
            int ans = 0;

            int slow = 0; // 一开始最小价格是第一天的价格
            int fast = 1;
            for(;fast < n;fast ++){
                if(prices[fast] > prices[slow]){
                    // 如果价格大 则计算一次利润
                    ans = Math.max(ans, prices[fast]- prices[slow]);
                }else{
                    // 否则 更新当前最小价格 也就是更新slow指针
                    slow = fast;

                }
            }
            return ans;
        }
    }



}
