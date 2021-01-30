package com.acabra.gtechdevalgs.google.wheretomove;

import com.acabra.gtechdevalgs.TestUtils;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Ignore;
import org.junit.Test;

import java.util.*;

@Ignore
public class WhereToMoveTest {

    @Test
    public void should_return_minus_one_interests_not_found() {
        Building[] street = getStreetWithNoInterests();
        List<Interest> interests = Arrays.asList(Interest.COFFEE_SHOP, Interest.GYM);
        MatcherAssert.assertThat(WhereToMove.findBuildingToMove(street, interests), Matchers.nullValue());
    }

    @Test
    public void should_return_two_as_the_building_has_the_interest() {
        Building[] street = getDefaultStreet();
        WhereToMove.CandidateBuilding buildingToMove = WhereToMove.findBuildingToMove(street, getInterests(Interest.HOSPITAL));
        MatcherAssert.assertThat(buildingToMove, Matchers.notNullValue());
        MatcherAssert.assertThat(0, Is.is(buildingToMove.distanceToAll));
        MatcherAssert.assertThat(2, Is.is(buildingToMove.buildingIndex));
    }

    @Test
    public void should_return_nine_since_it_is_in_the_middle_of_interest() {
        Building[] street = getDefaultStreet();
        WhereToMove.CandidateBuilding buildingToMove = WhereToMove.findBuildingToMove(street, getInterests(Interest.COFFEE_SHOP, Interest.CINEMA));
        MatcherAssert.assertThat(buildingToMove, Matchers.notNullValue());
        MatcherAssert.assertThat(1, Is.is(buildingToMove.distanceToAll));
        MatcherAssert.assertThat(9, Is.is(buildingToMove.buildingIndex));
    }

    @Test
    public void should_return_twelve_since_that_building_has_all_interests() {
        Building[] street = getDefaultStreet();
        WhereToMove.CandidateBuilding buildingToMove = WhereToMove.findBuildingToMove(street, getInterests(Interest.BAKERY, Interest.STORE));

        MatcherAssert.assertThat(buildingToMove, Matchers.notNullValue());
        MatcherAssert.assertThat(0, Is.is(buildingToMove.distanceToAll));
        MatcherAssert.assertThat(12, Is.is(buildingToMove.buildingIndex));
    }

    @Test
    public void should_return_minus_one_no_interests_to_look_for() {
        WhereToMove.CandidateBuilding actual = WhereToMove.findBuildingToMove(getDefaultStreet(), Collections.emptyList());
        MatcherAssert.assertThat(actual, Matchers.nullValue());
    }

    @Test
    public void should_return_ten_since_maximal_walking_distance_is_two() {
        WhereToMove.CandidateBuilding buildingToMove = WhereToMove.findBuildingToMove(getDefaultStreet(), getInterests(Interest.CINEMA, Interest.STORE, Interest.COFFEE_SHOP, Interest.BAKERY));

        MatcherAssert.assertThat(buildingToMove, Matchers.notNullValue());
        MatcherAssert.assertThat(2, Is.is(buildingToMove.distanceToAll));
        MatcherAssert.assertThat(10, Is.is(buildingToMove.buildingIndex));
    }

    @Test
    public void should_return_eleven_the_middle_point_between_two_buildings_containing_all_interests() {
        WhereToMove.CandidateBuilding buildingToMove = WhereToMove.findBuildingToMove(getDefaultStreet(), getInterests(Interest.CINEMA, Interest.STORE, Interest.BAKERY));

        MatcherAssert.assertThat(buildingToMove, Matchers.notNullValue());
        MatcherAssert.assertThat(1, Is.is(buildingToMove.distanceToAll));
        MatcherAssert.assertThat(11, Is.is(buildingToMove.buildingIndex));
    }

    @Test
    public void should_return_thirteen_that_buildings_contains_all_interests() {
        WhereToMove.CandidateBuilding buildingToMove = WhereToMove.findBuildingToMove(getDefaultStreet(), getInterests(Interest.SCHOOL, Interest.HOSPITAL, Interest.BAR));

        MatcherAssert.assertThat(buildingToMove, Matchers.notNullValue());
        MatcherAssert.assertThat(0, Is.is(buildingToMove.distanceToAll));
        MatcherAssert.assertThat(13, Is.is(buildingToMove.buildingIndex));
    }

    @Test
    public void should_return_twelve_that_buildings_was_first_seen_with_distance_to_all_of_one() {
        WhereToMove.CandidateBuilding buildingToMove = WhereToMove.findBuildingToMove(getDefaultStreet(), getInterests(Interest.SCHOOL, Interest.HOSPITAL, Interest.BAR, Interest.BAKERY, Interest.STORE));

        MatcherAssert.assertThat(buildingToMove, Matchers.notNullValue());
        MatcherAssert.assertThat(1, Is.is(buildingToMove.distanceToAll));
        MatcherAssert.assertThat(12, Is.is(buildingToMove.buildingIndex));
    }

    @Test
    public void should_return_seven_that_building_was_first_seen_with_distance_to_all_of_seven() {
        WhereToMove.CandidateBuilding buildingToMove = WhereToMove.findBuildingToMove(getDefaultStreet(), getInterests(Interest.GYM, Interest.PHARMACY));

        MatcherAssert.assertThat(buildingToMove, Matchers.notNullValue());
        MatcherAssert.assertThat(7, Is.is(buildingToMove.distanceToAll));
        MatcherAssert.assertThat(7, Is.is(buildingToMove.buildingIndex));
    }

    @Test
    public void should_return_seven_that_building_was_first_seen_with_distance_to_all_of_seven_2() {
        WhereToMove.CandidateBuilding buildingToMove = WhereToMove.findBuildingToMove(getDefaultStreet(), getInterests(Interest.LIBRARY, Interest.PHARMACY));

        MatcherAssert.assertThat(buildingToMove, Matchers.notNullValue());
        MatcherAssert.assertThat(7, Is.is(buildingToMove.distanceToAll));
        MatcherAssert.assertThat(7, Is.is(buildingToMove.buildingIndex));
    }

    @Test
    public void should_return_minus_one_street_missing_one_interest() {
        WhereToMove.CandidateBuilding buildingToMove = WhereToMove.findBuildingToMove(getStreetMissingOneInterests(), getInterests(Interest.LIBRARY, Interest.PHARMACY));
        MatcherAssert.assertThat(buildingToMove, Matchers.nullValue());
    }

    @Test
    public void should_return_zero_as_building_has_all_interests() {
        Building[] street = buildStreetBuildingsBasedOnInterests(List.of(
                List.of(Interest.PHARMACY, Interest.POLICE_STATION, Interest.LIBRARY),
                Collections.singleton(Interest.LIBRARY),
                Collections.singleton(Interest.PHARMACY),
                Collections.singleton(Interest.LIBRARY),
                Collections.singleton(Interest.PHARMACY)
        ));

        WhereToMove.CandidateBuilding buildingToMove = WhereToMove.findBuildingToMove(street, getInterests(Interest.LIBRARY, Interest.PHARMACY));

        MatcherAssert.assertThat(buildingToMove, Matchers.notNullValue());
        MatcherAssert.assertThat(0, Is.is(buildingToMove.distanceToAll));
        MatcherAssert.assertThat(0, Is.is(buildingToMove.buildingIndex));
    }

    @Test
    public void should_return_two_as_building_has_all_interests() {
        Building[] street = buildStreetBuildingsBasedOnInterests(List.of(
                Collections.singleton(Interest.LIBRARY),
                Collections.singleton(Interest.PHARMACY),
                List.of(Interest.PHARMACY, Interest.POLICE_STATION, Interest.LIBRARY),
                Collections.singleton(Interest.LIBRARY),
                Collections.singleton(Interest.PHARMACY)
        ));

        WhereToMove.CandidateBuilding buildingToMove = WhereToMove.findBuildingToMove(street, getInterests(Interest.LIBRARY, Interest.PHARMACY));

        MatcherAssert.assertThat(buildingToMove, Matchers.notNullValue());
        MatcherAssert.assertThat(0, Is.is(buildingToMove.distanceToAll));
        MatcherAssert.assertThat(2, Is.is(buildingToMove.buildingIndex));
    }

    @Test
    public void should_return_one_as_immediate_neighbors_have_all_interests() {
        Building[] street = buildStreetBuildingsBasedOnInterests(List.of(
                List.of(Interest.SCHOOL, Interest.POLICE_STATION),
                Collections.emptyList(),
                Collections.singleton(Interest.COFFEE_SHOP),
                Collections.singleton(Interest.SCHOOL),
                Collections.emptyList(),
                Collections.singleton(Interest.POLICE_STATION)));

        List<Interest> moverInterests = getInterests(Interest.COFFEE_SHOP, Interest.SCHOOL, Interest.POLICE_STATION);
        WhereToMove.CandidateBuilding buildingToMove = WhereToMove.findBuildingToMove(street, moverInterests);

        MatcherAssert.assertThat(buildingToMove, Matchers.notNullValue());
        MatcherAssert.assertThat(1, Is.is(buildingToMove.distanceToAll));
        MatcherAssert.assertThat(1, Is.is(buildingToMove.buildingIndex));
    }

    @Test
    public void should_return_three_as_its_the_middle_of_the_street() {
        Building[] street = buildStreetBuildingsBasedOnInterests(List.of(
                Collections.singleton(Interest.SCHOOL),
                Collections.singleton(Interest.LIBRARY),
                Collections.singleton(Interest.STORE),
                Collections.singleton(Interest.BAKERY),
                Collections.singleton(Interest.HOSPITAL),
                Collections.singleton(Interest.POLICE_STATION),
                Collections.singleton(Interest.PHARMACY),
                List.of(Interest.CINEMA, Interest.COFFEE_SHOP)));

        List<Interest> moverInterests = getInterests(Interest.COFFEE_SHOP, Interest.SCHOOL, Interest.POLICE_STATION);
        WhereToMove.CandidateBuilding buildingToMove = WhereToMove.findBuildingToMove(street, moverInterests);

        MatcherAssert.assertThat(buildingToMove, Matchers.notNullValue());
        MatcherAssert.assertThat(4, Is.is(buildingToMove.distanceToAll));
        TestUtils.iAssertTrue(new HashSet<Integer>(){{add(3);add(4);}}.contains(buildingToMove.buildingIndex));
    }

    @Test
    public void should_return_six_as_its_the_building_containing_all_interests_a() {
        Building[] street = buildStreetBuildingsBasedOnInterests(List.of(
                Collections.singleton(Interest.POLICE_STATION),
                Collections.singleton(Interest.LIBRARY),
                Collections.singleton(Interest.POLICE_STATION),
                Collections.singleton(Interest.BAKERY),
                Collections.singleton(Interest.POLICE_STATION),
                Collections.singleton(Interest.POLICE_STATION),
                Collections.singleton(Interest.POLICE_STATION),
                List.of(Interest.POLICE_STATION, Interest.LIBRARY)));

        List<Interest> moverInterests = getInterests(Interest.LIBRARY, Interest.POLICE_STATION);
        WhereToMove.CandidateBuilding buildingToMove = WhereToMove.findBuildingToMove(street, moverInterests);

        MatcherAssert.assertThat(buildingToMove, Matchers.notNullValue());
        MatcherAssert.assertThat(0, Is.is(buildingToMove.distanceToAll));
        MatcherAssert.assertThat(7, Is.is(buildingToMove.buildingIndex));
    }

    @Test
    public void should_return_six_as_its_the_building_containing_all_interests_b() {
        Building[] street = buildStreetBuildingsBasedOnInterests(List.of(
                List.of(Interest.COFFEE_SHOP, Interest.STORE, Interest.BAKERY, Interest.SCHOOL, Interest.HOSPITAL, Interest.CINEMA),
                List.of(Interest.COFFEE_SHOP, Interest.STORE, Interest.BAKERY, Interest.SCHOOL, Interest.HOSPITAL, Interest.CINEMA),
                List.of(Interest.COFFEE_SHOP, Interest.STORE, Interest.BAKERY, Interest.SCHOOL, Interest.HOSPITAL, Interest.CINEMA),
                List.of(Interest.COFFEE_SHOP, Interest.STORE, Interest.BAKERY, Interest.SCHOOL, Interest.HOSPITAL, Interest.CINEMA),
                List.of(Interest.COFFEE_SHOP, Interest.STORE, Interest.BAKERY, Interest.SCHOOL, Interest.HOSPITAL, Interest.CINEMA),
                List.of(Interest.COFFEE_SHOP, Interest.STORE, Interest.BAKERY, Interest.SCHOOL, Interest.HOSPITAL, Interest.CINEMA),
                List.of(Interest.COFFEE_SHOP, Interest.STORE, Interest.BAKERY, Interest.SCHOOL, Interest.HOSPITAL, Interest.CINEMA),
                List.of(Interest.COFFEE_SHOP, Interest.STORE, Interest.BAKERY, Interest.SCHOOL, Interest.HOSPITAL, Interest.CINEMA),
                List.of(Interest.COFFEE_SHOP, Interest.STORE, Interest.BAKERY, Interest.SCHOOL, Interest.HOSPITAL, Interest.CINEMA),
                List.of(Interest.COFFEE_SHOP, Interest.STORE, Interest.BAKERY, Interest.SCHOOL, Interest.HOSPITAL, Interest.CINEMA),
                List.of(Interest.COFFEE_SHOP, Interest.STORE, Interest.BAKERY, Interest.SCHOOL, Interest.HOSPITAL, Interest.CINEMA),
                List.of(Interest.COFFEE_SHOP, Interest.STORE, Interest.BAKERY, Interest.SCHOOL, Interest.HOSPITAL, Interest.CINEMA),
                List.of(Interest.COFFEE_SHOP, Interest.STORE, Interest.BAKERY, Interest.SCHOOL, Interest.HOSPITAL, Interest.CINEMA),
                List.of(Interest.COFFEE_SHOP, Interest.STORE, Interest.BAKERY, Interest.SCHOOL, Interest.HOSPITAL, Interest.CINEMA),
                List.of(Interest.POLICE_STATION, Interest.LIBRARY)));

        List<Interest> moverInterests = getInterests(Interest.LIBRARY, Interest.POLICE_STATION);
        WhereToMove.CandidateBuilding buildingToMove = WhereToMove.findBuildingToMove(street, moverInterests);

        MatcherAssert.assertThat(buildingToMove, Matchers.notNullValue());
        MatcherAssert.assertThat(0, Is.is(buildingToMove.distanceToAll));
        MatcherAssert.assertThat(14, Is.is(buildingToMove.buildingIndex));
    }

    @Test
    public void should_return_six_as_its_the_building_containing_all_interests_c() {
        Building[] street = buildStreetBuildingsBasedOnInterests(List.of(
                Collections.singleton(Interest.LIBRARY),
                List.of(Interest.COFFEE_SHOP, Interest.STORE, Interest.BAKERY, Interest.SCHOOL, Interest.HOSPITAL, Interest.CINEMA),
                List.of(Interest.COFFEE_SHOP, Interest.STORE, Interest.BAKERY, Interest.SCHOOL, Interest.HOSPITAL, Interest.CINEMA),
                List.of(Interest.COFFEE_SHOP, Interest.STORE, Interest.BAKERY, Interest.SCHOOL, Interest.HOSPITAL, Interest.CINEMA),
                List.of(Interest.COFFEE_SHOP, Interest.STORE, Interest.BAKERY, Interest.SCHOOL, Interest.HOSPITAL, Interest.CINEMA),
                List.of(Interest.COFFEE_SHOP, Interest.STORE, Interest.BAKERY, Interest.SCHOOL, Interest.HOSPITAL, Interest.CINEMA),
                List.of(Interest.COFFEE_SHOP, Interest.STORE, Interest.BAKERY, Interest.SCHOOL, Interest.HOSPITAL, Interest.CINEMA),
                List.of(Interest.COFFEE_SHOP, Interest.STORE, Interest.BAKERY, Interest.SCHOOL, Interest.HOSPITAL, Interest.CINEMA),
                List.of(Interest.COFFEE_SHOP, Interest.STORE, Interest.BAKERY, Interest.SCHOOL, Interest.HOSPITAL, Interest.CINEMA),
                List.of(Interest.COFFEE_SHOP, Interest.STORE, Interest.BAKERY, Interest.SCHOOL, Interest.HOSPITAL, Interest.CINEMA),
                List.of(Interest.COFFEE_SHOP, Interest.STORE, Interest.BAKERY, Interest.SCHOOL, Interest.HOSPITAL, Interest.CINEMA),
                List.of(Interest.COFFEE_SHOP, Interest.STORE, Interest.BAKERY, Interest.SCHOOL, Interest.HOSPITAL, Interest.CINEMA),
                List.of(Interest.COFFEE_SHOP, Interest.STORE, Interest.BAKERY, Interest.SCHOOL, Interest.HOSPITAL, Interest.CINEMA),
                List.of(Interest.COFFEE_SHOP, Interest.STORE, Interest.BAKERY, Interest.SCHOOL, Interest.HOSPITAL, Interest.CINEMA),
                List.of(Interest.COFFEE_SHOP, Interest.STORE, Interest.BAKERY, Interest.SCHOOL, Interest.HOSPITAL, Interest.CINEMA),
                Collections.singleton(Interest.POLICE_STATION)));

        List<Interest> moverInterests = getInterests(Interest.LIBRARY, Interest.POLICE_STATION);
        WhereToMove.CandidateBuilding buildingToMove = WhereToMove.findBuildingToMove(street, moverInterests);

        MatcherAssert.assertThat(buildingToMove, Matchers.notNullValue());
        MatcherAssert.assertThat(8, Is.is(buildingToMove.distanceToAll));
        MatcherAssert.assertThat(7, Is.is(buildingToMove.buildingIndex));
    }

    private Building[] buildStreetBuildingsBasedOnInterests(Collection<? extends Collection<Interest>> interests) {
        Building[] street = new Building[interests.size()];
        int i = 0;
        for (Collection<Interest> bInterests : interests) {
            street[i++] = new Building(bInterests);
        }
        return street;
    }

    private Building[] getStreetMissingOneInterests() {
         return new Building[] {
                buildingWithInterests(Interest.LIBRARY, Interest.COFFEE_SHOP),
                buildingWithInterests(Interest.SCHOOL, Interest.CINEMA),
                buildingWithInterests(Interest.HOSPITAL),
                buildingWithInterests(Interest.POLICE_STATION)
        };
    }

    private Building buildingWithInterests(Interest... interests) {
        List<Interest> buildingInterests = getInterests(interests);
        return new Building(buildingInterests);
    }

    private List<Interest> getInterests(Interest... interests) {
        List<Interest> buildingInterests = new ArrayList<>();
        Collections.addAll(buildingInterests, interests);
        return buildingInterests;
    }

    private Building buildingNoInterests() {
        return new Building(Collections.emptyList());
    }

    private Building[] getDefaultStreet() {
         return new Building[]{
                buildingNoInterests(), //0
                buildingWithInterests(Interest.GYM, Interest.LIBRARY), //1
                buildingWithInterests(Interest.HOSPITAL), //2
                buildingWithInterests(Interest.SCHOOL), //3
                buildingWithInterests(Interest.BAR), //4
                buildingWithInterests(Interest.BAKERY), // 5
                buildingNoInterests(), //6
                buildingWithInterests(Interest.STORE), //7
                buildingWithInterests(Interest.COFFEE_SHOP), //8
                buildingNoInterests(), //9
                buildingWithInterests(Interest.CINEMA),//10
                buildingNoInterests(), //11
                buildingWithInterests(Interest.BAKERY, Interest.STORE), //12
                buildingWithInterests(Interest.SCHOOL, Interest.HOSPITAL, Interest.BAR), //13
                buildingWithInterests(Interest.PHARMACY), //14
        };
    }

    private Building[] getStreetWithNoInterests() {
        return new Building[]{new Building(Collections.emptyList())};
    }
}
