package com.acabra.gtechdevalgs.litcode.dynamicprog;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class MaximizeProfitSales {public int maximizeTheProfit(int n, List<List<Integer>> ints) {
    List<Offer> offers = ints.stream()
            .map((e)-> new Offer(e))
            .collect(Collectors.toList());
    Sales sales = new Sales(n);
    for(int i=0;i<ints.size();++i) {
        if (sales.canSell(offers.get(i))) {
            sales.sell(offers.get(i));
        }
    }
    return sales.cash;
}

    record Range(int from, int to, int size) implements Comparable<Range> {
        List<Range> split(int x) {
            if (from >= x && x <= to) {
                return List.of(
                        new Range(from, x, x - from),
                        new Range(x+1, to, to -x -1)
                );
            }
            throw new NullPointerException("Cant split range at :" + x);
        }
        public int compareTo(Range o) {
            return this.from - o.from;
        }
        static Range of(int iStart, int iEnd) {
            return new Range(iStart, iEnd, iEnd-iStart+1);
        }

        public boolean intersects(Range o) {
            return pointBelongs(o.from) || pointBelongs(o.to);
        }

        public boolean pointBelongs(int p) {
            return this.from <= p && p <= this.to;
        }
    }

    static class Sales {
        private final TreeSet<Range> sold;
        private int cash = 0;
        Sales(int n) {
            this.sold = new TreeSet<>();
        }
        void sell(Offer offer) {
            this.sold.add(offer.range);
            cash += offer.cash;
        }
        boolean canSell(Offer offer) {
            for(Range r : sold) {
                if (r.intersects(offer.range) || offer.range.intersects(r)) {
                    return false;
                }
            }
            return true;
        }
    }

    static class Offer {
        private final Range range;
        private final int cash;
        Offer(List<Integer> args){
            this.range = Range.of(args.get(0), args.get(1));
            this.cash =args.get(2);
        }
        public String toString() {
            return String.format("R:{%s}, g:%d", range, cash);
        }
    }
}
