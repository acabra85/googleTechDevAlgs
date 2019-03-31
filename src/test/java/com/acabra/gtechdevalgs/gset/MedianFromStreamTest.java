package com.acabra.gtechdevalgs.gset;

import org.junit.Assert;
import org.junit.Test;

public class MedianFromStreamTest {

    @Test
    public void test_api() {
        MedianFromStream median = new MedianFromStream();
        median.add(1.0);
        median.add(2.0);
        Assert.assertEquals(1.5, median.getMedian(), 0.001);
        median.add(3.0);
        Assert.assertEquals(2.0, median.getMedian(), 0.001);
    }
}
