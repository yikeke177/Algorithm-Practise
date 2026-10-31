package com.yike.algorithms.leetcode.order198;

class Solution {
    public int rob(int[] nums) {
        /*
        回溯角度思考
        当前第i间房 偷或不偷 也就是“选或不选”
        状态转移方程：
        dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i-1]);
        */
        // 初始化 
        // 表示偷到当前第i间房的最大收益是多少
        int[] dp = new int[nums.length + 1];

        dp[0] = 0;
        dp[1] = nums[0]; // 偷第1间房 偷或不偷 最大收益是偷
        
        for(int i = 2;i <= nums.length;i ++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i-1]);
        }
        return dp[nums.length];
    }
}
