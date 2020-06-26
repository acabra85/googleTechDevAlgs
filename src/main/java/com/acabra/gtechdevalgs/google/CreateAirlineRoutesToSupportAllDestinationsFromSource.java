package com.acabra.gtechdevalgs.google;

import java.util.*;
import java.util.function.BiFunction;

public class CreateAirlineRoutesToSupportAllDestinationsFromSource {
    /**
     * This method finds the minimal amount of routes that are missing in the parameter "routes"
     * in order to enable a passenger to travel from "sourceAirportName" to any other airport in
     * "airports" (assume passengers don't care about stops).
     * It does it by finding the building strongly connected components of the graph using kosaraju's Algorithm
     * The running time of this code is O(m+n) where n is the total amount of 'routes'
     * @param airports A list of airport codes (represented by 3-letter strings)
     * @param routes A list of pairs of airport codes (represented by 3-letters strings)
     * @param sourceAirportName the source airport that passengers want to start their travel to all other destinations
     * @return the total minimal routes added that will allow the goal or -1 if is not possible.
     *
     * e.g.:
     * airports = {"LUX", "JFK", "CDG"}
     * routes = {{"LUX", "CDG"}, {"JFK", "CDG"}, {"CDG", "LUX"} }
     * source = "LUX"
     * expected = 1, adding any of the following routes ( {"CDG", "JFK"} or {"LUX", "JFK"} ) passengers
     *            from LUX can reach all other airports "JFK" and "CDG"
     */
    public int countMinimalMissingRoutes(String[] airports, String[][] routes, String sourceAirportName) {
        int totalAirports = airports.length;
        Map<String, Integer> airportIds = new HashMap<>();

        //create ids for the airports
        for (int i = 0; i < totalAirports; ++i) { //O(n)
            airportIds.put(airports[i], i);
        }

        //build both adjacency and reverse adjacency lists O(m)
        AdjacencyLists adjLists = AdjacencyLists.build(airportIds, routes);

        //build strongly connected components using kosaraju's[https://en.wikipedia.org/wiki/Kosaraju%27s_algorithm] Alg O(m+n)
        int[] scc = buildSCC(totalAirports, adjLists.adj, adjLists.rev);

        //build the in degree list for the airports O(m+n)
        int[] deg = buildInDegree(totalAirports, adjLists.adj, scc);

        ArrayDeque<String> missingRoutes = new ArrayDeque<>(); // find missing routes O(n)
        for (int destId = 0; destId < totalAirports; ++destId) {
            //if the current airport is the leader of the SCC
            //if the current airport has no incoming flights (is not a destination)
            //if the current airport is NOT the leader of the sourceAirport
            if (scc[destId] == destId && deg[destId] == 0 && scc[destId] != scc[airportIds.get(sourceAirportName)]) {
                missingRoutes.addFirst(airports[destId]);
            }
        }
        return missingRoutes.size();
    }

    private int[] buildInDegree(int totalAirports, Map<Integer, Set<Integer>> routesAdjacencyList, int[] scc) {
        int[] deg = new int[totalAirports];
        for (int airport = 0; airport < totalAirports; ++airport) {
            Set<Integer> destinations = routesAdjacencyList.get(airport);
            if(destinations!=null) {
                for (Integer dest : destinations) {
                    if (scc[airport] != scc[dest]) {
                        ++deg[scc[dest]];
                    }
                }
            }
        }
        return deg;
    }

    private int[] buildSCC(int totalAirports, Map<Integer, Set<Integer>> adj, Map<Integer, Set<Integer>> rev) {
        boolean[] visited = new boolean[totalAirports];

        Stack<Integer> stack = new Stack<>();
        for (int airportId = 0; airportId < totalAirports; ++airportId) {
            kosarajuStep1(airportId, adj, visited, stack);
        }

        //clean the visited array
        Arrays.fill(visited, false);
        int[] scc = new int[totalAirports];
        while(!stack.isEmpty()) {
            kosarajuStep2(stack.peek(), stack.pop(), scc, rev, visited);
        }
        return scc;
    }

    private void kosarajuStep2(Integer src, Integer root, int[] scc, Map<Integer, Set<Integer>> rev, boolean[] visited) {
        if (!visited[src]) {
            visited[src] = true;
            scc[src] = root;
            Set<Integer> destinations = rev.get(src);
            if (destinations != null) {
                for (Integer dest : destinations) {
                    kosarajuStep2(dest, root, scc, rev, visited);
                }
            }
        }
    }

    private void kosarajuStep1(Integer airportId, Map<Integer, Set<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        if(!visited[airportId]) {
            visited[airportId] = true;
            Set<Integer> destinations = adj.get(airportId);
            if (destinations != null) {
                for (Integer dest : destinations) {
                    kosarajuStep1(dest, adj, visited, stack);
                }
            }
            stack.push(airportId);
        }
    }

    private static class AdjacencyLists {

        final Map<Integer, Set<Integer>> adj;
        final Map<Integer, Set<Integer>> rev;

        private static final BiFunction<Set<Integer>, Set<Integer>, Set<Integer>> REMAP_FUNCTION = new BiFunction<>() {
            @Override
            public Set<Integer> apply(Set<Integer> existingList, Set<Integer> newValues) {
                existingList.addAll(newValues);
                return existingList;
            }
        };

        private AdjacencyLists(Map<Integer, Set<Integer>> adj, Map<Integer, Set<Integer>> rev) {
            this.adj = Collections.unmodifiableMap(adj);
            this.rev = Collections.unmodifiableMap(rev);
        }

        private static AdjacencyLists build(Map<String, Integer> airportIds, String[][] routes) {
            Map<Integer, Set<Integer>> adj = new HashMap<>();
            Map<Integer, Set<Integer>> rev = new HashMap<>();
            for (String[] route : routes) {
                adj.merge(airportIds.get(route[0]), new HashSet<>(){{add(airportIds.get(route[1]));}}, REMAP_FUNCTION);
                rev.merge(airportIds.get(route[1]), new HashSet<>(){{add(airportIds.get(route[0]));}}, REMAP_FUNCTION);
            }
            return new AdjacencyLists(adj, rev);
        }
    }
}
