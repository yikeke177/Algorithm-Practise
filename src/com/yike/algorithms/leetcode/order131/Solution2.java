package com.yike.algorithms.leetcode.order131;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jyk
 * @description: 131. 分割回文串
 * @date: 2025/11/29 17:56
 * @version: 1.0
 */
public class Solution2 {

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();

        List<String> path = new ArrayList<>();


        dfs2(0, 0, s, path, ans); // 先考虑第一个逗号选哪个位置的，不是指选第一个位置的逗号
        return ans;



    }

    // 方法一：

    /**
     *
     * @param i
     * @param start : 记录这次分割点的起始位置
     * @param str
     * @param path
     * @param ans
     */
    private void dfs2(int i, int start, String str, List<String> path, List<List<String>> ans){

        if(i == str.length()){
            ans.add(new ArrayList<>(path));
        }

        // 分割 i的后面空隙处分割
        String t = str.substring(start, i + 1);
        if(isReverseStr(t)){
            path.add(t);
            dfs2(i + 1, i + 1, str, path, ans);
            // 还原现场
            path.remove(path.size() - 1);
        }



        // 不分割
        if(i < str.length() - 1){ // 最后一个元素后的分割点必须分割，所以就跳过不分割的情况
            dfs2(i + 1,start, str, path, ans);
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
