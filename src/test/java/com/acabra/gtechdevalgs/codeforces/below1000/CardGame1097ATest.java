package com.acabra.gtechdevalgs.codeforces.below1000;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class CardGame1097ATest {

    @Test
    public void should_return_yes_0() throws IOException {
        CardGame1097A.Solution.Help help = CardGame1097A.Solution.Help.of("codeforces/below1000/1097A_0.txt");
        Assert.assertEquals("YES", CardGame1097A.Solution.solution(help));
    }

    @Test
    public void should_return_yes_1() throws IOException {
        CardGame1097A.Solution.Help help = CardGame1097A.Solution.Help.of("codeforces/below1000/1097A_2.txt");
        Assert.assertEquals("YES", CardGame1097A.Solution.solution(help));
    }

    @Test
    public void should_return_no_0() throws IOException {
        CardGame1097A.Solution.Help help = CardGame1097A.Solution.Help.of("codeforces/below1000/1097A_1.txt");
        Assert.assertEquals("NO", CardGame1097A.Solution.solution(help));
    }
}