package com.shred.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _47_PermuteUnique {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] used;

        public List<List<Integer>> permuteUnique(int[] nums) {
            used = new boolean[nums.length];
            Arrays.sort(nums);
            backtracing(nums);
            return result;
        }

        private void backtracing(int[] nums) {
            if (path.size() == nums.length) {
                result.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                //元素被使用过、
                //或者同一层次被使用过
                if (used[i]
                        || i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                    continue;
                }

                used[i] = true;
                path.add(nums[i]);
                backtracing(nums);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
