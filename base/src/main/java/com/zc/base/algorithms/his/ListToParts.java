package com.zc.base.algorithms.his;

import java.util.Arrays;

public class ListToParts {

    public static void main(String[] args) {
        ListToParts parts = new ListToParts();
        ListNode head = new ListNode(1);
        ListNode next = new ListNode(2);
        head.next = next;
        for (int i = 2; i < 10; i++) {
            next.next = new ListNode(i + 1);
            next = next.next;
        }
        System.out.println(Arrays.toString(parts.splitListToParts(head, 3)));
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] list = new ListNode[k];
        int count = 0;
        ListNode tail = head;
        while (tail != null){
            count ++;
            tail = tail.next;
        }
        int per = count / k;
        int mod = count % k;

        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            ListNode node = cur;
            int size = i < mod ? per + 1 : per;
            while (--size > 0){
                cur = cur.next;
            }
            if(cur != null){
                ListNode tmp = cur;
                cur = cur.next;
                tmp.next = null;
            }
            list[i] = node;
        }
        return list;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
           StringBuilder sbd = new StringBuilder("[");
           sbd.append(val);
            ListNode tail = next;
           while(tail != null){
               sbd.append(",").append(tail.val);
               tail = tail.next;
           }
           sbd.append("]");
           return sbd.toString();
        }
    }

}
