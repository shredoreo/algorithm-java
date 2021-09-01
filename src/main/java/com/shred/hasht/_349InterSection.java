package com.shred.hasht;

import java.util.Arrays;
import java.util.HashSet;

/*
349. 两个数组的交集
给定两个数组，编写一个函数来计算它们的交集。



示例 1：

输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]
示例 2：

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]


说明：

输出结果中的每个元素一定是唯一的。
我们可以不考虑输出结果的顺序。

 */
public class _349InterSection {

    class Solution1 {
        public int[] intersection(int[] nums1, int[] nums2) {
            HashSet<Integer> integers = new HashSet<>();
            for (int i : nums1) {
                integers.add(i);
            }

            HashSet<Integer> integers1 = new HashSet<>();
            for (int i : nums2) {
                if (integers.contains(i)){
                    integers1.add(i);
                }
            }

            //转成基本数组
            int[] ints = new int[integers1.size()];
            int index=0;
            for (Integer i : integers1) {
                ints[index++] = i;
            }
            return ints;
        }
    }
}
