package com.acabra.gtechdevalgs.codeforces.below1000;

import org.junit.Assert;
import org.junit.Test;

public class CardsBinary1220ATest {

    @Test
    public void should_return_0() {
        Assert.assertEquals("0", CardsBinary1220A.Solution.solution(4, "ezor"));
    }

    @Test
    public void should_return_110() {
        Assert.assertEquals("1 1 0", CardsBinary1220A.Solution.solution(10, "nznooeeoer"));
    }
}