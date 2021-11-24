package com.acabra.gtechdevalgs.litcode.graphs;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class IndependentGardensTest {

    private IndependentGardens underTest;

    @BeforeEach
    public void setup() {
        underTest = new IndependentGardens();
    }

    @Test
    public void test0() {
        int[][] paths = {{1,2},{3,4}};
        int[] expected = {1,2,1,2};
        Assertions.assertThat(underTest.getIndependentGardens(4, paths))
                .containsExactlyInAnyOrder(expected);
    }

    @Test
    public void test1() {
        int[][] paths = {{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}};
        int[] expected = {1,2,3,4};
        Assertions.assertThat(underTest.getIndependentGardens(4, paths))
                .containsExactlyInAnyOrder(expected);
    }

    @Test
    public void test2() {
        int[][] paths = {{1,2},{2,3},{3,1}};
        int[] expected = {1,2,3};
        Assertions.assertThat(underTest.getIndependentGardens(3, paths))
                .containsExactlyInAnyOrder(expected);
    }

    @Test
    public void test3() {
        int[][] paths = {};
        int[] expected = new int[10000];
        Arrays.fill(expected, 1);
        Assertions.assertThat(underTest.getIndependentGardens(10000, paths))
                .containsExactlyInAnyOrder(expected);
    }


}