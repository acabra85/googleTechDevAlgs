package com.acabra.gtechdevalgs.codeforces;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Polyhedrons785Test {
    @Test
    public void should_return_42() throws IOException {
        Polyhedrons785.Solution.Help help = Polyhedrons785.Solution.Help.of(Polyhedrons785.Solution.fileAsStream("codeforces/below1000/785_0.txt"));
        Assert.assertEquals(42, Polyhedrons785.Solution.solution(help));
    }

    @Test
    public void should_return_28() throws IOException {
        Polyhedrons785.Solution.Help help = Polyhedrons785.Solution.Help.of(Polyhedrons785.Solution.fileAsStream("codeforces/below1000/785_1.txt"));
        Assert.assertEquals(28, Polyhedrons785.Solution.solution(help));
    }
}
