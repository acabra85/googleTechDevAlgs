package com.acabra.gtechdevalgs.litcode.linkedlist;

import com.acabra.gtechdevalgs.TestUtils;
import org.junit.Assert;
import org.junit.Test;

public class MergeTwoListsTest {

    @Test
    public void test_1() {
        String s = "[1,2,4[1,3,4";
        ListNode[] list = TestUtils.buildMergeKList(s);
        ListNode expected =  TestUtils.buildMergeKList("1,1,2,3,4,4")[0];
        Assert.assertEquals(expected, new MergeTwoLists().merge(list[0], list[1]));
    }
}
