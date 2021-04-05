package com.acabra.gtechdevalgs.litcode.dynamicprog;

import com.acabra.gtechdevalgs.litcode.trees.TreeNode;
import java.util.HashMap;

public class RobHousesTree {


    /**
     * Find the maximum amount of money a thief can take by robbing houses
     * in a binary tree-arranged neighborhood without triggering the 'Neighbor Alarm'.
     * (The neighbor alarm is triggered when 2 directly connected houses are broken into).
     */
    public int rob(TreeNode root) {
        if (null == root) return 0;
        this.memoWith = new HashMap<>(10700);
        this.memoWithout = new HashMap<>(10700);
        return Math.max(solve(root, true), solve(root, false));
    }

    private int solve(TreeNode node, boolean mayTake) {
        if (null == node) return 0;
        HashMap<TreeNode, Integer> memo = mayTake ? memoWith : memoWithout;
        Integer integer = memo.get(node);
        if (integer != null) return integer;
        int withoutCurrentVal = solve(node.left, true) + solve(node.right, true);
        if(mayTake) {
            int withCurrentValue = node.val + solve(node.left, false) + solve(node.right, false);
            int max = Math.max(withCurrentValue, withoutCurrentVal);
            memoWith.put(node, max);
            return max;
        }
        memoWithout.put(node, withoutCurrentVal);
        return withoutCurrentVal;
    }

    private HashMap<TreeNode, Integer> memoWith;
    private HashMap<TreeNode, Integer> memoWithout;
}
