package com.yike.algorithms.leetcode_hot100.order10_560;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: jyk
 * @description: leetcode 560. 和为 K 的子数组
 * @date: 2025/8/16 23:47
 * @version: 1.0
 */
public class Code10 {
    class Solution {

        public int subarraySum(int[] nums, int k) {
            /**
             * 前缀和 + 哈希表
             * 优秀题解：https://leetcode.cn/problems/subarray-sum-equals-k/solutions/2781031/qian-zhui-he-ha-xi-biao-cong-liang-ci-bi-4mwr
             */
            int sum = 0;

            int len = nums.length;
            // 初始化前缀和数组
            int[] pre_sum = new int[len+1];
            for(int i = 0;i < len;i ++){
                pre_sum[i+1] = pre_sum[i] + nums[i];
            }

            // 计算字串和 pre_sum[j] - pre_sum[i] = k
            // 遍历j，统计pre_sum[i] = pre_sum[j] - k出现的次数

            int ans = 0;
            // 哈希表 用于计数
            Map<Integer, Integer> cnt = new HashMap<Integer,Integer>(len + 1);

            for(int j = 0;j <= len;j ++){
                if(cnt.containsKey(pre_sum[j] - k)){
                    ans += cnt.get(pre_sum[j] - k);
                }
                cnt.merge(pre_sum[j], 1, Integer::sum); // 计数+1或置为1
            }
            return ans;
        }
    }
}
