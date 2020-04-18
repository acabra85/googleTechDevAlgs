package com.acabra.gtechdevalgs.codeforces;

import org.junit.Assert;
import org.junit.Test;

public class BearAndBigBrother791ATest {

    @Test
    public void test() {
        Assert.assertEquals(2, BearAndBigBrother791A.Solution.solution(4, 7));
        Assert.assertEquals(3, BearAndBigBrother791A.Solution.solution(4, 9));
        Assert.assertEquals(1, BearAndBigBrother791A.Solution.solution(1, 1));
        Assert.assertEquals(0, BearAndBigBrother791A.Solution.solution(2, 1));
    }
}
