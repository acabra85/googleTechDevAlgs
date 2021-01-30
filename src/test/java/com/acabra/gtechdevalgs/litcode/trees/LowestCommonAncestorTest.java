package com.acabra.gtechdevalgs.litcode.trees;

import org.hamcrest.CoreMatchers;
import org.hamcrest.core.Is;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import com.acabra.gtechdevalgs.litcode.trees.LowestCommonAncestor.TreeNode;

public class LowestCommonAncestorTest {

    private LowestCommonAncestor underTest;

    @Before
    public void setUp() throws Exception {
        underTest = new LowestCommonAncestor();
    }

    @Test
    public void shouldReturnItSelf() {
        LowestCommonAncestor.TreeNode root = buildTree_singleNode();
        LowestCommonAncestor.TreeNode actual = underTest.lowestCommonAncestor(root, TreeNode.of(10), TreeNode.of(10));
        MatcherAssert.assertThat(actual.val, Is.is(root.val));
    }

    @Test
    public void shouldReturnNullOneNodeInExistent() {
        LowestCommonAncestor.TreeNode root = buildTree_singleNode();
        LowestCommonAncestor.TreeNode actual = underTest.lowestCommonAncestor(root, TreeNode.of(10), TreeNode.of(11));
        MatcherAssert.assertThat(actual, CoreMatchers.nullValue());
    }

    @Test
    public void shouldReturnNullBothNodesInExistent() {
        LowestCommonAncestor.TreeNode root = buildTree_singleNode();
        LowestCommonAncestor.TreeNode actual = underTest.lowestCommonAncestor(root, TreeNode.of(12), TreeNode.of(11));
        MatcherAssert.assertThat(actual, CoreMatchers.nullValue());
    }

    @Test
    public void shouldReturnRootAsParent() {
        LowestCommonAncestor.TreeNode root = buildTree_twoChildren();
        LowestCommonAncestor.TreeNode actual = underTest.lowestCommonAncestor(root, TreeNode.of(12), TreeNode.of(11));
        MatcherAssert.assertThat(actual.val, Is.is(root.val));
    }

    @Test
    public void shouldReturnRightChildOfRootAsParent() {
        LowestCommonAncestor.TreeNode root = buildTree_manyNodes();
        LowestCommonAncestor.TreeNode actual = underTest.lowestCommonAncestor(root, TreeNode.of(2), TreeNode.of(3));
        MatcherAssert.assertThat(actual.val, Is.is(root.right.val));
    }

    private LowestCommonAncestor.TreeNode buildTree_manyNodes() {
        LowestCommonAncestor.TreeNode root = LowestCommonAncestor.TreeNode.of(10);
        root.left = LowestCommonAncestor.TreeNode.of(5);
        root.right = LowestCommonAncestor.TreeNode.of(8);
        root.right.right = LowestCommonAncestor.TreeNode.of(3);
        root.right.left = LowestCommonAncestor.TreeNode.of(7);
        root.right.left.right = LowestCommonAncestor.TreeNode.of(2);
        return root;
    }

    private LowestCommonAncestor.TreeNode buildTree_twoChildren() {
        LowestCommonAncestor.TreeNode root = LowestCommonAncestor.TreeNode.of(10);
        root.left = LowestCommonAncestor.TreeNode.of(12);
        root.right = LowestCommonAncestor.TreeNode.of(11);
        return root;
    }

    private LowestCommonAncestor.TreeNode buildTree_singleNode() {
        return LowestCommonAncestor.TreeNode.of(10);
    }
}