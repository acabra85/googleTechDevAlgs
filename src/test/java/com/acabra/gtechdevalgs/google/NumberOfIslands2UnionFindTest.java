package com.acabra.gtechdevalgs.google;

import org.hamcrest.core.Is;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberOfIslands2UnionFindTest {

    private NumberOfIslands2UnionFind underTest;

    @Before
    public void setup() {
        underTest = new NumberOfIslands2UnionFind();
    }

    @Test
    public void numIslands2_unionFind_1() {
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 3, 2, 1, 1);
        int[][] positions = {{0, 0}, {0, 2}, {2, 0}, {2, 2}, {1, 1} ,{0, 1}, {1, 0}, {2, 1}, {1, 2}};
        List<Integer> actual = underTest.numIslands2(3, 3, positions);
        MatcherAssert.assertThat(actual.size(), Is.is(expected.size()));
        for (int i = 0; i < actual.size(); ++i) {
            MatcherAssert.assertThat(actual.get(i), Is.is(expected.get(i)));
        }
    }

    @Test
    public void numIslands2_unionFind_2() {
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 3, 2, 1, 1);
        int[][] positions = {{0, 0}, {0, 2}, {2, 0}, {2, 2}, {1, 1} ,{0, 1}, {1, 0}, {2, 1}, {1, 2}};
        List<Integer> actual = underTest.numIslands2(3, 3, positions);
        MatcherAssert.assertThat(actual.size(), Is.is(expected.size()));
        for (int i = 0; i < actual.size(); ++i) {
            MatcherAssert.assertThat(actual.get(i), Is.is(expected.get(i)));
        }
    }

    @Test
    public void numIslands2_unionFind_3() {
        List<Integer> expected = Collections.singletonList(1);
        int[][] positions = {{7, 0}};
        List<Integer> actual = underTest.numIslands2(8, 2, positions);
        MatcherAssert.assertThat(actual.size(), Is.is(expected.size()));
        for (int i = 0; i < actual.size(); ++i) {
            MatcherAssert.assertThat(actual.get(i), Is.is(expected.get(i)));
        }
    }

    @Test
    public void numIslands2_unionFind_4() {
        NumberOfIslands2Utils.TestInputObject testInputObject = NumberOfIslands2Utils.getNumberOfIslands2TestData4();
        int rows = testInputObject.getRows();
        int cols = testInputObject.getCols();
        int[][] positions = testInputObject.getPositions();
        List<Integer> actual = underTest.numIslands2(rows, cols, positions);
        MatcherAssert.assertThat(actual.size(), Is.is(testInputObject.getExpected().size()));
        for (int i = 0; i < actual.size(); ++i) {
            MatcherAssert.assertThat(actual.get(i), Is.is(testInputObject.getExpected().get(i)));
        }
    }

    @Test
    public void numIslands2_unionFind_5() {
        NumberOfIslands2Utils.TestInputObject testInputObject = NumberOfIslands2Utils.getNumberOfIslands2TestData5();
        int rows = testInputObject.getRows();
        int cols = testInputObject.getCols();
        int[][] positions = testInputObject.getPositions();
        List<Integer> actual = underTest.numIslands2(rows, cols, positions);
        MatcherAssert.assertThat(actual.size(), Is.is(testInputObject.getExpected().size()));
        for (int i = 0; i < actual.size(); ++i) {
            MatcherAssert.assertThat(actual.get(i), Is.is(testInputObject.getExpected().get(i)));
        }
    }

    @Test
    public void numIslands2_unionFind_6() {
        NumberOfIslands2Utils.TestInputObject testInputObject = NumberOfIslands2Utils.getNumberOfIslands2TestData6();
        int rows = testInputObject.getRows();
        int cols = testInputObject.getCols();
        int[][] positions = testInputObject.getPositions();
        List<Integer> actual = underTest.numIslands2(rows, cols, positions);
        MatcherAssert.assertThat(actual.size(), Is.is(testInputObject.getExpected().size()));
        for (int i = 0; i < actual.size(); ++i) {
            MatcherAssert.assertThat(actual.get(i), Is.is(testInputObject.getExpected().get(i)));
        }
    }

}