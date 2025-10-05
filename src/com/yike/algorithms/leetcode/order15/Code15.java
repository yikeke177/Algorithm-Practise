package com.yike.algorithms.leetcode.order15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 */

/**
 * @author: jyk
 * @description: 15. 三数之和
 * @date: 2025/9/16 10:18
 * @version: 1.0
 */
public class Code15 {
    public class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            /**
             * 题目特点 三个数字和为0 所以可以试着把数组进行排序 两个指针指向首尾
             * 三个指针，一个指针循环向后移动，另外两个指针分别指向第一个指针后面的数组首尾
             * 还要注意如何去重复 也就是指针移动时要跳过相同的数字 三个数字都得去重
             * 指针移动的条件 两边同时向中间移动
             */

            // 排序 从小到大
            Arrays.sort(nums);

            int len = nums.length;
            List<List<Integer>> ans = new ArrayList<>();

            for(int i = 0;i < len - 2;i ++){
                if(nums[0] > 0) break; // 第一个元素大于0则不可能有三个数和为0
                if(i > 0 && nums[i] == nums[i - 1]) continue; // 第一个数字也要去重
                // 双指针
                int l = i + 1, r = len - 1;
                while(l < r){ // 不能等于 因为三个数字要不同
                    if(nums[i] + nums[l] + nums[r] > 0){
                        // 大于0 则右指针要向内移动 减小值
                        r --;
                    }else if(nums[i] + nums[l] + nums[r] < 0){
                        l ++;
                    }else{
                        // 找到一个答案
                        ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        // 第二三个数字都得去重 跳过重复值 去重
                        while(nums[++l] == nums[l-1] && l < r); // 不用判断越界 l < r也能保证不可能越界
                        while(nums[--r] == nums[r + 1] && l < r);
                    }
                }
            }
            return ans;

        }
    }
}
