package com.acabra.gtechdevalgs.litcode.trees;

import java.util.ArrayDeque;

/**
 * Lowest common ancestor (p) between two nodes (a,b) is the lowest node containing
 * a and b as descendants (considering each node to be descendent of itself).
 */
public class LowestCommonAncestor {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        static TreeNode of(int id) {
            TreeNode n = new TreeNode();
            n.left = null;
            n.right = null;
            n.val = id;
            return n;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode na, TreeNode nb) {

        int a = na.val;
        int b = nb.val;
        if (a == b && root.val == b) return root; //root has no parent

        ArrayDeque<ExtendedNode> q = new ArrayDeque<>();
        q.push(new ExtendedNode(root, null));
        ExtendedNode nodeA = null;
        ExtendedNode nodeB = null;
        while (q.size() > 0 && (nodeA == null || nodeB == null)) {
            ExtendedNode pNode = q.poll();
            TreeNode poll = pNode.node;
            if (poll.val == a) {
                nodeA = pNode;
            }
            if (poll.val == b) {
                nodeB = pNode;
            }
            if (poll.left != null) {
                q.offer(ExtendedNode.of(poll.left, pNode));
            }
            if (poll.right != null) {
                q.offer(ExtendedNode.of(poll.right, pNode));
            }
        }
        if (nodeA == null || nodeB == null) {
            return null; // no LCA as unable to find both nodes within the given tree
        }
        if (nodeA == nodeB) return nodeA.node;
        while(nodeA.level > nodeB.level) {
            nodeA = nodeA.parent;
        }
        while (nodeB.level > nodeA.level) {
            nodeB = nodeB.parent;
        }
        while(nodeA.node.val != nodeB.node.val) {
            nodeA = nodeA.parent;
            nodeB = nodeB.parent;
        }
        return nodeA.node;
    }

    static class ExtendedNode {
        final TreeNode node;
        final ExtendedNode parent;
        final int level;

        ExtendedNode(TreeNode node, ExtendedNode parent) {
            this.node = node;
            this.parent = parent;
            this.level = null == parent ? 0 : parent.level + 1;
        }

        static ExtendedNode of(TreeNode node, ExtendedNode parent) {
            return new ExtendedNode(node, parent);
        }
    }

}
