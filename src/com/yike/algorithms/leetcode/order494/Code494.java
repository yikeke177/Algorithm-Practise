package com.yike.algorithms.leetcode.order494;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

/**
 * @author: jyk
 * @description: 494. 目标和
 * @date: 2025/12/16 20:45
 * @version: 1.0
 */
public class Code494 {
    /*
    回溯写法
     */
    class Solution {
        private int cnt = 0;
        public int findTargetSumWays(int[] nums, int target) {
            /*
            n个位置 选+或者选-
             */
            // java中基本数据类型是值传递 所以cnt值会一直是0
            int n = nums.length;

            dfs(0, 0, n, nums, target);
            return cnt;


        }
        private void dfs(int i, int sum, int n, int[] nums, int target){
            // 递归退出条件
            if(i == n) {
                if(sum == target)cnt ++;
                return;
            }

            // 选-
            dfs(i + 1, sum - nums[i], n, nums, target);
            // 选+
            dfs(i + 1, sum + nums[i], n, nums, target);
        }
    }

    /*
    转变成01背包问题
    已知nums的和为sum
    其中选择+号的数和为 p
    选择-号的数和为 q
    那么 p + q = sum
    又目标是： p - q = target
    联立可求得： p = (sum + target) / 2
    也就是说p是一个已知值
    问题就转换为：从nums中选择数的和为p的方案数有多少个
    也就是01背包问题的变体
    dfs(i, p)表示从前i个数中选 和为p的方案数有多少个
    转移方程：
    dfs(i, p) = dfs(i - 1, p - nums[i]) + dfs(i - 1, p)
    +号前者是选第i个数时的方案数 后者是不选第i个数时的方案数

     */
    class Solution2 {
        public int findTargetSumWays(int[] nums, int target) {
            int n = nums.length;

            int sum = Arrays.stream(nums)
                    .reduce(0, Integer::sum);
            if((sum + target) % 2 != 0) return 0;
            int p = (sum + target) / 2;

            return dfs(n - 1, p, nums);
        }


        private int dfs(int i, int p, int[] nums){
            if(i < 0 ){
                // 如果最后p正好为0 说明恰好能够等于p 有一种放
                if(p == 0) return 1;
                // 否则没有可行的方案。
                else return 0;
            }
            if(p < nums[i]){ // 也就是p - nums[i] < 0的情况
                // 如果当前数比目标和要大 那就只能不选当前数
                return dfs(i - 1, p, nums);
            }

            return dfs(i-1, p, nums) + dfs(i - 1, p - nums[i], nums);
        }
    }

    /**
     * 改成递推
     */
    class Solution3 {
        public int findTargetSumWays(int[] nums, int target) {
            /*
            f(i, p) = f(i - 1, p) + f(i - 1, p - nums[i])
             */
            int n = nums.length;
            int sum = Arrays.stream(nums)
                    .reduce(0, Integer::sum);
            if((sum + target) % 2 != 0) return 0;
            int p = (sum + target) / 2;
            // p 不能小于0 小于0 则表示没有可行的方案
            if(p < 0) return 0;
            // j的取值从0到p 所以要p+1个元素
            int[][] f = new int[n + 1][p+1];
            f[0][0] = 1; // 当p = 0 i = -1 时说明有一种可行方案
            for(int i = 0;i < n;i ++){
                for(int j = 0;j <= p;j ++){
                    if(j >= nums[i])
                        f[i+1][j] = f[i][j] + f[i][j - nums[i]];
                    else f[i+1][j] = f[i][j];
                }
            }
            return f[n][p];
        }
    }

    /**
     * 滚动数组优化空间 每一个状态i都只和上一个状态i-1有关 那么就之需要一个数组来回更新即可
     * 由于f[j] = f[j] + f[j - nums[i]] 需要的是上一个状态的f[j - nums[i]] 所以要从后往前循环
     * 如果从前往后循环 f[j - nums[i]]就会被新值覆盖 导致使用的不是旧值
     */
    class Solution4 {
        public int findTargetSumWays(int[] nums, int target) {
            int n = nums.length;
            int sum = Arrays.stream(nums)
                    .reduce(0, Integer::sum);
            if((sum + target) % 2 != 0) return 0;
            int p = (sum + target) / 2;
            // p 不能小于0 小于0 则表示没有可行的方案
            if(p < 0) return 0;

            // 1个数组
            int[] f = new int[p+1];
            f[0] = 1; // 当p = 0 i = -1 时说明有一种可行方案
            for(int i = 0;i < n;i ++){
                for(int j = p;j >= nums[i];j --){
                    f[j] = f[j] + f[j - nums[i]];
                }
            }
            return f[p];
        }
    }




    public static void main(String[] args) {
        Code494 code494 = new Code494();
        Solution solution = code494.new Solution();
        Solution2 solution2 = code494.new Solution2();
        Solution3 solution3 = code494.new Solution3();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int target =  scanner.nextInt();
        scanner.nextLine();
        int[] nums = new int[n];
        for(int i = 0;i < n;i ++) nums[i] = scanner.nextInt();

        System.out.println(solution3.findTargetSumWays(nums, target));
    }
}
