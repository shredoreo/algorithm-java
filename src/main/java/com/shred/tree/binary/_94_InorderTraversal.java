package com.shred.tree.binary;

import com.shred.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
94. 二叉树的中序遍历
给定一个二叉树的根节点 root ，返回它的 中序 遍历。



示例 1：


输入：root = [1,null,2,3]
输出：[1,3,2]
示例 2：

输入：root = []
输出：[]
示例 3：

输入：root = [1]
输出：[1]
示例 4：


输入：root = [1,2]
输出：[2,1]
示例 5：


输入：root = [1,null,2]
输出：[1,2]


提示：

树中节点数目在范围 [0, 100] 内
-100 <= Node.val <= 100


进阶: 递归算法很简单，你可以通过迭代算法完成吗？
*/

public class _94_InorderTraversal {
    class Solution {
        /*
        执行用时：
0 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗：
36.6 MB
, 在所有 Java 提交中击败了
63.12%
的用户
         */
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            traversal(list, root);
            return list;
        }

        /**
         * 中序遍历
         *
         * @param list
         * @param root
         */
        private void traversal(List<Integer> list, TreeNode root) {
            if (root == null) {
                return;
            }
            // 当前节点的 左节点
            traversal(list, root.left);
            // 当前节点的值
            list.add(root.val);
            // 当前节点的 右节点
            traversal(list, root.right);
        }
    }


    /**
     * 迭代法
     */
    class Solution2 {
        /*
执行用时：
0 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗：
36.6 MB
, 在所有 Java 提交中击败了
72.54%
的用户

 */
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            traversal(list, root);
            return list;
        }

        /**
         * 中序遍历
         * 中序遍历顺序: 左-中-右 入栈顺序： 左-右
         *
         * @param list
         * @param root
         */
        private void traversal(List<Integer> list, TreeNode root) {
            if (root == null) {
                return;
            }

            Stack<TreeNode> stack = new Stack<>();

            // 当前节点
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {

                if (cur != null) { // 指针来访问节点，访问到最底层
                    stack.push(cur); // 将访问的节点放进栈
                    // 左子节点
                    cur = cur.left;
                } else {
                    // 当前节点
                    TreeNode pop = stack.pop();
                    list.add(pop.val);
                    // 右子节点
                    cur = pop.right;
                }
            }
        }
    }
}
