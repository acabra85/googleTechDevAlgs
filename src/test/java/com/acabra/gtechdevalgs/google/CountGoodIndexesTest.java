package com.acabra.gtechdevalgs.google;

import com.acabra.gtechdevalgs.TestUtils;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CountGoodIndexesTest {

    private CountGoodIndexes underTest;

    @Before
    public void setup() {
        underTest = new CountGoodIndexes();
    }

    @Test
    public void shouldReturn2_1() {
        int[] input = {10,13,12,14,15};
        int expected = 2;
        Assert.assertThat(underTest.oddEvenJumps(input), Is.is(expected));
    }
    @Test
    public void shouldReturn2_2() {
        int[] input = {81,54,96,60,58};
        int expected = 2;
        Assert.assertThat(underTest.oddEvenJumps(input), Is.is(expected));
    }

    @Test
    public void shouldReturn2_3() {
        int[] input = {40,78};
        int expected = 2;
        Assert.assertThat(underTest.oddEvenJumps(input), Is.is(expected));
    }

    @Test
    public void shouldReturn3_1() {
        int[] input = {2,3,1,1,4};
        int expected = 3;
        Assert.assertThat(underTest.oddEvenJumps(input), Is.is(expected));
    }

    @Test
    public void shouldReturn3_2() {
        int[] input = {5,1,3,4,2};
        int expected = 3;
        Assert.assertThat(underTest.oddEvenJumps(input), Is.is(expected));
    }

    @Test
    public void shouldReturn6() {
        int[] input = {1,2,3,2,1,4,4,5};
        int expected = 6;
        Assert.assertThat(underTest.oddEvenJumps(input), Is.is(expected));
    }

    @Test
    public void shouldReturn16023_big() {
        int[] input = TestUtils.buildTestCaseBigJumpingEvenOdd("jumpingevenodd_big.in");
        int expected = 16023;
        Assert.assertThat(underTest.oddEvenJumps(input), Is.is(expected));
    }

    @Test
    public void shouldReturn2819_big() {
        int[] input = TestUtils.buildTestCaseBigJumpingEvenOdd("jumpingevenodd_big2.in");
        int expected = 2819;
        Assert.assertThat(underTest.oddEvenJumps(input), Is.is(expected));
    }

    @Test
    public void shouldReturn1420_big() {
        int[] input = TestUtils.buildTestCaseBigJumpingEvenOdd("jumpingevenodd_big3.in");
        int expected = 1420;
        Assert.assertThat(underTest.oddEvenJumps(input), Is.is(expected));
    }

    @Test
    public void shouldReturn3318_big() {
        int[] input = TestUtils.buildTestCaseBigJumpingEvenOdd("jumpingevenodd_big4.in");
        int expected = 3318;
        Assert.assertThat(underTest.oddEvenJumps(input), Is.is(expected));
    }

    @Test
    public void shouldReturn15366_big() {
        int[] input = TestUtils.buildTestCaseBigJumpingEvenOdd("jumpingevenodd_big5.in");
        int expected = 15366;
        Assert.assertThat(underTest.oddEvenJumps(input), Is.is(expected));
    }
}