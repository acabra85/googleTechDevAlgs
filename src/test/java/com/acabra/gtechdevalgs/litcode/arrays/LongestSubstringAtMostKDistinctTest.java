package com.acabra.gtechdevalgs.litcode.arrays;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

public class LongestSubstringAtMostKDistinctTest {

    @Test
    public void should_return_3_test_1() {
        String s = "ebeabc";
        int k = 2;
        int expected = 3;
        MatcherAssert.assertThat(expected, Is.is(new LongestSubstringAtMostKDistinct().sizeLongestSubstringAtMostKDistinct(s, k)));
    }

    @Test
    public void should_return_6_test_2() {
        String s = "aaaaaa";
        int k = 1;
        int expected = s.length();
        MatcherAssert.assertThat(expected, Is.is(new LongestSubstringAtMostKDistinct().sizeLongestSubstringAtMostKDistinct(s, k)));
    }

    @Test
    public void should_return_0_test_3() {
        String s = "aaaaaa";
        int k = 0;
        int expected = 0;
        MatcherAssert.assertThat(expected, Is.is(new LongestSubstringAtMostKDistinct().sizeLongestSubstringAtMostKDistinct(s, k)));
    }

    @Test
    public void should_return_6_test_4() {
        String s = "ebeabcbcbc";
        int k = 2;
        int expected = 6;
        MatcherAssert.assertThat(expected, Is.is(new LongestSubstringAtMostKDistinct().sizeLongestSubstringAtMostKDistinct(s, k)));
    }

    @Test
    public void should_return_10_test_5() {
        String s = "bcbcbcbcbc";
        int k = 2;
        int expected = 10;
        MatcherAssert.assertThat(expected, Is.is(new LongestSubstringAtMostKDistinct().sizeLongestSubstringAtMostKDistinct(s, k)));
    }

    @Test
    public void should_return_10_test_6() {
        String s = "bcbcbcbcbc";
        int k = 3;
        int expected = 10;
        MatcherAssert.assertThat(expected, Is.is(new LongestSubstringAtMostKDistinct().sizeLongestSubstringAtMostKDistinct(s, k)));
    }

    @Test
    public void should_return_10_test_7() {
        String s = "bcbcbcbcbc";
        int k = 4;
        int expected = 10;
        MatcherAssert.assertThat(expected, Is.is(new LongestSubstringAtMostKDistinct().sizeLongestSubstringAtMostKDistinct(s, k)));
    }

    @Test
    public void should_return_12_test_8() {
        String s = "bcbcsebcbcbc";
        int k = 4;
        int expected = 12;
        MatcherAssert.assertThat(expected, Is.is(new LongestSubstringAtMostKDistinct().sizeLongestSubstringAtMostKDistinct(s, k)));
    }

    @Test
    public void should_return_7_test_8() {
        String s = "bcbcsebcbcbc";
        int k = 3;
        int expected = 7;
        MatcherAssert.assertThat(expected, Is.is(new LongestSubstringAtMostKDistinct().sizeLongestSubstringAtMostKDistinct(s, k)));
    }

    @Test
    public void should_return_13_test_9() {
        String s = "bcbcsebcbcbcxbbccbb";
        int k = 3;
        int expected = 13;
        MatcherAssert.assertThat(expected, Is.is(new LongestSubstringAtMostKDistinct().sizeLongestSubstringAtMostKDistinct(s, k)));
    }
}
