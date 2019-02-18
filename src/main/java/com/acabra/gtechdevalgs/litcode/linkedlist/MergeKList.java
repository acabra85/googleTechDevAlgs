package com.acabra.gtechdevalgs.litcode.linkedlist;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class MergeKList {


    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        ListNode point = new ListNode(0);
        ListNode head = point;
        for (ListNode listNode : lists) {
            if (null != listNode) {
                pq.offer(listNode);
            }
        }
        while (!pq.isEmpty()) {
            ListNode remove = pq.remove();
            point.next = new ListNode(remove.val);
            point = point.next;
            remove = remove.next;
            if (null != remove) {
                pq.offer(remove);
            }
        }
        return head.next;
    }

    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val &&
                    Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }
    }
}