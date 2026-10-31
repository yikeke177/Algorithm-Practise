package com.yike.algorithms.leetcode.order70;

import java.util.Arrays;

public class Solution {
    public int climbStairs(int n) {
        /*
        记忆化搜索
        递归 缓存中间值 如果缓存命中就直接用 没有才计算 计算后缓存
        */
        // 初始化
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        

        return f(n, memo);

    }


    private int f(int n, int[] memo){
        // 递归退出条件
        if(n == 1) return 1;
        if(n == 2) return 2;

        if(memo[n] != -1){
            return memo[n];
        }else{
            memo[n] = f(n - 1, memo) + f(n - 2, memo);
            return memo[n];
        }

       
    }
}
