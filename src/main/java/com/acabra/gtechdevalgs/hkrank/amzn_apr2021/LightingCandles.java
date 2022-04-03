package com.acabra.gtechdevalgs.hkrank.amzn_apr2021;


import org.codehaus.groovy.runtime.DefaultGroovyMethods;

import java.util.*;
import java.util.stream.Collectors;

public class LightingCandles {

    private final Set<Integer> candlesBought;
    private final Map<Integer, Candle> candlesLit;

    public LightingCandles() {
        candlesBought = new HashSet<>();
        candlesLit = new HashMap<>();
    }

    /**
     * Finds the minimal amount of candles needed to be bought so that at every guest arrival
     * a minimal of minCandles are lit.
     * @param arrivals array representing the arrival times of guests
     * @param candleLife length of time a candle
     * @param minCandles the minimal amount of candles that have to be lit at every guest arrival
     * @return integer minimum candles needed to be bought
     */
    public int buyMinimumCandles(List<Integer> arrivals, int candleLife, int minCandles) {
        if(arrivals==null || arrivals.isEmpty()) return minCandles;
        List<Integer> arrivalsI = new ArrayList<>(arrivals);

        arrivalsI.sort(Integer::compareTo);
        int n = arrivalsI.size();

        int firstG = arrivalsI.get(0);
        attemptToLight(minCandles, firstG, candleLife);
        if(countLitCandles(firstG) < minCandles) return -1;

        for(int i=1;i<n;++i) {
            int guest = arrivalsI.get(i);
            int onFire = countLitCandles(guest);
            if(onFire < minCandles) {
                attemptToLight(minCandles - onFire, guest, candleLife);
                if(countLitCandles(guest) < minCandles) {
                    return -1;
                }
            }
        }
        return candlesBought.size();
    }
    private void attemptToLight(int reqAmount, int now, int candleLife) {
        for(int i=now-1,cIdx=0; cIdx<reqAmount && i >= 0 && i + candleLife >= now; --i,++cIdx){
            //cant fire candle 2 same instant
            if(!candlesBought.contains(i)) {
                candlesLit.put(i, new Candle(i, candleLife));
                candlesBought.add(i);
            }
        }
    }

    private int countLitCandles(int now) {
        candlesLit.values().stream()
                .filter(c -> c.isOff(now))
                .map(c -> c.litAt)
                .collect(Collectors.toList())
                .forEach(candlesLit::remove);
        return candlesLit.size();
    }

    static class Candle {
        final int litAt;
        final int ext;

        Candle(int l, int t) {
            this.litAt = l;
            this.ext = l + t;
        }
        boolean isOff(int now) {
            return now > ext;
        }

        public boolean equals(Object o) {
            if(o==null) return false;
            if(Candle.class == o.getClass()) {
                return ((Candle)o).litAt == litAt;
            }
            return false;
        }

        public int hashcode() {
            return litAt;
        }

    }
}
