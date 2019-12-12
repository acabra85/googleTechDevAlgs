package com.acabra.gtechdevalgs;

import com.acabra.gtechdevalgs.litcode.linkedlist.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class ReverseLinkedListTest {

    @Test
    public void should_reverse_list_and_head_be_6() {
        int[] values = {4, 2, 6, 3, 9, 7, 6};
        ListNode head = TestUtils.buildLinkedListOfValues(values);
        ListNode rHead = ReverseLinkedList.reverseLinkedList(head);
        for (int i = values.length - 1; i >= 0; i--) {
            Assert.assertNotNull(rHead);
            Assert.assertEquals(rHead.val, values[i]);
            rHead = rHead.next;
        }
    }

    @Test
    public void should_reverse_list_and_head_be_1() {
        int[] values = {1};
        ListNode head = TestUtils.buildLinkedListOfValues(values);
        ListNode rHead = ReverseLinkedList.reverseLinkedList(head);
        for (int i = values.length - 1; i >= 0; i--) {
            Assert.assertNotNull(rHead);
            Assert.assertEquals(rHead.val, values[i]);
            rHead = rHead.next;
        }
    }

    @Test
    public void two_reversal_should_equal_original() {
        int[] values = {1, 23, 8, 5, 2, 4};
        ListNode head = TestUtils.buildLinkedListOfValues(values);
        ListNode rHead = ReverseLinkedList.reverseLinkedList(ReverseLinkedList.reverseLinkedList(head));
        for (int i = 0; i < values.length; i++) {
            Assert.assertNotNull(rHead);
            Assert.assertEquals(rHead.val, values[i]);
            rHead = rHead.next;
        }
    }
}
