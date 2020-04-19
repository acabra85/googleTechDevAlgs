package com.acabra.gtechdevalgs.codeforces.below1000;

import org.junit.Assert;
import org.junit.Test;

public class NewYearNaming1284ATest {

    static String[] s = {"sin", "im", "gye", "gap", "eul", "byeong", "jeong", "mu", "gi", "gyeong"};
    static String[] t = {"yu", "sul", "hae", "ja", "chuk", "in", "myo", "jin", "sa", "o", "mi", "sin"};

    @Test
    public void test_api() {
        Assert.assertEquals("sinyu", NewYearNaming1284A.Solution.solution(s, t, 1));
        Assert.assertEquals("imsul", NewYearNaming1284A.Solution.solution(s, t, 2));
        Assert.assertEquals("gyehae", NewYearNaming1284A.Solution.solution(s, t, 3));
        Assert.assertEquals("gapja", NewYearNaming1284A.Solution.solution(s, t, 4));
        Assert.assertEquals("gyeongo", NewYearNaming1284A.Solution.solution(s, t, 10));
        Assert.assertEquals("sinmi", NewYearNaming1284A.Solution.solution(s, t, 11));
        Assert.assertEquals("imsin", NewYearNaming1284A.Solution.solution(s, t, 12));
        Assert.assertEquals("gyeyu", NewYearNaming1284A.Solution.solution(s, t, 13));
        Assert.assertEquals("gyeyu", NewYearNaming1284A.Solution.solution(s, t, 73));
        Assert.assertEquals("byeongsin", NewYearNaming1284A.Solution.solution(s, t, 2016));
        Assert.assertEquals("jeongyu", NewYearNaming1284A.Solution.solution(s, t, 2017));
        Assert.assertEquals("musul", NewYearNaming1284A.Solution.solution(s, t, 2018));
        Assert.assertEquals("gihae", NewYearNaming1284A.Solution.solution(s, t, 2019));
        Assert.assertEquals("gyeongja", NewYearNaming1284A.Solution.solution(s, t, 2020));
    }

}