package com.yike.algorithms.leetcode.order198;

class Solution2 {
    public int rob(int[] nums) {
        /*
        回溯角度思考
        当前第i间房 偷或不偷 也就是“选或不选”
        状态转移方程：
        dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i-1]);
        */
        // 初始化 
        int a = nums[0], b = 0;
        
        for(int i = 2;i <= nums.length;i ++){
            int tmp = a;
            a = Math.max(a, b + nums[i - 1]);
            b = tmp;
        }
        return a;
    }
}
