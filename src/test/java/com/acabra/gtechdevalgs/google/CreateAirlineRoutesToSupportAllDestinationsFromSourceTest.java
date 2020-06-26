package com.acabra.gtechdevalgs.google;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreateAirlineRoutesToSupportAllDestinationsFromSourceTest {


    @Test
    public void should_return_0() {
        String[] aiports = { "CDG", "LUX", "JFK"};

        String[][] routes = {
                {"LUX", "CDG"},
                {"JFK", "CDG"},
                {"JFK", "LUX"},
        };
        String source = "JFK";

        Assert.assertEquals(0, new CreateAirlineRoutesToSupportAllDestinationsFromSource().countMinimalMissingRoutes(aiports, routes, source));
    }

    @Test
    public void should_return_1_a() {
        String[] aiports = { "CDG", "LUX", "JFK"};

        String[][] routes = {
                {"LUX", "CDG"},
                {"JFK", "CDG"},
                {"JFK", "LUX"},
        };
        String source = "LUX";

        Assert.assertEquals(1, new CreateAirlineRoutesToSupportAllDestinationsFromSource().countMinimalMissingRoutes(aiports, routes, source));
    }

    @Test
    public void should_return_1_b() {
        String[] aiports = { "CDG", "LUX", "JFK"};

        String[][] routes = {
                {"LUX", "CDG"},
                {"JFK", "CDG"},
                {"JFK", "LUX"},
        };
        String source = "JFK";

        Assert.assertEquals(0, new CreateAirlineRoutesToSupportAllDestinationsFromSource().countMinimalMissingRoutes(aiports, routes, source));
    }
    @Test
    public void should_return_3() {
        String[] aiports = { "BGI", "CDG", "DEL", "DOH", "DSM", "EWR", "EYW", "HND", "ICN",
                "JFK", "LGA", "LHR", "ORD", "SAN", "SFO", "SIN", "TLV", "BUD"};

        String[][] routes = {
                {"DSM", "ORD"},
                {"ORD", "BGI"},
                {"BGI", "LGA"},
                {"SIN", "CDG"},
                {"CDG", "SIN"},
                {"CDG", "BUD"},
                {"DEL", "DOH"},
                {"DEL", "CDG"},
                {"TLV", "DEL"},
                {"EWR", "HND"},
                {"HND", "ICN"},
                {"HND", "JFK"},
                {"ICN", "JFK"},
                {"JFK", "LGA"},
                {"EYW", "LHR"},
                {"LHR", "SFO"},
                {"SFO", "SAN"},
                {"SFO", "DSM"},
                {"SAN", "EYW"},
        };
        String source = "LGA";

        Assert.assertEquals(3, new CreateAirlineRoutesToSupportAllDestinationsFromSource().countMinimalMissingRoutes(aiports, routes, source));
    }

}