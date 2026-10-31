package com.yike.algorithms.leetcode.order139;

import java.util.List;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        /*
        dp[i] 表示前i个字符能否被拆分
        它又有多个子问题
        也就是它的前j个字符能否被拆分 且 剩余单词是否存在于wordDict中
        也就是：
        valid = d[j] && wordDict.contains(s.substring(j, i));
        dp[i] = dp[i] || valid;
        */

        // 初始化
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true; // 前0个字符一定要能被拆分 因为假设j == 0 且剩余单词存在字典 应该返回true

        for(int i = 1;i <= n;i ++){
            for(int j = 0;j < i;j ++){
                boolean valid = dp[j] && wordDict.contains(s.substring(j, i));
                dp[i] = dp[i] || valid;
            }
        }

        return dp[n];



    }
}
