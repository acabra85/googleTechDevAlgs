package com.acabra.gtechdevalgs.litcode.arrays;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

public class FindIndexFirstUniqueCharTest {

    @Test
    public void should_return_0_test_1() {
        String str = "leetcode";
        MatcherAssert.assertThat(0, Is.is(new FindIndexFirstUniqueChar().findIndexFirstUnique(str)));
    }

    @Test
    public void should_return_2_test_2() {
        String str = "loveleetcode";
        MatcherAssert.assertThat(2, Is.is(new FindIndexFirstUniqueChar().findIndexFirstUnique(str)));
    }

    @Test
    public void should_return_0_test_fast_1() {
        String str = "leetcode";
        MatcherAssert.assertThat(0, Is.is(new FindIndexFirstUniqueChar().findIndexFirstUnique_fast(str)));
    }

    @Test
    public void should_return_2_test_fast_2() {
        String str = "loveleetcode";
        MatcherAssert.assertThat(2, Is.is(new FindIndexFirstUniqueChar().findIndexFirstUnique_fast(str)));
    }

    @Test
    public void should_return_2_test_fast_3() {
        String str = "z";
        MatcherAssert.assertThat(0, Is.is(new FindIndexFirstUniqueChar().findIndexFirstUnique_fast(str)));
    }
}
