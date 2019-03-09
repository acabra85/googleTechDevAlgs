package com.acabra.gtechdevalgs.litcode.linkedlist;

import com.acabra.gtechdevalgs.litcode.linkedlist.MergeKList.ListNode;

public class MergeTwoLists {

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode point = head;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while(null != p1 || null != p2) {
            if (p1 != null && (p2 == null || p1.val < p2.val)) {
                point.next = p1;
                point = point.next;
                p1 = p1.next;
            } else {
                point.next = p2;
                point = point.next;
                p2 = p2.next;
            }
        }
        return head.next;
    }
}
