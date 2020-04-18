package com.acabra.gtechdevalgs.codeforces;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Polyhedrons785Test {

    private Polyhedrons785.Solution.Help help;

    @After
    public void tearDown() throws Exception {
        help.close();
        help = null;
    }

    @Test
    public void should_return_42() throws IOException {
        help = Polyhedrons785.Solution.Help.of("codeforces/below1000/785_0.txt");
        Assert.assertEquals(42, Polyhedrons785.Solution.solution(help));
    }

    @Test
    public void should_return_28() throws IOException {
        help = Polyhedrons785.Solution.Help.of("codeforces/below1000/785_1.txt");
        Assert.assertEquals(28, Polyhedrons785.Solution.solution(help));
    }
}
