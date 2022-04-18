package com.acabra.gtechdevalgs.social;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class MinimizePermutations {
    private static class Node {
        final int[] val;
        final int level;
        final String id;
        Node(int[] _val, int _level) {
            this.val = _val;
            this.level = _level;
            this.id = asString(_val);
        }

        Node child(int from, int to) {
            int[] clone = val.clone();
            for(; from < to; ++from, --to) {
                int tmp = clone[from];
                clone[from] = clone[to];
                clone[to] = tmp;
            }
            return new Node(clone, level+1);
        }
    }

    private static String asString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(arr).forEach(sb::append);
        return sb.toString();
    }

    /*
    Given an array from 1 to N, return the minimal permutations** required to have the array sorted.
    A permutation is to take a sub-array (i to k with i>=0 and k<= length of array) and reverse it
     */
    public int minOperations(int[] arr) {
        String target = asString(IntStream.rangeClosed(1, arr.length).toArray());
        return bfs(target, arr);
    }

    private int bfs(String target, int[] arr){
        ArrayDeque<Node> dq = new ArrayDeque<>();
        Set<String> seen = new HashSet<>();
        Node node = new Node(arr, 0);
        dq.add(node);
        seen.add(node.id);
        while(!dq.isEmpty()) {
            Node removed = dq.remove();
            if(target.equals(removed.id)) {
                return removed.level;
            }
            Node pos = addChildren(removed, dq, seen, target);
            if(pos!= null) return pos.level;
        }
        return -1;
    }

    private Node addChildren(Node r, ArrayDeque<Node> dq, Set<String> seen, String target) {
        for(int i = 0;i<r.val.length;++i) {
            for(int j = i+1; j< r.val.length;++j) {
                Node child = r.child(i, j);
                if(!seen.contains(child.id)) {
                    if(child.id.equals(target)) {
                        return child;
                    }
                    seen.add(child.id);
                    dq.add(child);
                }
            }
        }
        return null;
    }
}
