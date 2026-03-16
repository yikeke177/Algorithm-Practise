package com.yike.algorithms.leetcode.order1143;

/**
 * @author: jyk
 * @description: 1143. 最长公共子序列
 * @date: 2025/12/20 18:54
 * @version: 1.0
 */
public class Code1143 {
    /*
    最长公共子序列
    状态转移：
    dp[i][j]表示text1的前i个字符和text2的前j个字符的最长公共子序列长度
    分为2种情况：
    1. 如果text1[i] = text2[j] 则最长长度可以+1 也就是 dp[i - 1][j - 1]
    2. 如果text1[i] != text[2] 那么就由两种状态转移过来 max(dp[i - 1][j], dp[i][j - 1])
        a. dp[i - 1][j]
        b. dp[i][j - 1]

    dp[i][j] = dp[i - 1][j - 1]
     */
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int len1 = text1.length();
            int len2 = text2.length();

            // 定义DP数组：dp[i][j]表示text1前i个字符和text2前j个字符的LCS长度
            int[][] dp = new int[len1 + 1][len2 + 1];

            // 遍历填充DP数组（i从1到len1，j从1到len2）
            for (int i = 1; i <= len1; i++) {
                char c1 = text1.charAt(i - 1); // text1第i个字符（索引i-1）
                for (int j = 1; j <= len2; j++) {
                    char c2 = text2.charAt(j - 1); // text2第j个字符（索引j-1）

                    if (c1 == c2) {
                        // 字符相等，LCS长度+1
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        // 字符不等，取上方或左方的最大值
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            // 最终结果是text1全部字符和text2全部字符的LCS长度
            return dp[len1][len2];
        }
    }
    /*
    左上角的值会被左边的值覆盖掉
    所以要用一个临时变量存储左上角的值
     */
    class Solution2 {
        public int longestCommonSubsequence(String text1, String text2) {
            int len1 = text1.length();
            int len2 = text2.length();

            int[] dp = new int[len2 + 1];


            for(int i = 1;i <= len1;i ++){
                // 每一行最开始的pre值
                int pre = 0;
                for(int j = 1;j <= len2;j ++){
                    int tmp = dp[j];
                    if(text1.charAt(i - 1) == text2.charAt(j - 1))
                        dp[j] = pre + 1;
                    else
                        dp[j] = Math.max(dp[j],dp[j - 1]);
                    pre = tmp;
                }

            }

            return dp[len2];

        }
    }


}
