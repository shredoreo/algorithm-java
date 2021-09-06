package com.shred.tree.binary.level;

import com.shred.base.TreeNode;
/*
226. 翻转二叉树
翻转一棵二叉树。

示例：

输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1
备注:
这个问题是受到 Max Howell 的 原问题 启发的 ：

谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
通过次数293,273提交次数372,303
 */
public class _226_InvertTree {

    class Solution {
        /**
         * 利用递归实现 dfs
         * 翻转一个树
         * @param root
         * @return
         */
        public TreeNode invertTree(TreeNode root) {
            if (root == null){
                return root;
            }

            // 先交换自己的
            swapLR(root);
            // 再依次交换左、右
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }

        /**
         * 交换左右子树
         * @param node
         */
        private void swapLR(TreeNode node) {
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

        }
        /*
        执行用时：
0 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗：
35.8 MB
, 在所有 Java 提交中击败了
66.89%
的用户
         */
    }
}
