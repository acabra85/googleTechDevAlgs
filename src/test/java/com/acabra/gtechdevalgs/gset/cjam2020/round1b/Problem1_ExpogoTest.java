package com.acabra.gtechdevalgs.gset.cjam2020.round1b;

import org.junit.Assert;
import org.junit.Test;

public class Problem1_ExpogoTest {

    @Test
    public void test() {
        Assert.assertEquals("SEN", Problem1_Expogo.Solution.solution(2, 3));
        Assert.assertEquals("NWS", Problem1_Expogo.Solution.solution(-2, -3));
        Assert.assertEquals("EE", Problem1_Expogo.Solution.solution(3, 0));
        Assert.assertEquals("", Problem1_Expogo.Solution.solution(0, 0));
        Assert.assertEquals("IMPOSSIBLE", Problem1_Expogo.Solution.solution(-1, 1));
        Assert.assertEquals("IMPOSSIBLE", Problem1_Expogo.Solution.solution(3, 7));
        Assert.assertEquals("IMPOSSIBLE", Problem1_Expogo.Solution.solution(8, 20));
    }

}