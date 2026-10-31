package com.yike.algorithms.leetcode.order32;

class Solution {
    public int longestValidParentheses(String s) {
        /*
         dp[i]`表示以第i个字符结尾的最长有效括号的长度。
        分成三种情况：
        - `s[i]`如果为左括号`(`结尾，`dp[i] = 0`
        - 如果为右括号结尾`()`，分为两种情况：
            - 最后两个是`()`结尾，也就是`s[i - 1] == '('`，则`dp[i] = dp[i - 2] + 2`，也就是`()`前面的位置结尾的最长有效括号长度 + 2，比如`()()`。
	        - 最后两个是`))`，也就是`s[i - 1] == s[i]`，那么就得判断前面是否有匹配的左括号，
            比如`(())`，也就是`j = i - dp[i - 1] -1`，`s[i] == '('`，此时`dp[i] = dp[i-1] + 2 + dp[j - 1]
         */

        // 初始化
        int n = s.length();
        int[] dp = new int[n];
        int ans = 0;
        


        for(int i = 0;i < n;i ++){
            if(s.charAt(i) == '(') dp[i] = 0;
            else if(s.charAt(i) == ')' && i >= 2){
                if(s.charAt(i-1) == '('){
                    dp[i] = dp[i - 2] + 2;
                }else if(s.charAt(i - 1) == ')'){
                    int j = i - dp[i - 1] - 1;
                    if(j >= 0 && s.charAt(j) == '('){
                        dp[i] = dp[i - 1] + 2;
                        if(j > 0)dp[i] += dp[j - 1];
                    }
                }
            }else if(i == 1 && s.charAt(i) == ')' && s.charAt(i - 1) == '('){
                dp[i] = 2;
            }else{ // i == 0
                dp[i] = 0;
            }
            ans = Math.max(ans, dp[i]);
            
        }

        return ans;
    }
}