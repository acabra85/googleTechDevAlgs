package com.acabra.gtechdevalgs.litcode.arrays;

import com.acabra.gtechdevalgs.TestUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SelfDividingNumberTest {

    @Test
    public void test_1() {
        int left = 1;
        int right = 22;
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22);
        TestUtils.assertListEquals(expected, new SelfDividingNumber().selfDividingNumbers(left, right));
    }
}
