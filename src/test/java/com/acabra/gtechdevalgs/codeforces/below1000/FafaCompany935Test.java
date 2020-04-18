package com.acabra.gtechdevalgs.codeforces.below1000;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class FafaCompany935Test {

    @Test
    public void should_return_1_0() {
        Assert.assertEquals(1, FafaCompany935.Solution.solution(2));
    }

    @Test
    public void should_return_3() {
        Assert.assertEquals(3, FafaCompany935.Solution.solution(10));
    }

    @Test
    public void should_return_1_1() throws IOException {
        FafaCompany935.Solution.Help help = FafaCompany935.Solution.Help.of("codeforces/below1000/935.txt");
        Assert.assertEquals(1, FafaCompany935.Solution.solution(help.nInt()));
    }

}