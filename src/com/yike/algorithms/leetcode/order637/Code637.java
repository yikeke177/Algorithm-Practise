package com.yike.algorithms.leetcode.order637;

/*
637. 二叉树的层平均值
给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。

 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */



import com.yike.algorithms.leetcode.data_structures.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: jyk
 * @description: 637. 二叉树的层平均值
 * @date: 2025/9/25 10:58
 * @version: 1.0
 */
public class Code637 {
    class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            /*
            使用队列逐层遍历
            深度优先搜索
            第一次做时没有想明白如何将遍历一层和加入新的结点分清
            实际上每一层可以计算一次队列size，然后循环size长度 这样就不怕碰到后面新加入的结点了
             */
            // 队列
            Deque<TreeNode> que = new ArrayDeque<>();


            // 根结点入队
            que.addLast(root);


            // 层序遍历
            List<Double> ans = new ArrayList<>();
            while(! que.isEmpty()){
                // 计算当前层长度
                int len = que.size();
                // 遍历当前层并累加
                double sum = 0;
                for(int i = 0;i < len;i ++){
                    // 获取首元素并删除
                    TreeNode tmp = que.removeFirst();;
                    sum += tmp.val;
                    // 左右子结点入队
                    if(tmp.left != null)que.addLast(tmp.left);
                    if(tmp.right != null) que.addLast(tmp.right);

                }
                // 计算平均数
                ans.add(sum / len);
            }
            return ans;


        }
    }

}
