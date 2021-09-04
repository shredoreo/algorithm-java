package com.shred.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
20. 有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。


示例 1：

输入：s = "()"
输出：true
示例 2：

输入：s = "()[]{}"
输出：true
示例 3：

输入：s = "(]"
输出：false
示例 4：

输入：s = "([)]"
输出：false
示例 5：

输入：s = "{[]}"
输出：true


提示：

1 <= s.length <= 104
s 仅由括号 '()[]{}' 组成
 */
public class _20BracketsIsValid {
    class Solution {
        /*
   执行用时：
1 ms
, 在所有 Java 提交中击败了
99.16%
的用户
内存消耗：
36.4 MB
, 在所有 Java 提交中击败了
74.27%
的用户

         */
        public boolean isValid(String s) {
            if (s.length() % 2 == 1) {
                return false;
            }
            char[] chars = s.toCharArray();
            Deque<Character> stack = new ArrayDeque<>();
            for (char a : chars) {
                //正括号，放入反括号
                if (a == '(') {
                    stack.push(')');
                } else if (a == '[') {
                    stack.push(']');
                } else if (a == '{') {
                    stack.push('}');
                } else {
                    //反括号，消除正括号
                    if (stack.isEmpty() || a != stack.pop()) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }
}
