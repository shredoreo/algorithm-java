package com.shred.str;

/*
 剑指 Offer 58 - II. 左旋转字符串
字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

示例 1：

输入: s = "abcdefg", k = 2
输出: "cdefgab"
示例 2：

输入: s = "lrloseumgh", k = 6
输出: "umghlrlose"

限制：

1 <= k < s.length <= 10000
 */
public class JZOffer58ReverseLeftWords {
    //todo 时间




    //空间少
    /*
    执行用时：
10 ms
, 在所有 Java 提交中击败了
8.41%
的用户
内存消耗：
37.6 MB
, 在所有 Java 提交中击败了
99.82%
的用户
     */
    static class Solution1 {
        public String reverseLeftWords(String s, int n) {
            int len = s.length();
            StringBuilder sb = new StringBuilder(s);
            reverseStr(sb,0, n-1);
            reverseStr(sb,n, len-1);
            return sb.reverse().toString();
        }

        private void reverseStr(StringBuilder sb, int start, int end) {

            while (start<end){
                char tmp = sb.charAt(start);
                sb.setCharAt(start, sb.charAt(end));
                sb.setCharAt(end, tmp);
                start++;
                end--;
            }

        }
    }

    public static void main(String[] args) {
        String abcdefg = new Solution1().reverseLeftWords("abcdefg", 2);
        System.out.println(abcdefg);
    }

}
