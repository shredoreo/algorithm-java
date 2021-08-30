package com.shred.cp1.array;

/*
70. 爬楼梯
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

示例 1：

输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
示例 2：

输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶
 */
public class A70 {

    /**
     * 思路：走到第n个台阶，有两种方式，
     * 1、走到台阶n-1，再走一步
     * 2、走到n-2，再走两步
     * 那么只要知道(n-1) 和n-2有多少中走法，并相加即可得到n阶的走法
     */
    class Solution {
        public int climbStairs(int n) {
            if (n <= 1) {
                return 1;
            } else if (n == 2) {
                return 2;
            }
            int a = 1, b = 2;
            for (int i = 3; i <= n; i++) {
                int tmp = a+b;
                a = b;
                b = tmp;
            }
            return b;
        }
    }
}
