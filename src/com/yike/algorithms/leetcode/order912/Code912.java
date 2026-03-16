package com.yike.algorithms.leetcode.order912;

import com.sun.deploy.nativesandbox.NativeSandboxBroker;

import java.util.Random;

/**
 * @author: jyk
 * @description: 912. 排序数组
 * @date: 2026/1/17 15:22
 * @version: 1.0
 */
public class Code912 {

    public static class Solution {
        private static final Random rand = new Random();
        public int[] sortArray(int[] nums) {
            /*
            先划分
            在分别对左右两侧进行排序
             */
            int left = 0, right = nums.length - 1;
            quickSort(nums, left, right);
            return nums;
        }



        private void quickSort(int[] nums, int left, int right){
            // 递归出口
            // 只有一个元素的时候一定有序 直接返回
            if(right - left + 1 <= 1) return;



            int idx = patition(nums, left, right);
            quickSort(nums, left, idx - 1);
            quickSort(nums, idx + 1, right);

        }

        private int patition(int[] nums, int left, int right){
            int i = rand.nextInt(right - left + 1);
            int pivot = nums[left + i];
            swap(nums, left, left + i);

            int l = left + 1, r = right;
            while(true){

                while(l <= r && nums[l] < pivot) l ++;
                while(l <= r && nums[r] > pivot) r --;

                if(l >= r) break;

                swap(nums, l, r);
                l ++;
                r --;
            }

            swap(nums, left, r);
            return r;

        }
        private void swap(int[] nums, int l, int r){

            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
    }

}
