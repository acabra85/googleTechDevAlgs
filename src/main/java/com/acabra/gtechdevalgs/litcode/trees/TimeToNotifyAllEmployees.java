package com.acabra.gtechdevalgs.litcode.trees;

import java.util.*;
import java.util.function.Function;

/**
 Given ceoId of a company and the time it takes for a given manager to notify all their reports and the employee array
 representing the boss (ceo has no boss so boss[ceoId] = -1) determine the time it takes for the ceo of the company
 (identified by ceoId) to notify all the employess of the
 company
 */
public class TimeToNotifyAllEmployees {
    private static class TreeNode {
        TreeNode mgr;
        final int id;
        List<TreeNode> emps;

        void addEmployee(TreeNode emp) {
            if (emps == null) {
                emps = new ArrayList<>();
            }
            emps.add(emp);
        }
        List<TreeNode> getEmps() {
            if (emps == null) {
                emps = new ArrayList<>();
            }
            return emps;
        }

        TreeNode(int id) {
            this.id = id;
            this.mgr = null;
            this.emps = null;
        }
    }
    private static Function<Integer, TreeNode> b = new Function<Integer, TreeNode>() {
        public TreeNode apply(Integer i) {
            return new TreeNode(i);
        }
    };

    private static class Pair2 {
        final TreeNode node;
        final int time;
        Pair2(TreeNode n, int time){
            this.node = n;
            this.time = time;
        }
    }

    public int timeToNotifyAll(int n, int ceoId, int[] boss, int[] informTime) {
        Map<Integer, TreeNode> map = new HashMap<>();
        for(int i=0;i<n;++i) {
            TreeNode self = map.computeIfAbsent(i, b);
            if(i != ceoId){
                map.computeIfAbsent(boss[i], b)
                        .addEmployee(self);
            }
        }
        int max = Integer.MIN_VALUE;
        Queue<Pair2> q = new LinkedList<>();
        q.add(new Pair2(map.get(ceoId), informTime[ceoId]));
        Pair2 pair;
        while(!q.isEmpty()) {
            pair = q.remove();
            max = Math.max(max, pair.time);
            if (!pair.node.getEmps().isEmpty()) {
                for(TreeNode curr: pair.node.getEmps()) {
                    q.add(new Pair2(curr, pair.time + informTime[curr.id]));
                }
            }
        }
        return max;
    }
}
