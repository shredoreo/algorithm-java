package com.shred.hasht;

import java.util.HashMap;

public class _454FourSumCount {
    class Solution {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            HashMap<Integer, Integer> sumCount = new HashMap<>();
            for (int i : nums1) {
                for (int j : nums2) {
                    sumCount.compute(i+j, (k,v)->v==null?1:++v);
                }
            }
            final int[] count = {0};

            for (int i : nums3) {
                for (int j : nums4) {
                    sumCount.computeIfPresent(-i-j, (k,v)->{--v;
                        count[0]++;
                        return v;
                    } );
                }
            }

            return count[0];

        }
    }
}
