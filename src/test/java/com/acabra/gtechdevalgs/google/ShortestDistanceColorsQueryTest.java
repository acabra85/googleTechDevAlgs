package com.acabra.gtechdevalgs.google;

import org.hamcrest.core.Is;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

public class ShortestDistanceColorsQueryTest {

    private ShortestDistanceColorsQuery underTest;

    @Before
    public void setUp() {
        underTest = new ShortestDistanceColorsQuery();
    }

    @Test
    public void shortestDistanceColor() {
        int[] colors = {1,1,2,1,3,2,2,3,3};
        int[][] queries = {{1,3},{2,2},{6,1},{3,8}};
        int[] expected = {3,0,3,-1};
        List<Integer> actual = underTest.shortestDistanceColor(colors, queries);
        IntStream.range(0, expected.length)
                .forEach(i -> MatcherAssert.assertThat(actual.get(i), Is.is(expected[i])));

    }
}