package com.yike.algorithms.leetcode.order739;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: jyk
 * @description: 739. 每日温度
 * @date: 2026/4/21 13:03
 * @version: 1.0
 */
public class Code739 {

    class Solution {
        public int[] dailyTemperatures(int[] temp) {
            /*
            画一个折线图，以一个一般情况为例
            遍历每个数，都要遍历该数字后面的每个数，如果大于当前数，就计算下标差
            但是其中有些数字完全没必要遍历，我们目的是找第一个比当前数大的，所以希望遍历的数组是单调递增的，这样效率才高

            从后往前，使用单调栈
            遍历单调栈，如果大于当前数字，计算下标差
            否则就出栈，再遍历下一个数字，直到栈空，栈空则返回0
            最后将当前数字入栈
             */
            int[] ans = new int[temp.length];

            // 初始化栈
            Deque<Integer> st = new LinkedList<>();

            for(int i = temp.length - 1;i >= 0;i --){
                while(!st.isEmpty()){
                    // 如果栈顶元素大于当前值
                    if(temp[st.peek()] > temp[i]){
                        ans[i] = st.peek() - i;
                        break;
                    }
                    // 否则出栈
                    else st.pop();
                }
                // 如果最后栈空 说明没有比他大的元素
                if(st.isEmpty()) ans[i] = 0;
                // 将当前数值入栈
                st.push(i);

            }

            return ans;


        }
    }


}
