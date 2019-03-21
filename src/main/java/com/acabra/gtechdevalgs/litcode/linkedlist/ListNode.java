package com.acabra.gtechdevalgs.litcode.linkedlist;

import java.util.Objects;

public class ListNode implements Comparable<ListNode> {
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

    @Override
    public int compareTo(ListNode other) {
        return this.val < other.val ? -1 : (this.val == other.val ? 0 : 1);
    }
}
