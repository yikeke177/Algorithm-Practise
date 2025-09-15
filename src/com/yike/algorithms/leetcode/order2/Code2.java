package com.yike.algorithms.leetcode.order2;


/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 *
 * 你可以按任意顺序返回答案。
 */

import java.util.*;

/**
 * @author: jyk
 * @description: 1. 两数之和
 * @date: 2025/9/10 16:54
 * @version: 1.0
 */
public class Code2 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int n = nums.length;
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0;i < n;i ++){
                if(map.containsKey(target-nums[i])){
                    return new int[]{map.get(target-nums[i]), i};
                }
                map.put(nums[i], i);
            }
            return new int[]{};
        }
    }

}
