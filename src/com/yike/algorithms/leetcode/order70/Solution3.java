package com.yike.algorithms.leetcode.order70;

import java.util.Arrays;

public class Solution3 {
    public int climbStairs(int n) {
        /*
        自底向上计算 
        */
        // 初始化
        int a = 1 , b = 1;
        for(int i = 2;i <= n;i ++){
            int tmp = a;
            
            a = a + b;
            b = tmp;
        }
        return a;

    }


    
}
