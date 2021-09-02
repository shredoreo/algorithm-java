package com.shred.hasht;

import java.util.HashMap;
import java.util.HashSet;

public class _202IsHappy {
    static class Solution {
        public boolean isHappy(int n) {
            HashSet<Integer> happyEver = new HashSet<>();

            int next = n;

            // 是否循环
            while (!happyEver.contains(next)) {
                //缓存next
                happyEver.add(next);

                int sum = 0;
                int x = 0;
                // 获取每个位上的平方和
                while (next > 0) {
                    x = next % 10;
                    sum += x * x;
                    next = next/10;
                }

                //移动next
                next =sum;

                //终止条件：next=1，n是快乐数
                if (next ==1){
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        boolean happy = new Solution().isHappy(19);
        System.out.println(happy);

        HashMap<String, String> ma = new HashMap<>();
        String aaa = "aaa";
         ma.put(aaa,"nnn");
        String compute = ma.compute(aaa, (k, v) -> v == null ? "000" : "cccc");
        System.out.println(compute);
        String s = ma.get(aaa);
        System.out.println(s);
    }
}
