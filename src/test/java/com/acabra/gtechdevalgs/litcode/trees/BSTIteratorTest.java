package com.acabra.gtechdevalgs.litcode.trees;

import com.acabra.gtechdevalgs.TestUtils;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

/**
 * Describe your class
 */
public class BSTIteratorTest {

    @Test
    public void api_test_01() {
        TreeNode root = TestUtils.buildBSTFromString("7,3,15,null,null,9,20");
        BSTIterator bstIterator = new BSTIterator(root);
        MatcherAssert.assertThat(3, Is.is(bstIterator.next()));
        MatcherAssert.assertThat(7, Is.is(bstIterator.next()));
        TestUtils.iAssertTrue(bstIterator.hasNext());
        MatcherAssert.assertThat(9, Is.is(bstIterator.next()));
        TestUtils.iAssertTrue(bstIterator.hasNext());
        MatcherAssert.assertThat(15, Is.is(bstIterator.next()));
        TestUtils.iAssertTrue(bstIterator.hasNext());
        MatcherAssert.assertThat(20, Is.is(bstIterator.next()));
        TestUtils.iAssertFalse(bstIterator.hasNext());
    }

    @Test
    public void api_test_02() {
        TreeNode root = TestUtils.buildBSTFromString("3,1,4,null,2");
        BSTIterator bstIterator = new BSTIterator(root);
        MatcherAssert.assertThat(1, Is.is(bstIterator.next()));
        TestUtils.iAssertTrue(bstIterator.hasNext());
        MatcherAssert.assertThat(2, Is.is(bstIterator.next()));
        TestUtils.iAssertTrue(bstIterator.hasNext());
        MatcherAssert.assertThat(3, Is.is(bstIterator.next()));
        TestUtils.iAssertTrue(bstIterator.hasNext());
        MatcherAssert.assertThat(4, Is.is(bstIterator.next()));
        TestUtils.iAssertFalse(bstIterator.hasNext());
    }

    @Test
    public void api_test_03() {
        TreeNode root = TestUtils.buildBSTFromString("");
        BSTIterator bstIterator = new BSTIterator(root);
        TestUtils.iAssertFalse(bstIterator.hasNext());
    }

    @Test
    public void api_test_04() {
        TreeNode root = TestUtils.buildBSTFromString("5,3,6,1,4,null,null,null,2");
        BSTIterator bstIterator = new BSTIterator(root);
        MatcherAssert.assertThat(1, Is.is(bstIterator.next()));
        MatcherAssert.assertThat(2, Is.is(bstIterator.next()));
        MatcherAssert.assertThat(3, Is.is(bstIterator.next()));
        MatcherAssert.assertThat(4, Is.is(bstIterator.next()));
        MatcherAssert.assertThat(5, Is.is(bstIterator.next()));
        MatcherAssert.assertThat(6, Is.is(bstIterator.next()));
        TestUtils.iAssertFalse(bstIterator.hasNext());

    }
}
