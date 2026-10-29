package com.yike.algorithms.leetcode.order33;

/**
 * @author: jyk
 * @description: 33. 搜索旋转排序数组
 * @date: 2026/1/21 10:56
 * @version: 1.0
 */
public class Code33 {

    public static class Solution {
        public int search(int[] nums, int target) {
            /*
            1. 首先找到最小值minVal
            2. 然后根据target和last比较可以知道target在前段还是后段

             */
            int minIdx = findMin(nums, target);
            int minVal = nums[minIdx];
            int last = nums[nums.length - 1];

            if(target <= last){
                // 在后段 升序
                int l = minIdx, r = nums.length - 1, mid;
                while(l <= r){
                    mid = (l + r) >> 1;
                    if(nums[mid] >= target){
                        r = mid - 1;
                    }else{
                        l = mid + 1;
                    }
                }
                return (l == nums.length || nums[l] != target) ? -1 : r + 1;
            }else{
                // 在前段
                int l = 0, r = minIdx - 1, mid;
                while(l <= r){
                    mid = (l + r) >> 1;
                    if(nums[mid] >= target){
                        r = mid - 1;
                    }else{
                        l = mid + 1;
                    }
                }
                return (r + 1 == minIdx || nums[l] != target) ? -1 : r + 1;
            }


        }

        private int findMin(int[] nums, int target){
            int l = 0, r = nums.length - 2, mid;
            int last = nums[nums.length - 1];
            while(l <= r){
                mid = (l + r) >> 1;
                if(nums[mid] > last){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
            return l;
        }
    }
}
