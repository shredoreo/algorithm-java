package com.shred.queue;

import java.util.ArrayDeque;
/*
239. 滑动窗口最大值
给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

返回滑动窗口中的最大值。



示例 1：

输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
输出：[3,3,5,5,6,7]
解释：
滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
示例 2：

输入：nums = [1], k = 1
输出：[1]
示例 3：

输入：nums = [1,-1], k = 1
输出：[1,-1]
示例 4：

输入：nums = [9,11], k = 2
输出：[11]
示例 5：

输入：nums = [4,-2], k = 2
输出：[4]


提示：

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
 */
public class _239MaxSlidingWindow {
    /*
执行用时：
26 ms
, 在所有 Java 提交中击败了
96.87%
的用户
内存消耗：
56.7 MB
, 在所有 Java 提交中击败了
24.81%
的用户
 */
    class Solution {
        /**
         * 单调队列
         */
        class MyMonotonicQueue{

            private ArrayDeque<Integer> deque =new ArrayDeque<Integer>();

            /**
             * 出队
             * @param val
             */
            public void pop(int val){
                //非空，且弹出的值等于给定的值
                if (!deque.isEmpty() && val==deque.peek()){
                    deque.poll();
                }
            }

            /**
             * 入队
             * @param val
             */
            public void add(int val){
                //队列末尾的值 比给定的值小，就弹出
                while (!deque.isEmpty() && deque.peekLast()<val){
                    deque.pollLast();
                }
                deque.add(val);
            }

            public int peek(){
                return deque.peek();
            }

        }

        public int[] maxSlidingWindow(int[] nums, int k) {
            MyMonotonicQueue queue = new MyMonotonicQueue();

            for (int i = 0; i < k; i++) {
                queue.add(nums[i]);
            }

            int[] maxArr = new int[nums.length-k+1];
            maxArr[0] = queue.peek();
            for (int i = k ; i < nums.length; i++) {
                //移出窗口外的元素
                queue.pop(nums[i-k]);
                queue.add(nums[i]);
                maxArr[i-k+1] = queue.peek();
            }
            return maxArr;

        }
    }
}
