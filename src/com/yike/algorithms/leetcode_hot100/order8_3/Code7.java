package com.yike.algorithms.leetcode_hot100.order8_3;

import java.util.*;

/**
 * @author: jyk
 * @description: leetcode hot100第8题 题号3
 * @date: 2025/8/12 06:47
 * @version: 1.0
 */
public class Code7 {

    public int lengthOfLongestSubstring(String s) {
        /**
         * 一个窗口内，如何判断新进入的字符是重复的
         * 新字符与窗口内字符重复后，窗口的左边界就得移动到重复字符后一个字符处
         * 通过什么方式移动到重复字符后一个呢？通过while不断后移并判断
         * 该题目误区：以为窗口右边指针也是一次移动很多，实际上右指针可以每次移动一位
         * 也就是每次固定右，移动左
         */
        char[] chars = s.toCharArray();
        int len = chars.length;
        // 这里记录的是出现频率，可以优化为记录字符出现的最后位置
        // 也可以优化为使用128大小的int数组来记录字符
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int left = 0;
        for(int right = 0;right < len;right ++){
            if(map.containsKey(chars[right])){
                 map.put(chars[right], map.get(chars[right]) + 1);
            }else{
                map.put(chars[right], 1);
            }
            while(map.get(chars[right]) > 1){
                map.put(chars[left], map.get(chars[left]) - 1);
                left ++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;


    }
}
