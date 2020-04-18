package com.acabra.gtechdevalgs.codeforces.below1000;

import org.junit.Assert;
import org.junit.Test;

public class Hulk705ATest {

    @Test
    public void test() {
        Assert.assertEquals("I hate that I love that I hate it", Hulk705A.Solution.solution(3));
        Assert.assertEquals("I hate that I love it", Hulk705A.Solution.solution(2));
        Assert.assertEquals("I hate it", Hulk705A.Solution.solution(1));
    }
}
