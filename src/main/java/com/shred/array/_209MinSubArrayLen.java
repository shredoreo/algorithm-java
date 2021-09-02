package com.shred.array;

public class _209MinSubArrayLen {

    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int minLen = nums.length;
            int s = 0;
            int sum= nums[s];
            for (int f = 0; f < nums.length; ) {
                sum+=nums[f];
                if (sum== target){
                    minLen = Math.min(minLen, f-s);
                }
                if (s==f){
                    s++;f++;
                    sum-=nums[s];
                }
                if (sum < target){
                    f++;
                } else if (sum>target){
                    sum-=nums[s];
                    s++;

                }
            }
            return minLen;
        }
    }
}
