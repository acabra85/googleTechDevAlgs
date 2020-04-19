package com.acabra.gtechdevalgs.codeforces.below1000;

import org.junit.Assert;
import org.junit.Test;

public class PensAndNotebooks1186ATest {

    @Test
    public void should_return_yes_0() {
        Assert.assertEquals("Yes", PensAndNotebooks1186A.Solution.solution(5, 8, 6));
    }

    @Test
    public void should_return_yes_1() {
        Assert.assertEquals("Yes", PensAndNotebooks1186A.Solution.solution(3, 9, 3));
    }
    @Test
    public void should_return_no() {
        Assert.assertEquals("No", PensAndNotebooks1186A.Solution.solution(8, 5, 20));
    }

}