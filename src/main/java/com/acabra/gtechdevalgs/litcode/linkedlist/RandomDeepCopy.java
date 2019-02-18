package com.acabra.gtechdevalgs.litcode.linkedlist;

public class RandomDeepCopy {

    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode copyHead = new RandomListNode(head.label);

        RandomListNode other = head;
        RandomListNode iCopyNode = copyHead;
        while (other.next != null) {
            iCopyNode.next = new RandomListNode(other.next.label);
        }
        return copyHead;
    }

    class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
    }
}
