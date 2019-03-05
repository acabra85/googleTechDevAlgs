package com.acabra.gtechdevalgs.litcode;

public class LongestUnivaluePath {

    public int longestUnivaluePath(TreeNode root) {
        int[] maxLength = new int[1];
        pLength(root, maxLength);
        return maxLength[0];
    }

    private int pLength(TreeNode root, int[] maxLength) {
        if(root == null) return 0;
        int l = pLength(root.left, maxLength);
        int r = pLength(root.right, maxLength);
        int lLenght = 0;
        int rLenght = 0;
        if (root.left != null && root.left.val == root.val) {
            lLenght += l + 1;
        }
        if (root.right != null && root.right.val == root.val){
            rLenght += r + 1;
        }
        maxLength[0] = Math.max(maxLength[0], rLenght + lLenght);
        return Math.max(lLenght, rLenght);
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }
}
