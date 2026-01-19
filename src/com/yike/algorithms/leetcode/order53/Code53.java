package com.yike.algorithms.leetcode.order53;

/**
 * @author: jyk
 * @description: 53. 最大子数组和
 * @date: 2026/1/12 10:41
 * @version: 1.0
 */
public class Code53 {

    class Solution {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            // 前缀和数组
            int[] preSum = new int[n + 1];
            for(int i = 0;i < n;i ++){
                preSum[i + 1] = preSum[i] + nums[i];
            }

            int minSum = 0;
            int ans = Integer.MIN_VALUE;
            for(int i = 1;i <= n;i ++){
                ans = Math.max(ans, preSum[i] - minSum);
                minSum = Math.min(minSum, preSum[i]);
            }
            return ans;
        }
    }

}
