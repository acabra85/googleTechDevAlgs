package com.acabra.gtechdevalgs.litcode.arrays;

import com.acabra.gtechdevalgs.TestUtils;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

public class MergeIntervalsTest {

    private static final Comparator<MergeIntervals.Interval> COMPARATOR = Comparator.comparingInt(a->a.start);

    @Test
    public void test_1() {
        int[][] inputArray = {{1,3},{2,6},{8,10},{15,18}};
        int[][] expectedArray = {{1,6},{8,10},{15,18}};
        List<MergeIntervals.Interval> input = TestUtils.buildIntervalList(inputArray);
        List<MergeIntervals.Interval> expected = TestUtils.buildIntervalList(expectedArray);
        TestUtils.assertListEquals(expected, new MergeIntervals().merge(input), COMPARATOR);
    }

    @Test
    public void test_2() {
        int[][] inputArray = {{1,4},{4,5}};
        int[][] expectedArray =  {{1,5}};
        List<MergeIntervals.Interval> input = TestUtils.buildIntervalList(inputArray);
        List<MergeIntervals.Interval> expected = TestUtils.buildIntervalList(expectedArray);
        TestUtils.assertListEquals(expected, new MergeIntervals().merge(input), COMPARATOR);
    }

    @Test
    public void test_3() {
        int[][] inputArray = {{1, 3},{2, 7},{7, 9}};
        int[][] expectedArray =  {{1,9}};
        List<MergeIntervals.Interval> input = TestUtils.buildIntervalList(inputArray);
        List<MergeIntervals.Interval> expected = TestUtils.buildIntervalList(expectedArray);
        TestUtils.assertListEquals(expected, new MergeIntervals().merge(input), COMPARATOR);
    }

    @Test
    public void test_4() {
        int[][] inputArray = {{1, 2},{3, 7},{8, 9}};
        int[][] expectedArray = {{1, 2},{3, 7},{8, 9}};
        List<MergeIntervals.Interval> input = TestUtils.buildIntervalList(inputArray);
        List<MergeIntervals.Interval> expected = TestUtils.buildIntervalList(expectedArray);
        TestUtils.assertListEquals(expected, new MergeIntervals().merge(input), COMPARATOR);
    }

    @Test
    public void test_5() {
        int[][] inputArray = {{1, 3},{2, 15},{7, 8}};
        int[][] expectedArray = {{1, 15}};
        List<MergeIntervals.Interval> input = TestUtils.buildIntervalList(inputArray);
        List<MergeIntervals.Interval> expected = TestUtils.buildIntervalList(expectedArray);
        TestUtils.assertListEquals(expected, new MergeIntervals().merge(input), COMPARATOR);
    }
}
