package com.shred.queue;

import java.util.*;

/*
347. 前 K 个高频元素
给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。



示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]


提示：

1 <= nums.length <= 105
k 的取值范围是 [1, 数组中不相同的元素的个数]
题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的


进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 */
public class _347_TopKFrequent {


    /**
     * 利用小堆
     */
    /*
    复杂度分析
时间复杂度：O(nlogk)O(nlogk)，nn 表示数组的长度。首先，遍历一遍数组统计元素的频率，这一系列操作的时间复杂度是 O(n)O(n)；接着，遍历用于存储元素频率的 map，如果元素的频率大于最小堆中顶部的元素，则将顶部的元素删除并将该元素加入堆中，这里维护堆的数目是 kk，所以这一系列操作的时间复杂度是 O(nlogk)O(nlogk) 的；因此，总的时间复杂度是 O(nlog⁡k)O(nlog⁡k)。
空间复杂度：O(n)O(n)，最坏情况下（每个元素都不同），map 需要存储 nn 个键值对，优先队列需要存储 kk 个元素，因此，空间复杂度是 O(n)O(n)。

作者：MisterBooo
链接：https://leetcode-cn.com/problems/top-k-frequent-elements/solution/leetcode-di-347-hao-wen-ti-qian-k-ge-gao-pin-yuan-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
            /*
    执行用时：
10 ms
, 在所有 Java 提交中击败了
96.94%
的用户
内存消耗：
40.6 MB
, 在所有 Java 提交中击败了
95.89%
的用户
     */
        public int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> idxMap = new HashMap<>();
            //计算
            for (int num : nums) {
                idxMap.compute(num, (k1, v) -> v == null ? 1 : ++v);
            }
            Set<Map.Entry<Integer, Integer>> entries = idxMap.entrySet();

            //优先队列，小的在前，小顶堆
            PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(
                    Comparator.comparingInt(Map.Entry::getValue));

            for (Map.Entry<Integer, Integer> entry : entries) {
                priorityQueue.offer(entry);
                //数量超过k，移出堆顶元素
                if (priorityQueue.size()> k){
                    priorityQueue.poll();
                }
            }
            int[] result = new int[k];
            for (int i = k-1; i >= 0; i--) {
                result[i] = priorityQueue.poll().getKey();
            }
            return result;

        }
    }


    //todo
    class Solution2 {
        public List<Integer> topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> idxMap = new HashMap<>();
            //计算
            for (int num : nums) {
                idxMap.compute(num, (k1, v) -> v == null ? 1 : ++v);
            }
            Set<Map.Entry<Integer, Integer>> entries = idxMap.entrySet();

            //桶，存放某一频率出现的字符
            List<Integer>[] arr = new ArrayList[nums.length + 1];

            for (Map.Entry<Integer, Integer> entry : entries) {
                Integer frequent = entry.getValue();
                if (arr[frequent] == null){
                    arr[frequent] = new ArrayList<>();
                }
                arr[frequent].add(entry.getKey());
            }

            List<Integer> res = new ArrayList();
            // 倒叙遍历桶，获取频率高的元素
            for (int i = arr.length-1 ; i >=0 && res.size()<k; i--) {
                if (arr[i] ==null){
                    continue;
                }
                res.addAll(arr[i]);
            }

            return res;
        }
    }

}
