package com.acabra.litcode.linkedlist;

import com.acabra.TestUtils;
import org.junit.Assert;
import org.junit.Test;

public class MergeKListTest {

    @Test
    public void test_1() {
        MergeKList.ListNode[] o = TestUtils.buildMergeKList("1,4,5[1,3,4[2,6");
        MergeKList.ListNode expected = TestUtils.buildMergeKList("1,1,2,3,4,4,5,6")[0];
        Assert.assertEquals(expected, new MergeKList().mergeKLists(o));
    }
}
