package com.shred.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
78. 子集
给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。



示例 1：

输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
示例 2：

输入：nums = [0]
输出：[[],[0]]


提示：

1 <= nums.length <= 10
-10 <= nums[i] <= 10
nums 中的所有元素 互不相同
 */
public class _78_Subsets {


    /*
       执行用时：
0 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗：
38.8 MB
, 在所有 Java 提交中击败了
15.07%
的用户
        */
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            if (nums.length == 0) {
                result.add(col);
                return result;
            }

            backTracking(nums, 0);
            return result;

        }

        //最终结果
        private List<List<Integer>> result = new ArrayList<>();
        //中间结果
        private LinkedList<Integer> col = new LinkedList<>();

        private void backTracking(int[] nums, int startIndex) {
            // 每个节点都要收集
            result.add(new ArrayList<>(col));

            if (startIndex >= nums.length) {
                return;
            }

            for (int i = startIndex; i < nums.length; i++) {
                col.add(nums[i]);//横向收集
                backTracking(nums, i + 1);//纵向收集
                //回溯，恢复结果
                col.removeLast();
            }
        }
    }
}
