package com.yike.algorithms.leetcode.order235;

import com.yike.algorithms.leetcode.data_structures.TreeNode;

/**
 * @author: jyk
 * @description: 235. 二叉搜索树的最近公共祖先
 * @date: 2025/10/12 14:01
 * @version: 1.0
 */
public class Code235 {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            /*
            相比于236题二叉树的最近公共祖先
            这题的不同之处在于访问某个结点时 不只可以判断该结点是否为p或q 还可以比较该结点是否大于p和q结点值
            如果p和q的值都小于root值 说明p和q在左子树中 递归返回左子树就行
            如果p和q的值都大于root值 说明p和q在右子树中 递归返回右子树就行
            如果p和q的值一个大一个小 说明p和q在左右子树中 当前结点就是最近公共祖先
             */

            if(root == q || root == p) return root;
            if(root.val > q.val && root.val > p.val) return lowestCommonAncestor(root.left, p, q);

            if(root.val < q.val && root.val < p.val) return lowestCommonAncestor(root.right, p, q);
            // 剩余情况 p和q的值一个大一个小 说明p和q在左右子树中 当前结点就是最近公共祖先
            return root;

        }
    }
}
