package com.acabra.gtechdevalgs.litcode.arrays;

import org.junit.Assert;
import org.junit.Test;

public class EvaluateDivisionTest {

    @Test
    public void test_1() {
        String[][] equations = {{"a", "b"}, {"b", "c"}};
        double[] values = {2.0, 3.0};
        String[][] queries = {
                {"a", "c"},
                {"b", "a"},
                {"a", "e"},
                {"a", "a"},
                {"x", "x"}
        };
        double[] expected = {
                6.0,
                0.5,
                -1.0,
                1.0,
                -1.0};
        Assert.assertArrayEquals(expected, new EvaluateDivision().evaluateDivision(equations, values, queries), 0.0001d);
    }

    @Test
    public void test_2() {
        String[][] equations = {{"a", "e"}, {"b", "e"}};
        double[] values = {4.0, 3.0};
        String[][] queries = {
                {"a", "b"},
                {"e", "e"},
                {"x", "x"}
        };
        double[] expected = {
                1.33333,
                1.0,
                -1.0};
        Assert.assertArrayEquals(expected, new EvaluateDivision().evaluateDivision(equations, values, queries), 0.0001d);
    }
    @Test
    public void test_3() {
        String[][] equations = {
                {"x1", "x2"},
                {"x2", "x3"},
                {"x3", "x4"},
                {"x4", "x5"}
        };
        double[] values = {3.0, 4.0, 5.0, 6.0};
        String[][] queries = {
                {"x1","x5"},
                {"x5","x2"},
                {"x2","x4"},
                {"x2","x2"},
                {"x2","x9"},
                {"x9","x9"}
        };
        double[] expected = {
                360.0,
                0.00833,
                20.0,
                1.0,
                -1.0,
                -1.0
        };
        Assert.assertArrayEquals(expected, new EvaluateDivision().evaluateDivision(equations, values, queries), 0.0001d);
    }
    @Test
    public void test_4() {
        /**
         *

         */
        String[][] equations = {
                {"a", "b"},
                {"e", "f"},
                {"b", "e"}
        };
        double[] values = {3.4,1.4,2.3};
        String[][] queries = {
                {"b","a"},
                {"a","f"},
                {"f","f"},
                {"e","e"},
                {"c","c"},
                {"a","c"},
                {"f","e"}
        };
        double[] expected = {
                0.29412,
                10.948,
                1.0,
                1.0,
                -1.0,
                -1.0,
                0.71429
        };
        Assert.assertArrayEquals(expected, new EvaluateDivision().evaluateDivision(equations, values, queries), 0.0001d);
    }
}
