package com.yike.algorithms.leetcode.order11;
/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 */


/**
 * @author: jyk
 * @description: 11. 盛最多水的容器
 * @date: 2025/9/15 16:16
 * @version: 1.0
 */
public class Code11 {
    class Solution {
        public int maxArea(int[] height) {
            /**
             * 任选两条垂线 a = height[i], b = height[j], i < j
             * 容积计算公式 底×高 --> (j - i) * min(a, b)
             * 也就是底长 乘以两垂线中最短的那条
             * 双指针l和r 分别指向首尾 往中间移动
             * 向中间靠的时候 容器的"底"一定是在减小的 那么我就必须要让容器的"高"尽可能变高
             * 所以每次移动两个指针中 高更小的那个 移动直到高更大为止 再计算一次容器体积
             * 循环直到两指针相等停止
             */
            int len = height.length;
            int ans = 0;
            int l = 0, r = len - 1;

            while(l < r){
                // 计算一次体积
                int l_height = height[l];
                int r_height = height[r];
                ans = Math.max(ans, Math.min(r_height, l_height) * (r - l));
                // 移动短边 而且是一直移动到它变得比之前要高
                if(l_height < r_height){
                    while(height[++l] > l_height && r < l); // 注意判断是否越界
                }else{
                    while(height[--r] > r_height && r < l);
                }
            }
            return ans;
        }
    }
}
