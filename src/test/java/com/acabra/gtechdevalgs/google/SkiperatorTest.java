package com.acabra.gtechdevalgs.google;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import static org.junit.Assert.*;

public class SkiperatorTest {

    @Test
    public void test_api_1() {
        List<Integer> objects = Arrays.asList(1, 2, 1, 3, 4, 1);
        Skiperator<Integer> skiperator = new Skiperator<>(objects.iterator());

        Assert.assertTrue(skiperator.hasNext());
        skiperator.skip(1);
        skiperator.skip(1);
        Assert.assertEquals(2, skiperator.next().intValue());
        Assert.assertEquals(3, skiperator.next().intValue());
        Assert.assertEquals(4, skiperator.next().intValue());
        Assert.assertTrue(skiperator.hasNext());
        skiperator.skip(1);
        Assert.assertFalse(skiperator.hasNext());

    }

    @Test(expected = NoSuchElementException.class)
    public void test_api_2() {
        List<Integer> objects = Arrays.asList(1, 1, 1, 1, 1);
        Skiperator<Integer> skiperator = new Skiperator<>(objects.iterator());

        Assert.assertTrue(skiperator.hasNext());
        for (Integer object : objects) {
            skiperator.skip(object);
        }
        Assert.assertFalse(skiperator.hasNext());
        skiperator.next();
    }

}