package com.acabra.gtechdevalgs.google.wheretomove;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WhereToMove {
    /**
     * Find the building where to move to minimize the maximum walking distance to all your interests.
     * Given an array of buildings with available attractions and unlimited housing on each and your list of interest
     * find such building, if two or more buildings match the optimal walking distance "a tie" choose the building
     * that matches more interests, if all match the same amount then return the first seen.
     */
    public static int findBuildingToMove(Building[] street, List<Interest> interests) {
        if (interests == null || interests.isEmpty() || null == street || street.length == 0) return -1;
        if (interests.size() == 1) {
            return linearFindBuilding(street, interests.get(0));
        }
        return findBuildingToMoveBF(street, interests);
    }

    /**
     * Goes to every building and calculates the maximum walking distance to all interest places from that building,
     * then returns the building that will render with the minimal walking distance to all interests
     * @param street the buildings in the street
     * @param interests the interests of the person looking to move to the street
     * @return -1 if the street does not contain all interest otherwise the building index in the street.
     */
    private static int findBuildingToMoveBF(Building[] street, List<Interest> interests) {
        CandidateBuilding candidate = null;
        int maxWalkDistanceToAll = Integer.MIN_VALUE;
        for (int i = 0; i < street.length; i++) {//
            Set<Interest> interestTx = new HashSet<>(interests);
            for (int j = i + 1; j < street.length && !interestTx.isEmpty(); j++) {
                if (interestTx.removeAll(street[j].availableInterests())) {
                    maxWalkDistanceToAll = Math.max(maxWalkDistanceToAll,  Math.abs(j - i));
                }
            }
            for (int j = i; j >=0 && !interestTx.isEmpty(); j--) {
                if (interestTx.removeAll(street[j].availableInterests())) {
                    maxWalkDistanceToAll = Math.max(maxWalkDistanceToAll,  Math.abs(j - i));
                }
            }
            if (Integer.MIN_VALUE == maxWalkDistanceToAll) {
                return -1;
            }
            if (candidate == null) {
                candidate = new CandidateBuilding(maxWalkDistanceToAll, i);
            } else {
                if (maxWalkDistanceToAll < candidate.distanceToAll) {
                    candidate = new CandidateBuilding(maxWalkDistanceToAll, i);
                } else if (maxWalkDistanceToAll == candidate.distanceToAll) {
                    int amountSharedInterestCandidateBuilding = street[candidate.buildingIndex].countSharedInterests(interests);
                    int amountSharedInterestCurrentBuilding = street[i].countSharedInterests(interests);
                    if (amountSharedInterestCurrentBuilding > amountSharedInterestCandidateBuilding) {
                        candidate = new CandidateBuilding(maxWalkDistanceToAll, i);
                    }
                }
            }
            interestTx.addAll(interests);
            maxWalkDistanceToAll = Integer.MIN_VALUE;
        }
        return candidate == null ? -1 : candidate.buildingIndex;
    }

    private static class CandidateBuilding {
        final int distanceToAll;
        final int buildingIndex;

        CandidateBuilding(int distanceToAll, int buildingIndex) {
            this.distanceToAll = distanceToAll;
            this.buildingIndex = buildingIndex;
        }
    }

    private static int linearFindBuilding(Building[] street, Interest interest) {
        for (int i = 0; i < street.length; i++) {
            if (street[i].hasInterest(interest)) {
                return i;
            }
        }
        return -1;
    }
}
