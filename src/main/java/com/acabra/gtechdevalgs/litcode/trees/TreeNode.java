package com.acabra.gtechdevalgs.litcode.trees;

/**
 * Describe your class
 */
public class TreeNode {

    public final int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return (left!=null ? left.val : ".")  + "@"+ val+"@"+(right!=null?right.val:".") ;
    }
}
