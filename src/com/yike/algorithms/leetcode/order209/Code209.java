package com.yike.algorithms.leetcode.order209;

/**
 * 209. 长度最小的子数组
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *
 *
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 *
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 */


import com.yike.algorithms.leetcode.order1200.Code1200;

import java.util.Scanner;

/**
 * @author: jyk
 * @description: 209. 长度最小的子数组
 * @date: 2025/9/19 16:48
 * @version: 1.0
 */
public class Code209 {
    // 典型错误写法
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            /**
             * 维护一个窗口内数字和>=target的窗口
             * 以右端点为基准 右端点一步步循环移动 如果窗口内值的和 sum>=target 则计算并比较一次sum
             * 然后循环移动左端点将首元素移出窗口直到 sum <  target
             * 注意!! 是循环移动左端点 而不是移动一次 因为窗口右端点加入的元素使得窗口内sum>target了 但可能因为移入的这个
             * 值非常大 而从左边移出的元素可能比较小 导致移出一个元素还不足以使得窗口内元素和sum < target
             */
            int len = nums.length;
            int ans = Integer.MAX_VALUE;
            int sum = 0;
            int l = 0;
            for(int r = 0; r < len;r ++){
                sum += nums[r];
                if(sum >= target){
                    ans = Math.min(ans, r - l + 1);
                }
                // 典型错误 这样做会漏掉移除左边元素后长度更小的答案
                while(sum >= target){
                    sum -= nums[l++];
                }
            }
            if(ans == Integer.MAX_VALUE) return 0;
            else return ans;
        }
    }
    class Solution2 {
        public int minSubArrayLen(int target, int[] nums) {
            /*
             维护一个窗口内数字和>=target的窗口
             以右端点为基准 右端点一步步循环移动 如果窗口内值的和 sum>=target 则计算并比较一次sum
             然后循环移动左端点将首元素移出窗口直到 sum <  target
             注意!! 是循环移动左端点 而不是移动一次 因为窗口右端点加入的元素使得窗口内sum>target了 但可能因为移入的这个
             值非常大 而从左边移出的元素可能比较小 导致移出一个元素后的窗口依然满足sum > target 即长度更小的答案
             */
            int len = nums.length;
            int ans = Integer.MAX_VALUE;
            int sum = 0;
            int l = 0;
            for(int r = 0; r < len;r ++){
                sum += nums[r];

                // 典型错误 这样做会漏掉移除左边元素后长度更小的答案
                while(sum >= target){
                    // 把更新答案放在while里面 因为移除左边元素后依旧可能满足sum > target
                    // 即是一个长度更小的答案
                    ans = Math.min(ans, r - l + 1);
                    sum -= nums[l++];
                }
            }
            if(ans == Integer.MAX_VALUE) return 0;
            else return ans;
        }
    }

    public static void main(String[] args) {
        /**
         * 6 7
         * 2 3 1 2 4 3
         */
        Code209 code209 = new Code209();
        Solution solution = code209.new Solution();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        sc.nextLine();
        int[] nums = new int[n];
        for(int i = 0;i < n;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(solution.minSubArrayLen(target, nums));
    }

}
