package com.yike.algorithms.leetcode.order845;

/**
 * @author: jyk
 * @description: 845. 数组中的最长山脉
 * @date: 2025/9/16 11:30
 * @version: 1.0
 */
public class Code845 {
    class Solution {
        public int longestMountain(int[] arr) {
            /*
             遍历每个元素 检查每个元素是否为"山峰"
             对于每个元素，分别两个指针向所有移动下降到最低点 然后计算长度
             */
            int len = arr.length;
            int ans = 0;


            for(int i = 1;i <= len - 2;i ++){ // 第一个元素和最后一个元素不可能是山峰
                int l = i, r = i;
                // 指针是先检查再移动 还是先移动再检查
                // 为了确保最后指针停在山的两端 应该先检查再移动
                while(l - 1 >= 0 && arr[l-1] < arr[l]) l --;
                while(r + 1 < len && arr[r + 1] < arr[r])r ++;
                if(r != l && r != i && l != i){
                    // 如果r和l都没有移动 那么只满足单边递减或不递减 不是山脉
                    ans = Math.max(r - l + 1, ans);
                }

            }

            return ans;
        }
    }
}
