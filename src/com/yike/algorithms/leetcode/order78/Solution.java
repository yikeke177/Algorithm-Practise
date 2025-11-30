package com.yike.algorithms.leetcode.order78;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jyk
 * @description: 78. 子集
 * @date: 2025/11/26 20:14
 * @version: 1.0
 */
public class Solution {
    /*
    回溯 每个位置上可以选该数字或者不选两种情况
    不选 : 直接递归到下一个位置
    选 : 选了后 再递归到下一个位置 最后还得恢复现场
    如何理解这里为什么要恢复现场？
    画一个棵递归树，左子树不选，右边选
    一开始会递归到左下角的叶子结点
    然后回溯 这里回溯的目的是寻求其他的答案 所以要恢复到上一次状态，以便从上一个状态进入下一个选择
    这里是两个选择，假如有第三个选择，必须先恢复状态再进行
    相当于每一个选择后都得恢复状态，这里“不选”就是原本的状态，所以隐式相当于恢复了状态
     */

    public List<List<Integer>> subsets(int[] nums) {



        List<List<Integer>> ans = new ArrayList<>();

        // 一条路径对应一个结果
        List<Integer> path = new ArrayList<>();
        dfs(0, nums, ans, path);
        return ans;


    }

    private void dfs(int i, int[] nums, List<List<Integer>> ans, List<Integer> path){

        if(i == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }

        // 不选 直接递归下一个
        dfs(i + 1, nums, ans, path);

        // 选
        path.add(nums[i]);
        dfs(i + 1, nums, ans, path);
        path.remove(path.size() - 1);
    }



}
