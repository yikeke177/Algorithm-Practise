package com.yike.algorithms.leetcode.order300;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: jyk
 * @description: 300. 最长递增子序列
 * @date: 2025/12/21 14:07
 * @version: 1.0
 */
public class Code300 {
    /*
    dp[i] 表示前i个字符的最长上升子序列长度
    它可能是从前面任意一个大于它的数字转移过来的
    dp[i] = 0;
    for(j = 0;j < i;j ++){
        if(nums[j] < nums[i])
            dp[i] = max(dp[j], d[i]);
    }
     */
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int ans = 0;

            // 最后结果是从以所有字符结尾的最长子序列中取最大值 而不是直接返回以最后字符结尾的最长子序列长度
            for(int i =0;i < n;i ++){
                ans = Math.max(ans, dfs(i, nums));
            }
            return ans;
        }


        private int dfs(int idx, int[] nums){
            // 退出条件 前1个数字的最长时上升子序列是1
            if(idx < 1){
                return 1;
            }
            int res = 0;
            for(int i = 0;i < idx;i ++){
                if(nums[i] < nums[idx])
                    res = Math.max(dfs(i, nums), res);
            }
            return res + 1;
        }
    }

    /*
    记忆化搜索
     */
    class Solution1 {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int ans = 0;
            //
            int[] cache = new int[n];
            Arrays.fill(cache, -1);
            // 最后结果是从以所有字符结尾的最长子序列中取最大值 而不是直接返回以最后字符结尾的最长子序列长度
            for(int i =0;i < n;i ++){
                ans = Math.max(ans, dfs(i, nums, cache));
            }
            return ans;
        }


        private int dfs(int idx, int[] nums, int[] cache){
            if(cache[idx] != -1) return cache[idx];
            // 退出条件 前1个数字的最长时上升子序列是1
            if(idx < 1){
                return 1;
            }
            int res = 0;
            for(int i = 0;i < idx;i ++){
                if(nums[i] < nums[idx])
                    res = Math.max(dfs(i, nums, cache), res);
            }
            cache[idx] = res + 1;
            return res + 1;
        }
    }
    /*
    动态规划
     */
    class Solution2 {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            int ans = 0;
            for(int i = 0;i < n;i ++){

                for(int j = 0;j < i;j ++){
                    if(nums[j] < nums[i]){
                        dp[i] = Math.max(dp[i], dp[j]);
                    }
                }
                dp[i] += 1;
                ans = Math.max(dp[i], ans);
            }

            return ans;
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];
        sc.nextLine();

        for(int i = 0;i < n;i ++){
            nums[i] = sc.nextInt();
        }

        Code300 code300 = new Code300();
        Solution solution = code300.new Solution();

        System.out.println(solution.lengthOfLIS(nums));
/*
8
10 9 2 5 3 7 101 18
 */
    }

}
