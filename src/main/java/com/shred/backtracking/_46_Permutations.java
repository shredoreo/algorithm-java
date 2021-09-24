package com.shred.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _46_Permutations {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            backTracing(nums);

        }

        private List<List<Integer>> result = new ArrayList<>();
        private LinkedList<Integer> path = new LinkedList<>();
        private void backTracing(int[] nums) {
            if (path.size() == nums.length){
                result.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < ; i++) {
                
            }
            
        }
    }
}
