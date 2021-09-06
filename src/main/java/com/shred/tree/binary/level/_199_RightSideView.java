package com.shred.tree.binary.level;

import com.shred.base.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
/*
199. 二叉树的右视图
给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。



示例 1:



输入: [1,2,3,null,5,null,4]
输出: [1,3,4]
示例 2:

输入: [1,null,3]
输出: [1,3]
示例 3:

输入: []
输出: []


提示:

二叉树的节点个数的范围是 [0,100]
-100 <= Node.val <= 100
 */
public class _199_RightSideView {
    // todo dfs 获取 二叉树的右视图


    /**
     * 广度优先遍历
     */
    class Solution {
        private List<Integer> data = new ArrayList<Integer>();

        public List<Integer> rightSideView(TreeNode root) {
            bfsForRightView(root);
            return data;
        }

        // todo 优化 bfs二叉树的右视图
        private void bfsForRightView(TreeNode root) {
            if (root ==null){
                return;
            }
            Deque<TreeNode> queue = new LinkedList<>();

            queue.offer(root);

            while (!queue.isEmpty()) {
                int levelSize = queue.size();

                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();
                    if (i == levelSize - 1) {
                        data.add(node.val);
                    }

                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }

            }
        }
        /*
        执行用时：
1 ms
, 在所有 Java 提交中击败了
88.61%
的用户
内存消耗：
37 MB
, 在所有 Java 提交中击败了
70.69%
的用户
         */
    }
}
