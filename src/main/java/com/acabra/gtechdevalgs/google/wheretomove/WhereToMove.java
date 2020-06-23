package com.acabra.gtechdevalgs.google.wheretomove;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class WhereToMove {
    private static final boolean DEBUG_MODE = false;
    private static final boolean ARTUR = true;

    static AtomicInteger at0 = new AtomicInteger(0);

    /**
     * Find the building where to move to minimize the maximum walking distance to all your interests.
     * Given an array of buildings with available attractions and unlimited housing on each and your list of interest
     * find such building, if two or more buildings match the optimal walking distance "a tie" choose any such building.
     */
    public static CandidateBuilding findBuildingToMove(Building[] street, List<Interest> interests) {
        if (interests == null || interests.isEmpty() || null == street || street.length == 0) return null;
        if (interests.size() == 1) {
            return linearFindBuilding(street, interests.get(0));
        }
        return ARTUR ? new WhereToMoveArtur().findBuildingToMove(street, interests):  findBuildingToMoveBudget(street, interests);
    }

    /**
     * The idea here is to attempt to move to every building in the street, and for every building have a
     * restricted budget of walking distance starting from zero until all interests are reached (or length of the
     * street is reached).
     * The budget to move to the next building will be one less than the minimum budget used to reach all interest
     * by moving to the previous building.
     * e.g.
     * interest: {A, C}
     * Street: [{}, {}, {}, {A}, {C}]  //buildings represented by sets containing zero or more interest
     * Expected Answer is 3 or 4 since moving to those buildings will give a maximum walking distance of 1 to reach
     * all interests.
     * Note that the algorithm first will attempt to move to the first building and will be able to reach all interests
     * with a budget of 4 (walking distance from building 0 to last building 4), when iterating to the next candidate
     * building (1), the maximum budget allowed will be 3 (1 less than the previous budget in the previous building)
     *
     * @param street the street to move
     * @param moverInterests the interests of the mover
     * @return an integer representing the index of the building where to move
     */
    private static CandidateBuilding findBuildingToMoveBudget(Building[] street, List<Interest> moverInterests) {
        CandidateBuilding candidate = null;
        int maxWalkDistanceToAll = street.length;
        // speeds up the run by ignoring to move to the first n-buildings where no interests where present.
        boolean fastForward = false;
        for (int idx = start(moverInterests, street); idx < street.length; ++idx) {
            ReachAnswer moving = moving(idx, street, moverInterests, maxWalkDistanceToAll);
            if (null == moving && idx == 0) { //unable to find his interests on the street
                System.out.println("total:"+ at0.get());
                return null;
            }
            if (null != moving && moving.foundWithinBudget) {
                maxWalkDistanceToAll = Math.min(maxWalkDistanceToAll, moving.budget);
                if (null == candidate || candidate.distanceToAll > maxWalkDistanceToAll) {
                    candidate = CandidateBuilding.of(maxWalkDistanceToAll, idx);
                    if (candidate.distanceToAll == 0) {
                        System.out.println("total:"+ at0.get());
                        return candidate;
                    }
                }
                if (!fastForward) {
                    fastForward = true;
                    if (idx != moving.idxFirstMatch) {
                        idx = moving.idxFirstMatch - 1;
                    }
                }
            }
        }
        System.out.println("total:"+ at0.get());
        return candidate;
    }

    private static int start(List<Interest> moverInterests, Building[] street) {
        for (int i = 0; i < street.length; i++) {
            for (Interest interest : moverInterests) {
                at0.getAndIncrement();
                if (street[i].availableInterests().contains(interest)) {
                    return i;
                }
            }
        }
        return street.length;
    }

    private static ReachAnswer moving(int idx, Building[] street, List<Interest> moverInterests, int maxBudget) {
        for (int budget = 0; budget < maxBudget; ++budget) {
            ReachAnswer reachAnswer = canReachAllInterestsWithinBudget(idx, street, moverInterests, budget);
            if (reachAnswer.foundWithinBudget) {
                return reachAnswer;
            }
        }
        return null;//could not meet his interests in the current street
    }

    private static ReachAnswer canReachAllInterestsWithinBudget(int idx, Building[] street, List<Interest> moverInterests, int budget) {
        int start = Math.max(0, idx - budget);
        int end = Math.min(idx + budget, street.length - 1);
        Set<Interest> interestSet = new HashSet<>(moverInterests);
        int idFirstInterestFound = -1;
        for (int i = start; i <= end && !interestSet.isEmpty(); ++i) {
            at0.getAndIncrement();
            if (interestSet.removeAll(street[i].availableInterests()) && idFirstInterestFound == -1) {
                idFirstInterestFound = i;
            }
        }
        return ReachAnswer.of(interestSet.isEmpty(), idFirstInterestFound, budget);
    }

    private static class ReachAnswer {
        final boolean foundWithinBudget;
        final int budget;
        final int idxFirstMatch;

        private ReachAnswer(boolean foundWithinBudget, int idxFirstMatch, int budget) {
            this.foundWithinBudget = foundWithinBudget;
            this.idxFirstMatch = idxFirstMatch;
            this.budget = budget;
        }
        static ReachAnswer of(boolean foundWithinBudget, int idxFirstMatch, int budget) {
            return new ReachAnswer(foundWithinBudget, idxFirstMatch, budget);
        }
    }

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
                return CandidateBuilding.of(0, i);
            }
        }
        return null;
    }
}
