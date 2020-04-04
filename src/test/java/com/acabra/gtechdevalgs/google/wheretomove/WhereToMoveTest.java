package com.acabra.gtechdevalgs.google.wheretomove;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WhereToMoveTest {

    @Test
    public void should_return_minus_one_interests_not_found() {
        Building[] street = getStreetWithNoInterests();
        List<Interest> interests = Arrays.asList(Interest.COFFEE_SHOP, Interest.GYM);
        Assert.assertEquals(-1, WhereToMove.findBuildingToMove(street, interests));
    }

    @Test
    public void should_return_two_as_the_building_has_the_interest() {
        Building[] street = getDefaultStreet();
        Assert.assertEquals(2, WhereToMove.findBuildingToMove(street, getInterests(Interest.HOSPITAL)));
    }

    @Test
    public void should_return_nine_since_it_is_in_the_middle_of_interest() {
        Building[] street = getDefaultStreet();
        Assert.assertEquals(9, WhereToMove.findBuildingToMove(street, getInterests(Interest.COFFEE_SHOP, Interest.CINEMA)));
    }

    @Test
    public void should_return_twelve_since_that_building_has_all_interests() {
        Building[] street = getDefaultStreet();
        Assert.assertEquals(12, WhereToMove.findBuildingToMove(street, getInterests(Interest.BAKERY, Interest.STORE)));
    }

    @Test
    public void should_return_minus_one_no_interests_to_look_for() {
        Assert.assertEquals(-1, WhereToMove.findBuildingToMove(getDefaultStreet(), Collections.emptyList()));
    }

    @Test
    public void should_return_ten_since_maximal_walking_distance_is_one() {
        Assert.assertEquals(10, WhereToMove.findBuildingToMove(getDefaultStreet(), getInterests(Interest.CINEMA, Interest.STORE, Interest.COFFEE_SHOP, Interest.BAKERY)));
    }

    @Test
    public void should_return_ten_the_middle_point_between_two_buildings_containing_all_interests() {
        Assert.assertEquals(11, WhereToMove.findBuildingToMove(getDefaultStreet(), getInterests(Interest.CINEMA, Interest.STORE, Interest.BAKERY)));
    }

    @Test
    public void should_return_thirteen_that_buildings_contains_all_interests() {
        Assert.assertEquals(13, WhereToMove.findBuildingToMove(getDefaultStreet(), getInterests(Interest.SCHOOL, Interest.HOSPITAL, Interest.BAR)));
    }

    @Test
    public void should_return_twelve_that_buildings_was_first_seen_with_distance_to_all_of_one() {
        int buildingToMove = WhereToMove.findBuildingToMove(getDefaultStreet(), getInterests(Interest.SCHOOL, Interest.HOSPITAL, Interest.BAR, Interest.BAKERY, Interest.STORE));
        Assert.assertEquals(13, buildingToMove);
    }

    @Test
    public void should_return_seven_that_building_was_first_seen_with_distance_to_all_of_seven() {
        int buildingToMove = WhereToMove.findBuildingToMove(getDefaultStreet(), getInterests(Interest.GYM, Interest.PHARMACY));
        Assert.assertEquals(7, buildingToMove);
    }

    @Test
    public void should_return_seven_that_building_was_first_seen_with_distance_to_all_of_seven_2() {
        int buildingToMove = WhereToMove.findBuildingToMove(getDefaultStreet(), getInterests(Interest.LIBRARY, Interest.PHARMACY));
        Assert.assertEquals(7, buildingToMove);
    }

    private Building buildingWithInterests(Interest... interests) {
        List<Interest> buildingInterests = getInterests(interests);
        return new Building(buildingInterests);
    }

    private List<Interest> getInterests(Interest... interests) {
        List<Interest> buildingInterests = new ArrayList<>();
        for(Interest interest: interests) {
            buildingInterests.add(interest);
        }
        return buildingInterests;
    }

    private Building buildingNoInterests() {
        return new Building(Collections.emptyList());
    }

    private Building[] getDefaultStreet() {
        Building[] street = {
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
        return street;
    }

    private Building[] getStreetWithNoInterests() {
        Building[] buildings = {new Building(Collections.emptyList())};
        return buildings;
    }
}