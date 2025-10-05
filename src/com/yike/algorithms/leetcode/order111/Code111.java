package com.yike.algorithms.leetcode.order111;

/*
111. 二叉树的最小深度


 */


import com.yike.algorithms.leetcode.data_structures.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: jyk
 * @description: 111. 二叉树的最小深度
 * @date: 2025/9/27 13:49
 * @version: 1.0
 */
public class Code111 {

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
    // 递归方法一：自顶向下“递”
    class Solution {
        private int ans = Integer.MAX_VALUE;
        public int minDepth(TreeNode root) {
            /*
            参考 104.二叉树的最大深度 中递归方式二：自顶向下递归
            区别在于：
            104.二叉树的最大深度：所有的结点上的深度值取最大值
            111.二叉树的最小深度：所有叶子结点上的深度值取最小值
             */

            dfs(root, 0);
            return root != null ? ans : 0;

        }
        // 错误写法
        private void dfs2(TreeNode root, int depth){
            // 递归终止条件
            if(root == null){
                // 错误点！！！
                /*
                    root == null不代表它的父结点就是叶子结点了
                    因为这只是它父结点的一个子结点为null 另一个子结点不一定也为null

                 */

                ans = Math.min(ans, depth);
                return;
            }
            // 非叶子结点
            dfs2(root.left, depth + 1);
            dfs2(root.right, depth + 1);


        }

        private void dfs(TreeNode root, int depth){
            // 递归终止条件
            if(root == null){

                return;
            }

            if(root.left == null && root.right == null){
                // 当左右子结点都为null时 说明是叶子结点
                ans = Math.min(ans, depth+1);
            }

            // 非叶子结点
            dfs(root.left, depth + 1);
            dfs(root.right, depth + 1);


        }

    }

    // 递归方法一：自底向上“归”
    // 错误写法
    class Solution2 {
        public int minDepth(TreeNode root) {
            /*
            参考 104.二叉树的最大深度 中递归方式一：自底向上
            以root为根结点的树的最小深度 = min(左子树最小深度, 右子树最小深度 ) + 1
             */
            // 终止条件
            if(root == null){
                // 空树的最小深度为0
                return 0;
            }
            /*
            为什么这样写是错的？
            对于根节点左子树是空，右子树非空的情况 这样会得到最小深度为1
            但这题最小深度的定义是叶子结点到根节点的距离 但根结点不能看作是叶子结点
            所以这题公式不应该是：min(左子树最小深度, 右子树最小深度 ) + 1
            而需要分两种情况：
            1. 一棵子树空，另一棵子树非空。最小深度 = 非空树的最小深度+1
            2. 两棵都非空。最小深度 = min(左子树最小深度, 右子树最小深度 ) + 1
             */
            int leftMin = minDepth(root.left);
            int rightMin = minDepth(root.right);

            return Math.min(leftMin, rightMin) + 1;

        }

    }
    // 递归方法一：自底向上“归”
    // 错误写法
    class Solution3 {
        public int minDepth(TreeNode root) {
            /*
            参考 104.二叉树的最大深度 中递归方式一：自底向上

            以root为根结点的树的最小深度 = min(左子树最小深度, 右子树最小深度 ) + 1
            由于当左右子树其中一棵为空时 最小深度应该为非空子树的深度+1 而不是那颗空子树的深度+1 因为它没有叶子结点
            所以本题情况：
            1. 一棵子树空，另一棵子树非空。最小深度 = 非空树的最小深度+1
            2. 两棵都非空。最小深度 = min(左子树最小深度, 右子树最小深度 ) + 1
             */
            // 终止条件
            if(root == null){
                // 空树的最小深度为0
                return 0;
            }
            // 情况一：
            if(root.left == null) return minDepth(root.right) + 1;
            if(root.right == null) return minDepth(root.left) + 1;
            // 情况二：
            return Math.min(minDepth(root.right), minDepth(root.left)) + 1;

        }

    }

    // 非递归 广度优先搜索
    class Solution4 {
        public int minDepth(TreeNode root) {
            /*
            层序遍历 第一个遍历到的叶子结点必是深度最小的
            一层一层遍历结点 如果该结点是叶子结点 则返回
             */

            // 队列
            Deque<TreeNode> que = new ArrayDeque<>();
            // 添加根节点
            if(root != null) que.addFirst(root);
            // 记录当前深度
            int depth = 0;

            while(!que.isEmpty()){
                depth ++;
                // 当前队列长度
                int len = que.size();

                // 遍历当前层 并把所有的子结点加入
                for(int i = 0;i < len;i ++){
                    // 获取队列首元素并弹出
                    TreeNode curNode = que.removeFirst();
                    // 如果是叶子结点 直接返回
                    if(curNode.left == null && curNode.right == null){
                        return depth;
                    }
                    // 加入所有子结点
                    if(curNode.right != null) que.addFirst(curNode.right);
                    if(curNode.left != null) que.addFirst(curNode.left);
                }
            }
            return 0;

        }

    }




}
