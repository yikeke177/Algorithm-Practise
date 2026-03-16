package com.yike.algorithms.leetcode.order3;

import java.util.HashMap;

/**
 * @author: jyk
 * @description: 3. 无重复字符的最长子串
 * @date: 2026/1/10 20:26
 * @version: 1.0
 */
public class Code3 {

    static class Solution{

        public int lengthOfLongestSubstring(String s){
            /*
            滑动窗口 + 哈希表
            */

            char[] str = s.toCharArray();
            if(str.length == 1) return 1;
            int ans = 0;

            int left = 0;
            HashMap<Character,Integer> map = new HashMap<>();

            for(int right = 0;right < str.length; right++){
                map.put(str[right], map.getOrDefault(str[right], 0) + 1);
                // 等于1也要计算ans 不能等到遇到重复再计算，因为有可能到最后都遇不到重复，就一直没计算ans
                if(map.get(str[right]) == 1)ans = Math.max(right - left + 1, ans);
                // 如果有重复
                if(map.get(str[right]) > 1){
                    ans = Math.max(right - left, ans);
                    // 移动窗口左边界直到没有重复
                    while(map.get(str[right]) > 1){
                        map.put(str[left], map.get(str[left]) - 1);
                        // 错误写法 前面的left是旧值 后面的left就变成新值了 操作的字符就不一样了
//                        map.put(str[left++], map.get(str[left]) - 1);
                        left ++;
                    }
                }
                // 如果没重复

            }

            return ans;
        }




    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = new String("au");

        System.out.println(solution.lengthOfLongestSubstring(s));
    }

}
