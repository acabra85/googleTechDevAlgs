package com.acabra.gtechdevalgs.litcode.linkedlist;

import com.acabra.gtechdevalgs.TestUtils;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

public class MergeKListTest {

    @Test
    public void test_1() {
        ListNode[] o = TestUtils.buildMergeKList("1,4,5[1,3,4[2,6");
        ListNode expected = TestUtils.buildMergeKList("1,1,2,3,4,4,5,6")[0];
        MatcherAssert.assertThat(expected, Is.is(new MergeKList().mergeKLists(o)));
    }

    @Test
    public void test_2() {
        ListNode[] o = TestUtils.buildMergeKList("1,2,4[1,3,4");
        ListNode expected = TestUtils.buildMergeKList("1,1,2,3,4,4")[0];
        MatcherAssert.assertThat(expected, Is.is(new MergeKList().mergeKLists(o)));
    }
}
