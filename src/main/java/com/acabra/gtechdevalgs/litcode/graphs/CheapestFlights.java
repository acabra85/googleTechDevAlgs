package com.acabra.gtechdevalgs.litcode.graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class CheapestFlights {

    /**
     * 
     * @param nodeCount the amount of cities
     * @param flights the flights availables in the format [from, to, cost]
     * @param source the origin of the trip
     * @param destination the destination of the trip
     * @param maxStops the maximum allowed stops to make during the trip
     * @return the cheapest trip cost
     */
    public int findCheapestPrice(int nodeCount, int[][] flights, int source, int destination, int maxStops) {
        int[][] graph = new int[nodeCount][nodeCount];
        for (int[] flight: flights) {
            graph[flight[0]][flight[1]] = flight[2];
        }

        Map<Integer, Integer> cheapest = new HashMap<>();
        Queue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0,0,source));
        while (!pq.isEmpty()) {
            Node node = pq.remove();
            if (validNode(maxStops, cheapest, node)) {
                if (node.place == destination) {
                    return node.cost;
                }
                for (int i = 0; i < nodeCount; ++i) {
                    if (graph[node.place][i] > 0) {
                        int iCost = node.cost + graph[node.place][i];
                        if (iCost < cheapest.getOrDefault((node.stops+1)*1000 + i, Integer.MAX_VALUE)) {
                            pq.offer(new Node(iCost, node.stops + 1, i));
                            cheapest.put((node.stops+1)*1000 + i, iCost);
                        }
                    }
                }
            }
        }
        return -1;
    }

    private boolean validNode(int maxStops, Map<Integer, Integer> cheapest, Node info) {
        return info.stops <= maxStops + 1 && info.cost <= cheapest.getOrDefault(info.stops * 1000 + info.place, Integer.MAX_VALUE);
    }

    private class Node implements Comparable<Node> {

        final int stops;
        final int place;
        final int cost;

        public Node(int cost, int stops, int place) {
            this.cost = cost;
            this.place = place;
            this.stops = stops;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
}
