package com.yike.algorithms.leetcode.order199;

import com.yike.algorithms.leetcode.data_structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jyk
 * @description: 199. 二叉树的右视图
 * @date: 2025/10/4 11:24
 * @version: 1.0
 */
public class Code199 {

    class Solution {

        public List<Integer> rightSideView(TreeNode root) {
            /*
            先遍历右子树记录每层的答案 然后遍历左子树 如果每层答案已经存在就不更新 如果不存在就记录下来
            如何判断某层是否已经记录 根据答案列表的长度判断
             */
            List<Integer> ans = new ArrayList<>();
            dfs(root, 1, ans);
            return ans;

        }

        private void dfs(TreeNode root, int depth, List<Integer> ans){
            // 终止条件
            if(root == null) return;

            // 先记录当前结点是否加入答案
            // depth从1开始 ans大小初始为0 遍历完右子树 高度应该等于ans大小
            if(depth > ans.size()) ans.add(root.val);
            // 先递归右子树
            dfs(root.right, depth + 1, ans);
            // 再左子树
            dfs(root.left, depth + 1, ans);

        }
    }
}
