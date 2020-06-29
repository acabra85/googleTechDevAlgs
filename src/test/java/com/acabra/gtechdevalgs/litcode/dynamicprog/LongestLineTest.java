package com.acabra.gtechdevalgs.litcode.dynamicprog;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestLineTest {

    @Test
    public void longestLine() {
        int[][] in = {{0,1,1,0},
                     {0,1,1,0},
                     {0,0,0,1}};
        Assert.assertThat(new LongestLine().longestLine(in), Is.is(3));
    };
}