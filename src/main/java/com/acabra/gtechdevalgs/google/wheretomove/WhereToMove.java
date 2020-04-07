package com.acabra.gtechdevalgs.google.wheretomove;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WhereToMove {
    private static final boolean DEBUG_MODE = false;

    /**
     * Find the building where to move to minimize the maximum walking distance to all your interests.
     * Given an array of buildings with available attractions and unlimited housing on each and your list of interest
     * find such building, if two or more buildings match the optimal walking distance "a tie" choose the building
     * that matches more interests, if all match the same amount then return the first seen.
     */
    public static CandidateBuilding findBuildingToMove(Building[] street, List<Interest> interests) {
        if (interests == null || interests.isEmpty() || null == street || street.length == 0) return null;
        if (interests.size() == 1) {
            return linearFindBuilding(street, interests.get(0));
        }
        return findBuildingToMoveBudget(street, interests);
    }

    /**
     * The idea here is to attempt to move to every building in the street, and for every building have a
     * restricted budget of walking distance that increases until all interests are reached and then attempts
     * the next building taking into consideration the available budget will be less than the previous one.
     * @param street the street to move
     * @param moverInterests the interests of the mover
     * @return an integer representing the index of the building where to move
     */
    private static CandidateBuilding findBuildingToMoveBudget(Building[] street, List<Interest> moverInterests) {
        CandidateBuilding candidate = null;
        int maxWalkDistanceToAll = street.length;
        for (int idx = 0; idx < street.length; idx++) {
            int moving = moving(idx, street, moverInterests, maxWalkDistanceToAll);
            if (-1 == moving) {
                if (maxWalkDistanceToAll == street.length) {
                    return null;
                }
            } else {
                maxWalkDistanceToAll = Math.min(maxWalkDistanceToAll, moving);
            }
            if (null == candidate || candidate.distanceToAll > maxWalkDistanceToAll) {
                candidate = CandidateBuilding.of(maxWalkDistanceToAll, idx);
            }
        }
        return candidate;
    }

    private static int moving(int idx, Building[] street, List<Interest> moverInterests, int maxBudget) {
        for (int budget = 0; budget < maxBudget; ++budget) {
            log(String.format("****idx:%d, bud:%d", idx, budget));
            if (canReachAllInterestsWithinBudget(idx, street, moverInterests, budget)) {
                return budget;
            }
        }
        return -1;//could not meet his interests in the current street
    }

    private static boolean canReachAllInterestsWithinBudget(int idx, Building[] street, List<Interest> moverInterests, int budget) {
        int start = Math.max(0, idx - budget);
        int end = Math.min(idx + budget, street.length - 1);
        log(String.format("from:%d to:%d", start, end));
        Set<Interest> interestSet = new HashSet<>(moverInterests);
        for (int i = start; i <= end && !interestSet.isEmpty(); i++) {
            interestSet.removeAll(street[i].availableInterests());
            log(String.format("checked building:%d interest:%d", i, interestSet.size()));
        }
        return interestSet.isEmpty();
    }

    private static void log(String str) { if (DEBUG_MODE) {System.out.println(str);} }

    protected static class CandidateBuilding {
        final int distanceToAll;
        final int buildingIndex;

        private CandidateBuilding(int distanceToAll, int buildingIndex) {
            this.distanceToAll = distanceToAll;
            this.buildingIndex = buildingIndex;
        }

        public static CandidateBuilding of(int distanceToAll, int idx) {
            return new CandidateBuilding(distanceToAll, idx);
        }

        @Override
        public String toString() {
            return String.format("idx:%d, maxWalk:%d", buildingIndex, distanceToAll);
        }
    }

    private static CandidateBuilding linearFindBuilding(Building[] street, Interest interest) {
        for (int i = 0; i < street.length; i++) {
            if (street[i].hasInterest(interest)) {
                log("distance 0");
                return CandidateBuilding.of(0, i);
            }
        }
        return null;
    }
}
