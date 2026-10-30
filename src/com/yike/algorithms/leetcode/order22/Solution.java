package com.yike.algorithms.leetcode.order22;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    

    public List<String> generateParenthesis(int n) {
        /*
        生成合法的括号
        回溯 + 剪枝（提前判断当前分支得到的结构是否合法）
        */
        // 初始化
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();

        backtrace(1, res, path, n, 0, 0);
        
        return res;
        
    }

    private void backtrace(int idx, List<String> res, StringBuilder path, int n, int left, int right){
        // 终止条件
        if(idx == n*2 + 1){
            res.add(path.toString());
            return;
        }

        // 选择当前位置 要么选左括号 要么选右括号
        // 选择左括号
        if(left < n){ // 只有当左括号数量小于n时才能选择左括号
            path.append('(');
            backtrace(idx + 1, res, path, n, left + 1, right);
            // 恢复现场
            path.deleteCharAt(path.length() - 1);
        }
        // 选择右括号
        if(right < left){
            path.append(')');
            backtrace(idx + 1, res, path, n, left, right + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
