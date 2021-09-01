package com.shred.hasht;

import java.util.Arrays;
import java.util.HashMap;

public class _242IsAnagram {

    /**
     * 利用java的hashMap
     */
    class Solution1 {
        public boolean isAnagram(String s, String t) {
            if (s.length()!=t.length()){
                return false;
            }
            HashMap<Character, Integer> count = new HashMap<>();
            for (char c : s.toCharArray()) {
                count.compute(c, (k, v) -> v == null ? 1 : ++v);
            }

            for (char c : t.toCharArray()) {
                Integer compute = count.compute(c, (k, v) -> v == null ? -1 : --v);
                if (compute<0){
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * 利用数组做哈希表，
     * 收集字符个数，
     * 比较个数表是否相等
     */
    class Solution2 {
        public boolean isAnagram(String s, String t) {
            char[] chars1 = new char[26];
            char[] chars2 = new char[26];

            for (char c : s.toCharArray()) {
                chars1[c-'a']++;
            }

            for (char c : t.toCharArray()) {
                chars2[c-'a']++;
            }

            return Arrays.equals(chars1, chars2);
        }
    }
}
