package com.acabra.gtechdevalgs.litcode.dynamicprog;

import java.util.*;

public class HireWorkers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        PriorityQueue<Worker> workers = new PriorityQueue<>();
        for (int i = 0; i < wage.length; i++) {
            workers.offer(new Worker(quality[i], wage[i]));
        }
        Double ans = Double.POSITIVE_INFINITY;
        int sum  = 0;
        PriorityQueue<Integer> pool = new PriorityQueue<>();
        while (workers.size() > 0) {
            Worker worker = workers.remove();
            pool.offer(-worker.quality);
            sum += worker.quality;
            if (pool.size() > K) sum += pool.poll();
            if (pool.size() == K) ans = Math.min(ans, sum * worker.ratio);
        }
        return ans;
    }

    class Worker implements Comparable<Worker> {

        public final double ratio;
        public final int quality;
        public final int wage;

        public Worker(int quality, int wage) {
            this.quality = quality;
            this.wage = wage;
            this.ratio = (double) wage / quality;
        }

        @Override
        public int compareTo(Worker o) {
            return Double.compare(this.ratio, o.ratio);
        }
    }
}
