package com.yike.algorithms.leetcode.order41;

/**
 * @author: jyk
 * @description: 41. 缺失的第一个正数
 * @date: ：2026/05/17 16:18
 * @version: 1.0
 */
public class Code41 {

    class Solution {
        public int firstMissingPositive(int[] nums) {
            /*
            遍历数组，每个位置上应当放置位置对应的数字，如果不是，就交换到它位置上。
            下标0放置1
            最后检查一遍 第一个不再位置上的位置就是缺失的第一个正数
            否则 返回n + 1
             */

            int n = nums.length;


            for(int i = 0; i < n; i++){
                // 如果在1~n之间 且 当前位置上的数字不等于当前位置标号 且 当前数字的座位上没有真身
                // 则进行交换
                while(1 <= nums[i] && nums[i] <= n && nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]){
                    // 和座位上的数字进行交换
                    int tmp = nums[i];
                    nums[i] = nums[nums[i] - 1];
                    nums[tmp - 1] = tmp;
                }
            }

            // 遍历数组 找第一个缺失的正数
            for(int i = 0; i < n; i++){
                if(nums[i] != i + 1){
                    return i + 1;
                }
            }

            // 否则
            return n + 1;
        }
    }
}
