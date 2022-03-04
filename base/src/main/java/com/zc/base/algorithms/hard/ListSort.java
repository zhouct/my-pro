package com.zc.base.algorithms.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ListSort {

    public static ListNode mergeKLists(ListNode[] lists) {

        int len = lists.length;
        List<ListNode> total = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            ListNode cur = lists[i];
            while(cur != null){
                total.add(cur);
                cur = cur.next;
            }
        }

        ListNode node = new ListNode();
        if(total.size() > 0){
            ListNode[] newNodes = new ListNode[total.size()];
            total.toArray(newNodes);
            Arrays.sort(newNodes, (o1, o2) -> {
                if(o1.val < o2.val){
                    return -1;
                }else if(o1.val > o2.val){
                    return 1;
                }else {
                    return 0;
                }
            });

            node = newNodes[0];
            if(newNodes.length == 1){
                node.next = null;
                return node;
            }
            ListNode n = newNodes[1];
            node.next = n;
            ListNode next = node.next;
            int size = 2;
            while(size < newNodes.length){
                next.next = newNodes[size ++];
                next = next.next;
            }
        }

        return node;
    }

    /**
     * [[1,4,5],[1,3,4],[2,6]]
     * @param args
     */
    public static void main(String[] args) {
        ListNode n1 = getNodeByArr(new int[]{1,4,5});
        ListNode n2 = getNodeByArr(new int[]{1,3,4});
        ListNode n3 = getNodeByArr(new int[]{2,6});

        ListNode[] listNodes = new ListNode[]{n1,n2,n3};

        ListNode node = mergeKLists(listNodes);
        System.out.println(node);

    }

    static ListNode getNodeByArr(int[] vals){
        if(vals.length == 0){
            return null;
        }
        ListNode h = new ListNode(vals[0]);
        if(vals.length == 1){
            return h;
        }
        int i = 2;
        ListNode n = new ListNode(vals[1]);
        h.next = n;
        ListNode t = h.next;
        while(vals.length > i){
            t.next = new ListNode(vals[i ++]);
            t = t.next;
        }
        return h;
    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            String a = String.valueOf(val);
            while(next != null){
                a += ", " + next.val;
                next = next.next;
            }
            return "[ " + a + " ] ";
        }
    }

}


