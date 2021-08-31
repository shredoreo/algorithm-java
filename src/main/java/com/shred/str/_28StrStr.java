package com.shred.str;
/*
https://leetcode-cn.com/problems/implement-strstr/
28. 实现 strStr()
实现 strStr() 函数。

给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。



说明：

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。



示例 1：

输入：haystack = "hello", needle = "ll"
输出：2
示例 2：

输入：haystack = "aaaaa", needle = "bba"
输出：-1
示例 3：

输入：haystack = "", needle = ""
输出：0


提示：

0 <= haystack.length, needle.length <= 5 * 104
haystack 和 needle 仅由小写英文字符组成

 */

public class _28StrStr {

    /*
    执行用时：
13 ms
, 在所有 Java 提交中击败了
49.43%
的用户
内存消耗：
37.9 MB
, 在所有 Java 提交中击败了
79.26%
的用户
     */
    //todo KMP algorithm
    class Solution1 {
        public int strStr(String haystack, String needle) {
            if (needle == null|| needle.length() == 0){
                return 0;
            }

            int[] nextArr = getNextArr(needle);

            int j =-1;

            for (int i = 0; i < haystack.length(); i++) {

                while (j >=0 && haystack.charAt(i)!= needle.charAt(j+1)){
                    j = nextArr[j];
                }

                if (haystack.charAt(i) == needle.charAt(j+1)){
                    j++;
                }

                if (j == needle.length() -1){
                    return i - needle.length()+1;
                }

            }

            return -1;
        }

        private int[] getNextArr(String needle) {
            int[] next = new int[needle.length()];
            int j = -1;
            next[0] = j;
            for (int i = 1; i < needle.length(); i++) {

                while (j>=0 && needle.charAt(i)!=needle.charAt(j+1)){
                    j = next[j];
                }

                if (needle.charAt(i) == needle.charAt(j+1)){
                    j++;
                }

                next[i] = j;
            }

            return next;
        }
    }

    static class Solution2 {
        public int strStr(String haystack, String needle) {
            int i=0, j=needle.length() -1;
            while (j< haystack.length()){
                String substring = haystack.substring(i, j+1);
                System.out.println(substring);
                if (substring.equals(needle)){
                    return i;
                }
                i++;j++;
            }
            return  -1;
        }
    }

    public static void main(String[] args) {
        int i = new Solution2().strStr("hello", "ll");
        System.out.println(i);
    }
}
