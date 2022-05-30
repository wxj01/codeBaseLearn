package com.wxj.codebaselearn.test;

public class test2 {

    class ListNode{
        int val;
        ListNode next;

        ListNode(){}

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = null;
        }
    }


    public  ListNode megerListNode(ListNode l1,ListNode l2){

        // 1  2  7
        // 1 3 6
        // 1 1 2 3 6 7

        // 1 2 7    8 9
        // 1 3 6
        if(l1 == null){
            return l2;
        }

        if(l2 == null){
            return l1;
        }

        // 返回一个新链表
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        // 循环两个链表
        while (l1 != null && l2 != null){

            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }

            cur = cur.next;
        }

        if(l2 == null){
            cur.next = l1;
        }

        if(l1 == null){
            cur.next = l2;
        }


        return dummy.next;
    }
}
