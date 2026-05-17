package com.yike.algorithms.leetcode.order76;

/**
 * @author: jyk
 * @description: 76. 最小覆盖子串
 * @date: ：2026/05/15 16:31
 * @version: 1.0
 */
public class Code76 {

    static class Solution {
        public String minWindow(String S, String T) {
            /*
            初始化最短窗口左边界和右边界
            ansLeft = -1, ansRight = s.length;

            统计s和t中的字符出现次数

            初始化窗口子串左边界left = 0 right = t.length
            右边界遍历s
            对于窗口对应的子串 如果包含子串t 就收缩左边界直到不包含t


             */
            int lenS = S.length(), lenT = T.length();
            // 左闭右开区间[ansLeft, ansRight)
            int ansLeft = -1, ansRight = lenS;

            // 统计T中的次数
            int[] cntT = new int[128];
            for(char c : T.toCharArray()){
                cntT[c] ++;
            }

            // 右边界遍历S
            char[] s = S.toCharArray();
            // 边遍历 边统计cntS
            int[] cntS = new int[128];
            int left = 0;
            for(int right = 0;right < lenS;right ++){
                cntS[s[right]] ++;

                // 如果当前子串s[left, right)包含t 则可以缩短左边界 找最短
                while(coverage(cntS, cntT)){

                    // 如果长度短于当前长度 更新ansLeft ansRight
                    if((right - left + 1) < (ansRight - ansLeft)){
                        ansRight = right + 1;
                        ansLeft = left;
                    }

                    cntS[s[left]] --; // 去除左边界字母的统计
                    left ++;

                }


            }

            if(ansLeft < 0) return "";
            else return S.substring(ansLeft, ansRight);

        }

        private boolean coverage(int[] cntS, int[] cntT){
            // 遍历每个字符 如果cntS[c] < cntT[c] 返回false
            for(int i = 'a';i <= 'z';i ++){
                if(cntS[i] < cntT[i]) return false;
            }

            for(int i = 'A';i <= 'Z';i ++){
                if(cntS[i] < cntT[i]) return false;
            }
            return true;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        String out = solution.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(out);
    }
}
