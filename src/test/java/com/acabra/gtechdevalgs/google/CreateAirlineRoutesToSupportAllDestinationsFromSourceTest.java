package com.acabra.gtechdevalgs.google;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

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

        MatcherAssert.assertThat(0, Is.is(new CreateAirlineRoutesToSupportAllDestinationsFromSource().countMinimalMissingRoutes(aiports, routes, source)));
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

        MatcherAssert.assertThat(1, Is.is(new CreateAirlineRoutesToSupportAllDestinationsFromSource().countMinimalMissingRoutes(aiports, routes, source)));
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

        MatcherAssert.assertThat(0, Is.is(new CreateAirlineRoutesToSupportAllDestinationsFromSource().countMinimalMissingRoutes(aiports, routes, source)));
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

        MatcherAssert.assertThat(3, Is.is(new CreateAirlineRoutesToSupportAllDestinationsFromSource().countMinimalMissingRoutes(aiports, routes, source)));
    }

}