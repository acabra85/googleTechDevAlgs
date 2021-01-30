package com.acabra.gtechdevalgs.google;

import com.acabra.gtechdevalgs.TestUtils;
import org.hamcrest.core.Is;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.stream.IntStream;

public class CountGoodIndexesTreeMapTest {


    private CountGoodIndexesTreeMap underTest;

    @Before
    public void setup() {
        underTest = new CountGoodIndexesTreeMap();
    }

    @Test
    public void shouldReturn2_1() {
        int[] input = {10,13,12,14,15};
        int expected = 2;
        Collection<Integer> actual = underTest.oddEvenJumps(input);
        MatcherAssert.assertThat(actual.size(), Is.is(expected));
    }
    @Test
    public void shouldReturn2_2() {
        int[] input = {81,54,96,60,58};
        int expected = 2;
        Collection<Integer> actual = underTest.oddEvenJumps(input);
        MatcherAssert.assertThat(actual.size(), Is.is(expected));
    }

    @Test
    public void shouldReturn2_3() {
        int[] input = {40,78};
        int expected = 2;
        Collection<Integer> actual = underTest.oddEvenJumps(input);
        MatcherAssert.assertThat(actual.size(), Is.is(expected));
    }

    @Test
    public void shouldReturn3_1() {
        int[] input = {2,3,1,1,4};
        int expected = 3;
        Collection<Integer> actual = underTest.oddEvenJumps(input);
        MatcherAssert.assertThat(actual.size(), Is.is(expected));
    }

    @Test
    public void shouldReturn3_2() {
        int[] input = {5,1,3,4,2};
        int expected = 3;
        Collection<Integer> actual = underTest.oddEvenJumps(input);
        MatcherAssert.assertThat(actual.size(), Is.is(expected));
    }

    @Test
    public void shouldReturn6() {
        int[] input = {1,2,3,2,1,4,4,5};
        int expected = 6;
        Collection<Integer> actual = underTest.oddEvenJumps(input);
        MatcherAssert.assertThat(actual.size(), Is.is(expected));
    }

    @Test
    public void shouldReturn16023_big() {
        int[] input = TestUtils.buildTestCaseBigJumpingEvenOdd("google/countgoodindexes/16023.in");
        int[] expected = TestUtils.buildTestCaseBigJumpingEvenOdd("google/countgoodindexes/16023.out");
        Object[] actual = underTest.oddEvenJumps(input).toArray();
        MatcherAssert.assertThat(actual.length, Is.is(expected.length));
        IntStream.range(0, expected.length).forEach(idx -> MatcherAssert.assertThat(actual[idx], Is.is(expected[idx])));
    }

    @Test
    public void shouldReturn2819_big() {
        int[] input = TestUtils.buildTestCaseBigJumpingEvenOdd("google/countgoodindexes/2819.in");
        int[] expected = TestUtils.buildTestCaseBigJumpingEvenOdd("google/countgoodindexes/2819.out");
        Object[] actual = underTest.oddEvenJumps(input).toArray();
        MatcherAssert.assertThat(actual.length, Is.is(expected.length));
        IntStream.range(0, expected.length).forEach(idx -> MatcherAssert.assertThat(actual[idx], Is.is(expected[idx])));
    }

    @Test
    public void shouldReturn1420_big() {
        int[] input = TestUtils.buildTestCaseBigJumpingEvenOdd("google/countgoodindexes/1420.in");
        int[] expected = TestUtils.buildTestCaseBigJumpingEvenOdd("google/countgoodindexes/1420.out");
        Object[] actual = underTest.oddEvenJumps(input).toArray();
        MatcherAssert.assertThat(actual.length, Is.is(expected.length));
        IntStream.range(0, expected.length).forEach(idx -> MatcherAssert.assertThat(actual[idx], Is.is(expected[idx])));
    }

    @Test
    public void shouldReturn3318_big() {
        int[] input = TestUtils.buildTestCaseBigJumpingEvenOdd("google/countgoodindexes/3318.in");
        int[] expected = TestUtils.buildTestCaseBigJumpingEvenOdd("google/countgoodindexes/3318.out");
        Object[] actual = underTest.oddEvenJumps(input).toArray();
        MatcherAssert.assertThat(actual.length, Is.is(expected.length));
        IntStream.range(0, expected.length).forEach(idx -> MatcherAssert.assertThat(actual[idx], Is.is(expected[idx])));
    }

    @Test
    public void shouldReturn15366_big() {
        int[] input = TestUtils.buildTestCaseBigJumpingEvenOdd("google/countgoodindexes/15366.in");
        int[] expected = TestUtils.buildTestCaseBigJumpingEvenOdd("google/countgoodindexes/15366.out");
        Object[] actual = underTest.oddEvenJumps(input).toArray();
        MatcherAssert.assertThat(actual.length, Is.is(expected.length));
        IntStream.range(0, expected.length).forEach(idx -> MatcherAssert.assertThat(actual[idx], Is.is(expected[idx])));
    }
}