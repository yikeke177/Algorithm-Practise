package com.yike.algorithms.leetcode.order200;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author: jyk
 * @description: 200. 岛屿数量
 * @date: 2025/9/14 11:03
 * @version: 1.0
 */
public class Code200 {

    class Solution {

        class Point{
            public int x;
            public int y;
            public Point(int x, int y){
                this.x = x;
                this.y = y;
            }
        }
        private char[][] grid;
        private int[][] visited; // 标记是否已经访问 0 未访问 1 已访问
        private int rows; // 行数
        private int cols; // 列数


        private void bfs(int x, int y){
            // 初始化一个队列，java中一般用双端队列，因为功能可以覆盖普通队列
            Deque<Point> deque = new ArrayDeque<>();
            // 初始化添加根节点
            Point root = new Point(x, y);
            deque.addFirst(root);
            // 四个方向 上 下 左 右
            int[] pos_x = new int[]{-1, 1, 0, 0};
            int[] pos_y = new int[]{0, 0, -1, 1};

            // 循环
            while(deque.size() != 0){
                // 访问首元素 然后出队列
                Point tmp = deque.getFirst();
                visited[tmp.x][tmp.y] = 1; // 标记为已访问
                deque.removeFirst(); // 出队

                // 新元素加入队列
                for(int i = 0;i < 4;i ++){
                    int new_x = tmp.x + pos_x[i];
                    int new_y = tmp.y + pos_y[i];
                    // 检查边界是否超出 先检查边界 再检查是否访问 因为有可能越界
                    if(new_x < 0 || new_x > rows-1 || new_y < 0 || new_y > cols-1)continue;
                    // 检查是否是岛屿的一部分
                    if(this.grid[new_x][new_y] == '0') continue;
                    // 检查是否已经访问过
                    if(visited[new_x][new_y] == 1) continue;
                    // 标记为岛屿的一部分
                    visited[new_x][new_y] = 1;

                    // 检查通过 加入队列
                    deque.addLast(new Point(new_x, new_y));
                }
            }



        }

        public int numIslands(char[][] grid) {
            /**
             * 如何判断是否为岛屿
             * 1. 深度优先搜索：先一条路走到黑，然后再换下一条路
             * 2. 广度优先搜索：一圈一圈往外拓展
             * 使用广度优先搜索一圈一圈往外扩展，直到结束，得到一个岛屿，同时通过另一个矩阵来标记是否已经访问过。
             * 广度优先算法的实现有两种，一种是迭代，一种是递归。一般用迭代，更清晰。递归的方式不易debug且容易栈溢出
             */
            // 先校验输入的矩阵，这是个好习惯
            if(grid.length == 0) return 0;

            // 写一个广度优先搜索的算法作为一个函数
//            dfs(x,y)

            int count = 0;

            // 遍历矩阵
            this.grid = grid;
            this.rows = grid.length;
            this.cols = grid[0].length;
            this.visited = new int[this.rows][this.cols];
            for(int r = 0;r < this.rows;r ++){
                for(int c = 0;c < this.cols;c ++){
                    if(grid[r][c] == '1' && visited[r][c] != 1){ // 如果是陆地 且没有被访问过 则bfs搜索
                        count ++;// 岛屿数量+1
                        bfs(r, c);
                    }
                }
            }
            return count;



        }
    }

    public static void main(String[] args){
        Code200 code200 = new Code200();
        Code200.Solution solution = code200.new Solution();

        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int c = in.nextInt();
        in.nextLine();
        char[][] grid = new char[r][c];
        for(int i = 0;i < r;i ++){
            for(int j = 0;j < c;j ++){
                grid[i][j] = in.next().charAt(0);
            }
            in.nextLine();
        }
        System.out.println(solution.numIslands(grid));

    }
}
