package com.acabra.gtechdevalgs.google;

import java.util.*;

public class NumberOfIslands2UnionFind {

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        if (positions == null || positions.length < 1) return Collections.emptyList();

        List<Integer> res = new ArrayList<>(positions.length);
        UnionFind unionFind = new UnionFind(m, n);
        for(int[] pos: positions) {
            res.add(addLand(pos[0], pos[1], unionFind));
        }
        return res;
    }

    public int addLand(int i, int j, UnionFind unionFind) {
        int id = unionFind.calcId(i, j);
        if (!unionFind.isPresent(id)) {
            unionFind.set(id);
            int neighborId = 0;
            if (j - 1 >= 0) {
                neighborId = id -1;
                if(unionFind.isPresent(neighborId)) {
                    unionFind.join(id, neighborId);
                }
            }
            if (j + 1 < unionFind.cols) {
                neighborId = id + 1;
                if(unionFind.isPresent(neighborId)) {
                    unionFind.join(id, neighborId);
                }
            }
            neighborId = id - unionFind.cols;
            if(unionFind.isPresent(neighborId)) {
                unionFind.join(id, neighborId);
            }
            neighborId = id + unionFind.cols;
            if(unionFind.isPresent(neighborId)) {
                unionFind.join(id, neighborId);
            }
        }
        return unionFind.getIslandCount();
    }

    private static class UnionFind {

        final int[] union;
        final int[] rank;
        private final int cols;
        private int islandCount;
        private boolean[] cells;

        UnionFind(int M, int N) {
            int n = M * N;
            this.cols = N;
            this.union = new int[n];
            this.rank = new int[n];
            this.cells = new boolean[n];
            this.islandCount = 0;
            for(int i=0; i<n;i++) {
                this.union[i] = i;
                this.rank[i] = -1;
            }
        }

        int find(int x) {
            int index = x;
            while (index != union[index]) {
                index = union[index];
            }

            int tmp = x;
            while (tmp != union[tmp]) {
                int p = union[tmp];
                union[tmp] = index;
                tmp = p;
            }
            return index;
        }

        int calcId(int i, int j) {
            return this.cols*i + j;
        }

        void join(int rootId, int neighborId) {
            int rIdx = find(rootId);
            int nIdx = find(neighborId);
            if (nIdx != rIdx) {
                if (rank[nIdx] >= rank[rIdx]) {
                    rank[nIdx] += rank[rIdx];
                    union[rIdx] = nIdx;
                } else {
                    rank[rIdx] += rank[nIdx];
                    union[nIdx] = rIdx;
                }
                --this.islandCount;
            }
        }

        public int getIslandCount() {
            return this.islandCount;
        }

        public boolean isPresent(int id) {
            return valid(id) && cells[id];
        }

        private boolean valid(int id) {
            return id >= 0 && id < this.rank.length;
        }

        public void set(int id) {
            cells[id] = true;
            ++this.islandCount;
        }
    }

}
