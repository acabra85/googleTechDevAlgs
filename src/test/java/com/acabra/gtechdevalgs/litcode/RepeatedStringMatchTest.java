package com.acabra.gtechdevalgs.litcode;

import org.junit.Assert;
import org.junit.Test;

public class RepeatedStringMatchTest {

    @Test
    public void should_return_three() {
        String A = "abcd";
        String B = "cdabcdab";
        Assert.assertEquals(3, new RepeatedStringMatch().nRepetitionsOfAToGetB(A, B));
    }

    @Test
    public void should_return_two() {
        String A = "a";
        String B = "aa";
        Assert.assertEquals(2, new RepeatedStringMatch().nRepetitionsOfAToGetB(A, B));
    }

    @Test
    public void should_return_one_equal_strings() {
        String A = "abcd";
        String B = "abcd";
        Assert.assertEquals(1, new RepeatedStringMatch().nRepetitionsOfAToGetB(A, B));
    }

    @Test
    public void should_return_one_b_contained() {
        String A = "abcd";
        String B = "cd";
        Assert.assertEquals(1, new RepeatedStringMatch().nRepetitionsOfAToGetB(A, B));
    }

    @Test
    public void should_return_four() {
        String A = "abc";
        String B = "cabcabca";
        Assert.assertEquals(4, new RepeatedStringMatch().nRepetitionsOfAToGetB(A, B));
    }

    @Test
    public void should_return_minus_1() {
        String A = "baaa";
        String B = "baba";
        Assert.assertEquals(-1, new RepeatedStringMatch().nRepetitionsOfAToGetB(A, B));
    }

    @Test
    public void should_return_minus_one_a_missing_characters_on_b_1() {
        String A = "baaa";
        String B = "babac";
        Assert.assertEquals(-1, new RepeatedStringMatch().nRepetitionsOfAToGetB(A, B));
    }
}
