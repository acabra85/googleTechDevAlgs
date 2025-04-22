package com.acabra.gtechdevalgs.litcode.dynamicprog;

import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class MaximizeProfitSales {
    static Comparator<List<Integer>> sorter = Comparator.comparingInt(a -> a.get(1));
    private record Offer(int start, int end, int gold) {
        static Offer of(List<Integer> vals) {
            return new Offer(vals.get(0),vals.get(1),vals.get(2));
        }
    }
    public int maximizeTheProfit(int n, List<List<Integer>> vals, boolean binarySearch) {
        if (vals == null || vals.isEmpty()) {
            return 0;
        }
        List<Offer> offers = vals.stream().sorted(sorter).map(Offer::of).toList();
        if (binarySearch) {
            return usingBinarySearch(offers);
        }
        return usingTreeMap(offers);
    }

    private int usingTreeMap(List<Offer> offers) {
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(-1, 0);

        for(Offer offer : offers){
            Integer maxProfitUpToCurrentOffer = dp.floorEntry(offer.start - 1).getValue();
            if(maxProfitUpToCurrentOffer != null){
                int goldIfOfferTaken = maxProfitUpToCurrentOffer + offer.gold;
                if(goldIfOfferTaken > dp.lastEntry().getValue()){
                    dp.put(offer.end, goldIfOfferTaken);
                }
            }
        }

        return dp.lastEntry().getValue();
    }

    private int usingBinarySearch(List<Offer> offers) {

        int m = offers.size();
        int[] dp = new int[m + 1];

        for (int i = 1; i <= m; ++i) {
            Offer currentOffer = offers.get(i - 1);
            int prevMaxGold = this.findMaxValue(offers, dp, i, currentOffer.start);
            // max including and excluding the current offer
            dp[i] = Math.max(dp[i - 1], currentOffer.gold + prevMaxGold);
        }
        return dp[m];
    }

    // Find the maximum amount of gold right before the current offer
    private int findMaxValue(List<Offer> offers, int[] dp, int i, int start) {
        int low = 0;
        int high = i - 2;
        int latestNonOverlapOfferIndex = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (offers.get(mid).end < start) {
                latestNonOverlapOfferIndex = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        int prevMaxGold = 0;
        if (latestNonOverlapOfferIndex != -1) {
            prevMaxGold = dp[latestNonOverlapOfferIndex + 1];
        }
        return prevMaxGold;
    }
}
