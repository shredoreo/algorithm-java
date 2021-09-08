package com.shred.tree.binary.level;

import com.shred.base.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
/*
111. 二叉树的最小深度
给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明：叶子节点是指没有子节点的节点。



示例 1：


输入：root = [3,9,20,null,null,15,7]
输出：2
示例 2：

输入：root = [2,null,3,null,4,null,5,null,6]
输出：5


提示：

树中节点数的范围在 [0, 105] 内
-1000 <= Node.val <= 1000

 */
public class _111_MinDepth {
    /**
     * 递归法，需要遍历所有节点。
     */
    class Solution1 {

        public int minDepth(TreeNode root) {
            /**
             * 因为下面所有的分支都是一个return 语句，所以不需要写else
             */
            if (root == null) return 0;

            //根结点存在，深度算 1 层
            //左右 都为空，返回深度
            if (root.left == null && root.right == null) return 1;

            // 只有左边或右边 为空，返回另一边的深度，再加上自己的1层
            if (root.left == null) return minDepth(root.right) + 1;
            if (root.right == null) return minDepth(root.left) + 1;

            // 都不为空，返回左、右子树的最小深度，再加上自己的1层
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
        /*
        执行用时：
5 ms
, 在所有 Java 提交中击败了
71.29%
的用户
内存消耗：
58.9 MB
, 在所有 Java 提交中击败了
25.90%
的用户
         */
    }

    /**
     * 使用迭代法，更优
     * 因为找到最短深度 就直接返回了
     */
    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) return 0;

            //队列
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int depth = 0;

            while (!queue.isEmpty()) {
                //每层的节点数量
                int size = queue.size();
                // 深度+1
                depth++;

                while (size-- > 0) {
                    TreeNode node = queue.poll();

                    //左右节点都为空，说明当前是一个叶子节点，直接返回深度
                    if (node.left == null && node.right == null) return depth;

                    if (node.left != null) queue.offer(node.left);

                    if (node.right != null) queue.offer(node.right);

                }
            }
            return depth;
        }
        /*
        执行用时：
1 ms
, 在所有 Java 提交中击败了
99.48%
的用户
内存消耗：
58.1 MB
, 在所有 Java 提交中击败了
84.42%
的用户
         */
    }


}
