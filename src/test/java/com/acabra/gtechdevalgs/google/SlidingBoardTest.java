package com.acabra.gtechdevalgs.google;

import org.hamcrest.core.Is;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SlidingBoardTest {

    SlidingBoard underTest;
    @Before
    public void setUp() {
        underTest = new SlidingBoard();
    }
    @Test
    public void shouldReturn1() {
        int[][] input = {{1,2,3},{4,0,5}};
        MatcherAssert.assertThat(underTest.slidingPuzzle(input), Is.is(1));
    }

    @Test
    public void shouldReturnMinus1() {
        int[][] input = {{1,2,3},{5,4,0}};
        MatcherAssert.assertThat(underTest.slidingPuzzle(input), Is.is(-1));
    }
}