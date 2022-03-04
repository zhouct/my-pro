package com.zc.base.algorithms.his;

public class NodeConvert {

    public static void main(String[] args) {
        Node head = new Node(1, null, null, null);
        Node cur = head;
        for (int i = 2; i <= 6; i++) {
            Node newNode = new Node(i, null, null, null);
            cur.next = newNode;
            newNode.prev = cur;
            cur = cur.next;
        }

        Node secondNode = new Node(7, null, null, null);
        cur = secondNode;
        for (int i = 8; i <= 10; i++) {
            Node newNode = new Node(i, null, null, null);
            cur.next = newNode;
            newNode.prev = cur;
            cur = cur.next;
        }
        head.next.next.child = secondNode;

        Node thirdNode = new Node(11, null, null, null);
        cur = thirdNode;
        for (int i = 12; i <= 12; i++) {
            Node newNode = new Node(i, null, null, null);
            cur.next = newNode;
            newNode.prev = cur;
            cur = cur.next;
        }
        secondNode.next.child = thirdNode;

        NodeConvert convert = new NodeConvert();
//        System.out.println(head);
        System.out.println(convert.flatten(head));
    }

    /**
     * 1---2---3---4---5---6--NULL
     *          |
     *          7---8---9---10--NULL
     *              |
     *              11--12--NULL
     *
     * @param head
     * @return
     */
    public Node flatten(Node head) {
        convert(head);
        return head;
    }

    private Node convert(Node head) {
        Node cur = head;
        Node tail = null;
        while (cur != null){
            Node next = cur.next;
            Node child = cur.child;
            if(child != null){
                tail = convert(child);
                cur.next = child;
                child.prev = next;
                tail.next = next;
                next.prev = tail;
                cur = next;
            }else {
                tail = cur;
                cur = next;
            }
        }
        return tail;
    }

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val, Node prev, Node next, Node child) {
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }

        @Override
        public String toString() {
            StringBuilder sbd = new StringBuilder();
            sbd.append(val);
            Node tail = next;
            Node last = null;
            while (tail != null){
                sbd.append("-");
                sbd.append(tail.val);
                last = tail;
                tail = tail.next;
            }
            sbd.append(" | ");
            sbd.append(last.val);
            while (last.prev != null){
                sbd.append("-");
                sbd.append(last.prev.val);
                last = last.prev;
            }
            return sbd.toString();
        }
    };

}
