package com.acabra.gtechdevalgs.litcode.arrays;

import com.acabra.gtechdevalgs.TestUtils;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

public class ToeplitzTest {

    @Test
    public void should_return_true_test_01() {
        int [][] matrix = {
                {1,2,3,4},
                {5,1,2,3},
                {9,5,1,2}
        };
        TestUtils.iAssertTrue(new Toeplitz().isToeplitz(matrix));
    }

    @Test
    public void should_return_false_test_01() {
        int [][] matrix = {
                {1,2,3,4},
                {5,1,2,3},
                {9,2,1,2}
        };
        TestUtils.iAssertFalse(new Toeplitz().isToeplitz(matrix));
    }
}
