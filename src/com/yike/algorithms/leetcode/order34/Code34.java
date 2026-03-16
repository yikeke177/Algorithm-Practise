package com.yike.algorithms.leetcode.order34;

/**
 * @author: jyk
 * @description: 34. 在排序数组中查找元素的第一个和最后一个位置
 * @date: 2026/1/19 13:09
 * @version: 1.0
 */
public class Code34 {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int lower = lowerBound(nums, target);
            /*
            1. 如果全都小于target 最后会返回数组长度
            2. 如果根本没有target 则返回的索引对应值不是target 而是 >=它的第一个值。
             */
            if(lower == nums.length || nums[lower] != target) return new int[]{-1,-1};
            // <= target 的第一个值 转换为 >= (target + 1)  - 1
            int higher = lowerBound(nums, target + 1) - 1;
            return new int[]{lower, higher};
        }

        private int lowerBound(int[] nums, int target){

            int l = 0, r = nums.length - 1, mid;
            while(l <= r) {
                mid = (l + r) >> 1;
                if (nums[mid] >= target) r = mid - 1;
                else l = mid + 1;
            }
            return r + 1;

        }
    }
}
