package com.acabra.gtechdevalgs.litcode.arrays;

import org.hamcrest.core.Is;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

public class FindInMountainTest {

    @Test
    public void findInMountainArray_shouldReturn0_0() {
        int target = 0;
        int expected = 0;
        FindInMountain.MountainArray mountain = FindInMountain.MountainArray.ofSize(15);
        MatcherAssert.assertThat(new FindInMountain().findInMountainArray(target, mountain), Is.is(expected));
    }

    @Test
    public void findInMountainArray_shouldReturn0_1() {
        int target = 0;
        int expected = 0;
        FindInMountain.MountainArray mountain = FindInMountain.MountainArray.of(new int[]{0,5,3,1});
        MatcherAssert.assertThat(new FindInMountain().findInMountainArray(target, mountain), Is.is(expected));
    }

    @Test
    public void findInMountainArray_shouldReturn2_1() {
        int target = 3;
        int expected = 2;
        FindInMountain.MountainArray mountain = FindInMountain.MountainArray.of(new int[]{1,2,3,4,5,3,1});
        MatcherAssert.assertThat(new FindInMountain().findInMountainArray(target, mountain), Is.is(expected));
    }

    @Test
    public void findInMountainArray_shouldReturn277() {
        int target = 277;
        int expected = 277;
        FindInMountain.MountainArray mountain = FindInMountain.MountainArray.ofSize(10000);
        MatcherAssert.assertThat(new FindInMountain().findInMountainArray(target, mountain), Is.is(expected));
    }

    @Test
    public void findInMountainArray_shouldReturn1() {
        int target = 5;
        int expected = 1;
        FindInMountain.MountainArray mountain = FindInMountain.MountainArray.of(new int[]{1,5,2});
        MatcherAssert.assertThat(new FindInMountain().findInMountainArray(target, mountain), Is.is(expected));
    }

    @Test
    public void findInMountainArray_shouldReturn5001() {
        int target = 24;
        int expected = 5001;
        FindInMountain.MountainArray mountain = FindInMountain.MountainArray.ofSize(25, 10000);
        MatcherAssert.assertThat(new FindInMountain().findInMountainArray(target, mountain), Is.is(expected));
    }

    @Test
    public void findInMountainArray_shouldNotFind1() {
        int target = 10000;
        int expected = -1;
        FindInMountain.MountainArray mountain = FindInMountain.MountainArray.ofSize(25, 10000);
        MatcherAssert.assertThat(new FindInMountain().findInMountainArray(target, mountain), Is.is(expected));
    }

    @Test
    public void findInMountainArray_shouldNotFind2() {
        int target = 8;
        int expected = -1;
        FindInMountain.MountainArray mountain = FindInMountain.MountainArray.ofSize(15);
        MatcherAssert.assertThat(new FindInMountain().findInMountainArray(target, mountain), Is.is(expected));
    }
}