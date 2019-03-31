package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BullsCows {


    public String getHint(String secret, String guess) {
        Map<Character, Set<Integer>> mapToIndex = new HashMap<>();
        Map<Character, Integer> mapCount = new HashMap<>();
        Character charAt;
        for (int i = 0; i < secret.length(); i++) {
            charAt = secret.charAt(i);
            mapToIndex.putIfAbsent(charAt, new HashSet<>());
            mapToIndex.get(charAt).add(i);
            mapCount.merge(charAt, 1, (a, b) -> a + b);
        }
        int bulls = 0;
        int cows = 0;
        //check for bulls
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < guess.length(); i++) {
            charAt = guess.charAt(i);
            if (isBull(mapToIndex, mapCount, charAt, i)) {
                mapCount.put(charAt, mapCount.get(charAt) - 1);
                visited.add(i);
                bulls++;
            }
        }
        //check for cows
        for (int i = 0; i < guess.length(); i++) {
            if (!visited.contains(i)) {
                charAt = guess.charAt(i);
                if (isCow(mapToIndex, mapCount, charAt)) {
                    mapCount.put(charAt, mapCount.get(charAt) - 1);
                    cows++;
                }
            }
        }
        return String.format("%dA%dB", bulls, cows);
    }

    private boolean isCow(Map<Character, Set<Integer>> mapToIndex, Map<Character, Integer> mapCount, Character charAt) {
        return mapToIndex.containsKey(charAt) && mapCount.get(charAt) > 0;
    }

    private boolean isBull(Map<Character, Set<Integer>> mapToIndex, Map<Character, Integer> mapCount, Character charAt, int i) {
        return mapToIndex.containsKey(charAt) && mapCount.get(charAt) > 0 && mapToIndex.get(charAt).contains(i);
    }
}
