package com.acabra.gtechdevalgs.google;

import java.util.Collection;
import java.util.Map;
import java.util.Stack;

public class MaxRevenueTwoCities {

    /*
    Calculate the maximum revenue to be obtained by a seller in N days given revA and revB representing
    the daily revenue on each city (A B respectively) and a traveling fix cost between A and B travelCost.
    The revenue in a day can be made exclusively in one city.
     */
    //TODO FIX IMPLEMENTATIONS DP and RECURSIVE and enable back tests
    public int maxRevenue(int[]revA, int[] revB, int travelCost, boolean recursive) {
        return recursive ?
                recursive(true, 0, 0, revA, revB, travelCost,null)
                : dp(revA, revB, travelCost);
    }

    private int dp(int[] revA, int[] revB, int travelCost) {
        int n = revA.length;
        int[] resA = new int[n];
        int[] resB = new int[n];
        resA[0] = revA[0];
        resB[0] = revB[0];
        for (int i = 1; i < n; ++i) {
            resA[i] = resA[i-1] + Math.max(revA[i], revB[i] - travelCost);
            resB[i] = resB[i-1] + Math.max(revB[i], revA[i] - travelCost);
        }
        return Math.max(resA[n-1], resB[n-1]);
    }

    private int recursive(boolean cityA, int day, int revenue,
                          int[] a, int[] b, int cost, Map<String, Integer> cache) {
        if(day == a.length) {
            return revenue;
        }
        if(cityA) {
            return revenue + Math.max(
                    recursive(true, day + 1, a[day], a, b, cost, cache),
                    recursive(false, day + 1, a[day] - cost, a, b, cost, cache)
            );
        }
        return revenue + Math.max(
                recursive(false, day + 1, b[day], a, b, cost, cache),
                recursive(true, day + 1, b[day] - cost, a, b, cost, cache)
        );
    }

    public int maxRevenueDFS(int[] revA, int[] revB, int travelCost) {
        Node max = null;
        Node node = null;
        Stack<Node> q = new Stack<>();
        q.push(new Node(revA[0], 0, true, ""));
        q.push(new Node(revB[0], 0, false, ""));
        while(!q.isEmpty()) {
            node = q.pop();
            if(max == null || node.revenue > max.revenue) {
                max = node;
            }
            if(node.level+1 < revA.length) {
                q.push(node.stay(revA, revB));
                q.push(node.travel(revA, revB, travelCost));
            }
        }
        System.out.println(max.toString());
        return max.revenue;
    }

    static class Node {
        final int revenue;
        final int level;
        final boolean cityA;
        StringBuilder sb;

        Node(int revenue, int level, boolean cityA, String old) {
            this.revenue = revenue;
            this.level = level;
            this.cityA = cityA;
            sb = new StringBuilder(old);
            sb.append((cityA ? "A" : "B")).append(level)
                    .append("_").append(revenue).append("->");
        }

        Node travel(int[] revA, int[] revB, int cost) {
            int value = (cityA ? revB : revA)[level+1];
            return new Node(revenue+value-cost, level+1, !cityA, toString());
        }

        public Node stay(int[] revA, int[] revB) {
            int value = (cityA ? revA: revB)[level+1];
            return new Node(revenue + value, level + 1, cityA, toString());
        }

        @Override
        public String toString() {
            return sb.toString();
        }
    }
}
