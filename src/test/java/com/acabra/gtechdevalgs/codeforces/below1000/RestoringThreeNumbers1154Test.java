package com.acabra.gtechdevalgs.codeforces.below1000;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class RestoringThreeNumbers1154Test {

    @Test
    public void test_1() {
        List<Integer> expected = List.of(1, 2, 3);
        int[] input = {3, 6, 5, 4};
        Assert.assertEquals(expected, RestoringThreeNumbers1154.Solution.solution(input));
    }

    @Test
    public void test_2() {
        List<Integer> expected = List.of(20, 20, 20);
        int[] input = {40, 40, 40, 60};
        Assert.assertEquals(expected, RestoringThreeNumbers1154.Solution.solution(input));
    }

    @Test
    public void test_3() {
        List<Integer> expected = List.of(1, 100, 100);
        int[] input = {201, 101, 101, 200};
        Assert.assertEquals(expected, RestoringThreeNumbers1154.Solution.solution(input));
    }

    @Test
    public void test_4() throws IOException {
        List<Integer> expected = List.of(1, 2, 3);
        RestoringThreeNumbers1154.Solution.Help help = RestoringThreeNumbers1154.Solution.Help.of("codeforces/below1000/1154_0.txt");
        int[] input = {help.nInt(), help.nInt(), help.nInt(), help.nInt()};
        help.close();
        Assert.assertEquals(expected, RestoringThreeNumbers1154.Solution.solution(input));
    }
}