package com.yike.algorithms.leetcode.order2246;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jyk
 * @description: 2246. 相邻字符不同的最长路径
 * @date: 2025/10/25 16:44
 * @version: 1.0
 */
public class Code2246 {

    class Solution {
        private int ans = 0;
        private List<List<Integer>> tree = null;
        private String str;
        public int longestPath(int[] parent, String s) {
            /*
            这是图论的题，图以邻接表的形式给出
            这是一棵一般树，不是二叉树，也就说子树可以大于2个
            同时这题也不一定是以叶子结点开始和结束 那么就只需通过判断相邻结点是否重复字符来去掉路径

            先根据邻接表构建树
            然后思路同543.二叉树的直径 递归每个结点最大链长
            但在求每个结点最大链长时，不只有两个子树，有很多子树

            当前结点最长链 = max(c1, c2, c3 ...) + 1

            还有一个要解决的问题 如何求当前结点子树中最大的两个路径长的和
            可以变遍历边求 原理就是在遍历的过程中用一个变量维护当前最大的链长长度 一开始最大链长长度为0
            然后另一个变量求当前已遍历的值中最大的两个值的和 用max更新即可
             */
            this.str = s;
            // 建树
            int len = parent.length;
            tree = new ArrayList<>(len);
            // 光分配长度不行，还得为每个结点创建
            for (int i = 0; i < len; i++) {
                tree.add(new ArrayList<>());
            }

            for(int i = 1;i < len;i ++){
                tree.get(parent[i]).add(i);
            }
            dfs(0);
            return ans + 1;

        }

        private int dfs(int root){
            // 叶子树
            List<Integer> childs = tree.get(root);
            if(childs.isEmpty()) return 0;

            // 循环遍历所有的子树 求最大链长 同时求最大两个链长的和
            int maxLen = 0; // 初始化最长链长为0
            int maxTwoLen = 0; // 初始化最长两条链的和为0
            for(int i = 0;i < childs.size();i ++){
                int curLen = dfs(childs.get(i)) + 1;
                if(str.charAt(root) != str.charAt(childs.get(i))){ // 只有相邻字符不同才更新答案 否则去掉
                    // 更新最大的两个链长和 不能在这里写+2 因为不一定两个链都会保留 比如只有一个链时就只应该+1
                    // maxTwoLen = Math.max(maxTwoLen, maxLen + curLen);
                    maxTwoLen = Math.max(maxTwoLen, maxLen + curLen);
                    maxLen = Math.max(curLen, maxLen);
                }
            }
            ans = Math.max(maxTwoLen, ans);

            // 放回当前结点最长链
            return maxLen;
        }


    }
}
