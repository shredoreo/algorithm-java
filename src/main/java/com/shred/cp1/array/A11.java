package com.shred.cp1.array;

public class A11 {

    public static void main(String[] args) {

    }

    class Solution {
        public int maxArea(int[] height) {
            int max = 0;
            for (int i = 0, j = height.length-1; i < j; ) {
                int width = j -i ;
                int h1 = height[i], h2 = height[j];

                int hei = Math.min(h1, h2);

                max = Math.max(width* hei, max);

                if (hei == h1) {
                    ++i;
                } else {
                    --j;
                }
            }
            return max;
        }
    }
}
