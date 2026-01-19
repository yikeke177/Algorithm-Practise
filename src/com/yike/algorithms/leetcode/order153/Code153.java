package com.yike.algorithms.leetcode.order153;

/**
 * @author: jyk
 * @description: 153. 寻找旋转排序数组中的最小值
 * @date: 2026/1/19 20:21
 * @version: 1.0
 */
public class Code153 {

    public static class Solution {
        public int findMin(int[] nums) {
            int n = nums.length;
            int l = 0, r = n - 2, mid;
            while(l <= r){

                mid = (l + r) >> 1;
                if(nums[mid] > nums[n - 1]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }

            return nums[l];
        }
    }
}
