package com.yike.algorithms.leetcode.order448;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
 * 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 */

/**
 * @author: jyk
 * @description: TODO
 * @date: 2025/9/10 16:40
 * @version: 1.0
 */
public class Code448 {

    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            /**
             *
             */
            int n = nums.length;
            Set<Integer> set = new HashSet<>();
            for(int i = 0;i < n;i ++){
                set.add(nums[i]);
            }
            List<Integer> ans = new ArrayList<>();
            for(int i = 1;i <= nums.length;i ++){
                if(!set.contains(i)){
                    ans.add(i);
                }
            }
            return ans;

        }
    }

}
