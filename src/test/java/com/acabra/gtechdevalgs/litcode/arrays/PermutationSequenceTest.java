package com.acabra.gtechdevalgs.litcode.arrays;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

public class PermutationSequenceTest {

    @Test
    public void test_should_return_213_bf() {
        int n = 3;
        int k = 3;
        MatcherAssert.assertThat("213", Is.is(new PermutationSequence().findKPermutation_bf(n, k)));
    }
    @Test
    public void test_should_return_2314_bf() {
        int n = 4;
        int k = 9;
        MatcherAssert.assertThat("2314", Is.is(new PermutationSequence().findKPermutation_bf(n, k)));
    }

    @Test
    public void test_should_return_123_bf() {
        int n = 3;
        int k = 1;
        MatcherAssert.assertThat("123", Is.is(new PermutationSequence().findKPermutation_bf(n, k)));
    }

    @Test
    public void test_should_return_213_optimal() {
        int n = 3;
        int k = 3;
        MatcherAssert.assertThat("213", Is.is(new PermutationSequence().findKPermutation(n, k)));
    }

    @Test
    public void test_should_return_2314_optimal() {
        int n = 4;
        int k = 9;
        MatcherAssert.assertThat("2314", Is.is(new PermutationSequence().findKPermutation(n, k)));
    }

    @Test
    public void test_should_return_3142_optimal() {
        int n = 4;
        int k = 14;
        MatcherAssert.assertThat("3142", Is.is(new PermutationSequence().findKPermutation(n, k)));
    }

    @Test
    public void test_should_return_123_optimal() {
        int n = 3;
        int k = 1;
        MatcherAssert.assertThat("123", Is.is(new PermutationSequence().findKPermutation(n, k)));
    }
}
