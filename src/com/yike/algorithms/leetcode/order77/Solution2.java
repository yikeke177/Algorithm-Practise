package com.yike.algorithms.leetcode.order77;

import java.util.ArrayList;
import java.util.List;



/**
 * 
 * Solution2
 */
public class Solution2 {
    public List<List<Integer>> combine(int n, int k) {
        /*
        n个数里面选择k个数的所有组合结果
        组合问题 不考虑顺序 所以可以看做固定顺序 前面选过的就不再选了
        选过的数就不能再选了
        path当前选择的
        result每个选择的结果
        */

        // 初始化
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        backtrace(1, path, res, n, k);

        return res;
    }
    /**
     * 
     * @param idx 从哪个数开始
     * @param path
     * @param res
     */
    private void backtrace(int idx, List<Integer> path, List<List<Integer>> res, int n, int k){
        // 递归退出条件
        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }

        // 
        for(int i = idx;i <= n;i ++){
            // 递归
            path.add(i);
            backtrace(i + 1, path, res, n, k);
            // 恢复现场
            path.remove(path.size() - 1);
        }
        
    }
}
