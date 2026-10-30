package com.yike.algorithms.leetcode.order51;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        /*
        本质上就是全排列 + 剪枝（剪去对角皇后冲突的分支）
        */
        // 初始化
        List<List<String>> res = new ArrayList<>();
        int[] path = new int[n];
        boolean[] usedCol = new boolean[n];

        backtrace(0, n, path, res, usedCol);

        return res;
    }


    private void backtrace(int row, int n, int[] path, List<List<String>> res, boolean[] usedCol){
        // 递归退出条件
        if(row == n){
            // 构造答案
            List<String> ans = new ArrayList<>();
            for(int i = 0;i < n;i ++){
                StringBuilder curRow = new StringBuilder();
                for(int j = 0;j < path[i];j ++) curRow.append('.');
                curRow.append('Q');
                for(int j = path[i] + 1;j < n;j ++) curRow.append('.');
                ans.add(curRow.toString());
            }
            res.add(ans);
            return;
        }

        // 当前行选择列
        for(int col = 0;col < n;col ++){
            if(usedCol[col]) continue;
            // 检查是否有对角冲突
            if(!isValid(row, col, path)) continue;
            path[row] = col;
            usedCol[col] = true;
            // 递归
            backtrace(row + 1, n, path, res, usedCol);

            // 恢复现场
            usedCol[col] = false;
            
        }
    }
    private boolean isValid(int row, int col, int[] path){
        for(int x = 0;x < row;x ++){
            if(Math.abs(row - x) == Math.abs(col - path[x])) return false;
        }
        return true;
    }
}
