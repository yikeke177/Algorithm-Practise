package com.yike.algorithms.leetcode.order200;

import com.yike.algorithms.leetcode.order20.Code20ACM;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Code200ACM {



    static class Solution{

        public int solve(char[][] grid){
            /*
            遍历每个元素，如果为'1'，岛屿数量+1，然后递归标记所有土地为'0'
             */
            int cnt = 0;
            for(int i = 0;i < grid.length;i ++){
                for(int j = 0;j < grid[0].length;j ++){
                    if(grid[i][j] == '1'){
                        cnt ++;
                        bfs(i, j, grid);
                    }
                }
            }

            return cnt;

        }

        private void dfs(int i, int j, char[][] grid){
            // 退出条件
            // 如果越界了
            if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
            // 如果不是'1'
            if(grid[i][j] != '1') return;

            // 标记为0
            grid[i][j] = '0';

            // 上 下 左 右
            dfs(i -1, j, grid);
            dfs(i + 1, j, grid);
            dfs(i, j-1, grid);
            dfs(i, j+1, grid);

        }
        static class Point{
            int x, y;
            Point(int x, int y){
                this.x = x;
                this.y = y;
            }
        }

        private void bfs(int i, int j, char[][] grid){
            // 队列
            // 入队
            // 队列
            Deque<Point> que = new LinkedList<>();
            // 初始点入队
            que.addLast(new Point(i, j));

            final int[] POSX = new int[]{-1, 1, 0, 0};
            final int[] POSY = new int[]{0, 0, -1, 1};

            while(!que.isEmpty()){
                // 取出队头元素
                Point cur = que.removeFirst();
                // 计算四种方向的新point
                for(int k = 0;k < 4;k ++){
                    int X = cur.x + POSX[k];
                    int Y = cur.y + POSY[k];

                    if(X < 0 || X >= grid.length || Y < 0 || Y >= grid[0].length) continue;
                    if(grid[X][Y] != '1')continue;

                    // 加入队列 标记
                    que.addLast(new Point(X, Y));
                    grid[X][Y] = '0';


                }

            }


        }
    }


    public static void main(String[] args) {
        Solution solution = new Code200ACM.Solution();

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        char[][] grid = new char[m][n];
        for(int i = 0;i < m;i ++){
            for(int j = 0;j < n;j ++){
                grid[i][j] = (char) ('0' + sc.nextInt());
            }
        }
        /*
4 4
1 1 0 0
1 0 1 1
0 0 1 0
1 0 0 0
3

5 5
1 1 1 0 0
0 0 0 1 0
0 0 0 0 0
0 0 0 0 0
1 1 1 1 1
         */

        System.out.println(solution.solve(grid));
    }
}
