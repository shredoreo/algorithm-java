package com.shred.tree.binary.balance;

import com.shred.base.TreeNode;

public class _110_IsBalanced {
    class Solution {
        public boolean isBalanced(TreeNode root) {
            return getDepth(root)!=-1;

        }

        private int getDepth(TreeNode root) {
            if (root == null)return 0;

            int leftDepth = getDepth(root.left);
            if (leftDepth == -1) return -1;

            int rightDepth = getDepth(root.right);
            if (rightDepth == -1) return -1;

            return Math.abs(leftDepth-rightDepth) >1
                    ? -1
                    : 1+ Math.max(leftDepth, rightDepth);
        }
        /*
        执行用时：
1 ms
, 在所有 Java 提交中击败了
80.01%
的用户
内存消耗：
38.7 MB
, 在所有 Java 提交中击败了
5.92%
的用户
         */
    }
}
