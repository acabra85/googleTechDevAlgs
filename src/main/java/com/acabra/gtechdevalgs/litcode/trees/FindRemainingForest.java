package com.acabra.gtechdevalgs.litcode.trees;
import java.util.*;

public class FindRemainingForest {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int i) {
            this.val = i;
            this.left = null;
            this.right = null;
        }

        public String toString() {
            return "v: " + val  + " [ " +(left==null?"_":left.val)+", "+(right==null?"_":right.val)+"]";
        }
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> remainingForest = new LinkedList<>();
        Set<Integer> deleteSet = new HashSet<>();
        for(int del: to_delete) {
            deleteSet.add(del);
        }

        removeNode(root, deleteSet, remainingForest);
        if (!deleteSet.contains(root.val)) {
            remainingForest.add(root);
        }
        return remainingForest;
    }


    public List<TreeNode> delNodesIterative(TreeNode root, int[] to_delete) {
        List<TreeNode> remainingForest = new LinkedList<>();
        Set<Integer> deleteSet = new HashSet<>();
        for(int del: to_delete) {
            deleteSet.add(del);
        }

        Stack<TreeNode> q = new Stack<>();
        q.push(root);
        TreeNode tmp = null;
        while(!q.isEmpty()) {
            tmp = q.pop();
            if (deleteSet.contains(tmp.val)) {
                if(tmp.left != null && !deleteSet.contains(tmp.left.val)) {
                    remainingForest.add(tmp.left);
                }
                if(tmp.right != null && !deleteSet.contains(tmp.right.val)) {
                    remainingForest.add(tmp.right);
                }
            }
            if(tmp.right != null) {
                q.push(tmp.right);
                if (deleteSet.contains(tmp.right.val)) {
                    tmp.right = null;
                }
            }
            if(tmp.left != null) {
                q.push(tmp.left);
                if (deleteSet.contains(tmp.left.val)) {
                    tmp.left = null;
                }
            }
        }

        if (!deleteSet.contains(root.val)) {
            remainingForest.add(root);
        }
        return remainingForest;
    }

    public TreeNode removeNode(TreeNode root, Set<Integer> deleteSet, List<TreeNode> remainingForest) {

        if (root == null) {
            return null;
        }

        root.left = removeNode(root.left, deleteSet, remainingForest);
        root.right = removeNode(root.right, deleteSet, remainingForest);

        if(deleteSet.contains(root.val)) {
            if(root.right != null) {
                remainingForest.add(root.right);
            }
            if(root.left != null) {
                remainingForest.add(root.left);
            }
            return null;
        }
        return root;
    }
}