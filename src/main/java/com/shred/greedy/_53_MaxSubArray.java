package com.shred.greedy;

public class _53_MaxSubArray {
    class Solution {
        public int maxSubArray(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }

            int maxSum = Integer.MIN_VALUE;
            int tmpSum = 0;
            for (int i = 0; i < nums.length; i++) {
                tmpSum += nums[i];
                maxSum = Math.max(tmpSum, maxSum);
                if (tmpSum < 0) {
                    tmpSum = 0;
                }
            }
            return maxSum;
        }
    }
    /*
    执行用时：
1 ms
, 在所有 Java 提交中击败了
90.91%
的用户
内存消耗：
48.5 MB
, 在所有 Java 提交中击败了
5.02%
的用户
     */
}
