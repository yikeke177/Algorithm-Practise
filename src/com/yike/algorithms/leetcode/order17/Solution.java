package com.yike.algorithms.leetcode.order17;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jyk
 * @description: 17. 电话号码的字母组合
 * @date: 2025/11/26 19:31
 * @version: 1.0
 */
class Solution {

    private static final String[] NUM_MAPPING = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};



    public List<String> letterCombinations(String digits) {
            /*
                有length(digits)个位置，每个位置上都有确定数量的字符可以选择
                输出所有的排列组合情况
                简单的思路就是循环，多少个位置就有多少个循环 缺点是什么？

                使用回溯方法，递归
                dfs(i)表示当前位置i已经确定，剩下的>=i+1的位置还没有确定，于是递归确定下一个子集问题。
                第一个集合dfs(i)
                第二个子集dfs(i+1)
                ...
                一直到最后确定最后一个子集dfs(n-1)
             */
        if(digits.isEmpty()) return new ArrayList<>();

        List<String> ans = new ArrayList<>();
        // 一种字母组合结果
        char[] textResult = new char[digits.length()];
        dfs(0, digits.toCharArray(), ans, textResult);
        return ans;


    }
    public void dfs(int i, char[] digits, List<String> ans, char[] textResult){ // 最大的集合
        //
        if(i == digits.length){
            ans.add(new String(textResult));
            return;
        }

        char[] letters = NUM_MAPPING[digits[i] - '0'].toCharArray();
        for(char c : letters){
            textResult[i] = c;
            dfs(i + 1, digits, ans, textResult);
        }

    }
}
