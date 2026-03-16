package com.yike.algorithms.leetcode.order42;

/**
 * 题目：
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */


import oracle.jrockit.jfr.parser.FLREventInfo;

/**
 * @author: jyk
 * @description: 42. 接雨水
 * @date: 2025/9/15 16:55
 * @version: 1.0
 */
public class Code42 {
    // 方法一：通过数组来记录当前位置左边和右边最高的柱子
    class Solution {
        public int trap(int[] height) {
            /**
             * 每个位置上能接的水的量等于该位置左边最高的柱子 和 右边最高的柱子 中矮的那个柱子高度减去当前位置上柱子的高度
             * 所以需要维护两个数组 分别表示当前柱子左边最高的柱子高度 和 右边最高的柱子高度。
             * 可以先通过从前向后和从后向前两次遍历得到这两个数组
             * 参考优秀题解【盛最多水的容器 接雨水【基础算法精讲 02】】 https://www.bilibili.com/video/BV1Qg411q7ia/?share_source=copy_web&vd_source=706e89d02d8f2e3054b318652ffa1de4
             */

            int len = height.length;
            int[] l_height = new int[len]; // 第一个值永远是0
            int[] r_height = new int[len];

            for (int i = 1; i < len; i++) {
                if (height[i - 1] > l_height[i - 1]) l_height[i] = height[i - 1];
                else l_height[i] = l_height[i - 1];
            }

            for (int i = len - 2; i >= 0; i--) {
                if (height[i + 1] > r_height[i + 1]) r_height[i] = height[i + 1];
                else r_height[i] = r_height[i + 1];
            }

            int sum = 0;
            for (int i = 0; i < len; i++) {
                int low = Math.min(r_height[i], l_height[i]);
                if (low > height[i]) sum += (low - height[i]);
            }
            return sum;
        }
    }

    // 方式二：方法一优化 双指针法 并且通过两个变量记录左边和右边最高的柱子高度 思路比方法一要难以理解 但空间复杂度要更低
    class Solution2 {
        public int trap(int[] height) {
            /**
             * 方法二思路：
             * 双指针从两边开始 两边都可以计算接水
             * 方法一是从头到尾一个个计算接水 方法二是两边交替计算接水量
             * 为什么可以这样做？
             * 因为前缀高度和后缀高度有个特点
             * 比如对于前缀高度，它是单调不减的，也就是虽然当前位置后面的位置的前缀最大高度我不知道，但至少是当前位置前缀最大高度
             * 后缀高度同理。
             * 指针移动的条件：
             */
            int len = height.length;
            int left_max = height[0]; // 一开始左边最高的柱子等于第一根柱子高度
            int right_max = height[len - 1]; // 一开始右边最高的柱子等于最后一根柱子高度
            int sum = 0;

            int left = 1; // 第一根柱子接不了水 所以从第二根柱子开始
            int right = len - 2; // 同理 最后一根柱子接不了水
            // TODO : 是否要等于？
            while(left <= right){
                if(left_max < right_max){
                    if(left_max > height[left]) sum += (left_max - height[left]);
                    left_max = Math.max(left_max, height[left]);
                    left ++;
                }else{
                    if(right_max > height[right]) sum += (right_max - height[right]);
                    right_max = Math.max(right_max, height[right]);
                    right --;
                }

            }
            return sum;


        }
    }



}
