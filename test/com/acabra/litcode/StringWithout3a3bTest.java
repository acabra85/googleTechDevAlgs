package com.acabra.litcode;

import org.junit.Assert;
import org.junit.Test;

public class StringWithout3a3bTest {

    @Test
    public void should_return_string_aabaa() {
        int A = 4;
        int B = 1;

        Assert.assertEquals("aabaa", new StringWithout3a3b().strWithout3a3b(A, B));
    }


    @Test
    public void should_be_true_contains_aaa() {
        Assert.assertTrue(new StringWithout3a3b().invalid("aaaaa"));
    }

    @Test
    public void should_be_true_contains_bbb() {
        Assert.assertTrue(new StringWithout3a3b().invalid("abbb"));
    }

    @Test
    public void should_be_true_contains_both() {
        Assert.assertTrue(new StringWithout3a3b().invalid("bbbaaa"));
    }
}
