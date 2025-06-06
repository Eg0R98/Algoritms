package com.stulikov.tasksFromInterview.mergeTwoSortLists;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        
    ListNode list1 = new ListNode(1);
    list1.next = new ListNode(3);
    list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        System.out.println(mergeTwoLists(list1, list2));

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Присоединяем оставшиеся элементы
        current.next = (list1 != null) ? list1 : list2;

        return dummy.next;

    }
}
