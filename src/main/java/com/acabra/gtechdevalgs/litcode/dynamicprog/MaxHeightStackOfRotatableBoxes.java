package com.acabra.gtechdevalgs.litcode.dynamicprog;

import java.util.*;

public class MaxHeightStackOfRotatableBoxes {

    public int calculateMaxBoxesStackHeight(int[][] boxes) {
        sortCuboids(boxes);
        int[] dp = buildHeights(boxes);
        Map<Integer, Set<Integer>> canGo = buildCanGoMap(boxes);
        int tallest = 0;
        for (int i = dp.length - 1; i >= 0; --i) {
            Set<Integer> dest = canGo.get(i);
            if (dest != null && !dest.isEmpty()) {
                dp[i] += getMaxHeight(dest, dp);
            }
            tallest = Math.max(tallest, dp[i]);
        }
        return tallest;
    }

    private int getMaxHeight(Set<Integer> dest, int[] heights) {
        int max = 0;
        for (Integer elm : dest) {
            max = Math.max(max, heights[elm]);
        }
        return max;
    }

    private void sortCuboids(int[][] boxes) {
        for (int[] box : boxes) {
            Arrays.sort(box);
        }
        Arrays.sort(boxes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[2] == b[2] ?
                        a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1])
                        : Integer.compare(a[2], b[2]);
            }
        });
    }

    private int[] buildHeights(int[][] arr) {
        int[] h = new int[arr.length];
        int i = -1;
        for (int[] e : arr) {
            h[++i] = e[2];
        }
        return h;
    }

    private Map<Integer, Set<Integer>> buildCanGoMap(int[][] boxes) {
        Map<Integer, Set<Integer>> canGo = new HashMap<>();
        for (int i = 0; i < boxes.length; ++i) {
            for (int j = i + 1; j < boxes.length; ++j) {
                if (acceptOnTop(boxes[j], boxes[i])) {
                    canGo.putIfAbsent(i, new HashSet<>());
                    canGo.get(i).add(j);
                }
            }
        }
        return canGo;
    }

    private boolean acceptOnTop(int[] base, int[] top) {
        return top[0] <= base[0] && top[1] <= base[1] && top[2] <= base[2];
    }
}
