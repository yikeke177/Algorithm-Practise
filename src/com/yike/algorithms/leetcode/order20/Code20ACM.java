package com.yike.algorithms.leetcode.order20;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Code20ACM {


    class Solution{

        public boolean solve(String str){
            /*
            使用栈，遇到左括号入栈，遇到右括号出栈，出栈匹配
            1. 奇数长度：直接返回false
            2. 使用Deque.push() Deque.pop()
            3. 使用hashmap进行匹配
            3. 遍历字符数组
                左括号入栈
                右边括号出栈，如果匹配，则出栈，否则返回false
            4. 最后如果栈为空 返回true，否则false
             */

            // 奇数长度直接返回false
            if(str.length() % 2 == 1) return false;

            // 创建栈
            Deque<Character> st = new LinkedList<>();

            // 创建map
            HashMap<Character, Character> map = new HashMap<>();
            map.put('(', ')');
            map.put('[', ']');
            map.put('{', '}');

            // 遍历字符串
            char[] s = str.toCharArray();
            for(int i = 0;i < s.length;i ++){
                if(map.containsKey(s[i])){
                    // 如果是左括号，直接压入栈
                    st.push(s[i]);
                }else {

                    // 如果不匹配或则和直接为空 直接返回false
                    if (st.isEmpty() || map.get(st.pop()) != s[i]) return false;
                }

            }
            // 判断栈是否为空
            return st.isEmpty();

        }

    }

    public static void main(String[] args) {
        Code20ACM code20ACM = new Code20ACM();

        Solution solution = code20ACM.new Solution();

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        System.out.println(solution.solve(str));


    }

}
