package com.acabra.gtechdevalgs.litcode.arrays;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.List;
import java.util.NoSuchElementException;

public class ArraySnapshotTest {

    @Test
    public void test_case_1() {
        String[] instructions = {"ini","snap","get","get","set","get","set","get","set"};
        List<int[]> params = List.of(
                new int[]{2},
                new int[]{},
                new int[]{1,0},
                new int[]{0,0},
                new int[]{1,8},
                new int[]{1,0},
                new int[]{0,20},
                new int[]{0,0},
                new int[]{0,7}
        );
        Integer[] expected = {null,0,0,0,null,0,null,0,null};
        runTest(params, instructions, expected);
    }

    @Test
    public void test_case_2() {
        String[] instructions = {"ini","set","snap","set","get"};
        List<int[]> params = List.of(
                new int[]{3},
                new int[]{0,5},
                new int[]{},
                new int[]{0,6},
                new int[]{0,0}
        );
        Integer[] expected = {null,null,0,null,5};
        runTest(params, instructions, expected);
    }

    @Test
    public void test_case_3() {
        String[] instructions = {"ini","snap","snap","set","snap","get","set","get","snap","get"};
        List<int[]> params = List.of(
                new int[]{1},
                new int[]{},
                new int[]{},
                new int[]{0,4},
                new int[]{},
                new int[]{0,1},
                new int[]{0,12},
                new int[]{0,1},
                new int[]{},
                new int[]{0,3}
        );
        Integer[] expected = {null,0,1,null,2,0,null,0,3,12};
        runTest(params, instructions, expected);
    }

    private static void runTest(List<int[]> params, String[] instructions, Integer[] expected) {
        var underTest = new ArraySnapshot(params.getFirst()[0]);
        for (int i = 1; i < instructions.length; ++i) {
            int[] iParams = params.get(i);
            if(expected[i] == null) {
                if (instructions[i].equals("set")) {
                    underTest.set(iParams[0], iParams[1]);
                } else {
                    throw new NoSuchElementException("nse");
                }
            } else {
                if (instructions[i].equals("snap")) {
                   MatcherAssert.assertThat(expected[i], Is.is(underTest.snap()));
                } else {
                   MatcherAssert.assertThat(expected[i], Is.is(underTest.get(iParams[0], iParams[1])));
                }
            }
        }
    }
}