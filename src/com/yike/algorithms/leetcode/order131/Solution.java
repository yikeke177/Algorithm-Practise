package com.yike.algorithms.leetcode.order131;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jyk
 * @description: 131. 分割回文串
 * @date: 2025/11/29 17:56
 * @version: 1.0
 */
public class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();

        List<String> path = new ArrayList<>();


        dfs1(0, s, path, ans); // 先考虑第一个逗号选哪个位置的，不是指选第一个位置的逗号
        return ans;



    }

    // 方法一：
    private void dfs1(int i, String str, List<String> path, List<List<String>> ans){
        if(i == str.length()){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int j = i;j < str.length();j++){ // 一开始从i~n-1 总共三个逗号里选
            // j可以看作当前子串的右端点
            // i看作当前子串的左端点
            String t = str.substring(i, j + 1);
            if(isReverseStr(t)){
                path.add(t);
                dfs1(j + 1, str, path, ans);
                // 恢复现场
                path.remove(path.size() - 1);
            }
        }


    }

    private boolean isReverseStr(String str){
        char[] chars = str.toCharArray();
        // 双指针
        int left = 0, right = chars.length - 1;
        while(left < right){
            if(chars[left] != chars[right]) return false;
            left ++;
            right --;
        }
        return true;

    }
}
