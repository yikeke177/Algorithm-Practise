package com.yike.algorithms.leetcode.order337;

import com.yike.algorithms.leetcode.data_structures.TreeNode;

/**
 * @author: jyk
 * @description: 337. 打家劫舍 III
 * @date: 2025/10/26 19:11
 * @version: 1.0
 */
public class Code337 {

    class Solution {
        private int ans = 0;
        public int rob(TreeNode root) {
            /*
            递归遍历每个结点的子树 求该子树选和不选时的最大金额 然后同时更新全局最大金额
            该子树的最大金额 = max(选该结点的最大金额, 不选该结点的最大金额)
            然后选该结点的最大金额 = 不选左子树最大金额 + 不选右子树最大金额 + 当前结点金额
            因为选了该结点 它的左右子结点肯定就不能选
            然后不选该结点的最大金额 = max(选左子树最大金额, 不选左子树最大金额) + max(选右子树最大金额,不选右子树最大金额)
            因为不选该结点 它的左右子树选或不选都可以
             */
            dfs(root);
            return ans;
        }

        private int[] dfs(TreeNode root){
            // 返回条件 空结点 选或不选都是0
            if(root == null) return new int[]{0,0};

            // 得到左右子树选和不选的最大金额
            int[] left = dfs(root.left);
            int[] right = dfs(root.right);
            // 求选root结点的最大金额
            int choose = left[1] + right[1] + root.val;
            // 不选root结点的最大金额
            int notChoose = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            // 更新全局最大金额
            ans = Math.max(ans,Math.max(choose, notChoose));
            // 返回该结点的最大金额
            return new int[]{choose, notChoose};
        }
    }
}
