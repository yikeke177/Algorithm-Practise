package com.yike.algorithms.leetcode.order93;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jyk
 * @description 93. 复原 IP 地址
 * @date 2026/3/17 13:58
 */
public class Code93 {

    class Solution {

        public List<String> restoreIpAddresses(String s) {
            // 回溯 从剩下分割点里选
            // 当前字符串如果不合法 就剪枝

            List<String> ans = new ArrayList<>();

            List<String> path = new ArrayList<>();

            dfs(0, s, path, ans);
            return ans;

        }

        private void dfs(int begin, String s, List<String> path, List<String> ans) {

            // 只能分割三次 也就是得到四个字符串 如果超过四个字符串就剪枝
            if(path.size() > 4) return;

            // 退出条件
            if (begin == s.length() && path.size() == 4) {
                //构建答案
                StringBuilder str = new StringBuilder("");
                for (int i = 0; i < path.size() - 1; i++) {
                    str.append(path.get(i));
                    str.append(".");
                }
                str.append(path.get(path.size() - 1)); // 添加最后一个字符串
                // 把构造后的结果放入答案
                ans.add(str.toString());
                return;
            }



            for (int i = begin + 1; i <= s.length(); i++) {
                String sub = s.substring(begin, i);
                // 如果不合法直接跳过当前递归
                if (!isValid(sub)) continue;
                // 合法则加入path 递归到下一个
                path.add(sub);
                dfs(i, s, path, ans);
                // 恢复现场
                path.remove(path.size() - 1);

            }

        }

        private boolean isValid(String s) {
            // 长度>3直接跳过
            if(s.length() > 3) return false;
            // 前导0
            if (s.length() > 1 && s.charAt(0) == '0') return false;
            // 0~255之间
            int num = Integer.parseInt(s);
            if (num < 0 || num > 255) return false;
            return true;
        }

    }
}
