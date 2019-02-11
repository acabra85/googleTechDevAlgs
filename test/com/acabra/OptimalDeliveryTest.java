package com.acabra;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Agustin on 1/23/2019.
 */
public class OptimalDeliveryTest {

    @Test
    public void calculateOptimalRouteTruckCapacitySinglePackage_test_1() {
        System.out.println("calculateOptimalRouteTruckCapacitySinglePackage_test_1");
        List<List<Integer>> allDestinations = new ArrayList<List<Integer>>() {{
            add(Arrays.asList(1, 2));
            add(Arrays.asList(3,4));
            add(Arrays.asList(1,-1));
        }};
        int numDestinations = 2;

        List<List<Integer>> expectedAnswer = new ArrayList<List<Integer>>() {{
            add(Arrays.asList(1,-1));
            add(Arrays.asList(1, 2));
        }};
        Assert.assertEquals(expectedAnswer, OptimalDelivery.calculateOptimalRouteTruckCapacitySinglePackage(allDestinations, numDestinations));
    }
    @Test
    public void calculateOptimalRouteTruckCapacitySinglePackage_test_2() {
        System.out.println("calculateOptimalRouteTruckCapacitySinglePackage_test_2");
        List<List<Integer>> allDestinations = new ArrayList<List<Integer>>() {{
            add(Arrays.asList(2, 1));
            add(Arrays.asList(4, 0));
            add(Arrays.asList(3, 1));
            add(Arrays.asList(5, 1));
            add(Arrays.asList(5, 2));
            add(Arrays.asList(2, 5));
            add(Arrays.asList(5, 3));
            add(Arrays.asList(4, 4));
            add(Arrays.asList(1, 5));
            add(Arrays.asList(1, 2));
            add(Arrays.asList(1, 3));
        }};
        int numDestinations = allDestinations.size();
        List<List<Integer>> expectedAnswer = new ArrayList<List<Integer>>() {{
            add(Arrays.asList(2, 1));
            add(Arrays.asList(1, 2));
            add(Arrays.asList(1, 3));
            add(Arrays.asList(3, 1));
            add(Arrays.asList(4, 0));
            add(Arrays.asList(5, 1));
            add(Arrays.asList(1, 5));
            add(Arrays.asList(5, 2));
            add(Arrays.asList(2, 5));
            add(Arrays.asList(4, 4));
            add(Arrays.asList(5, 3));
        }};
        Assert.assertEquals(expectedAnswer, OptimalDelivery.calculateOptimalRouteTruckCapacitySinglePackage(allDestinations, numDestinations));
    }

    @Test
    public void calculateOptimalRouteTruckCapacitySinglePackage_test_3() {
        System.out.println("calculateOptimalRouteTruckCapacitySinglePackage_test_3");
        List<List<Integer>> allDestinations = new ArrayList<List<Integer>>() {{
            add(Arrays.asList(1, 0));
            add(Arrays.asList(-1, 0));
            add(Arrays.asList(0, -1));
            add(Arrays.asList(0, 1));
        }};
        int numDestinations = allDestinations.size();

        List<List<Integer>> expectedAnswer = new ArrayList<List<Integer>>() {{
            add(Arrays.asList(1, 0));
            add(Arrays.asList(0, 1));
            add(Arrays.asList(0, -1));
            add(Arrays.asList(-1, 0));
        }};
        Assert.assertEquals(expectedAnswer, OptimalDelivery.calculateOptimalRouteTruckCapacitySinglePackage(allDestinations, numDestinations));
    }

    @Test
    public void calculateOptimalRouteTruckCapacityAllPackages_test_1() {
        System.out.println("calculateOptimalRouteTruckCapacityAllPackages_test_1");

        List<List<Integer>> allDestinations = new ArrayList<List<Integer>>() {{
            add(Arrays.asList(1, 2));
            add(Arrays.asList(3,4));
            add(Arrays.asList(1,-1));
        }};
        int numDestinations = 2;

        List<List<Integer>> expectedAnswer = new ArrayList<List<Integer>>() {{
            add(Arrays.asList(1,-1));
            add(Arrays.asList(1, 2));
        }};
        Assert.assertEquals(expectedAnswer, OptimalDelivery.calculateOptimalRouteTruckCapacityAllPackages(allDestinations, numDestinations));
    }

    @Test
    public void calculateOptimalRouteTruckCapacityAllPackages_test_2() {
        System.out.println("calculateOptimalRouteTruckCapacityAllPackages_test_2");
        List<List<Integer>> allDestinations = new ArrayList<List<Integer>>() {{
            add(Arrays.asList(2, 1));
            add(Arrays.asList(3, 1));
            add(Arrays.asList(4, 0));
            add(Arrays.asList(5, 1));
            add(Arrays.asList(5, 2));
            add(Arrays.asList(4, 4));
            add(Arrays.asList(5, 3));
            add(Arrays.asList(1, 5));
            add(Arrays.asList(1, 3));
            add(Arrays.asList(1, 2));
        }};
        int numDestinations = allDestinations.size();

        List<List<Integer>> expectedAnswer = new ArrayList<List<Integer>>() {{
            add(Arrays.asList(2, 1));
            add(Arrays.asList(3, 1));
            add(Arrays.asList(4, 0));
            add(Arrays.asList(5, 1));
            add(Arrays.asList(5, 2));
            add(Arrays.asList(5, 3));
            add(Arrays.asList(4, 4));
            add(Arrays.asList(1, 5));
            add(Arrays.asList(1, 3));
            add(Arrays.asList(1, 2));
        }};
        Assert.assertEquals(expectedAnswer, OptimalDelivery.calculateOptimalRouteTruckCapacityAllPackages(allDestinations, numDestinations));
    }

    @Test
    public void calculateOptimalRouteTruckCapacityAllPackages_test_3() {
        System.out.println("calculateOptimalRouteTruckCapacityAllPackages_test_3");
        List<List<Integer>> allDestinations = new ArrayList<List<Integer>>() {{
            add(Arrays.asList(1, 0));
            add(Arrays.asList(-1, 0));
            add(Arrays.asList(0, -1));
            add(Arrays.asList(0, 1));
        }};
        int numDestinations = allDestinations.size();

        List<List<Integer>> expectedAnswer = new ArrayList<List<Integer>>() {{
            add(Arrays.asList(1, 0));
            add(Arrays.asList(0, -1));
            add(Arrays.asList(-1, 0));
            add(Arrays.asList(0, 1));
        }};
        Assert.assertEquals(expectedAnswer, OptimalDelivery.calculateOptimalRouteTruckCapacityAllPackages(allDestinations, numDestinations));
    }
}
