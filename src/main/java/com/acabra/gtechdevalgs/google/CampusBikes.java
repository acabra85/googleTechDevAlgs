package com.acabra.gtechdevalgs.google;

import java.util.*;

public class CampusBikes {

    static class Info {
        final int dist;
        final int wIdx;
        final int bIdx;

        Info(int dist, int wIdx, int bIdx) {
            this.dist = dist;
            this.wIdx = wIdx;
            this.bIdx = bIdx;
        }
    }

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        PriorityQueue<Info> pq = new PriorityQueue<Info>(new Comparator<Info>() {
            // {dist, workerIdx, bikeIdx}
            @Override
            public int compare(Info o1, Info o2) {
                return o1.dist != o2.dist ? o1.dist - o2.dist : (o1.wIdx != o2.wIdx ? o1.wIdx - o2.wIdx : o1.bIdx - o2.bIdx);
            }
        });

        for (int i = 0; i < workers.length; ++i) {
            for (int j = 0; j < bikes.length; ++j) {
                pq.offer(new Info(manhattanDistance(workers[i], bikes[j]), i, j));
            }
        }

        int[] ans = new int[workers.length];
        boolean[] isWorkerWaiting = new boolean[workers.length];
        boolean[] isBikeReserved = new boolean[bikes.length];
        int assigned = 0;

        Info tmp = null;
        while (assigned < workers.length) {
            tmp = pq.remove();
            if (!isWorkerWaiting[tmp.wIdx] && !isBikeReserved[tmp.bIdx]) {
                isWorkerWaiting[tmp.wIdx] = true;
                isBikeReserved[tmp.bIdx] = true;
                ans[tmp.wIdx] = tmp.bIdx;
                ++assigned;
            }
        }
        return ans;
    }

    private static int manhattanDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}
