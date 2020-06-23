package com.acabra.gtechdevalgs.litcode.arrays;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConfusingNumbersTest {

    @Test
    public void confusingNumber() {
        Assert.assertTrue(new ConfusingNumbers().confusingNumber(8019));
        Assert.assertTrue(new ConfusingNumbers().confusingNumber(800));

        Assert.assertFalse(new ConfusingNumbers().confusingNumber(101));
        Assert.assertFalse(new ConfusingNumbers().confusingNumber(25));
        Assert.assertFalse(new ConfusingNumbers().confusingNumber(689));
    }
}