package com.yike.algorithms.leetcode.order124;
import com.yike.algorithms.leetcode.data_structures.TreeNode;

/**
 * @author: jyk
 * @description: 124. 二叉树中的最大路径和
 * @date: 2025/10/25 16:08
 * @version: 1.0
 */
public class Code124 {

    class Solution {
        private int ans = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            /*
            类似于题目543.二叉树的直径 只不过这题是求结点和
            而且不一定是以叶子结点开始和结束，因为如何叶子结点是负数，带上叶子结点只会让和更小。
            所以在求当前结点最大和时，如果是负数就丢弃该值，返回0。

            递归求每个结点的最大链和
            最大链和 = max(左子树最大链和, 右子树最大链和) + root.val

            当前结点的路径和 = 左子树最大链和 + 右子树最大链和 + root.val
             */
            dfs(root);
            return ans;

        }
        private int dfs(TreeNode root){
            if(root == null) return 0;

            // 左子树
            int leftSum = dfs(root.left);
            // 右子树
            int rightSum = dfs(root.right);

            // 更新答案
            ans = Math.max(ans, leftSum + rightSum + root.val);

            // 当前结点最大和
            int curSum = Math.max(rightSum, leftSum) + root.val;
            // 如果当前最大和为负数，宁愿丢弃掉不算上它，因为带上它只会让和更小
            return Math.max(curSum, 0);
        }
    }
}
