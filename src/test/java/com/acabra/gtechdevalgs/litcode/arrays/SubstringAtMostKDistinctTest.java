package com.acabra.gtechdevalgs.litcode.arrays;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

public class SubstringAtMostKDistinctTest {

    @Test
    public void should_return_3_test_1() {
        String s = "ebeabc";
        int k = 2;
        String expected = "ebe";
        MatcherAssert.assertThat(expected, Is.is(new SubstringAtMostKDistinct().substringAtMostKDistinct(s, k)));
    }

    @Test
    public void should_return_6_test_2() {
        String s = "aaaaaa";
        int k = 1;
        String expected = "aaaaaa";
        MatcherAssert.assertThat(expected, Is.is(new SubstringAtMostKDistinct().substringAtMostKDistinct(s, k)));
    }

    @Test
    public void should_return_0_test_3() {
        String s = "aaaaaa";
        int k = 0;
        String expected = "";
        MatcherAssert.assertThat(expected, Is.is(new SubstringAtMostKDistinct().substringAtMostKDistinct(s, k)));
    }

    @Test
    public void should_return_6_test_4() {
        String s = "ebeabcbcbc";
        int k = 2;
        String expected = "bcbcbc";
        MatcherAssert.assertThat(expected, Is.is(new SubstringAtMostKDistinct().substringAtMostKDistinct(s, k)));
    }

    @Test
    public void should_return_10_test_5() {
        String s = "bcbcbcbcbc";
        int k = 2;
        String expected = "bcbcbcbcbc";
        MatcherAssert.assertThat(expected, Is.is(new SubstringAtMostKDistinct().substringAtMostKDistinct(s, k)));
    }

    @Test
    public void should_return_10_test_6() {
        String s = "bcbcbcbcbc";
        int k = 3;
        String expected = "bcbcbcbcbc";
        MatcherAssert.assertThat(expected, Is.is(new SubstringAtMostKDistinct().substringAtMostKDistinct(s, k)));
    }

    @Test
    public void should_return_10_test_7() {
        String s = "bcbcbcbcbc";
        int k = 4;
        String expected = "bcbcbcbcbc";
        MatcherAssert.assertThat(expected, Is.is(new SubstringAtMostKDistinct().substringAtMostKDistinct(s, k)));
    }

    @Test
    public void should_return_12_test_8() {
        String s = "bcbcsebcbcbc";
        int k = 4;
        String expected = "bcbcsebcbcbc";
        MatcherAssert.assertThat(expected, Is.is(new SubstringAtMostKDistinct().substringAtMostKDistinct(s, k)));
    }

    @Test
    public void should_return_7_test_8() {
        String s = "bcbcsebcbcbc";
        int k = 3;
        String expected = "ebcbcbc";
        MatcherAssert.assertThat(expected, Is.is(new SubstringAtMostKDistinct().substringAtMostKDistinct(s, k)));
    }

    @Test
    public void should_return_13_test_9() {
        String s = "bcbcsebcbcbcxbbccbb";
        int k = 3;
        String expected = "bcbcbcxbbccbb";
        MatcherAssert.assertThat(expected, Is.is(new SubstringAtMostKDistinct().substringAtMostKDistinct(s, k)));
    }
}
