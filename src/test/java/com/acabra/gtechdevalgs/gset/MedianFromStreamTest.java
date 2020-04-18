package com.acabra.gtechdevalgs.gset;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.LongBinaryOperator;

import com.google.common.base.Stopwatch;
import org.junit.Assert;
import org.junit.Test;

public class MedianFromStreamTest {

    private AtomicLong totalBF = new AtomicLong();
    private AtomicLong totalFast = new AtomicLong();

    /**
     * For 10 items Brute force is ~1600 times slower than Fast implementation
     * For 100 items Brute force is ~400 times slower than Fast implementation
     * For 1000 items Brute force is ~50 times slower than Fast implementation
     * For 10000 items Brute force is ~100 times slower than Fast implementation
     * For 100000 items Brute force is ~1300 times slower than Fast implementation
     */
    @Test
    public void test_api() {
        MedianFromStream median = new MedianFromStream();
        SecureRandom sr = new SecureRandom();
        int CAP = 100000;
        List<Double> nums = new ArrayList<>(CAP);
        double expected;
        LongBinaryOperator OP = new LongBinaryOperator() {
            @Override
            public long applyAsLong(long left, long right) {
                return left + right;
            }
        };
        double actual;
        for (int i = 0; i < CAP; i++) {
            double num = sr.nextDouble();
            median.accept(num);
            nums.add(num);
            Stopwatch bf = Stopwatch.createStarted();
            expected = calculateMedian(nums);
            totalBF.accumulateAndGet(bf.stop().elapsed(TimeUnit.NANOSECONDS), OP);
            Stopwatch fast = Stopwatch.createStarted();
            actual = median.getMedian();
            totalFast.accumulateAndGet(fast.stop().elapsed(TimeUnit.NANOSECONDS), OP);
            Assert.assertEquals(expected, actual, 0.01);
        }
        System.out.println("  bf: " + totalBF);
        System.out.println("fast: " + totalFast);
        System.out.println("factor of: " + (totalBF.get() * 1.0 / (totalFast.get() * 1.0)));
    }

    private static double calculateMedian(List<Double> nums) {
        nums.sort(Double::compareTo);
        int mid = nums.size() / 2;
        if(nums.size() % 2 == 0) {
            return (nums.get(mid - 1) + nums.get(mid)) / 2.0;
        }
        return nums.get(mid);
    }
}
