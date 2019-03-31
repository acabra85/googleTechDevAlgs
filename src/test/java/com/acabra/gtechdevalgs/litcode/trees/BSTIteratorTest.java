package com.acabra.gtechdevalgs.litcode.trees;

import com.acabra.gtechdevalgs.TestUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Describe your class
 */
public class BSTIteratorTest {

    @Test
    public void api_test_01() {
        TreeNode root = TestUtils.buildBSTFromString("7,3,15,null,null,9,20");
        BSTIterator bstIterator = new BSTIterator(root);
        Assert.assertEquals(3, bstIterator.next());    // return 3
        Assert.assertEquals(7, bstIterator.next());    // return 7
        Assert.assertTrue(bstIterator.hasNext()); // return true
        Assert.assertEquals(9, bstIterator.next());    // return 9
        Assert.assertTrue(bstIterator.hasNext()); // return true
        Assert.assertEquals(15, bstIterator.next());    // return 15
        Assert.assertTrue(bstIterator.hasNext()); // return true
        Assert.assertEquals(20, bstIterator.next());    // return 20
        Assert.assertFalse(bstIterator.hasNext()); // return false
    }

    @Test
    public void api_test_02() {
        TreeNode root = TestUtils.buildBSTFromString("3,1,4,null,2");
        BSTIterator bstIterator = new BSTIterator(root);
        Assert.assertEquals(1, bstIterator.next());    // return 1
        Assert.assertTrue(bstIterator.hasNext()); // return true
        Assert.assertEquals(2, bstIterator.next());    // return 2
        Assert.assertTrue(bstIterator.hasNext()); // return true
        Assert.assertEquals(3, bstIterator.next());    // return 3
        Assert.assertTrue(bstIterator.hasNext()); // return true
        Assert.assertEquals(4, bstIterator.next());    // return 4
        Assert.assertFalse(bstIterator.hasNext()); // return false
    }

    @Test
    public void api_test_03() {
        TreeNode root = TestUtils.buildBSTFromString("");
        BSTIterator bstIterator = new BSTIterator(root);
        Assert.assertFalse(bstIterator.hasNext()); // return false
    }

    @Test
    public void api_test_04() {
        TreeNode root = TestUtils.buildBSTFromString("5,3,6,1,4,null,null,null,2");
        BSTIterator bstIterator = new BSTIterator(root);
        Assert.assertEquals(1, bstIterator.next());    // return 1
        Assert.assertEquals(2, bstIterator.next());    // return 1
        Assert.assertEquals(3, bstIterator.next());    // return 1
        Assert.assertEquals(4, bstIterator.next());    // return 1
        Assert.assertEquals(5, bstIterator.next());    // return 1
        Assert.assertEquals(6, bstIterator.next());    // return 1
        Assert.assertFalse(bstIterator.hasNext()); // return false

    }
}
