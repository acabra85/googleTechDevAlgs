package com.acabra.gtechdevalgs.google.wheretomove;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author kaarchib korartyr@gmail.com
 */
public class WhereToMoveArtur {

    private AtomicInteger at0 = new AtomicInteger(0);

    public int[] findBuildingToMove(List<String>[] street, List<String> interests) {
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> myInterests = new HashSet<>();

        for (String s : interests) myInterests.add(s);
        int interestsCount = 0;

        int max = Integer.MAX_VALUE;
        int index = -1;


        int from = -1;
        for (int i = 0; i < street.length; i++) {//every building on the street
            List<String> buildingInterests = street[i];
            if (buildingInterests.size() > 1) {
                for (String buildingInterest : buildingInterests) {
                    at0.incrementAndGet();
                    if (myInterests.contains(buildingInterest)) {
                        if (from == -1) from = i;
                        if (!map.containsKey(buildingInterest)) {
                            map.put(buildingInterest, 1);
                            interestsCount++;
                        } else {
                            map.put(buildingInterest, map.get(buildingInterest) + 1);
                        }
                    }
                }

                while (from != -1) {
                    if (removeIfCan(map, myInterests, street, from)) {
                        from++;
                    } else {
                        break;
                    }
                }

                if (interestsCount == interests.size()) {
                    int curMax = (i - from + 1) / 2;
                    if (curMax < max) {
                        max = curMax;
                        index = from + (i - from) / 2;
                    }
                }
            }

        }

        return new int[]{index, max};
    }

    private boolean removeIfCan(HashMap<String, Integer> allInterests, HashSet<String> interests, List<String>[] street, int index) {
        List<String> startInterests = street[index];

        for (String interest : startInterests) {
            at0.incrementAndGet();
            if (!interests.contains(interest)) continue;
            if (!allInterests.containsKey(interest)) return false;
            if (allInterests.get(interest) == 1) return false;
        }

        for (String interest : startInterests) {
            at0.incrementAndGet();
            if (!interests.contains(interest)) continue;
            allInterests.put(interest, allInterests.get(interest) - 1);
        }

        return true;
    }

    public WhereToMove.CandidateBuilding findBuildingToMove(Building[] street, List<Interest> interests) {
        int[] buildingToMove = findBuildingToMove(parseStreet(street), parseInterests(interests));
        System.out.println("total:" + at0.get());
        return parseCandidate(buildingToMove);
    }

    private WhereToMove.CandidateBuilding parseCandidate(int[] buildingToMove) {
        int idx = buildingToMove[0];
        return idx == -1 ? null : WhereToMove.CandidateBuilding.of(buildingToMove[1], idx);
    }

    private List<String>[] parseStreet(Building[] street) {
        ArrayList<String>[] arrayLists = new ArrayList[street.length];
        int i = 0;
        for (Building building : street) {
            arrayLists[i++] = parseBuilding(building);
        }
        return arrayLists;
    }

    private ArrayList<String> parseBuilding(Building building) {
        Set<Interest> interests = building.availableInterests();
        ArrayList<String> strings = new ArrayList<>(interests.size());
        interests.forEach(i -> strings.add(i.name()));
        return strings;
    }

    private List<String> parseInterests(List<Interest> interests) {
        List<String> list = new ArrayList<>();
        for (Interest interest : interests) {
            list.add(interest.name());
        }
        return list;
    }
}
