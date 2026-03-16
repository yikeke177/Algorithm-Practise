package com.yike.algorithms.leetcode.order20;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * @author: jyk
 * @description: 20. 有效的括号
 * @date: 2026/1/12 11:09
 * @version: 1.0
 */
public class Code20 {
    static class Solution {
        public boolean isValid(String s) {

            /*
            最近相关性匹配问题
            使用栈
            遍历字符串，如果是左括号就压入栈 如果是右括号就出栈（最近的左括号）看是否匹配，不匹配直接返回false
            最后栈空则返回true 否则false
             */
            if(s.length() % 2 == 1) return false;

            char[] str = s.toCharArray();

            // 右括号集合
            HashMap<Character, Character> map = new HashMap<>();
            map.put(']', '[');
            map.put(')', '(');
            map.put('}', '{');

            // stack
            Deque<Character> st = new ArrayDeque<>();

            for(char c : str){
                if(!map.containsKey(c)){ // 如果是左括号
                    st.addFirst(c);
                }else if(st.isEmpty() || st.removeFirst() != map.get(c)){
                    return false;
                }
            }
            return st.isEmpty();

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()[]{}"));
    }

}
