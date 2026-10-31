package com.yike.algorithms.leetcode.order152;

public class Solution {
    
    public int maxProduct(int[] nums) {
        /*
        dp[i] 表示以第i个数字结尾的连续子数组的最大乘积
        分别保存前一个数字结尾的连续子数组的最大乘积 和 最小乘积
        */

        // 初始化
        int n = nums.length;
        int[] maxDp = new int[n + 1];
        int[] minDp = new int[n + 1];

        maxDp[0] = 1;
        minDp[0] = 1;

        int ans = Integer.MIN_VALUE;

        for(int i = 1;i <= n;i ++){
            int tmp1 = maxDp[i - 1] * nums[i - 1];
            int tmp2 = minDp[i - 1] * nums[i - 1];
            maxDp[i] = Math.max(Math.max(tmp1, tmp2), nums[i - 1]);
            minDp[i] = Math.min(Math.min(tmp1, tmp2), nums[i - 1]);

            ans = Math.max(maxDp[i], ans);
        }

        return ans;

        
        
    }
}
