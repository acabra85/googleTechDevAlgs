package com.acabra.gtechdevalgs.litcode.arrays;

import com.acabra.gtechdevalgs.TestUtils;
import org.junit.Test;

public class ConfusingNumbersTest {

    @Test
    public void confusingNumber() {
        TestUtils.iAssertTrue(new ConfusingNumbers().confusingNumber(8019));
        TestUtils.iAssertTrue(new ConfusingNumbers().confusingNumber(800));

        TestUtils.iAssertFalse(new ConfusingNumbers().confusingNumber(101));
        TestUtils.iAssertFalse(new ConfusingNumbers().confusingNumber(25));
        TestUtils.iAssertFalse(new ConfusingNumbers().confusingNumber(689));
    }
}