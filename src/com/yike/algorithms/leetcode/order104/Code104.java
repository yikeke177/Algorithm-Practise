package com.yike.algorithms.leetcode.order104;

import com.yike.algorithms.leetcode.data_structures.TreeNode;

/**
 * @author: jyk
 * @description: 104. 二叉树的最大深度
 * @date: 2025/9/27 13:57
 * @version: 1.0
 */
public class Code104 {
    // 递归方法一：自底向上 最小的子树合并求max 然后逐渐网上“归”
    class Solution {
        public int maxDepth(TreeNode root) {
            /*
            以某个结点为根的树的最大深度 = max(左子树的最大深度, 右子树的最大深度) + 1
            然后左右子树的最大深度又是同样的计算方法
            因此使用递归
            而使用递归需要想清楚递归的终止条件
            在这里终止条件就是叶子结点的左右空结点（无子树,深度为0）
            所以终止条件返回的深度值为0 因为空树深度肯定为0
             */
            if(root == null) return 0;

            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

        }


    }

    // 递归方法二：自顶向下 从根往下“递”的过程就是统计的过程 不需要“归”的操作
    class Solution2 {
        private int maxDept;
        public int maxDepth(TreeNode root) {
            /*
            计算所有结点到根节点的距离：
            当前结点到根节点的距离 = 父结点到根节点的距离 + 1
            当遍历了整棵树（也就是访问到了所有的叶子结点）时，就得到了每个叶子结点到根结点的距离
            取所有结点到根节点距离的最大值即可 通过维护一个全局变量ans记录最大值 每次访问到一个新的结点就更新这个最大值
             */

            subMaxDepth(root, 0);
            return maxDept;


        }
        private void subMaxDepth(TreeNode root, int depth){
            if(root == null) return;

            maxDept = Math.max(maxDept, depth + 1);
            subMaxDepth(root.left, depth + 1);
            subMaxDepth(root.right, depth + 1);
        }

    }

}
