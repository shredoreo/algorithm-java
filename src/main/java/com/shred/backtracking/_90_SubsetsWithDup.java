package com.shred.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
90. 子集 II
给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。



示例 1：

输入：nums = [1,2,2]
输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
示例 2：

输入：nums = [0]
输出：[[],[0]]


提示：

1 <= nums.length <= 10
-10 <= nums[i] <= 10
 */
public class _90_SubsetsWithDup {


    class Solution {

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            if (nums.length == 0){
                result.add(path);
                return result;
            }
            //以下算法比较是否使用相同元素 前提是排序
            Arrays.sort(nums);
            used = new boolean[nums.length];
            backTracing(nums, 0);

            return result;
        }

        List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
        LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果
        boolean[] used;

        public void backTracing(int[] nums, int startIndex) {
            // 每次开始递归时，收集节点
            result.add(new ArrayList<>(path));

            if (startIndex >= nums.length) {
                return;
            }

            for (int i = startIndex; i < nums.length; i++) {
                // nums[i] == nums[i - 1] 是true，说明本次循环使用的数值与上次是一样的
                // used[i-1] 是true，说明是在递归时，发现上一个元素相同
                // used[i-1] 是false，说明是在循环时，发现上一个元素相同
                //      这种情况下，由于在上一次循环中，数值相同的已经把 当前情况 枚举到了，所以直接continue
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }

                path.add(nums[i]);
                used[i] = true;
                backTracing(nums, i + 1);
                used[i] = false;
                path.removeLast();
            }
        }
    }
    /*
    执行用时：
1 ms
, 在所有 Java 提交中击败了
99.89%
的用户
内存消耗：
38.5 MB
, 在所有 Java 提交中击败了
86.67%
的用户

     */
}
