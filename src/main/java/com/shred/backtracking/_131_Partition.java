package com.shred.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _131_Partition {

    class Solution {
        public List<List<String>> partition(String s) {
            backTracking(s, 0);

            return result;
        }

        List<List<String >> result = new ArrayList<>();
        Deque<String> path = new LinkedList<>();

        private void backTracking(String target, int startIndex) {
            if (startIndex >= target.length()){
                result.add(new ArrayList<>(path));
                return;
            }

            for (int i = startIndex; i < target.length(); i++) {
                // 横向遍历，看看起始位置到i是否回文串
                if (isPalindrome(target, startIndex, i)){
                    String substring = target.substring(startIndex, i + 1);
                    path.addLast(substring);
                } else {
                    continue;
                }
                //纵向遍历，递归，起始位置后移
                backTracking(target, i+1);
                path.removeLast();
            }


        }


        public boolean isPalindrome(String str, int start, int end) {
            for (int i = start, j = end; i < j; i++, j--) {
                if (str.charAt(i)!= str.charAt(j)) {
                    return false;
                }
            }
            return true;
        }
        /*
        执行用时：
13 ms
, 在所有 Java 提交中击败了
14.84%
的用户
内存消耗：
51.5 MB
, 在所有 Java 提交中击败了
62.83%
的用户
         */
    }
}
