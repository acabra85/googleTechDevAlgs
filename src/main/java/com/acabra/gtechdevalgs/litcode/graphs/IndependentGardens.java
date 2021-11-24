package com.acabra.gtechdevalgs.litcode.graphs;

import java.util.*;

public class IndependentGardens {

    /*
     PLant a flower type (1,2,3,4) for each garden such that, for any two gardens connected by a path,
     they have different types of flowers given that Every garden has at most 3 paths coming into or leaving it
     */
    public int[] getIndependentGardens(int n, int[][] paths) {
        int[] ans = new int[n];
        HashMap<Integer, Set<Integer>> pathCx = new HashMap<>();
        int planted = 0;
        for(int[] path: paths) {
            addPath(pathCx, path[0]-1, path[1]-1);
        }
        for(int[] path: paths) {
            if(addFlower(ans, path[0]-1, pathCx)) ++planted;
            if(addFlower(ans, path[1]-1, pathCx)) ++planted;
        }
        if(planted < n) {
            for (int i = 0; i < n; ++i) {
                if(ans[i] == 0) {
                    ans[i] = calculateAvailableTypes(pathCx.get(i), ans);
                }
            }
        }
        return ans;
    }
    static final int[] availableFlowers = {1,2,3,4};

    public void addPath(Map<Integer, Set<Integer>> map, int g1, int g2) {
        map.computeIfAbsent(g1, k -> new HashSet<>()).add(g2);
        map.computeIfAbsent(g2, k -> new HashSet<>()).add(g1);
    }

    public boolean addFlower(int[] gardens, int garden, Map<Integer, Set<Integer>> cx) {
        if (gardens[garden] == 0) {
            gardens[garden] = calculateAvailableTypes(cx.get(garden), gardens);
            return true;
        }
        return false;
    }

    private Integer calculateAvailableTypes(Set<Integer> neighbors, int[] gardens) {
        if (neighbors != null) {
            Set<Integer> used = new HashSet<>();
            neighbors.stream()
                    .mapToInt(id -> gardens[id])
                    .filter(elm -> elm > 0)
                    .forEach(used::add);
            for (Integer availableFlower : availableFlowers) {
                if(!used.contains(availableFlower)) {
                    return availableFlower;
                }
            }
            throw new RuntimeException("Unable to plant garden");
        }
        return 1;
    }
}
