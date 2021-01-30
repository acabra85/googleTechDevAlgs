package com.acabra.gtechdevalgs.litcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

public class RepeatedStringMatchTest {

    @Test
    public void should_return_three() {
        String A = "abcd";
        String B = "cdabcdab";
        MatcherAssert.assertThat(3, Is.is(new RepeatedStringMatch().nRepetitionsOfAToGetB(A, B)));
    }

    @Test
    public void should_return_two() {
        String A = "a";
        String B = "aa";
        MatcherAssert.assertThat(2, Is.is(new RepeatedStringMatch().nRepetitionsOfAToGetB(A, B)));
    }

    @Test
    public void should_return_one_equal_strings() {
        String A = "abcd";
        String B = "abcd";
        MatcherAssert.assertThat(1, Is.is(new RepeatedStringMatch().nRepetitionsOfAToGetB(A, B)));
    }

    @Test
    public void should_return_one_b_contained() {
        String A = "abcd";
        String B = "cd";
        MatcherAssert.assertThat(1, Is.is(new RepeatedStringMatch().nRepetitionsOfAToGetB(A, B)));
    }

    @Test
    public void should_return_four() {
        String A = "abc";
        String B = "cabcabca";
        MatcherAssert.assertThat(4, Is.is(new RepeatedStringMatch().nRepetitionsOfAToGetB(A, B)));
    }

    @Test
    public void should_return_minus_1() {
        String A = "baaa";
        String B = "baba";
        MatcherAssert.assertThat(-1, Is.is(new RepeatedStringMatch().nRepetitionsOfAToGetB(A, B)));
    }

    @Test
    public void should_return_minus_one_a_missing_characters_on_b_1() {
        String A = "baaa";
        String B = "babac";
        MatcherAssert.assertThat(-1, Is.is(new RepeatedStringMatch().nRepetitionsOfAToGetB(A, B)));
    }
}
