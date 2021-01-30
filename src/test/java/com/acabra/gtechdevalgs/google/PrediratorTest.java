package com.acabra.gtechdevalgs.google;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

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

        MatcherAssert.assertThat(predirator.hasNext(), Is.is(true));
        MatcherAssert.assertThat(2, Is.is(predirator.next()));
        MatcherAssert.assertThat(3, Is.is(predirator.next()));
        MatcherAssert.assertThat(4, Is.is(predirator.next()));
        MatcherAssert.assertThat(predirator.hasNext(), Is.is(false));

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
        MatcherAssert.assertThat(predirator.hasNext(), Is.is(false));
        predirator.next();
    }
}