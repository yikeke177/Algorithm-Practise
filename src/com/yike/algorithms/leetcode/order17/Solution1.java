package com.yike.algorithms.leetcode.order17;

import java.util.ArrayList;
import java.util.List;


public class Solution1 {
    
    public List<String> letterCombinations(String digits) {
        /*
        组合问题
         */
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        backtrace(0, res, path, map, digits);
        return res;
    }

    private void backtrace(int depth, List<String> res, StringBuilder path, String[] map, String digits){
        // 递归退出条件
        if(path.length() == digits.length()){
            res.add(path.toString());
            return;
        }

        // 从候选中选择字母取出当前字母对应的候选
        int num = digits.charAt(depth) - '0';
        String chars = map[num];
        for(int i = 0;i < chars.length();i ++){
            // 选择当前字母
            path.append(chars.charAt(i));
            backtrace(depth + 1, res, path, map, digits);
            // 恢复现场
            path.deleteCharAt(path.length() - 1);
        }
    }
}
