package com.yike.algorithms.leetcode.order416;

public class Solution {
    
    public boolean canPartition(int[] nums) {
        /*
        转换为01背包问题
        两个子集和相等
        子集和一定等于总和/2
        所以问题就转换为
        从n个数里选 每个数最多只能选1次 是否能凑出和为target的子集
        */

        // 求和
        int sum = 0;
        for(int i = 0; i < nums.length;i ++){
            sum += nums[i];
        }
        if(sum % 2 == 1) return false;
        int target = sum / 2;

        // dp数组
        boolean[][] dp = new boolean[nums.length+1][target + 1];
        // 初始化 
        for(int i = 0;i < nums.length + 1;i ++){
            dp[i][0] = true;
        }

        for(int i = 1;i < nums.length + 1;i ++){
            for(int j = 1;j < target +1;j ++){
                // 选或不选第i个数
                // dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]] 
                if(j >= nums[i-1])dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[nums.length][target];
        
    }
}
