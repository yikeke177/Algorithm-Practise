package com.yike.algorithms.leetcode.order72;

/**
 * @author: jyk
 * @description: 72. 编辑距离
 * @date: 2025/12/20 21:29
 * @version: 1.0
 */
public class Code72 {

    /*
    if(word1[i] == word2[j]) dp[i][j] = dp[i-1][j-1];
    else{
        dp[i][j] = min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]) + 1;
    }
     */
    class Solution {
        public int minDistance(String word1, String word2) {

            int len1 = word1.length();
            int len2 = word2.length();

            // 表示从word1的前i个字符转换成word2的前j个字符最少操作数
            int[][] dp = new int[len1 + 1][len2 + 1];

            // 当i= 0，j=0时， 表示从前0个字符转换成前0个字符最少操作数为0
            // 当i = 0 j = 1时 最少操作数为插入一个字符 1
            // 当i = 1, j = 0时 最少操作数为删除 1
            // 当i= 1， j = 1时，最少操作数 = 0或者1（替换）

            // 初始化边界：空字符串互转
            for (int i = 0; i <= len1; i++) {
                dp[i][0] = i; // 前i个转空，删除i次
            }
            for (int j = 0; j <= len2; j++) {
                dp[0][j] = j; // 空转前j个，插入j次
            }

            for(int i = 1;i <= len1;i ++){
                for(int j = 1;j <= len2;j ++){
                    if(word1.charAt(i-1) == word2.charAt(j-1))
                        dp[i][j] = dp[i - 1][j - 1];
                    else
                        dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i-1][j]), dp[i - 1][j - 1]) + 1;
                }
            }

            return dp[len1][len2];
        }
    }


    class Solution2 {
        public int minDistance(String word1, String word2) {

            int len1 = word1.length();
            int len2 = word2.length();

            // 表示从word1的前i个字符转换成word2的前j个字符最少操作数
            int[] dp = new int[len2 + 1];

            // 当i= 0，j=0时， 表示从前0个字符转换成前0个字符最少操作数为0
            // 当i = 0 j = 1时 最少操作数为插入一个字符 1
            // 当i = 1, j = 0时 最少操作数为删除 1
            // 当i= 1， j = 1时，最少操作数 = 0或者1（替换）


            for (int j = 0; j <= len2; j++) {
                dp[j] = j; // 空转前j个，插入j次
            }

            for(int i = 1;i <= len1;i ++){
                // 表示第i行的第一个值
                // 也就是word1前i-1个字符转换为word2前j=0个字符的最少操作数 执行i-1次删除
                int pre = i - 1;
                dp[0] = i; // 也就是word1前i个字符转换为word2前j=0个字符的最少操作数 执行i次删除
                for(int j = 1;j <= len2;j ++){
                    int tmp = dp[j];
                    if(word1.charAt(i-1) == word2.charAt(j-1))
                        dp[j] = pre;
                    else
                        dp[j] = Math.min(Math.min(dp[j - 1], tmp), pre) + 1;
                    pre = tmp;
                }

            }

            return dp[len2];
        }
    }
}
