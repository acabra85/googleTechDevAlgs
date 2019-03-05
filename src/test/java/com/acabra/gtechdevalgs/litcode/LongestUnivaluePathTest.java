package com.acabra.gtechdevalgs.litcode;

import com.acabra.gtechdevalgs.TestUtils;
import org.junit.Assert;
import org.junit.Test;

public class LongestUnivaluePathTest {

    @Test
    public void test_1_should_return_2() {
        LongestUnivaluePath.TreeNode root = TestUtils.buildTreeForLongestUnivaluePath("5,4,5,1,1,null,5");
        Assert.assertEquals(2, new LongestUnivaluePath().longestUnivaluePath(root));
    }
    @Test
    public void test_2_should_return_0() {
        LongestUnivaluePath.TreeNode root = TestUtils.buildTreeForLongestUnivaluePath(null);
        Assert.assertEquals(0, new LongestUnivaluePath().longestUnivaluePath(root));
    }
    @Test
    public void test_3_should_return_1() {
        LongestUnivaluePath.TreeNode root = TestUtils.buildTreeForLongestUnivaluePath("1,1");
        Assert.assertEquals(1, new LongestUnivaluePath().longestUnivaluePath(root));
    }
    @Test
    public void test_4_should_return_0() {
        LongestUnivaluePath.TreeNode root = TestUtils.buildTreeForLongestUnivaluePath("1");
        Assert.assertEquals(0, new LongestUnivaluePath().longestUnivaluePath(root));
    }
    @Test
    public void test_5_should_return_2() {
        LongestUnivaluePath.TreeNode root = TestUtils.buildTreeForLongestUnivaluePath("1,4,5,4,4,5");
        Assert.assertEquals(2, new LongestUnivaluePath().longestUnivaluePath(root));
    }
    @Test
    public void test_6_should_return_2() {
        LongestUnivaluePath.TreeNode root = TestUtils.buildTreeForLongestUnivaluePath("1,4,5,4,4,null,5");
        Assert.assertEquals(2, new LongestUnivaluePath().longestUnivaluePath(root));
    }
    @Test
    public void test_7_should_return_4() {
        LongestUnivaluePath.TreeNode root = TestUtils.buildTreeForLongestUnivaluePath("5,5,5,5,5,4,5");
        Assert.assertEquals(4, new LongestUnivaluePath().longestUnivaluePath(root));
    }
}
