package com.yike.algorithms.leetcode.order88;

/**
 * @author: jyk
 * @description: 88. 合并两个有序数组
 * @date: 2026/1/11 11:11
 * @version: 1.0
 */
public class Code88 {


    static class Solution{

        public void merge(int[] nums1, int m, int[] nums2, int n){
            /*
            反着合并到nums1中 从大到小 避免覆盖
             */
            int p1 = m - 1, p2 = n - 1;

            int p3 = nums1.length - 1;

            while(p1 >= 0 && p2 >= 0){

                if(nums1[p1] >= nums2[p2]){
                    nums1[p3--] = nums1[p1--];
                }else{
                    nums1[p3--] = nums2[p2--];
                }
            }

            if(p1 == -1){
                while(p2 >= 0){
                    nums1[p3--] = nums2[p2--];
                }
            }else{
                while(p1 >= 0){
                    nums1[p3--] = nums2[p1--];
                }
            }


        }

    }
}
