package com.yike.algorithms.leetcode.order543;
import com.yike.algorithms.leetcode.data_structures.TreeNode;

/**
 * @author: jyk
 * @description: 543. 二叉树的直径
 * @date: 2025/10/19 11:21
 * @version: 1.0
 */
public class Code543 {

    class Solution {
        private int ans = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            /*
            最大直径的特征1：最大直径这条链一定是以叶子结点开始，以叶子结点结束。
            因为如果不是以叶子结点结束，那么就一定能继续延伸至叶子结点得到更长的链

            最大直径特征2:既然一定由叶子结点开始和结束。那么一定会在某个结点处拐弯。因此最大直径通常由两条链组成，在某个结点处拐弯。（也可能只由一条链组成）

            解题思路：递归求解当前结点的最长链，在这个过程中同时求解并更新最大直径。
            强调：写的递归函数dfs作用是用来求当前结点最长链的。顺带求解最大直径

            所以得到root结点的最长链 = max(左子树最长链, 右子树最长链) + 1 其中链长初始值为-1
            而不是 max(左子树最长链,右子树最长链) + 1 其中链长初始值为0 因为如果是孤立的root结点 得到的结果为max(0,0) + 1 = 1 不对 真实的链长应该为0


            然后计算最大直径 = (左子树最大链 + 右子树最大链) + 2
             */
            dfs(root);
            return ans;


        }
        private int dfs(TreeNode root){
            // 边界条件 空树
            if(root == null) return -1;

            // 得到左右子树的链长
            int leftLen = dfs(root.left);
            int rightLen = dfs(root.right);
            // 更新最大直径
            ans = Math.max(ans, leftLen + rightLen + 2);
            // 计算当前节点root的最长链
            return Math.max(leftLen, rightLen) + 1;
        }
    }
}
