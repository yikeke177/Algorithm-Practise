package com.yike.algorithms.leetcode.order79;

import java.util.Arrays;

class Solution {
    private final int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0,1}};
    public boolean exist(char[][] board, String word) {
        /*
        dfs 深度优先搜索
        visited数组标记已经访问过的元素
        */
       boolean[][] visited = new boolean[board.length][board[0].length];
       for(int i = 0;i < board.length;i ++){
            Arrays.fill(visited[i], false);
       }

        // 遍历board 从第一个单词开始
        for(int i = 0;i < board.length;i ++){
            for(int j = 0;j < board[0].length;j ++){
                if(board[i][j] == word.charAt(0)){
                    visited[i][j] = true;
                    if(dfs(0, i, j, board, word, visited)) return true;
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean dfs(int idx, int row, int col, char[][] board, String word, boolean[][] visited){
        // 递归退出条件
        if(idx == word.length() - 1){
            return true;
        }

        boolean flag = false;
        // 选择
        for(int i = 0;i < 4;i ++){
            int nextRow = row + dirs[i][0];
            int nextCol = col + dirs[i][1];
            if(nextRow < 0 || nextRow >= board.length || nextCol < 0 || nextCol >= board[0].length) continue;
            if(visited[nextRow][nextCol]) continue;
            if(board[nextRow][nextCol] != word.charAt(idx + 1)) continue;
            // 向下递归
            visited[nextRow][nextCol] = true;
            if(dfs(idx + 1, nextRow, nextCol, board, word, visited)) flag = true;
            // 恢复现场
            visited[nextRow][nextCol] = false;
        }
        return flag;
    }
}
