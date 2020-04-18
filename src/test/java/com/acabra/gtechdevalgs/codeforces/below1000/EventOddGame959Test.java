package com.acabra.gtechdevalgs.codeforces.below1000;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class EventOddGame959Test {
    @Test
    public void should_return_Ehab() {
        Assert.assertEquals("Ehab", EventOddGame959.Solution.solution(1));
    }

    @Test
    public void should_return_Mahmoud_0() {
        Assert.assertEquals("Mahmoud", EventOddGame959.Solution.solution(2));
    }

    @Test
    public void should_return_Mahmoud_1() throws IOException {
        EventOddGame959.Solution.Help help = EventOddGame959.Solution.Help.of("codeforces/below1000/959.txt");
        Assert.assertEquals("Mahmoud", EventOddGame959.Solution.solution(help.nInt()));
    }
}