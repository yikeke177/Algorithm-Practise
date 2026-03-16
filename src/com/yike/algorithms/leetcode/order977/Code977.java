package com.yike.algorithms.leetcode.order977;


/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 */




/**
 * @author: jyk
 * @description: 977. 有序数组的平方
 * @date: 2025/9/16 10:02
 * @version: 1.0
 */
public class Code977 {
    class Solution {
        public int[] sortedSquares(int[] nums) {
            /**
             * 由于数组元素可以是负数 所以这个数组元素平方后的特点是两边大中间小
             * 所以可以使用双指针l r分别从首尾开始 计算平方数 谁大谁放新数组尾部 新数组要从后往前 但需要使用一个额外的数组
             *
             */

            int len = nums.length;
            int[] ans = new int[len];

            int l = 0, r = len - 1;
            int idx = len - 1;
            while(l <= r){
                if(nums[l] * nums[l] > nums[r] * nums[r]){
                    ans[idx--] = nums[l] * nums[l];
                    l ++;
                }else{
                    ans[idx--] = nums[r] * nums[r];
                    r --;
                }
            }
            return ans;
        }
    }
}
