package com.yike.algorithms.leetcode.order189;

/**
 * @author: jyk
 * @description: 189. 轮转数组
 * @date: ：2026/05/17 14:35
 * @version: 1.0
 */
public class Code189 {
    class Solution {
        public void rotate(int[] nums, int k) {
            // `(A, B) --> (rev(A, B)) --> (rev(B), rev(A)) --> (rev(rev(B)), rev(rev(A))) --> (B, A)`




            int len = nums.length;

            // k有可能大于数组长度 取模即可
            k = k % len;

            // 翻转整体[0, len - 1]
            reverse(nums, 0, len - 1);

            // 翻转[0, k - 1], [k, len - 1]
            reverse(nums, 0,  k - 1);
            reverse(nums, k, len - 1);



        }

        private void reverse(int[] nums, int start, int end) {
            // 双指针法
            int left = start, right = end;
            while (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right--;
            }

        }
    }


}
