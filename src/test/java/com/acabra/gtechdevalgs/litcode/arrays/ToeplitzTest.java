package com.acabra.gtechdevalgs.litcode.arrays;

import org.junit.Assert;
import org.junit.Test;

public class ToeplitzTest {

    @Test
    public void should_return_true_test_01() {
        int [][] matrix = {
                {1,2,3,4},
                {5,1,2,3},
                {9,5,1,2}
        };
        Assert.assertTrue(new Toeplitz().isToeplitz(matrix));
    }

    @Test
    public void should_return_false_test_01() {
        int [][] matrix = {
                {1,2,3,4},
                {5,1,2,3},
                {9,2,1,2}
        };
        Assert.assertFalse(new Toeplitz().isToeplitz(matrix));
    }
}
