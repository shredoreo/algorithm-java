package com.shred.tree.binary.level;

import com.shred.base.TreeNode;

public class _101_IsSymmetric {

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return compareSymmetricLR(root.left, root.right);

        }

        private boolean compareSymmetricLR(TreeNode left, TreeNode right) {
            // 亦或运算，左 、右节点有一个空一个非空，那么false
            if (left==null ^ right==null) return false;
            // 排除了亦或的情况，那么只剩下同时为空、同时不为空
            // 此时只要 判断left==null，就可判断right 必然是null
            else if (left == null ) return true;
            // 两个都不是空，判断节点值不想等，则false
            else if (left.val!=right.val) return false;


            return false;
        }
    }
}
