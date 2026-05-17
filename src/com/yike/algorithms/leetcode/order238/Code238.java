package com.yike.algorithms.leetcode.order238;

/**
 * @author: jyk
 * @description: 238. 除了自身以外数组的乘积
 * @date: ：2026/05/17 15:26
 * @version: 1.0
 */
public class Code238 {

    class Solution {
        public int[] productExceptSelf(int[] nums) {
            // ans[i] = pre[i] * suf[i]
            // pre[i] = nums[i - 1] * pre[i - 1]
            // suf[i] = nums[i + 1] * suf[i + 1]

            // 前缀积
            int len = nums.length;
            int[] pre = new int[len];
            pre[0] = 1;
            for (int i = 1; i < len; i++) {
                pre[i] = pre[i - 1] * nums[i - 1];
            }

            // 后缀积
            int[] suf = new int[len];
            suf[len - 1] = 1;
            for(int i = len - 2;i >= 0;i--){
                suf[i] = suf[i + 1] * nums[i + 1];
            }

            // 求答案
            int[] ans = new int[len];

            for(int i = 0;i < len;i ++){
                ans[i] = pre[i] * suf[i];
            }
            return ans;
        }
    }
}
