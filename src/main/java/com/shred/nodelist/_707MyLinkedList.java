package com.shred.nodelist;

public class _707MyLinkedList {

    class MyLinkedList {
        class Node {
            int val;
            Node next;

            public Node(int val, Node next) {
                this.val = val;
                this.next = next;
            }

            public int getVal() {
                return val;
            }

            public void setVal(int val) {
                this.val = val;
            }

            public Node getNext() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }
        }

        private Node head;
        private Node tail;
        private int size;

        /** Initialize your data structure here. */
        public MyLinkedList() {
            head = new Node(-1, null);
            tail = head.next;
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
           /* if ( index >=size){
                return -1;
            }
            int i = 0;
            Node cur = head;
            while (i++<index){
                cur = cur.next;
            }
            return cur.val;*/

            return getNode(index) == null? -1:getNode(index).val;
        }

        /**
         * 获取节点
         * @param index
         * @return
         */
        public Node getNode(int index) {
            if ( index >=size || index<0){
                return null;
            }
            int i = 0;
            Node cur = head;
            while (i++<index){
                cur = cur.next;
            }
            return cur;
        }




        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {

        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {

        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if (index >= size || index<0){
                return;
            }
            size++;
            if (index==0){
                int i = get(index);
            }


        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {

        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
}
