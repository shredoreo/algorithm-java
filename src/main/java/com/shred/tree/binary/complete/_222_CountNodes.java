package com.shred.tree.binary.complete;

import com.shred.base.TreeNode;
/*
222. 完全二叉树的节点个数
给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。

完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。



示例 1：


输入：root = [1,2,3,4,5,6]
输出：6
示例 2：

输入：root = []
输出：0
示例 3：

输入：root = [1]
输出：1


提示：

树中节点的数目范围是[0, 5 * 104]
0 <= Node.val <= 5 * 104
题目数据保证输入的树是 完全二叉树


进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？
 */
public class _222_CountNodes {
    /**
     * 递归，两行代码搞定
     */
    class Solution1 {
        public int countNodes(TreeNode root) {
            if (root == null) return 0;
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
        /*
        执行用时：
0 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗：
41 MB
, 在所有 Java 提交中击败了
26.24%
的用户
         */
    }


    /**
     * 利用完全二叉树特性
     */
    class Solution {
        public int countNodes(TreeNode root) {
            if (root == null) return 0;

            int leftDepth = getDepth(root.left);
            int rightDepth = getDepth(root.right);

            //深度相同，左子树必为满二叉树
            if (leftDepth == rightDepth) {
                // 当前节点 + 左边满二叉树节点数量 + 右边的节点树 =
                // 1 + (2^leftDepth-1) + 右边的节点树 =
                // 2^leftDepth + 右边的节点树
                return (1 << leftDepth) + countNodes(root.right);
            }
            // 深度不同，右子树必为满二叉树
            else {
                return (1 << rightDepth) + countNodes(root.left);
            }

        }

            /**
             * 计算完全二叉树深度
             *
             * @param node
             * @return
             */
            private int getDepth(TreeNode node) {
                int depth = 0;
                while (node != null) {
                    depth++;
                    node = node.left;
                }
                return depth;
            }
        /*
        执行用时：
0 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗：
40.7 MB
, 在所有 Java 提交中击败了
83.01%
的用户
         */
    }

    //todo 尝试使用迭代，虽然其效率低

}
