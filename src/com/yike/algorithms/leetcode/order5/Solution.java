package com.yike.algorithms.leetcode.order5;

class Solution {
    public String longestPalindrome(String s) {
        /*
        区间dp
        由小区间递推大区间
        dp[i][j] 表示区间[i, j] 是否为回文串
        dp[i][j] = dp[i +1][j - 1] && s[i] == s[j]
        i 从大到小
        j 从小到大
        dp初始化：
        dp[i][j] = 
        */
        
        int n = s.length();
        String ans = s.substring(0, 1);

        boolean[][] dp = new boolean[n][n];
        // 初始化 所有长度为1 和长度为2的区间
        for(int i = 0;i < n;i ++){
            dp[i][i] = true;
            if (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                ans = s.substring(i, i + 2);
            }
        }

        for(int i = n - 1;i >= 0;i --){
            for(int j = n + 2;j < n;j --){

                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                if(dp[i][j] && (j - i + 1) > ans.length()){
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
        
        
    }
}
