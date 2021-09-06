package com.shred.tree.binary.level;

import com.shred.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
102. 二叉树的层序遍历
给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。



示例：
二叉树：[3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层序遍历结果：

[
  [3],
  [9,20],
  [15,7]
]
*/
public class _102_LevelOrder {

    class Solution {
        /*
        执行用时：
1 ms
, 在所有 Java 提交中击败了
92.30%
的用户
内存消耗：
38.7 MB
, 在所有 Java 提交中击败了
29.43%
的用户
         */
        public List<List<Integer>> levelOrder(TreeNode root) {
            bfs(root);
            return data;
        }

        private List<List<Integer>> data = new ArrayList<>();


        /**
         * Breadth First Search ( BFS)
         * 利用队列实现广度优先遍历
         *
         * @param root
         */
        private void bfs(TreeNode root) {
            if (root == null) {
                return;
            }

            Queue<TreeNode> queue = new LinkedList<>();

            queue.offer(root);
            while (!queue.isEmpty()) {
                int sizeOfLevel = queue.size();

                ArrayList<Integer> levelData = new ArrayList<>();
                data.add(levelData);
                while (sizeOfLevel-- > 0) {
                    TreeNode node = queue.poll();
                    levelData.add(node.val);

                    if (node.left != null) {
                        queue.offer(node.left);
                    }

                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }

        }
    }


    class Solution2 {
        /*
        执行用时：
0 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗：
38.5 MB
, 在所有 Java 提交中击败了
70.36%
的用户
         */
        private List<List<Integer>> data = new ArrayList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {

            bfs(root, 0);

            return data;
        }

        private void bfs(TreeNode root, int level) {
            if (root == null) {
                return;
            }

            level++;
            // 利用数组大小，判断是否第一次进入当前层级
            if (data.size() < level) {
                // 第一次进入，初始化当前层级的列表
                data.add(new ArrayList<>());
            }
            data.get(level - 1).add(root.val);

            bfs(root.left, level);
            bfs(root.right, level);
        }
    }
}
