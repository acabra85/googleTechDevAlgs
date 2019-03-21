package com.acabra.gtechdevalgs.litcode.linkedlist;

import java.util.PriorityQueue;

public class MergeKList {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>();
        ListNode head = new ListNode(0);
        for (ListNode listNode : lists) {
            if (null != listNode) {
                pq.offer(listNode);
            }
        }
        ListNode remove;
        ListNode point = head;
        while (!pq.isEmpty()) {
            remove = pq.remove();
            point.next = remove;
            point = point.next;
            if (null != remove.next) {
                pq.offer(remove.next);
            }
        }
        return head.next;
    }
}
