package com.shred.nodelist;

import com.shred.base.ListNode;

public class _203RemoveEle {

    //todo
    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            if (head == null){
                return head;
            }

            ListNode h = new ListNode(0, head);
            ListNode p = h;
            while (p.next != null){
                if (p.val == val){
                    p.next = p.next.next;
                }
                p = p.next;
            }
            return h.next;

        }
    }
}
