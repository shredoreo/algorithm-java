package com.shred.tree.binary.level;

import com.shred.base.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
107. 二叉树的层序遍历 II
给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其自底向上的层序遍历为：

[
  [15,7],
  [9,20],
  [3]
]
 */
public class _107_LevelOrderBottom {

    class Solution {
        private List<List<Integer>> data = new ArrayList<>();

        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            bfs(root, 0);
            Collections.reverse(data);
            return data;
        }

        private void bfs(TreeNode root, int deep) {
            if (root ==null){
                return;
            }
            deep++;
            if (data.size() < deep){
                data.add(new ArrayList<>());
            }

            data.get(deep-1).add(root.val);

            bfs(root.left, deep);
            bfs(root.right, deep);
        }

                /*
        执行用时：
0 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗：
38.6 MB
, 在所有 Java 提交中击败了
61.00%
的用户
         */
    }
}
