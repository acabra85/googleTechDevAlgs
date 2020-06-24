package com.acabra.gtechdevalgs.litcode.trees;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FindRemainingForestTest {

    @Test
    public void delNodes() {
        int[] to_delete = {3, 5};
        FindRemainingForest.TreeNode root = buildBinaryTree();
        List<FindRemainingForest.TreeNode> treeNodes = new FindRemainingForest().delNodes(root, to_delete);
        Assert.assertEquals(3, treeNodes.size());
    }

    @Test
    public void delNodes_iterative() {
        int[] to_delete = {3, 5};
        FindRemainingForest.TreeNode root = buildBinaryTree();
        List<FindRemainingForest.TreeNode> treeNodes = new FindRemainingForest().delNodesIterative(root, to_delete);
        Assert.assertEquals(3, treeNodes.size());
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