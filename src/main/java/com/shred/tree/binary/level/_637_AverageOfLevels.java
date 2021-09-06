package com.shred.tree.binary.level;

import com.shred.base.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
/*
637. 二叉树的层平均值
给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。



示例 1：

输入：
    3
   / \
  9  20
    /  \
   15   7
输出：[3, 14.5, 11]
解释：
第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。


提示：

节点值的范围在32位有符号整数范围内。
 */
public class _637_AverageOfLevels {

    class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            return bfsForAverage(root);
        }

        private ArrayList<Double> bfsForAverage(TreeNode root) {
            ArrayList<Double> result = new ArrayList<>();

            if (root == null){
                return result;
            }

            Deque<TreeNode> queue = new LinkedList<>();

            queue.offer(root);

            while (!queue.isEmpty()){
                int levelSize = queue.size();
                int i = levelSize;
                //累计值
                double sum = 0;
                while (i-- >0){
                    TreeNode node = queue.poll();
                    sum+=node.val;

                    if (node.left!=null) queue.offer(node.left);
                    if (node.right!=null)queue.offer(node.right);
                }
                //计算平均值
                result.add(sum/levelSize);
            }
            return result;
        }
    }
    /*
    执行用时：
2 ms
, 在所有 Java 提交中击败了
97.18%
的用户
内存消耗：
40.1 MB
, 在所有 Java 提交中击败了
81.16%
的用户
     */
}
