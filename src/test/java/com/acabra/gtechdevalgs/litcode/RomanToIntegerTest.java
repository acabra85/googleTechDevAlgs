package com.acabra.gtechdevalgs.litcode;

import org.junit.Assert;
import org.junit.Test;

public class RomanToIntegerTest {

    @Test
    public void mustReturn1695() {
        Assert.assertEquals(1695, RomanToInteger.romanToInt("MDCXCV"));
    }

    @Test
    public void mustReturn4() {
        Assert.assertEquals(4, RomanToInteger.romanToInt("IV"));
    }

    @Test
    public void mustReturn7() {
        Assert.assertEquals(7, RomanToInteger.romanToInt("VII"));
    }

    @Test
    public void mustReturn1598() {
        Assert.assertEquals(1598, RomanToInteger.romanToInt("MDLXXXXVIII"));
    }

    @Test
    public void mustReturn1879() {
        Assert.assertEquals(1879, RomanToInteger.romanToInt("MDCCCLXXIX"));
    }

    @Test
    public void mustReturn1390() {
        Assert.assertEquals(1390, RomanToInteger.romanToInt("MCCCXC"));
    }

    @Test
    public void mustReturn1380() {
        Assert.assertEquals(1380, RomanToInteger.romanToInt("MCCCLXXX"));
    }

}
