package com.shred.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
17. 电话号码的字母组合
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。





示例 1：

输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
示例 2：

输入：digits = ""
输出：[]
示例 3：

输入：digits = "2"
输出：["a","b","c"]


提示：

0 <= digits.length <= 4
digits[i] 是范围 ['2', '9'] 的一个数字。
 */
public class _17_LetterCombinations {

    static class Solution {
        private final static String[] LETTER_IDX = new String[]{
                "", // 0
                "", // 1
                "abc", // 2
                "def", // 3
                "ghi", // 4
                "jkl", // 5
                "mno", // 6
                "pqrs", // 7
                "tuv", // 8
                "wxyz", // 9
        };

        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.length() == 0) {
                return result;
            }
            backTracking(digits, 0);
            return result;
        }

        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        public void backTracking(String digits, int startIndex) {
            if (sb.length() == digits.length()) {
                result.add(sb.toString());
                return;
            }

            int indexNum = digits.charAt(startIndex) - '0';
            String letter = LETTER_IDX[indexNum];
            for (int i = 0; i < letter.length(); i++) {
                sb.append(letter.charAt(i));
                backTracking(digits, startIndex + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        /*
        执行用时：
0 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗：
37.1 MB
, 在所有 Java 提交中击败了
68.18%
的用户
         */

        public static void main(String[] args) {
            List<String> strings = new Solution().letterCombinations("23");
            System.out.println(strings.toString());
        }
    }
}
