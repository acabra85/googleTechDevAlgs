package com.acabra.gtechdevalgs.google.wheretomove;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class WhereToMove {
    private static final boolean DEBUG_MODE = false;
    private static final boolean ARTUR = true;

    static AtomicInteger at0 = new AtomicInteger(0);

    /**
     * Find the building where to move to minimize the maximum walking distance to all your interests.
     * Given an array of buildings with available attractions and unlimited housing on each and your list of interest
     * find such building, if two or more buildings match the optimal walking distance "a tie" choose the
     * one with closest to the 0-index building.
     */
    public static CandidateBuilding findBuildingToMove(Building[] street, List<Interest> interests) {
        if (interests == null || interests.isEmpty() || null == street || street.length == 0) return null;
        if (interests.size() == 1) {
            return linearFindBuilding(street, interests.getFirst());
        }
        return ARTUR
                ? new WhereToMoveArtur().findBuildingToMove(street, interests)
                : internalFindBuildingToMove(street, interests);
    }

    /**
     *
     * @param street the street to move
     * @param moverInterests the interests of the mover
     * @return an integer representing the index of the building where to move
     */
    private static CandidateBuilding internalFindBuildingToMove(Building[] street, List<Interest> moverInterests) {
        Set<Interest> allInterests = new HashSet<>();
        IntStream.range(0, street.length).forEach(i -> allInterests.addAll(street[i].availableInterests()));
        for (Interest moverInterest : moverInterests) {
            if (!allInterests.contains(moverInterest)) {
                return null;
            }
        }
        // precompute interests per building
        Map<Interest, TreeSet<Integer>> interestToBuildings =  new HashMap<>();
        for (Interest moverInterest : moverInterests) {
            final TreeSet<Integer> tree = new TreeSet<>();
            for (int i = 0; i < street.length; ++i) {
                if (street[i].hasInterest(moverInterest)) {
                    tree.add(i);
                }
            }
            interestToBuildings.put(moverInterest, tree);
        }
        final CandidateBuilding[] c = new CandidateBuilding[1];
        IntStream.range(0, street.length).forEach(i -> {
            Building b = street[i];
            int dist = Integer.MIN_VALUE;
            for (Interest moverInterest : moverInterests) {
                int curr = -1;
                if (b.hasInterest(moverInterest)) {
                    curr = 0;
                } else {
                    curr = getSmallestDistance(interestToBuildings.get(moverInterest), i);
                }
                dist = Math.max(dist, curr);
            }
            if (c[0] == null || dist < c[0].distanceToAll) {
                c[0] = new CandidateBuilding(dist, i);
            }
        });
        return c[0];
    }

    private static int getSmallestDistance(TreeSet<Integer> tree, int idx) {
        int lower = Integer.MAX_VALUE;
        int higher = Integer.MAX_VALUE;
        final Integer lo = tree.lower(idx);
        if (lo != null) {
            lower = Math.min(lower, Math.abs(idx - lo));
        }
        final Integer hi = tree.higher(idx);
        if (hi != null) {
            higher = Math.min(higher, Math.abs(idx - hi));
        }
        return Math.min(lower, higher);
    }

    public record CandidateBuilding(int distanceToAll,int buildingIndex){}

    private static CandidateBuilding linearFindBuilding(Building[] street, Interest interest) {
        for (int i = 0; i < street.length; i++) {
            if (street[i].hasInterest(interest)) {
                return new CandidateBuilding(0, i);
            }
        }
        return null;
    }
}
