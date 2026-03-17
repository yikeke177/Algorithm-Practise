package com.yike.algorithms.leetcode.order415;

/**
 * @author jyk
 * @description 415. 字符串相加
 * @date 2026/3/16 11:07
 */
public class Code415 {

    class Solution{
        public String addStrings(String num1, String num2){
            // 初始化字符串StringBuilder

            // 从个位开始 以最长的那个数字遍历完为结尾
            // 每次计算两数同位上的数字

            StringBuilder ans = new StringBuilder();

            int i = num1.length() - 1, j = num2.length() - 1;
            int carry = 0;// 一开始进位为0

            while(i >= 0 || j >= 0){ // 以最长的数字遍历完为结尾
                // 如果某数字已经遍历完，该位上数字看作0
                int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
                int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;

                // 相加
                int cur = (n1 + n2 + carry) % 10;
                ans.append(Integer.toString(cur));

                // 计算并更新进位
                carry = (n1 + n2 + carry) / 10;

                i --;
                j --;

            }
            // 如果最后还有进位则加上进位
            if(carry == 1){
                ans.append(carry);
            }

            return ans.reverse().toString();


        }

    }
}
