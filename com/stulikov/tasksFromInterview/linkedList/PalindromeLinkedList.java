package com.stulikov.tasksFromInterview.linkedList;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode node4 = new ListNode(1);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head  = new ListNode(1, node2);

        System.out.println(isPalindrome(head));


    }

    public static boolean isPalindrome(ListNode head) {
       ListNode slow = head;
       ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        while (head != slow && prev != null){
            if(head.val != prev.val) return false;
            head = head.next;
            prev = prev.next;
        }

        return true;
    }

      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }

          @Override
          public String toString() {
              return "ListNode{" +
                      "val=" + val +
                      ", next=" + next +
                      '}';
          }
      }
}
