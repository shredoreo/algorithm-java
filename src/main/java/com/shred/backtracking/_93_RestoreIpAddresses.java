package com.shred.backtracking;

import java.util.ArrayList;
import java.util.List;
/*
93. 复原 IP 地址
给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。

有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。



示例 1：

输入：s = "25525511135"
输出：["255.255.11.135","255.255.111.35"]
示例 2：

输入：s = "0000"
输出：["0.0.0.0"]
示例 3：

输入：s = "1111"
输出：["1.1.1.1"]
示例 4：

输入：s = "010010"
输出：["0.10.0.10","0.100.1.0"]
示例 5：

输入：s = "101023"
输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]


提示：

0 <= s.length <= 3000
s 仅由数字组成
 */
public class _93_RestoreIpAddresses {
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            if (s.length() > 12) return result;
            backTracking(s, 0, 0);
            return result;
        }

        List<String> result = new ArrayList<>();

        private void backTracking(String target, int startIndex, int pointNum) {
            if (pointNum == 3) {
                //最后一段有效
                if (isValid(target, startIndex, target.length() - 1)) {
                    result.add(target);
                }
                return;
            }


            for (int i = startIndex; i < target.length(); i++) {
                if (isValid(target, startIndex, i)) {
                    //插入点
                    target = target.substring(0, i + 1) + "." + target.substring(i + 1);
                    pointNum++;

                    backTracking(target, i + 2, pointNum);

                    //去掉点
                    pointNum--;
                    target = target.substring(0, i + 1) + target.substring(i + 2);

                } else {
                    break;
                }

            }
        }

        /**
         * 校验每个子串是否有效
         *
         * @param target
         * @param start
         * @param end
         * @return
         */
        public boolean isValid(String target, int start, int end) {
            //end - start >3 表明当前截取的字符串长度超过3，超过255
            if (start > end || end - start > 3) {
                return false;
            }

            if (target.charAt(start) == '0' && start != end) {
                return false;
            }

            int num = 0;
            for (int i = start; i <= end; i++) {
                char c = target.charAt(i);
                //非数字
                if (c > '9' || c < '0') {
                    return false;
                }

                //将当前区间的字符串转成数字
                //数值最大为255
                num = 10 * num + (c - '0');
                if (num > 255) {
                    return false;
                }
            }

            return true;
        }
        /*
        执行用时：
5 ms
, 在所有 Java 提交中击败了
35.65%
的用户
内存消耗：
38.3 MB
, 在所有 Java 提交中击败了
69.77%
的用户
         */

    }
}
