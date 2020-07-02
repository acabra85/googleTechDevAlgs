package com.acabra.gtechdevalgs.google;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberOfIslands2Test {

    @Test
    public void numIslands2_smart_1() {
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 3, 2, 1, 1);
        int[][] positions = {{0, 0}, {0, 2}, {2, 0}, {2, 2}, {1, 1} ,{0, 1}, {1, 0}, {2, 1}, {1, 2}};
        List<Integer> actual = new NumberOfIslands2().numIslands2(3, 3, positions);
        Assert.assertThat(actual.size(), Is.is(expected.size()));
        for (int i = 0; i < actual.size(); ++i) {
            Assert.assertThat(actual.get(i), Is.is(expected.get(i)));
        }
    }

    @Test
    public void numIslands2_smart_2() {
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 3, 2, 1, 1);
        int[][] positions = {{0, 0}, {0, 2}, {2, 0}, {2, 2}, {1, 1} ,{0, 1}, {1, 0}, {2, 1}, {1, 2}};
        List<Integer> actual = new NumberOfIslands2().numIslands2(3, 3, positions);
        Assert.assertThat(actual.size(), Is.is(expected.size()));
        for (int i = 0; i < actual.size(); ++i) {
            Assert.assertThat(actual.get(i), Is.is(expected.get(i)));
        }
    }

    @Test
    public void numIslands2_smart_3() {
        List<Integer> expected = Collections.singletonList(1);
        int[][] positions = {{7, 0}};
        List<Integer> actual = new NumberOfIslands2().numIslands2(8, 2, positions);
        Assert.assertThat(actual.size(), Is.is(expected.size()));
        for (int i = 0; i < actual.size(); ++i) {
            Assert.assertThat(actual.get(i), Is.is(expected.get(i)));
        }
    }
}