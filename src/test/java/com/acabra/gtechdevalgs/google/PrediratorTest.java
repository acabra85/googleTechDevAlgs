package com.acabra.gtechdevalgs.google;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import static org.junit.Assert.*;

public class PrediratorTest {

    @Test
    public void test_api_1() {
        List<Integer> objects = Arrays.asList(1, 2, 1, 3, 4, 1);
        Predirator<Integer> predirator = new Predirator<>(objects.iterator(), new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return 1 == integer;
            }
        });

        Assert.assertTrue(predirator.hasNext());
        Assert.assertEquals(2, predirator.next().intValue());
        Assert.assertEquals(3, predirator.next().intValue());
        Assert.assertEquals(4, predirator.next().intValue());
        Assert.assertFalse(predirator.hasNext());

    }

    @Test(expected = NoSuchElementException.class)
    public void test_api_2() {
        List<Integer> objects = Arrays.asList(1, 1, 1, 1, 1);
        Predirator<Integer> predirator = new Predirator<>(objects.iterator(), new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return 1 == integer;
            }
        });
        Assert.assertFalse(predirator.hasNext());
        predirator.next();
    }
}