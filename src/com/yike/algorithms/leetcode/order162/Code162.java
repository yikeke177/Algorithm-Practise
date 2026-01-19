package com.yike.algorithms.leetcode.order162;

/**
 * @author: jyk
 * @description: 162. 寻找峰值
 * @date: 2026/1/19 19:37
 * @version: 1.0
 */
public class Code162 {

    public static class Solution {
        public int findPeakElement(int[] nums) {
            /*
            二分法
             */

            int l = 0, r = nums.length - 2, mid;

            while(l <= r){
                mid = (l + r) >> 1;
                if(nums[mid] < nums[mid + 1]){
                    // 此时峰值肯定在mid右边 缩小范围
                    l = mid + 1;
                }else{
                    // 峰值是mid或者mid左边
                    r = mid;
                }

            }

            return r;
        }
    }

}
