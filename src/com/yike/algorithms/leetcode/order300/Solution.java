package com.yike.algorithms.leetcode.order300;

import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        /*
        以i为结尾的最长递增子序列的长度
        dp[i] = dp[j] + 1; nums[j] > nums[i] && j < i;
        */   

        // 初始化
        int n = nums.length;
        int[] dp = new int[n];
        // 全部初始化为1 因为如果没有比当前元素小的 最长长度默认为1 而不是0
        Arrays.fill(dp, 1);
        int ans = 1;

        for(int i = 0;i < n;i ++){
            for(int j = 0;j < i;j ++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    
                }
                
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
}
