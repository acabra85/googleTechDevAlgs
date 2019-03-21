package com.acabra.gtechdevalgs.litcode.linkedlist;

public class AddTwoNumbers {

    /**
     * Addition using listNodes on a linked list
     * @param v1 a linked list representing a number in reverse order
     * @param v2 a linked list representing a number in reverse order
     * @return a linked list representing the number v1+v2 in reverse order
     */
    public ListNode add(ListNode v1, ListNode v2) {
        if (v1 == null || v2 == null) return null;
        int carryOver = 0;
        ListNode head = new ListNode(0);
        ListNode current = head;
        int sum = 0;
        do {
            sum = v1.val + v2.val + carryOver;
            if (sum>=10) {
                current.next = new ListNode(sum - 10);
                carryOver = 1;
            } else {
                current.next = new ListNode(sum);
                carryOver = 0;
            }
            current = current.next;
            v1 = v1.next;
            v2 = v2.next;
        } while (v1!= null && v2 != null);
        v1 = v2 == null ? v1 : v2;
        while(v1!=null) {
            sum = v1.val + carryOver;
            if (sum>=10) {
                current.next = new ListNode(sum - 10);
                carryOver = 1;
            } else {
                current.next = new ListNode(sum);
                carryOver = 0;
            }
            current = current.next;
            v1 = v1.next;
        }
        if (carryOver > 0) {
            current.next = new ListNode(1);
        }
        return head.next;
    }
}
