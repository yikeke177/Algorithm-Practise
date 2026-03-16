package com.yike.algorithms.leetcode.order322;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author: jyk
 * @description: 322. 零钱兑换
 * @date: 2025/12/19 17:19
 * @version: 1.0
 */
public class Code322 {

    class Solution {
        public int coinChange(int[] coins, int amount) {
            /*
            前者表示不选第i种硬币 后者表示选第i种硬币 选完之后还能再选
            f(i, m) = min( f(i - 1, m), f(i , m - coins[i]) + 1)
             */
            int n = coins.length;

            int[][] f = new int[n + 1][amount + 1];
            // amount最大为1e4 硬币的最小为1 所以最多需要1e4枚硬币
            // Integer.MAX_VALUE = 2^32 = (1024)^3 = 1e9
            // 所以除以2也会是最大值 且能防止溢出
            // 使用流函数式填充
            IntStream.range(0, n+1)
                    .forEach(i -> Arrays.fill(f[i], Integer.MAX_VALUE / 2));
//            Arrays.fill(f[0], Integer.MAX_VALUE / 2);
            f[0][0] = 0;

            for(int i = 0;i < n;i ++){
                for(int j = 0;j <= amount;j ++){
                    if(j >= coins[i]){
                        f[i+1][j] = Math.min(f[i][j], f[i+1][j - coins[i]] + 1);
                    }else{
                        f[i+1][j] = f[i][j];
                    }
                }
            }
            if(f[n][amount] == Integer.MAX_VALUE / 2) return -1;
            else return f[n][amount];


        }
    }
    /*
    使用一个数组优化空间复杂度
    完全背包问题要从前往后算
    01背包问题要逆序算
    原因在于：
    01背包都是从上一个状态转移过来
    而完全背包有一个是从当前状态转移过来
     */
    class Solution2 {
        public int coinChange(int[] coins, int amount) {
            /*
            前者表示不选第i种硬币 后者表示选第i种硬币 选完之后还能再选
            f(i, m) = min( f(i - 1, m), f(i , m - coins[i]) + 1)
             */
            int n = coins.length;

            int[] f = new int[amount + 1];
            // amount最大为1e4 硬币的最小为1 所以最多需要1e4枚硬币
            // Integer.MAX_VALUE = 2^32 = (1024)^3 = 1e9
            // 所以除以2也会是最大值 且能防止溢出
            Arrays.fill(f, Integer.MAX_VALUE / 2);
            f[0] = 0;

            for(int i = 0;i < n;i ++){
                // 对于完全背包问题 要从前往后算
                // 对于01背包问题 则要逆序
                // 原因在于01背包都是从上一个状态转移过来
                // 而完全背包有一个是从当前状态转移过来
                for(int j = coins[i];j <= amount;j ++){
                    f[j] = Math.min(f[j], f[j - coins[i]] + 1);
                }
            }
            if(f[amount] == Integer.MAX_VALUE / 2) return -1;
            else return f[amount];


        }
    }

    public static void main(String[] args) {
        Code322 code322 = new Code322();
        Solution solution = code322.new Solution();
        Solution2 solution2 = code322.new Solution2();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int amount = sc.nextInt();

        sc.nextLine();

        int[] coins = new int[n];

        for(int i = 0;i < n;i++){
            coins[i] = sc.nextInt();
        }
        System.out.println(solution2.coinChange(coins, amount));

    }



}
