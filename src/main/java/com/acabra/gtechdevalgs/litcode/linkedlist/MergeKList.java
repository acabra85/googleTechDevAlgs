package com.acabra.gtechdevalgs.litcode.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Objects;

public class MergeKList {


    static final Comparator<ListNode> COMP = new Comparator<ListNode>() {
        @Override
        public int compare(ListNode a, ListNode b) {
            return a.val < b.val ? -1 : (a.val == b.val ? 0 : 1);
        }
    };

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(COMP);
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
