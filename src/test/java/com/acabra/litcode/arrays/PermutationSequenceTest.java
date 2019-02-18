package com.acabra.litcode.arrays;

import org.junit.Assert;
import org.junit.Test;

public class PermutationSequenceTest {

    @Test
    public void test_should_return_213_bf() {
        int n = 3;
        int k = 3;
        Assert.assertEquals("213", new PermutationSequence().findKPermutation_bf(n, k));
    }
    @Test
    public void test_should_return_2314_bf() {
        int n = 4;
        int k = 9;
        Assert.assertEquals("2314", new PermutationSequence().findKPermutation_bf(n, k));
    }

    @Test
    public void test_should_return_123_bf() {
        int n = 3;
        int k = 1;
        Assert.assertEquals("123", new PermutationSequence().findKPermutation_bf(n, k));
    }

    @Test
    public void test_should_return_213_optimal() {
        int n = 3;
        int k = 3;
        Assert.assertEquals("213", new PermutationSequence().findKPermutation(n, k));
    }

    @Test
    public void test_should_return_2314_optimal() {
        int n = 4;
        int k = 9;
        Assert.assertEquals("2314", new PermutationSequence().findKPermutation(n, k));
    }

    @Test
    public void test_should_return_3142_optimal() {
        int n = 4;
        int k = 14;
        Assert.assertEquals("3142", new PermutationSequence().findKPermutation(n, k));
    }

    @Test
    public void test_should_return_123_optimal() {
        int n = 3;
        int k = 1;
        Assert.assertEquals("123", new PermutationSequence().findKPermutation(n, k));
    }
}
