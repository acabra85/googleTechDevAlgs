package com.acabra.gtechdevalgs.codeforces;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class SearchEasyProblem1030ATest {

    private SearchEasyProblem1030A.Solution.Help help;

    @After
    public void tearDown() throws IOException {
        help.close();
        help = null;
    }

    @Test
    public void should_return_hard() throws IOException {
        help = SearchEasyProblem1030A.Solution.Help.of("codeforces/below1000/1030A_0.txt");
        Assert.assertEquals("HARD", SearchEasyProblem1030A.Solution.solution(help));
    }

    @Test
    public void should_return_easy() throws IOException {
        help = SearchEasyProblem1030A.Solution.Help.of("codeforces/below1000/1030A_1.txt");
        Assert.assertEquals("EASY", SearchEasyProblem1030A.Solution.solution(help));
    }
}
