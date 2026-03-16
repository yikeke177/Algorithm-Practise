package com.yike.algorithms.leetcode.order79;

/**
 * @author: jyk
 * @description: 79. 单词搜索
 * @date: 2026/1/4 19:03
 * @version: 1.0
 */
public class Code79 {

    static class Solution{
        private static final int[] px = {-1, 1, 0, 0};
        private static final int[] py = {0, 0, -1, 1};


        public boolean exist(char[][] board, String word){

		/*
		先找到起始字母，然后开始深度优先搜索
		要么找到
		要么无法继续搜索
		*/
            int n = board.length;
            int m = board[0].length;
            for(int i = 0;i < n;i ++){
                for(int j = 0;j < m;j ++){
                    if(board[i][j] == word.charAt(0)){
                        boolean[][] vis = new boolean[n][m];
                        vis[i][j] = true;
                        if(dfs(i, j, 0, board, word, vis))return true;
                    }
                }
            }
            return false;


        }

        private boolean dfs(int x, int y, int idx, char[][] board, String word, boolean[][] vis){
            // 退出条件
            if(idx == word.length()-1) return true;

            char[] chars = word.toCharArray();
            // 从上下左右四个方向里选
            for(int i = 0;i < 4;i ++){
                int nextX = x + px[i], nextY = y + py[i];
                if(nextX < 0 || nextY >= board[0].length || nextY < 0 || nextX >= board.length)continue;
                if(vis[nextX][nextY]) continue;
                if(board[nextX][nextY] != chars[idx + 1]) continue;
                vis[nextX][nextY] = true;
                if(dfs(nextX, nextY, idx + 1,  board, word, vis)) return true;
                // 恢复现场
                vis[nextX][nextY] = false;
            }
            return false;

        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String[] str = new String[]{"ABCE", "SFCS", "ADEE"};
        char[][] board1 = new char[3][];
        for(int i = 0;i < board1.length;i ++){
            board1[i] = str[i].toCharArray();
        }

        String word = new String("SEE");

        solution.exist(board, word);

    }

}
