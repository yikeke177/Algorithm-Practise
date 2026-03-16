package com.yike.algorithms.leetcode.order17;

import java.util.*;

/**
 * @author: jyk
 * @description: 17. 电话号码的字母组合
 * @date: 2025/11/26 19:42
 * @version: 1.0
 */
public class SolutionAcm {
    private static final String[] NUM_MAPPING = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


    public static void main(String[] args) {
        /*
        input:
        23

        output:
        [ad, ae, af, bd, be, bf, cd, ce, cf]
        */
        Scanner sc = new Scanner(System.in);
        String digits = sc.nextLine();
        List<String> ans = solve(digits);
        System.out.println(ans);
    }


    private static List<String> solve(String digits){

        int n = digits.length();
        if(n == 0)return new ArrayList<>();

        char[] text = new char[n];
        List<String> ans = new ArrayList<>();

        dfs(0, digits.toCharArray(), text, ans);
        return ans;

        
    }

    private static void dfs(int i, char[] digits, char[] text, List<String> ans){
        if(i == digits.length){
             ans.add(new String(text));
             return;
        }

        char[] letters = NUM_MAPPING[digits[i] - '0'].toCharArray();
        for(char c : letters){
            text[i] = c;
            dfs(i + 1, digits, text, ans);
        }
    }



}
