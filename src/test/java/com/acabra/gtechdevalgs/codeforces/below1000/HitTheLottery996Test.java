package com.acabra.gtechdevalgs.codeforces.below1000;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class HitTheLottery996Test {

    @Test
    public void should_return_3() {
        Assert.assertEquals(3, HitTheLottery996.Solution.solution(125));
    }

    @Test
    public void should_return_five() {
        Assert.assertEquals(5, HitTheLottery996.Solution.solution(43));
    }

    @Test
    public void should_return_10_m() throws IOException {
        HitTheLottery996.Solution.Help help = HitTheLottery996.Solution.Help.of("codeforces/below1000/996.txt");
        Assert.assertEquals(10000000, HitTheLottery996.Solution.solution(help.nInt()));
    }
}
