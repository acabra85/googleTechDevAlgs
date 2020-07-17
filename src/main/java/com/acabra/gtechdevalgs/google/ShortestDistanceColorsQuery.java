package com.acabra.gtechdevalgs.google;

import java.util.ArrayList;
import java.util.List;

public class ShortestDistanceColorsQuery {

    /**
     * Given an array containing references to colors and a queries array
     * where a query is (idx, color) return the answer of the queries
     * indicating the minimum distance to the query.color from the query.idx.
     * if color is not found -1 is returned.
     * e.g.
     * Array Colors-> [1,1,2,1,3,2,2,3,3]
     * Queries -> [[1,3],[2,2],[6,1]]
     * Answer->  {3,0,3}
     */
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        List<Integer> ans = new ArrayList(queries.length);
        for(int[] query: queries) {
            ans.add(find(query[0], query[1], colors));
        }
        return ans;
    }

    private int find(int idx, int qColor, int[] colors) {
        if (idx >= 0 && idx < colors.length) {
            if (qColor == colors[idx]) {
                return 0;
            }
            int left = findLeft(idx, qColor, colors);
            int right = findRight(idx, qColor, colors);
            if (left == -1) return right;
            if (right == -1) return left;
            return Math.min(left, right);
        }
        return -1;

    }

    private  int findRight(int idx, int qColor, int[] colors) {
        int d = 0;
        for(int i = idx ; i<colors.length;++i, ++d) {
            if (colors[i] == qColor) {
                return d;
            }
        }
        return -1;
    }

    private  int findLeft(int idx, int qColor, int[] colors) {
        int d = 0;
        for(int i = idx ; i >= 0;--i, ++d) {
            if (colors[i] == qColor) {
                return d;
            }
        }
        return -1;
    }
}
