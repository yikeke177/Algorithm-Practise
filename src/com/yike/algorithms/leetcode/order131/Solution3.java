package com.yike.algorithms.leetcode.order131;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jyk
 * @description: TODO
 * @date: 2026/1/5 16:38
 * @version: 1.0
 */
class Solution3{

    public List<List<String>> partition(String s){
		/*
		每个字母后面都可以选择分割或者不分割
		最后能够得到一组子串，如果其中一个子串非回文就return
		dfs每次看位置分还是不分割，
		*/
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        // 相当于初始在第1个字符后选择是否分割
        dfs(1, 0, s, path, ans);


        return ans;


    }

    private void dfs(int idx, int pre, String s, List<String> path, List<List<String>> ans){
        // 到第idx字符结束
        if(idx == s.length()){
            // 最后一个字符后只能选择分割
            String substr = s.substring(pre, idx);
            if(!isReverse(substr)) return;
            path.add(substr);
            ans.add(new ArrayList<>(path));
            // 恢复现场
            path.remove(path.size() - 1);
            return;
        }

        // 分割
        String substr = s.substring(pre, idx);
        if(isReverse(substr)){
            path.add(substr);
            // 更新pre
            dfs(idx + 1, idx, s, path, ans);
            // 恢复现场
            path.remove(path.size() - 1);
        }



        // 不分割
        dfs(idx + 1, pre, s, path, ans);


    }

    private boolean isReverse(String s){
        // 两种方案 双指针或者直接Collector的静态方法
        char[] str = s.toCharArray();

        int l = 0, r = str.length - 1;

        while(l < r){
            if(str[l] != str[r]) return false;
            l ++;
            r --;
        }
        return true;

    }


    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();

        solution3.partition("aab");
    }

}

