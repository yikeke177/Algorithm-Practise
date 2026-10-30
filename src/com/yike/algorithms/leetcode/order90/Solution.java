package com.yike.algorithms.leetcode.order90;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        /*
        子集去重 从二叉树节点来看就是去掉同一层的重复节点
        剪枝掉重复的分支
        */
        List<List<Integer>> res = new ArrayList<>();
	
        List<Integer> path = new ArrayList<>();
        // 排序
        Arrays.sort(nums);
        
        backtrace(0, path, res, nums);
        
        return res;
        
    }
    private void backtrace(int idx, List<Integer> path, List<List<Integer>> res, int[] nums){
	
		// 每次递归都要保存结果 第一次的空集也要保存
		
		res.add(new ArrayList<>(path));
		
		
		// 选择
		
		for(int i = idx; i < nums.length;i ++){
			// 同层去重
            /*因为在当前递归调用中，startIndex 表示这一层的搜索起点，而 i 表示这一层正在尝试的候选位置。

    当 i > startIndex 且当前元素与前一个元素相同，说明本层已经枚举过相同数值的候选，所以可以跳过。 */
            if(i > idx && nums[i] == nums[i - 1]) continue;
			// 选择当前数
			path.add(nums[i]);
			backtrace(i + 1, path, res, nums);

			// 回溯 恢复现场
			path.remove(path.size() - 1);
		
		}
	
	}

}
