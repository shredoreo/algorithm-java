package com.shred.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
216. 组合总和 III
找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

说明：

所有数字都是正整数。
解集不能包含重复的组合。
示例 1:

输入: k = 3, n = 7
输出: [[1,2,4]]
示例 2:

输入: k = 3, n = 9
输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class _216_CombinationSum3 {


    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        public List<List<Integer>> combinationSum3(int k, int n) {
            backTracking(n, k, 0, 1);
            return result;
        }

        private void backTracking(int targetSum, int k, int sum, int startIndex) {
            if (sum > targetSum) {
                return;
            }

            if (path.size() == k) {
                //path总和为目标和
                if (sum == targetSum) {
                    result.add(new ArrayList<>(path));
                }
                return;
            }

            for (int i = startIndex; i <= 9 - (k - path.size() )+ 1; i++) {
                sum += i;
                path.addLast(i);
                backTracking(targetSum, k, sum, i + 1);
                //回溯
                path.removeLast();
                sum -= i;
            }
        }
        /*
        执行用时：
0 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗：
36.1 MB
, 在所有 Java 提交中击败了
25.31%
的用户

         */
    }
}
