package com.yike.algorithms.leetcode.order239;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: jyk
 * @description: 239. 滑动窗口最大值
 * @date: ：2026/05/15 15:17
 * @version: 1.0
 */
public class Code239 {

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            /*
            单调队列 队列中元素永远是单调递减的
            窗口右边界遍历整个数组
            每次窗口进入一个数 就尝试入队
            循环比较队尾元素 如果队尾元素小 就从队尾出队
            当左边界移动到k-1时开始记录答案 把队头元素假如答案
             */

            // 创建双端队列 记录的是元素下标
            Deque<Integer> que = new LinkedList<>();

            // 创建答案数组
            List<Integer> ans = new ArrayList<>();

            // 遍历数组
            for(int i = 0;i < nums.length;i ++){

                // 入队 如果队列不为空 且队尾元素比当前元素小 就循环出队
                while(!que.isEmpty() && nums[que.getLast()] < nums[i]) que.removeLast();
                // 入队
                que.addLast(i);

                // 出队 判断队头元素下标是否已经超出窗口左边界 如果超出就出队 每超出不用管
                if(!que.isEmpty() && i - que.getFirst() >= k) que.removeFirst();

                // 记录答案 如果窗口长度已经达到k-1
                if(i >= k-1){
                    ans.add(nums[que.getFirst()]);
                }
            }

            return ans.stream().mapToInt(Integer::intValue).toArray();

        }
    }

}
