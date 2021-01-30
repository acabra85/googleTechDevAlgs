package com.acabra.gtechdevalgs.google;

import com.acabra.gtechdevalgs.TestUtils;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class SkiperatorTest {

    @Test
    public void test_api_1() {
        List<Integer> objects = Arrays.asList(1, 2, 1, 3, 4, 1);
        Skiperator<Integer> skiperator = new Skiperator<>(objects.iterator());

        TestUtils.iAssertTrue(skiperator.hasNext());
        skiperator.skip(1);
        skiperator.skip(1);
        MatcherAssert.assertThat(2, Is.is(skiperator.next().intValue()));
        MatcherAssert.assertThat(3, Is.is(skiperator.next().intValue()));
        MatcherAssert.assertThat(4, Is.is(skiperator.next().intValue()));
        TestUtils.iAssertTrue(skiperator.hasNext());
        skiperator.skip(1);
        TestUtils.iAssertFalse(skiperator.hasNext());

    }

    @Test(expected = NoSuchElementException.class)
    public void test_api_2() {
        List<Integer> objects = Arrays.asList(1, 1, 1, 1, 1);
        Skiperator<Integer> skiperator = new Skiperator<>(objects.iterator());

        TestUtils.iAssertTrue(skiperator.hasNext());
        for (Integer object : objects) {
            skiperator.skip(object);
        }
        TestUtils.iAssertFalse(skiperator.hasNext());
        skiperator.next();
    }

}