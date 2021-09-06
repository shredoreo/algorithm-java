package com.shred.tree.binary;

import com.shred.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
144. 二叉树的前序遍历
给你二叉树的根节点 root ，返回它节点值的 前序 遍历。



示例 1：


输入：root = [1,null,2,3]
输出：[1,2,3]
 */
public class _144_PreorderTraversal {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        /*
        执行用时：
0 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗：
36.4 MB
, 在所有 Java 提交中击败了
95.97%
的用户
         */
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            traversal(list, root);
            return list;
        }

        /**
         * 前序遍历
         *
         * @param list
         * @param root
         */
        private void traversal(List<Integer> list, TreeNode root) {
            if (root == null) {
                return;
            }
            // 当前节点的值
            list.add(root.val);
            // 当前节点的 左节点
            traversal(list, root.left);
            // 当前节点的 右节点
            traversal(list, root.right);
        }
    }


    /**
     * 迭代
     */
    class Solution2 {
        /*
        执行用时：
0 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗：
36.3 MB
, 在所有 Java 提交中击败了
96.94%
的用户
         */
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            traversal(list, root);
            return list;
        }

        /**
         * 前序遍历
         *
         * @param list
         * @param root
         */
        private void traversal(List<Integer> list, TreeNode root) {
            if (root== null){
                return;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                // 当前节点
                TreeNode node = stack.pop();
                list.add(node.val);

                // 先把当前节点的右子节点 压栈
                if (node.right!=null){
                    stack.push(node.right);
                }

                // 再先把当前节点的 左子节点 压栈
                // 这样的话，出栈的时候就是左先出，右后出了
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
    }
}
