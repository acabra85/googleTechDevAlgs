package com.acabra.gtechdevalgs.litcode.arrays;

import org.junit.Assert;
import org.junit.Test;

public class FindIndexFirstUniqueCharTest {

    @Test
    public void should_return_0_test_1() {
        String str = "leetcode";
        Assert.assertEquals(0, new FindIndexFirstUniqueChar().findIndexFirstUnique(str));
    }

    @Test
    public void should_return_2_test_2() {
        String str = "loveleetcode";
        Assert.assertEquals(2, new FindIndexFirstUniqueChar().findIndexFirstUnique(str));
    }

    @Test
    public void should_return_0_test_fast_1() {
        String str = "leetcode";
        Assert.assertEquals(0, new FindIndexFirstUniqueChar().findIndexFirstUnique_fast(str));
    }

    @Test
    public void should_return_2_test_fast_2() {
        String str = "loveleetcode";
        Assert.assertEquals(2, new FindIndexFirstUniqueChar().findIndexFirstUnique_fast(str));
    }

    @Test
    public void should_return_2_test_fast_3() {
        String str = "z";
        Assert.assertEquals(0, new FindIndexFirstUniqueChar().findIndexFirstUnique_fast(str));
    }
}
