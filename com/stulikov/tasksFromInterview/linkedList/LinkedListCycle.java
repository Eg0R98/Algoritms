package com.stulikov.tasksFromInterview.linkedList;

public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        head.next = listNode2;
        ListNode listNode3 = new ListNode(0);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(-4);
        listNode3.next = listNode4;

        listNode4.next = listNode2;

        System.out.println(hasCycle(head));
        System.out.println(head);


    }

    public static boolean hasCycle(ListNode head) {


    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}