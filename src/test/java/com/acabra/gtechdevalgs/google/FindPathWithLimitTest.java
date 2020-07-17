package com.acabra.gtechdevalgs.google;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FindPathWithLimitTest {

    private FindPathWithLimit underTest;

    @Before
    public void setUp() {
        underTest = new FindPathWithLimit();
    }
    @Test
    public void isTherePathNotExceedingLimit() {
        int[][] in = {
                {1,2,1,1,1},
                {1,2,1,3,1},
                {1,2,1,3,1},
                {1,3,1,3,1},
                {1,1,1,3,1}
        };
        Assert.assertThat(underTest.hasAValidPathToTarget(in, 0), Is.is(true));
    }

    @Test
    public void isTherePathNotExceedingLimit2() {
        int[][] in = {
                {1,2,1,4,4,5},
                {1,4,2,5,3,5},
                {1,4,1,5,2,5},
                {1,4,2,5,2,5},
                {1,4,4,4,3,5},
                {1,1,1,1,6,4}
        };
        Assert.assertThat(underTest.hasAValidPathToTarget(in, 1), Is.is(true));
    }
}