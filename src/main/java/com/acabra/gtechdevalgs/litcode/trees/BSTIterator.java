package com.acabra.gtechdevalgs.litcode.trees;


import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Describe your class
 */
public class BSTIterator {

    private final PriorityQueue<Integer> pq;

    public BSTIterator(TreeNode root) {
        pq = buildPQ(root);
    }

    private static PriorityQueue<Integer> buildPQ(TreeNode root) {
        PriorityQueue pq = new PriorityQueue<>();
        if (null == root) return pq;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            pq.offer(pop.val);
            if(pop.left != null) stack.push(pop.left);
            if(pop.right != null) stack.push(pop.right);
        }
        return pq;
    }


    public boolean hasNext() {
        return !pq.isEmpty();
    }

    public int next() {
        return pq.remove();
    }
}
