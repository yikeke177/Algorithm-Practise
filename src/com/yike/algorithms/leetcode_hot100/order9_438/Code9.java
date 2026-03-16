package com.yike.algorithms.leetcode_hot100.order9_438;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jyk
 * @description: leetcode 438. 找到字符串中所有字母异位词
 * @date: 2025/8/15 21:49
 * @version: 1.0
 */
public class Code9 {
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            /**
             * 1. 如何判断两个字符串是字母异位词，哈希表记录频次，复杂度O(n)
             * 2. 没必要一开始就把窗口左右端点初始化好，可以同时从0开始，然后判断窗口长度是否符合要求了
             */
            int plen = p.length(), slen = s.length();
            // 统计p中字母出现次数
            int[] pCount = new int[26];
            for(int i = 0;i < plen;i ++){
                pCount[p.charAt(i) - 'a'] ++;
            }
            // 用于统计s中窗口字串的字符频次
            int[] sWinCount = new int[26];

            List<Integer> ans = new ArrayList<>();

            // 滑动窗口
            for(int l = 0, r = 0;r < slen;r ++){
                sWinCount[s.charAt(r) - 'a'] ++;
                if(r - l + 1 == plen){// 如果窗口大小为p长度，则判断是否为异位词
                    if(isSame(sWinCount, pCount)) ans.add(l);
                    sWinCount[s.charAt(l) - 'a'] --;
                    l ++;
                }
            }
            return ans;
        }

        public boolean isSame(int[] arr1, int[] arr2){
            for(int i = 0;i < arr1.length;i ++){
                if(arr1[i] != arr2[i]) return false;
            }
            return true;
        }
    }
}
