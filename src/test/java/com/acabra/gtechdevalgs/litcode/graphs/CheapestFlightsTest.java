package com.acabra.gtechdevalgs.litcode.graphs;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

/**
 * Describe your class
 */
public class CheapestFlightsTest {

    @Test
    public void should_return_200_test_01() {
        int n = 3;
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        int src = 0;
        int dst = 2;
        int maxStops = 1;
        int cheapestExpectedPrice = 200;
        MatcherAssert.assertThat(cheapestExpectedPrice, Is.is(new CheapestFlights().findCheapestPrice(n, flights, src, dst, maxStops)));
    }

    @Test
    public void should_return_16_test_02() {
        int n = 7;
        int[][] flights = {{0,3,7},{4,5,3},{6,4,8},{2,0,10},{6,5,6},{1,2,2},{2,5,9},{2,6,8},{3,6,3},{4,0,10},{4,6,8},{5,2,6},{1,4,3},{4,1,6},{0,5,10},{3,1,5},{4,3,1},{5,4,10},{0,1,6}};;
        int src = 2;
        int dst = 4;
        int maxStops = 1;
        int cheapestExpectedPrice = 16;
        MatcherAssert.assertThat(cheapestExpectedPrice, Is.is(new CheapestFlights().findCheapestPrice(n, flights, src, dst, maxStops)));
    }
}
