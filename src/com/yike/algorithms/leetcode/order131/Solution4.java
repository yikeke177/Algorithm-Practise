package com.yike.algorithms.leetcode.order131;
import java.util.ArrayList;
import java.util.List;

class Solution4 {
    public List<List<String>> partition(String s) {
        /*
        分割字符串 本质上子集问题
        每次选择分割点，也是每次选择当前子串的结束点位置
        */

        // 初始化
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();

        // 递归
        backtrace(0, res, path, s);

        return res;
    }

    private void backtrace(int startIndex, List<List<String>> res, List<String> path, String s){
        // 递归出口
        if(startIndex == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        // 选择分割点（当前子串的结尾）
        for(int i = startIndex;i < s.length();i ++){
            // 当前子串
            String cur = s.substring(startIndex, i + 1);
            // 判断是否为回文串 如果不是回文 直接跳过这个分支
            if(! isHuiWen(cur)) continue;
            path.add(cur);
            // 递归到下一层
            backtrace(i + 1, res, path, s);
            // 恢复现场
            path.remove(path.size() - 1);
        }
    }
    private boolean isHuiWen(String s){
        // 双指针判断回文
        int l = 0, r = s.length() - 1;
        while(l < r){
            if(s.charAt(r) != s.charAt(l)) return false;
            l ++;
            r --;
        }
        return true;
    }
}