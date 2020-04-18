package com.acabra.gtechdevalgs.codeforces.below1000;

import org.junit.Assert;
import org.junit.Test;

public class WrongSubtract977ATest {
    @Test
    public void should_return_50() {
        Assert.assertEquals(50, WrongSubtract977A.Solution.solution(512, 4));
    }
    @Test
    public void should_return_1() {
        Assert.assertEquals(1, WrongSubtract977A.Solution.solution(1000000000, 9));
    }
}
