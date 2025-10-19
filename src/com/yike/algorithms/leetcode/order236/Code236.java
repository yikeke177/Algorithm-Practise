package com.yike.algorithms.leetcode.order236;

import com.yike.algorithms.leetcode.data_structures.TreeNode;

/**
 * @author: jyk
 * @description: 236. 二叉树的最近公共祖先
 * @date: 2025/10/10 19:13
 * @version: 1.0
 */
public class Code236 {

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            /*
            先递归遍历每个子树 判断该子树的根是不是这两个结点的公共祖先
            1. 该结点为空 或 为p 或 为q 则本身就是公共祖先
            2. 既不是p也不是q 则细分为四种
                1. p和q分别在左右子树 则当前结点为最近公共祖先
                2. p和q都在左子树 或者都在右子树 则返回左右子树的递归结果
                3. 既不在左子树 也不在右子树 则返回空 也就是这个子树上无最近公共祖先
             */
            if(root == null || root == p || root == q) return root;

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            if(left != null && right != null) return root;

            if(left != null) return left;
            if(right != null) return right;

            return null;

        }
    }
}
