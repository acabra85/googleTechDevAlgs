package com.acabra.gtechdevalgs;

import com.acabra.gtechdevalgs.litcode.linkedlist.ListNode;

/**
 * Describe your class
 */
public class ReverseLinkedList {

    public static ListNode reverseLinkedList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode curr = head;
        ListNode prev = null;
        ListNode next;
        while(curr.next != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        curr.next = prev;
        return curr;
    }
}
