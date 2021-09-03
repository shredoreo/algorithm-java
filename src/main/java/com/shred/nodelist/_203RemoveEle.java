package com.shred.nodelist;

import com.shred.base.ListNode;

/*
203. 移除链表元素
给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。


示例 1：


输入：head = [1,2,6,3,4,5,6], val = 6
输出：[1,2,3,4,5]
示例 2：

输入：head = [], val = 1
输出：[]
示例 3：

输入：head = [7,7,7,7], val = 7
输出：[]
 */
public class _203RemoveEle {

    // https://leetcode-cn.com/problems/remove-linked-list-elements/

    /**
     * 单个指针
     */
    class Solution1 {
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) {
                return null;
            }
            // 虚拟头结点
            ListNode h = new ListNode(0, head);
            ListNode p = h;
            while (p != null) {
                // 直到p.next.val不等于 val
                while (p.next != null && p.next.val == val) {
                    p.next = p.next.next;
                }
                // 移动指针
                p = p.next;
            }
            return h.next;
        }
    }

    /**
     * 两个指针
     */
    class Solution2 {
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) {
                return null;
            }
            // 虚拟头结点
            ListNode h = new ListNode(0, head);
            ListNode prev = h;
            ListNode cur = prev.next;
            while (cur != null) {
                // 删除节点
                if (cur.val == val) {
                    prev.next = cur.next;
                } else {
                    prev = cur;
                }
                // 移动两个指针
                cur = cur.next;
            }
            return h.next;
        }
    }
}
