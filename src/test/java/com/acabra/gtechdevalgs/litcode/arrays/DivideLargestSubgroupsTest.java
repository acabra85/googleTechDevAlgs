package com.acabra.gtechdevalgs.litcode.arrays;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

public class DivideLargestSubgroupsTest {

    @Test
    public void test_01() {
        int[] ints = {5, 6, 7};
        char[] chars = {'a', 'b', 'c', 'a', 'b',
                'e', 'd', 'f', 'd', 'd', 'e',
                'j', 'h', 'g', 'h', 'g', 'j', 'g' };
        MatcherAssert.assertThat(ints, Is.is(new DivideLargestSubgroups().findSubgroups(chars)));
    }

    @Test
    public void test_02() {
        int[] ints = {1, 1, 1};
        char[] chars = {'a', 'b', 'c'};
        MatcherAssert.assertThat(ints, Is.is(new DivideLargestSubgroups().findSubgroups(chars)));
    }

    @Test
    public void test_03() {
        int[] ints = {3, 1};
        char[] chars = {'a', 'b', 'a', 'c'};
        MatcherAssert.assertThat(ints, Is.is(new DivideLargestSubgroups().findSubgroups(chars)));
    }

    @Test
    public void test_04() {
        int[] ints = {6};
        char[] chars = {'a', 'b', 'c', 'a', 'c', 'b'};
        MatcherAssert.assertThat(ints, Is.is(new DivideLargestSubgroups().findSubgroups(chars)));
    }

    @Test
    public void test_05() {
        int[] ints = {9, 7, 8};
        char[] chars = {'a', 'b', 'a', 'b', 'c', 'b', 'a', 'c', 'a',
                'd', 'e', 'f', 'e', 'g', 'd', 'e',
                'h', 'i', 'j', 'h', 'k', 'l', 'i', 'j'
        };
        MatcherAssert.assertThat(ints, Is.is(new DivideLargestSubgroups().findSubgroups(chars)));
    }
}
