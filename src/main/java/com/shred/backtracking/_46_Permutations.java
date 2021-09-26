package com.shred.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//todo 84.35%  32.15%
/*
46. 全排列
给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。



示例 1：

输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
示例 2：

输入：nums = [0,1]
输出：[[0,1],[1,0]]
示例 3：

输入：nums = [1]
输出：[[1]]


提示：

1 <= nums.length <= 6
-10 <= nums[i] <= 10
nums 中的所有整数 互不相同
 */
public class _46_Permutations {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            used = new boolean[nums.length];
            backTracing(nums);
            return result;
        }

        private List<List<Integer>> result = new ArrayList<>();
        private LinkedList<Integer> path = new LinkedList<>();
        private boolean[] used;

        private void backTracing(int[] nums) {
            if (path.size() == nums.length) {
                result.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                path.add(nums[i]);
                backTracing(nums);
                path.removeLast();
                used[i] = false;
            }
        }
        /*
        执行用时：
1 ms
, 在所有 Java 提交中击败了
84.35%
的用户
内存消耗：
38.7 MB
, 在所有 Java 提交中击败了
32.15%
的用户
         */
    }
}
