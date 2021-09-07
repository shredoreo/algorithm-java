package com.shred.tree.binary.level;


import com.shred.tree.model.Node;

import java.util.ArrayDeque;
import java.util.List;
/*
559. N 叉树的最大深度
给定一个 N 叉树，找到其最大深度。

最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。

N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。



示例 1：



输入：root = [1,null,3,2,4,null,5,6]
输出：3
示例 2：



输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
输出：5


提示：

树的深度不会超过 1000 。
树的节点数目位于 [0, 104] 之间。

 */
public class _559_MaxDepth {

    class Solution {
        public int maxDepth(Node root) {
            if (root == null)return 0;

            List<Node> children = root.children;
            int depth=1;
            for (Node child : children) {
                depth =Math.max(1+maxDepth(child), depth);
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
38.4 MB
, 在所有 Java 提交中击败了
81.19%
的用户

         */
    }

    class solution2{
        public int maxDepth(Node root) {
            ArrayDeque<Node> queue = new ArrayDeque<>();

            if (root!=null) queue.offer(root);

            int depth = 0;
            while (!queue.isEmpty()){
                depth++;
                int size = queue.size();

                while (size-- >0){
                    Node node = queue.poll();
                    for (Node child : node.children) {
                        queue.offer(child);
                    }
                }
            }
            return depth;
        }
        /*
        执行用时：
2 ms
, 在所有 Java 提交中击败了
27.60%
的用户
内存消耗：
38.2 MB
, 在所有 Java 提交中击败了
94.87%
的用户
         */
    }
}
