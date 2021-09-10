package com.shred.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
77. 组合
给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。

你可以按 任何顺序 返回答案。



示例 1：

输入：n = 4, k = 2
输出：
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
示例 2：

输入：n = 1, k = 1
输出：[[1]]


提示：

1 <= n <= 20
1 <= k <= n

 */
public class _77_Combine {

    class Solution2 {
        public List<List<Integer>> combine(int n, int k) {
            findCombines(n, k, 1);

            return result;
        }

        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();

        private void findCombines(int n, int k, int startIdx) {
            if (list.size()  == k){
                result.add(new ArrayList<>(list));
                return;
            }

            // 剪纸。剪去 元素不足的情况
            for (int i =startIdx; i <= n - (k - list.size()) + 1; i++) {
                list.add(i);
                findCombines(n,k, i+1);
                list.pollLast();
            }

        }
        /*
        执行用时：
1 ms
, 在所有 Java 提交中击败了
99.99%
的用户
内存消耗：
39.8 MB
, 在所有 Java 提交中击败了
47.82%
的用户
         */
    }


    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            findCombines(n, k, 1);

            return result;
        }

        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();

        private void findCombines(int n, int k, int startIdx) {
            if (list.size()  == k){
                result.add(new ArrayList<>(list));
                return;
            }

            for (int i =startIdx; i <= n; i++) {
                list.add(i);
                findCombines(n,k, i+1);
                list.pollLast();
            }

        }
        /*
        执行用时：
17 ms
, 在所有 Java 提交中击败了
41.17%
的用户
内存消耗：
39.9 MB
, 在所有 Java 提交中击败了
28.67%
的用户
         */
    }


}
