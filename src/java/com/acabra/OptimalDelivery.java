package com.acabra;

import java.util.*;
import java.util.concurrent.atomic.DoubleAdder;

/**
 * Created by Agustin on 1/23/2019.
 * This class represents a system that calculates the best delivery route for a parcel delivery truck that
 * has to deliver numDestination parcels but can only carry one parcel at a time, the truck must pick a destination
 * deliver the parcel and return to the warehouse to pick up the next item.
 */
public class OptimalDelivery {

    private final static Comparator<Destination> MIN_QUEUE_COMPARATOR = (a, b) -> Double.compare(a.distance, b.distance);

    /**
     * Given a list of all destinations return the optimal route (minimum distance from the origin) that a delivery truck
     * must follow in order to deliver @numDestinations parcels, starting from the position 0,0.
     * The distance is measured using the Euclidean Distance of every destination to the origin.
     * @param allDestinations a list containing pairs of coordinates of delivery destinations
     * @param numDestinations the amount of deliveries that the truck must complete in the route.
     * @return an unmodifiable list of pairs representing the optimal route to deliver
     */
    public static List<List<Integer>> calculateOptimalRouteTruckCapacitySinglePackage(final List<List<Integer>> allDestinations, int numDestinations) {
        if (null == allDestinations || numDestinations > allDestinations.size())
            return null;
        PriorityQueue<Destination> orderedDestinations = new PriorityQueue<>(MIN_QUEUE_COMPARATOR);
        List<Integer> origin = Arrays.asList(0,0);
        for (int i = 0; i < allDestinations.size(); i++) {
            orderedDestinations.add(new Destination(i, allDestinations.get(i), origin));
        }

        DoubleAdder da = new DoubleAdder();
        List<List<Integer>> destinations = new ArrayList<>(numDestinations);
        for (int i = 0; i < numDestinations; i++) {
            Destination remove = orderedDestinations.remove();
            da.add(remove.distance * (i==numDestinations-1?1:2));
            destinations.add(allDestinations.get(remove.indexOnInputList));
        }
        System.out.println(String.format("Single Truck total distance: %.4f ", da.doubleValue()));
        return Collections.unmodifiableList(destinations);
    }

    /**
     * This method calculates the optimal delivery route assuming an ideal truck that can carry all the packages in the
     * same trip so it is not required to go back to warehouse after every delivery
     * @param allDestinations
     * @param numDestinations
     * @return
     */
    public static List<List<Integer>> calculateOptimalRouteTruckCapacityAllPackages(final List<List<Integer>> allDestinations, int numDestinations) {
        if (null == allDestinations || numDestinations > allDestinations.size())
            return null;
        List<Integer> from = Arrays.asList(0,0);
        List<List<Integer>> route = new ArrayList<>(numDestinations);
        List<List<Integer>> allDestinationsCopy = new ArrayList<>(allDestinations);
        DoubleAdder da = new DoubleAdder();
        for (int i = 0; i < numDestinations; i++) {
            PriorityQueue<Destination> orderedDestinations = new PriorityQueue<>(MIN_QUEUE_COMPARATOR);
            for (int j = 0; j < allDestinationsCopy.size(); j++) {
                orderedDestinations.add(new Destination(j, allDestinationsCopy.get(j), from));
            }
            Destination remove = orderedDestinations.remove();
            int indexOnInputList = remove.indexOnInputList;
            da.add(remove.distance);
            route.add(allDestinationsCopy.get(indexOnInputList));
            allDestinationsCopy.remove(indexOnInputList);
            from = route.get(route.size()-1);
        }
        System.out.println(String.format("Magic Truck total distance: %.4f", da.doubleValue()));
        return Collections.unmodifiableList(route);
    }

    /**
     * Represents a Delivery destination within the context of the input list by the main method
     */
    private static class Destination {

        /**
         * The indext of this destination on the original input
         */
        final int indexOnInputList;

        /**
         * The distance of this destination with respect to the origin
         */
        final double distance;

        Destination(int indexOnInputList, List<Integer> coordinate, List<Integer> origin) {
            this.indexOnInputList = indexOnInputList;
            int x = coordinate.get(0);
            int y = coordinate.get(1);
            int x1 = origin.get(0);
            int y1 = origin.get(1);
            this.distance = Math.sqrt(Math.pow(x - x1, 2) + Math.pow(y -y1, 2));
        }
    }
}
