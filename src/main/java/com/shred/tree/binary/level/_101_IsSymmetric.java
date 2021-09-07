package com.shred.tree.binary.level;

import com.shred.base.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/*
101. 对称二叉树
给定一个二叉树，检查它是否是镜像对称的。



例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3


但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3


进阶：

你可以运用递归和迭代两种方法解决这个问题吗？
 */
public class _101_IsSymmetric {

    class Solution1 {
        public boolean isSymmetric(TreeNode root) {
            return compareSymmetricLR(root.left, root.right);

        }

        /**
         * 递归判断左右镜像节点是否对称
         * @param left 左侧节点
         * @param right 右侧节点
         * @return
         */
        private boolean compareSymmetricLR(TreeNode left, TreeNode right) {
            // 亦或运算，左 、右节点有一个空一个非空，那么false
            if (left == null ^ right == null) return false;
                // 排除了亦或的情况，那么只剩下同时为空、同时不为空
                // 此时只要 判断left==null，就可判断right 必然是null
            else if (left == null) return true;
                // 两个都不是空，判断节点值不想等，则false
            else if (left.val != right.val) return false;

            //剩下的情况就是两个非空，值相等的
            // 做子节点的对称判断
            // 左节点的左子树 与右节点的右子树；左节点的右子树与右节点的左子树；
            return compareSymmetricLR(left.left, right.right)
                    && compareSymmetricLR(left.right, right.left);
        }

        /*
        执行用时：
0 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗：
36.3 MB
, 在所有 Java 提交中击败了
86.74%
的用户
         */
    }


    class Solution2 {
        public boolean isSymmetric(TreeNode root) {
            if (root == null)return true;

            Deque<TreeNode> queue = new LinkedList<>();

            queue.offer(root.left);
            queue.offer(root.right);

            while (!queue.isEmpty()){
                TreeNode left = queue.poll();
                TreeNode right = queue.poll();

                /*同时为空，对称*/
                if (left == null && right == null){
                    continue;
                }
                /*单边为空、或者值不想等，非对称*/
                else if (left == null || right == null || left.val != right.val){
                    return false;
                }

                //对称入队
                //左边的左孩子、右边的右孩子
                queue.offer(left.left);
                queue.offer(right.right);
                //左边的右孩子、右边的左孩子
                queue.offer(left.right);
                queue.offer(right.left);

            }
            return true;

        }

        /*
        执行用时：
1 ms
, 在所有 Java 提交中击败了
23.81%
的用户
内存消耗：
37.3 MB
, 在所有 Java 提交中击败了
21.19%
的用户

         */
    }

}
