package com.acabra.gtechdevalgs.litcode;

import java.util.*;

public class KEmptySlots {

    /**
     * Determines the day 2 flowers k-slots apart are blooming.
     * @param flowers the position and schedule pairOf blooming flowers
     * @param k the amount pairOf slots for the flowers to be apart
     * @return the day when 2 flowers that are k-slots apart are blooming or -1 if not possible
     */
    public int kEmptySlots(int[] flowers, int k) {
        if(null == flowers || k < 0 || (k > flowers.length - 2) ) return -1;

        TreeSet<Integer> bloomingFlowers = new TreeSet<>();
        bloomingFlowers.add(flowers[0]);
        bloomingFlowers.add(flowers[1]);
        Pair pair = pairOf(Integer.min(flowers[0], flowers[1]), Integer.max(flowers[0], flowers[1]));
        Integer distance = pair.getDistance();
        if (distance == k) return 2;
        for (int day = 2; day < flowers.length; day++) {
            bloomingFlowers.add(flowers[day]);
            if (reconcileDistances(flowers[day], bloomingFlowers, k)) {
                return day + 1;
            }
        }
        return -1;
    }

    private boolean reconcileDistances(int newPos, TreeSet<Integer> bloomingFlowers, int k) {
        Integer x  = bloomingFlowers.lower(newPos);
        Integer y  = bloomingFlowers.higher(newPos);
        if (null == x || null == y) { //not affecting blooming distance
            Pair newPair = null == x ? pairOf(newPos, y) : pairOf(x, newPos);
            int distance = newPair.getDistance();
            if (distance == k) {
                return true;
            }
        } else { //new bloom between existing blooms
            Pair oldPair = pairOf(x, y);
            Pair lowPair = oldPair.prepend(newPos);
            int distLow = lowPair.getDistance();
            if (distLow == k) {
                return true;
            }
            Pair hiPair = oldPair.append(newPos);
            int distHi = hiPair.getDistance();
            if (distHi == k) {
                return true;
            }
        }
        return false;
    }

    static Pair pairOf(int x, int y) {
        return new Pair(x, y);
    }

    private static class Pair {
        final int x;
        final int y;

        private Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        Pair append(int newPos) {
            return new Pair(x, newPos);
        }

        Pair prepend(int newPos) {
            return new Pair(newPos, y);
        }

        Integer getDistance() {
            return y - x - 1;
        }
    }
}
