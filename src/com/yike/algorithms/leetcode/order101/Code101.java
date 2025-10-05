package com.yike.algorithms.leetcode.order101;

import com.yike.algorithms.leetcode.data_structures.TreeNode;

/**
 * @author: jyk
 * @description: 101. 对称二叉树
 * @date: 2025/10/4 10:41
 * @version: 1.0
 */
public class Code101 {

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            /*
            类似于100.相同的树
            但这题是 两棵树对称 = 根节点相同 + 1的左子树和2的右子树对称 且 1的右子树和2的左子树对称
             */
            return isSym(root.left, root.right);

        }

        private boolean isSym(TreeNode root1, TreeNode root2){
            // 终止条件: 都是空结点 或 其中一个为空结点
            if(root1 == null && root2 == null) return true;
            if(root1 == null && root2 != null) return false;
            if(root1 != null && root2 == null) return false;

            // 如果根节点不相同
            if(root1.val != root2.val) return false;
            // 如果根节点相同 则继续递归子树
            return isSym(root1.right, root2.left) && isSym(root1.left, root2.right);

        }
    }
}
