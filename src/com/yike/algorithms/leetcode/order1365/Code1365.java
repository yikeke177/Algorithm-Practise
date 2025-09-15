package com.yike.algorithms.leetcode.order1365;

import java.util.*;

/**
 * @author: jyk
 * @description: 1365. 有多少小于当前数字的数字
 * @date: 2025/9/12 15:13
 * @version: 1.0
 */
public class Code1365 {

    class Solution {
        public int[] smallerNumbersThanCurrent(int[] nums) {
            /**
             * 先对数组排序，可以观察到比每个元素大的数就是它前面数字的个数，除了重复的数字要特殊处理
             * 重复的数字，则比它小的数字个数都想同
             * 我第一次做时没有解决的问题是，这种排序后的方法得到的结果顺序，和给予数组元素的顺序不对应，不知道怎么对应。
             * 解决方法是：排序后结果放入哈希表，然后对于nums里的元素一个个查表即可。
             */
            int n = nums.length;
            Map<Integer, Integer> map = new HashMap<>();

            int[] sort_nums = Arrays.copyOf(nums,n);
            Arrays.sort(sort_nums);
            for(int i = 0;i < n;i ++){
                if(!map.containsKey(sort_nums[i])){
                    map.put(sort_nums[i],i);
                }
                // else continue
            }

            int[] ans = new int[n];
            for(int i = 0;i < n;i ++){
                ans[i] = map.get(nums[i]);

            }
            return ans;
        }
    }
}
