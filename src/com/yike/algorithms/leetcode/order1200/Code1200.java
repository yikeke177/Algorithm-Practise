package com.yike.algorithms.leetcode.order1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/*
请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
给你个整数数组 arr，其中每个元素都 不相同。
每对元素对 [a,b] 如下：
a , b 均为数组 arr 中的元素
a < b
b - a 等于 arr 中任意两个元素的最小绝对差
示例 1：
输入：arr = [4,2,1,3]
输出：[[1,2],[2,3],[3,4]]
示例 2：
输入：arr = [1,3,6,10,15]
输出：[[1,3]]
示例 3：
输入：arr = [3,8,-10,23,19,-4,-14,27]
输出：[[-14,-10],[19,23],[23,27]]
 */

/**
 * @author: jyk
 * @description: 1200. 最小绝对差
 * @date: 2025/9/19 16:14
 * @version: 1.0
 */
public class Code1200 {
    class Solution {
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            /*
             首先题目要求升序返回 那么很自然能想到先对数组进行排序 排序后相邻两个数的绝对差肯定比较小
             遍历一遍 比较所有数对 得到最小的差
             然后再遍历一遍 统计所有的最小差数对
             */
            int len = arr.length;

            Arrays.sort(arr);
            int minVal = Integer.MAX_VALUE;
            for(int i = 0;i < len - 1;i ++){
                int j = i + 1;
                if(arr[j] - arr[i] < minVal) minVal = arr[j] - arr[i];
            }

            List<List<Integer>> ans = new ArrayList<>();
            for(int i = 0;i < len - 1;i ++){
                int j = i + 1;
                if(arr[j] - arr[i] == minVal){
                    ans.add(Arrays.asList(arr[i], arr[j]));
                }
            }
            return ans;


        }
    }

    public static void main(String[] args) {
        Code1200 code1200 = new Code1200();
        Solution solution = code1200.new Solution();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] nums = new int[n];
        for(int i = 0;i < n;i ++){
            nums[i] = sc.nextInt();
        }
        System.out.println(solution.minimumAbsDifference(nums));
    }
}
