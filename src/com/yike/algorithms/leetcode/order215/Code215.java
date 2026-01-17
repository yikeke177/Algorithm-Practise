package com.yike.algorithms.leetcode.order215;

import java.util.Random;

/**
 * @author: jyk
 * @description: 215. 数组中的第K个最大元素
 * @date: 2026/1/17 14:01
 * @version: 1.0
 */
public class Code215 {



    public static class Solution{
        private static final Random rand = new Random();

        public int findKthLargest(int[] nums, int k) {

            int n = nums.length;
            int left = 0, right = n - 1;


            while(true){
                int idx = findIndex(nums, left, right);
                if(idx == n - k)return nums[idx];
                else if(idx < n-k) {
                    left = idx + 1;
                }else{
                    right = idx - 1;
                }
            }


        }
        private int findIndex(int[] nums, int left, int right){

            // random pivot
            int i = rand.nextInt(right - left + 1); // [0, num)
            int pivot = nums[left + i];
            swap(nums, left, left + i);
            // 双指针
            int l = left + 1, r = right;
            while(true){

                while(l <= r && nums[l] < pivot) l ++;
                // 此时num[l] >= pivot

                while(l <= r && nums[r] >= pivot) r --;
                // 此时nums[r] < pivot

                // 如果结束循环了
                if(l >= r) break;

                // 交换

                swap(nums, l, r);
                l ++;
                r --;

            }
            // 将pivot和l交换
            // 如果和r交换，可能会把相等的重复值交换到前面去了
            swap(nums, left, r);

            return r;

        }

        private void swap(int[] nums, int i, int j){

            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

    }
}
