package com.acabra.gtechdevalgs.litcode.trees;

import edu.umd.cs.findbugs.ClassAnnotation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class FindRemainingForestTest {

    private FindRemainingForest.TreeNode root;

    @Before
    public void setup(){
        root = buildBinaryTree();
    }

    @After
    public void tearDown() {
        root = null;
    }

    @Test
    public void delNodes() {
        int[] to_delete = {3, 5};
        List<FindRemainingForest.TreeNode> treeNodes = new FindRemainingForest().delNodes(root, to_delete);
        Assert.assertEquals(3, treeNodes.size());
        Set<Integer> validAnswer = new HashSet<Integer>(){{
            add(1);
            add(7);
            add(6);
        }};
        for (FindRemainingForest.TreeNode treeNode : treeNodes) {
            Assert.assertTrue(validAnswer.contains(treeNode.val));
        }
    }

    @Test
    public void delNodes_iterative() {
        int[] to_delete = {3, 5};
        List<FindRemainingForest.TreeNode> treeNodes = new FindRemainingForest().delNodesIterative(root, to_delete);
        Assert.assertEquals(3, treeNodes.size());
        Set<Integer> validAnswer = new HashSet<Integer>(){{
            add(1);
            add(7);
            add(6);
        }};
        for (FindRemainingForest.TreeNode treeNode : treeNodes) {
            Assert.assertTrue(validAnswer.contains(treeNode.val));
        }
    }

    @Test
    public void delNodes__2() {
        int[] to_delete = {2, 3};
        List<FindRemainingForest.TreeNode> treeNodes = new FindRemainingForest().delNodes(buildBinaryTree2(), to_delete);
        Assert.assertEquals(2, treeNodes.size());
        Set<Integer> validAnswer = new HashSet<Integer>(){{
            add(1);
            add(4);
        }};
        for (FindRemainingForest.TreeNode treeNode : treeNodes) {
            Assert.assertTrue(validAnswer.contains(treeNode.val));
        }
    }

    @Test
    public void delNodes_iterative_2() {
        int[] to_delete = {2, 3};
        List<FindRemainingForest.TreeNode> treeNodes = new FindRemainingForest().delNodesIterative(buildBinaryTree2(), to_delete);
        Assert.assertEquals(2, treeNodes.size());
        Set<Integer> validAnswer = new HashSet<Integer>(){{
            add(1);
            add(4);
        }};
        for (FindRemainingForest.TreeNode treeNode : treeNodes) {
            Assert.assertTrue(validAnswer.contains(treeNode.val));
        }
    }

    private FindRemainingForest.TreeNode buildBinaryTree2() {
        FindRemainingForest.TreeNode root = new FindRemainingForest.TreeNode(1);
        FindRemainingForest.TreeNode n2 = new FindRemainingForest.TreeNode(2);
        FindRemainingForest.TreeNode n3 = new FindRemainingForest.TreeNode(3);
        FindRemainingForest.TreeNode n4 = new FindRemainingForest.TreeNode(4);

        root.left = n2;
        root.right = null;

        n2.left = n3;
        n2.right = n4;

        return root;
    }

    private FindRemainingForest.TreeNode buildBinaryTree() {
        FindRemainingForest.TreeNode root = new FindRemainingForest.TreeNode(1);
        FindRemainingForest.TreeNode n2 = new FindRemainingForest.TreeNode(2);
        FindRemainingForest.TreeNode n3 = new FindRemainingForest.TreeNode(3);
        FindRemainingForest.TreeNode n4 = new FindRemainingForest.TreeNode(4);
        FindRemainingForest.TreeNode n5 = new FindRemainingForest.TreeNode(5);
        FindRemainingForest.TreeNode n6 = new FindRemainingForest.TreeNode(6);
        FindRemainingForest.TreeNode n7 = new FindRemainingForest.TreeNode(7);

        root.left = n2;
        root.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        return root;
    }
}