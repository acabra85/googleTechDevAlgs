package com.acabra.gtechdevalgs.google;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaxRevenueTwoCities {

    /*
    Calculate the maximum revenue to be obtained by a seller in N days given revA and revB representing
    the daily revenue on each city (A B respectively) and a traveling fix cost between A and B travelCost.
    The revenue in a day can be made exclusively in one city.
     */
    public int maxRevenueRecursiveMemo(int[]revA, int[] revB, int travelCost) {
        return Math.max(
                recursive(true, 0,0, revA, revB,travelCost, new HashMap<>()),
                recursive(false, 0,0, revA, revB, travelCost, new HashMap<>())
        );
    }

    public int maxRevenueDP(int[] revA, int[] revB, int travelCost) {
        int n = revA.length;
        int[] resA = new int[n];
        int[] resB = new int[n];
        resA[0] = revA[0];
        resB[0] = revB[0];
        for (int i = 1; i < n; ++i) {
            resA[i] = Math.max(resA[i-1], resB[i-1] - travelCost) + revA[i];
            resB[i] = Math.max(resB[i-1], resA[i-1] - travelCost) + revB[i];
        }
        return Math.max(resA[n-1], resB[n-1]);
    }

    //TODO IMPLEMENT MEMOIZATION CORRECTLY!!
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

    //This exhaustive search just works for small values of n given that O(2^n)
    public int maxRevenueDFS(int[] revA, int[] revB, int travelCost) {
        Node max = null;
        Node node = null;
        Stack<Node> q = new Stack<>();
        q.push(new Node(revA[0], 0, true));
        q.push(new Node(revB[0], 0, false));
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
        return max.revenue;
    }

    static class Node {
        final int revenue;
        final int level;
        final boolean cityA;

        Node(int revenue, int level, boolean cityA) {
            this.revenue = revenue;
            this.level = level;
            this.cityA = cityA;
        }

        Node travel(int[] revA, int[] revB, int cost) {
            int value = (cityA ? revB : revA)[level+1];
            return new Node(revenue+value-cost, level+1, !cityA);
        }

        public Node stay(int[] revA, int[] revB) {
            int value = (cityA ? revA: revB)[level+1];
            return new Node(revenue + value, level + 1, cityA);
        }
    }
}
