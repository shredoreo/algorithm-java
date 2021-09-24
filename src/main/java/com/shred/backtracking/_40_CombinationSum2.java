package com.shred.backtracking;

import java.util.*;

/*
40. 组合总和 II
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

注意：解集不能包含重复的组合。



示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
输出:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
输出:
[
[1,2,2],
[5]
]


提示:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30
 */
public class _40_CombinationSum2 {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        int sum = 0;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {

            Arrays.sort(candidates);

            backTracing(candidates, target, 0, new boolean[candidates.length]);
            return result;
        }

        public void backTracing(int[] candidates, int target, int index, boolean[] flag) {

            if (sum == target) {
                result.add(new ArrayList<>(deque));
                return;
            }
            if (sum > target) {
                return;
            }

            // 在for循环这里剪枝  candidates[i]+sum<=target
            for (int i = index; i < candidates.length && candidates[i] + sum <= target; i++) {
                //数组排序的情况下，判断当前数值 是否在同一层被使用过了
                // 同一层被用过，就直接跳过，
                // 因为同一层的上一条树枝，已经使用过了相同的组合
                if (i > 0 && candidates[i] == candidates[i - 1] && !flag[i - 1]) {
                    continue;
                }

                flag[i] = true;
                deque.push(candidates[i]);
                sum += candidates[i];

                backTracing(candidates, target, i + 1, flag);

                flag[i] = false;
                deque.poll();
                sum -= candidates[i];
            }

        }
        /*
        执行用时：
2 ms
, 在所有 Java 提交中击败了
99.57%
的用户
内存消耗：
38.8 MB
, 在所有 Java 提交中击败了
23.68%
的用户
         */
    }
}
