package com.acabra.gtechdevalgs.codeforces;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class SearchEasyProblem1030ATest {

    @Test
    public void should_return_hard() throws IOException {
        SearchEasyProblem1030A.Solution.Help help = SearchEasyProblem1030A.Solution.Help.of(SearchEasyProblem1030A.Solution.fileAsStream("codeforces/below1000/1030A_0.txt"));
        Assert.assertEquals("HARD", SearchEasyProblem1030A.Solution.solution(help));
    }

    @Test
    public void should_return_easy() throws IOException {
        SearchEasyProblem1030A.Solution.Help help = SearchEasyProblem1030A.Solution.Help.of(SearchEasyProblem1030A.Solution.fileAsStream("codeforces/below1000/1030A_1.txt"));
        Assert.assertEquals("EASY", SearchEasyProblem1030A.Solution.solution(help));
    }
}
