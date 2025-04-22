package com.acabra.gtechdevalgs.litcode.dynamicprog;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.List;

public class MaximizeProfitSalesTest {
    @Test
    public void shouldReturn3() {
        List<List<Integer>> offers = List.of(
                List.of(0,0,1),
                List.of(0,2,2),
                List.of(1,3,2)
        );
        int n = 5;
        int expected = 3;
        MaximizeProfitSalesTest.runTest(n, offers, expected);
    }
    @Test
    public void shouldReturn10() {
        List<List<Integer>> offers = List.of(
                List.of(0,0,1),
                List.of(0,2,10),
                List.of(1,3,2)
        );
        int n = 5;
        int expected = 10;
        MaximizeProfitSalesTest.runTest(n, offers, expected);
    }
    @Test
    public void shouldReturn17() {
        List<List<Integer>> offers = List.of(
                List.of(1,3,10),
                List.of(1,3,3),
                List.of(0,0,1),
                List.of(0,0,7)
        );
        int n = 4;
        int expected = 17;
        MaximizeProfitSalesTest.runTest(n, offers, expected);
    }
    @Test
    public void shouldReturn16() {
        List<List<Integer>> offers = List.of(
                List.of(0, 0, 6),
                List.of(1, 2, 8),
                List.of(0, 3, 7),
                List.of(2, 2, 5),
                List.of(0, 1, 5),
                List.of(2, 3, 2),
                List.of(0, 2, 8),
                List.of(2, 3, 10),
                List.of(0, 3, 2)
        );
        int n = 4;
        int expected = 16;
        MaximizeProfitSalesTest.runTest(n, offers, expected);
    }

    private static void runTest(int n, List<List<Integer>> offers, int expected) {
        MaximizeProfitSales underTest = new MaximizeProfitSales();
        MatcherAssert.assertThat(underTest.maximizeTheProfit(n, offers, true), Is.is(expected));
        MatcherAssert.assertThat(underTest.maximizeTheProfit(n, offers, false), Is.is(expected));
    }

}