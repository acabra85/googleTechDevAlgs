package com.acabra.gtechdevalgs.google;

import com.acabra.gtechdevalgs.TestUtils;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.stream.IntStream;

public class CountGoodIndexesTest {

    private CountGoodIndexes underTest;
    private CountGoodIndexesTreeMap helper = new CountGoodIndexesTreeMap();

    @Before
    public void setup() {
        underTest = new CountGoodIndexes();
    }

    @Test
    public void shouldReturn2_1() {
        int[] input = {10, 13, 12, 14, 15};
        Object[] expected = helper.oddEvenJumps(input).toArray();
        Object[] actual = underTest.oddEvenJumps(input).toArray();
        Assert.assertThat(actual.length, Is.is(expected.length));
        IntStream.range(0, expected.length).forEach(idx -> Assert.assertThat(actual[idx], Is.is(expected[idx])));
    }

    @Test
    public void shouldReturn2_2() {
        int[] input = {81, 54, 96, 60, 58};
        Object[] expected = helper.oddEvenJumps(input).toArray();
        Object[] actual = underTest.oddEvenJumps(input).toArray();
        Assert.assertThat(actual.length, Is.is(expected.length));
        IntStream.range(0, expected.length).forEach(idx -> Assert.assertThat(actual[idx], Is.is(expected[idx])));
    }

    @Test
    public void shouldReturn2_3() {
        int[] input = {40, 78};
        Object[] expected = helper.oddEvenJumps(input).toArray();
        Object[] actual = underTest.oddEvenJumps(input).toArray();
        Assert.assertThat(actual.length, Is.is(expected.length));
        IntStream.range(0, expected.length).forEach(idx -> Assert.assertThat(actual[idx], Is.is(expected[idx])));
    }

    @Test
    public void shouldReturn3_1() {
        int[] input = {2, 3, 1, 1, 4};
        Object[] expected = helper.oddEvenJumps(input).toArray();
        Object[] actual = underTest.oddEvenJumps(input).toArray();
        Assert.assertThat(actual.length, Is.is(expected.length));
        IntStream.range(0, expected.length).forEach(idx -> Assert.assertThat(actual[idx], Is.is(expected[idx])));
    }

    @Test
    public void shouldReturn3_2() {
        int[] input = {5, 1, 3, 4, 2};
        Object[] expected = helper.oddEvenJumps(input).toArray();
        Object[] actual = underTest.oddEvenJumps(input).toArray();
        Assert.assertThat(actual.length, Is.is(expected.length));
        IntStream.range(0, expected.length).forEach(idx -> Assert.assertThat(actual[idx], Is.is(expected[idx])));
    }

    @Test
    public void shouldReturn6() {
        int[] input = {1, 2, 3, 2, 1, 4, 4, 5};
        Object[] expected = helper.oddEvenJumps(input).toArray();
        Object[] actual = underTest.oddEvenJumps(input).toArray();
        Assert.assertThat(actual.length, Is.is(expected.length));
        IntStream.range(0, expected.length).forEach(idx -> Assert.assertThat(actual[idx], Is.is(expected[idx])));
    }

    @Test
    public void shouldReturn16023_big() {
        int[] input = TestUtils.buildTestCaseBigJumpingEvenOdd("google/countgoodindexes/16023.in");
        Object[] expected = helper.oddEvenJumps(input).toArray();
        Object[] actual = underTest.oddEvenJumps(input).toArray();
        Assert.assertThat(actual.length, Is.is(expected.length));
        IntStream.range(0, expected.length).forEach(idx -> Assert.assertThat(actual[idx], Is.is(expected[idx])));
    }

    @Test
    public void shouldReturn2819_big() {
        int[] input = TestUtils.buildTestCaseBigJumpingEvenOdd("google/countgoodindexes/2819.in");
        Object[] expected = helper.oddEvenJumps(input).toArray();
        Object[] actual = underTest.oddEvenJumps(input).toArray();
        Assert.assertThat(actual.length, Is.is(expected.length));
        IntStream.range(0, expected.length).forEach(idx -> Assert.assertThat(actual[idx], Is.is(expected[idx])));
    }

    @Test
    public void shouldReturn1420_big() {
        int[] input = TestUtils.buildTestCaseBigJumpingEvenOdd("google/countgoodindexes/1420.in");
        Object[] expected = helper.oddEvenJumps(input).toArray();
        Object[] actual = underTest.oddEvenJumps(input).toArray();
        Assert.assertThat(actual.length, Is.is(expected.length));
        IntStream.range(0, expected.length).forEach(idx -> Assert.assertThat(actual[idx], Is.is(expected[idx])));
    }

    @Test
    public void shouldReturn3318_big() {
        int[] input = TestUtils.buildTestCaseBigJumpingEvenOdd("google/countgoodindexes/3318.in");
        Object[] expected = helper.oddEvenJumps(input).toArray();
        Object[] actual = underTest.oddEvenJumps(input).toArray();
        Assert.assertThat(actual.length, Is.is(expected.length));
        IntStream.range(0, expected.length).forEach(idx -> Assert.assertThat(actual[idx], Is.is(expected[idx])));
    }

    @Test
    public void shouldReturn15366_big() {
        int[] input = TestUtils.buildTestCaseBigJumpingEvenOdd("google/countgoodindexes/15366.in");
        Object[] expected = helper.oddEvenJumps(input).toArray();
        Object[] actual = underTest.oddEvenJumps(input).toArray();
        Assert.assertThat(actual.length, Is.is(expected.length));
        IntStream.range(0, expected.length).forEach(idx -> Assert.assertThat(actual[idx], Is.is(expected[idx])));
    }
}