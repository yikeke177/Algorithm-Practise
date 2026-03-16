package com.yike.algorithms.leetcode.order217;

/**
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 * 输入：nums = [1,2,3,1]
 * 输出：true
 *
 * 解释：
 * 元素 1 在下标 0 和 3 出现。
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: jyk
 * @description: 217. 存在重复元素](https://leetcode.cn/problems/contains-duplicate/)
 * @date: 2025/9/10 15:28
 * @version: 1.0
 */
public class Code217 {
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            /**
             * 思路1:
             * 使用哈希表
             * 用数组遍历一遍统计各个数字出现次数，数组大小得1e9，有点大
             * 思路2:
             * 使用set集合，可以去重，去重后大小和原数组大小不同，就返回ture
             */
            List<Integer> list = Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new));
            Set<Integer> set = new HashSet<>(list);
            if(set.size() != nums.length)
                return true;
            else return false;


        }
    }
    class Solution2 {
        public boolean containsDuplicate(int[] nums) {
            /**
             * 方法二：不涉及到List转set的问题
             * 遍历元素放入set并检查set中是否已经存在
             */
            Set<Integer> set = new HashSet<Integer>();
            for(int i = 0;i < nums.length;i ++){
                if(set.contains(nums[i])){
                    return true;
                }
                set.add(nums[i]);
            }
            return false;


        }
    }
}
