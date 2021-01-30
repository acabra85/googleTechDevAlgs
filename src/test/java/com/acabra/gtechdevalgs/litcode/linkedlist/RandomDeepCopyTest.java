package com.acabra.gtechdevalgs.litcode.linkedlist;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Ignore;
import org.junit.Test;

public class RandomDeepCopyTest {

    @Test @Ignore
    public void test_1() {
        RandomDeepCopy.RandomListNode o = null;
        MatcherAssert.assertThat(o, Is.is(new RandomDeepCopy().copyRandomList(o)));
    }
}
