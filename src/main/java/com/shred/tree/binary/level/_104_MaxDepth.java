package com.shred.tree.binary.level;

import com.shred.base.TreeNode;

import java.util.ArrayDeque;

/*
104. 二叉树的最大深度
给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。


 */
public class _104_MaxDepth {

    /**
     * 后序遍历
     */
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
        /*
        执行用时：
0 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗：
38.2 MB
, 在所有 Java 提交中击败了
83.22%
的用户

         */
    }


    class Solution2 {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            ArrayDeque<TreeNode> queue = new ArrayDeque<>();

            queue.offer(root);
            int depth = 0;
            while (!queue.isEmpty()){
                int levelSize = queue.size();
                depth++;
                while (levelSize-->0){
                    root = queue.poll();
                    if (root.left!=null)queue.offer(root.left);
                    if (root.right!=null)queue.offer(root.right);
                }

            }

            return depth;

        }
        /*
        执行用时：
1 ms
, 在所有 Java 提交中击败了
19.04%
的用户
内存消耗：
38 MB
, 在所有 Java 提交中击败了
93.18%
的用户
         */
    }

    //todo 前序遍历获取最大深度
}
