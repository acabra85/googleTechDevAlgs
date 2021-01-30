package com.acabra.gtechdevalgs.litcode.trees;

import com.acabra.gtechdevalgs.TestUtils;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

public class LongestUnivaluePathTest {

    @Test
    public void test_1_should_return_2() {
        TreeNode root = TestUtils.buildBSTFromString("5,4,5,1,1,null,5");
        MatcherAssert.assertThat(2, Is.is(new LongestUnivaluePath().longestUnivaluePath(root)));
    }
    @Test
    public void test_2_should_return_0() {
        TreeNode root = TestUtils.buildBSTFromString(null);
        MatcherAssert.assertThat(0, Is.is(new LongestUnivaluePath().longestUnivaluePath(root)));
    }
    @Test
    public void test_3_should_return_1() {
        TreeNode root = TestUtils.buildBSTFromString("1,1");
        MatcherAssert.assertThat(1, Is.is(new LongestUnivaluePath().longestUnivaluePath(root)));
    }
    @Test
    public void test_4_should_return_0() {
        TreeNode root = TestUtils.buildBSTFromString("1");
        MatcherAssert.assertThat(0, Is.is(new LongestUnivaluePath().longestUnivaluePath(root)));
    }
    @Test
    public void test_5_should_return_2() {
        TreeNode root = TestUtils.buildBSTFromString("1,4,5,4,4,5");
        MatcherAssert.assertThat(2, Is.is(new LongestUnivaluePath().longestUnivaluePath(root)));
    }
    @Test
    public void test_6_should_return_2() {
        TreeNode root = TestUtils.buildBSTFromString("1,4,5,4,4,null,5");
        MatcherAssert.assertThat(2, Is.is(new LongestUnivaluePath().longestUnivaluePath(root)));
    }
    @Test
    public void test_7_should_return_4() {
        TreeNode root = TestUtils.buildBSTFromString("5,5,5,5,5,4,5");
        MatcherAssert.assertThat(4, Is.is(new LongestUnivaluePath().longestUnivaluePath(root)));
    }
}
