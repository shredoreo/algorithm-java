package com.shred.greedy;

public class _122_BestTimeToSellStock2 {
    class Solution {
        public int maxProfit(int[] prices) {
            int result = 0;
            for (int i = 1; i < prices.length; i++) {
                result+=Math.max(prices[i]-prices[i-1], 0);
            }
            return result;
        }
        /*
        执行用时：
1 ms
, 在所有 Java 提交中击败了
99.66%
的用户
内存消耗：
38.1 MB
, 在所有 Java 提交中击败了
62.88%
的用户
         */
    }
}
