package com.shred.tree.binary;

import com.shred.base.TreeNode;

import java.util.*;

/*
145. 二叉树的后序遍历
给定一个二叉树，返回它的 后序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [3,2,1]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class _145_PostorderTraversal {
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
90.66%
的用户
         */
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();

            traversal(result, root);

            return result;
        }

        private void traversal(List<Integer> list, TreeNode root) {
            if (root == null) {
                return;
            }

            // 当前节点的 左节点
            traversal(list, root.left);

            // 当前节点的 右节点
            traversal(list, root.right);

            // 当前节点的值
            list.add(root.val);

        }
    }

    /**
     * 迭代法，速度反而慢了
     */
    class Solution2 {
        /*
        执行用时：
1 ms
, 在所有 Java 提交中击败了
31.03%
的用户
内存消耗：
36.5 MB
, 在所有 Java 提交中击败了
80.05%
的用户
         */
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();

            traversal(result, root);

            return result;
        }

        /**
         * 后序遍历
         *
         * @param list
         * @param root
         */
        private void traversal(List<Integer> list, TreeNode root) {
            if (root == null) {
                return;
            }

            Stack<TreeNode> stack = new Stack<>();

            stack.push(root);

            while (!stack.isEmpty()) {

                // 当前
                TreeNode node = stack.pop();
                list.add(node.val);

                // 左
                if (node.left != null) {
                    stack.push(node.left);
                }

                // 右
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
            Collections.reverse(list);
        }
    }
}
