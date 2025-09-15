package com.yike.algorithms.leetcode.order268;

import java.util.Arrays;

/**
 * @author: jyk
 * @description: TODO
 * @date: 2025/9/10 16:06
 * @version: 1.0
 */
public class Code268 {
    // 方法一
    class Solution {
        public int missingNumber(int[] nums) {
            /**
             * 对数组排序，按道理数组的下标和数字应该是对应的，找到第一个不对应的那个下标就是答案
             */
            int n = nums.length;
            Arrays.sort(nums);
            for(int i = 0;i < n;i ++){
                if(nums[i] != i){
                    return i;

                }
            }
            return n;
        }
    }
    // 方法二
    class Solution2 {
        public int missingNumber(int[] nums) {
            /**
             * 给的数组的数字和与实际应该的数组和的差就是缺少的那个数字
             */
            int n = nums.length;
            int sum1 = 0;
            for(int i = 0;i < n;i ++){
                sum1 += nums[i];
            }
            int sum2 = (1 + n)* n / 2;
            if(sum2 != sum1) return sum2 - sum1;
            else return 0;
        }
    }
}
