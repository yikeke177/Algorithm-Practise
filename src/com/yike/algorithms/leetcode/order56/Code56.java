package com.yike.algorithms.leetcode.order56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jyk
 * @description 56. 合并区间
 * @date 2026/3/16 11:15
 */
public class Code56 {

    class Solution {

        public int[][] merge(int[][] intervals) {
            // 首先按照左端点进行排序
            // 相邻两两尝试合并 能合并就合并 更新当前的end右边界
            // 如果不能合并 就得到一个新的区间 开始合并这个新区间

            // 1.按照左端点对数组进行排序 从小到大
            Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

            // 2. 存储答案 末尾区间是当前正在更新的区间
            List<int[]> ans = new ArrayList<>();
            // 先将第一个区间放入 作为初始化
            ans.add(intervals[0]);

            // 开始遍历 逐个合并到区间里
            for(int i = 1;i < intervals.length;i ++){
                int curStart = intervals[i][0], curEnd = intervals[i][1];
                int preStart = ans.get(ans.size() - 1)[0], preEnd = ans.get(ans.size() - 1)[1];

                // 如果旧区间右端点 >= 新区间左端点 融合更新旧区间的右端点为新区间的右端点
                if(preEnd >= curStart){
                    ans.get(ans.size() - 1)[1] = Math.max(curEnd, preEnd);
                }else{ /// 否则 开始一个新的区间的合并
                    ans.add(intervals[i]);
                }

            }

            return ans.toArray(new int[ans.size()][]);





        }

    }
}
