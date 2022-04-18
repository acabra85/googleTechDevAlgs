package com.acabra.gtechdevalgs.social;

import java.util.*;

public class SmallestArrayInKSwaps {
    static class Node {
        final String id;
        final int[] val;
        final int level;

        Node(int[] val, int level) {
            this.level = level;
            this.val = val;
            this.id = buildId(val);
        }

        int compareTo(Node o) {
            for(int i=0;i<val.length;++i) {
                if(val[i] != o.val[i]) {
                    return val[i] < o.val[i] ? -1 : 1;
                }
            }
            return 0;
        }

        Node child(int i, int j) {
            int[] clone = val.clone();
            clone[i] ^= clone[j];
            clone[j] ^= clone[i];
            clone[i] ^= clone[j];
            return new Node(clone, level+1);
        }

        Collection<Node> children(Set<String> seen) {
            List<Node> children = new ArrayList<>();
            for(int i=0,j=1; j<val.length;++i,++j) {
                Node child = child(i, j);
                if(!seen.contains(child.id)) {
                    children.add(child);
                    seen.add(child.id);
                }
            }
            return children;
        }

        static String buildId(int[] arr) {
            StringBuilder sb = new StringBuilder();
            Arrays.stream(arr).forEach(sb::append);
            return sb.toString();
        }
    }

    /*
    Given a sequence of n integers arr, determine the lexicographically smallest sequence which may be
    obtained from it after performing at most k element swaps, each involving a pair of consecutive elements
    in the sequence.
    Note: A list x is lexicographically smaller than a different equal-length list y if and only if,
    for the earliest index at which the two lists differ, x's element at that index is smaller than
    y's element at that index.
    */
    int[] findMinArray(int[] arr, int k) {
        if (arr == null || arr.length == 0 || arr.length == 1 || k <= 0) {
            return arr;
        }
        Set<String> seen = new HashSet<>();
        ArrayDeque<Node> dq = new ArrayDeque<>();
        Node node = new Node(arr, 0);
        seen.add(node.id);
        dq.add(node);
        Node smallest = null;
        while(!dq.isEmpty()){
            node = dq.remove();
            if(node.level == k) {
                if(smallest == null) {
                    smallest = node;
                } else if(node.compareTo(smallest) < 0) {
                    smallest = node;
                }
            } else if(node.level < k) {
                dq.addAll(node.children(seen));
            }
        }
        return smallest.val;
    }
}
