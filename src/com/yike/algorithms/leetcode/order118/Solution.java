package com.yike.algorithms.leetcode.order118;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        /*
        
        */
        int[][] dp = new int[numRows + 1][numRows + 1];
        for(int i = 1;i <= numRows;i ++){
            dp[i][1] = 1;
            dp[i][i] = 1;
        }

        for(int i = 1;i <= numRows;i ++){
            for(int j = 2;j <= i - 1;j ++){
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1;i <= numRows;i ++){
            List<Integer> curRow = new ArrayList<>();
            for(int j = 1;j <= i;j ++){
                curRow.add(dp[i][j]);
            }
            ans.add(curRow);
        }
        return ans;
    }
}
