package com.acabra.gtechdevalgs.google;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxRevenueTwoCitiesTest {

    private MaxRevenueTwoCities underTest;

    @BeforeEach
    void setUp() {
        underTest = new MaxRevenueTwoCities();
    }

    @Test
    public void shouldReturn36() {
        //given
        int[]revA = {7, 4, 1, 8, 9};
        int[]revB = {1, 8, 8, 7, 6};
        int travelCost = 2;
        int expected = 36;

        //when
        int actualDFS = underTest.maxRevenueDFS(revA, revB, travelCost);
        int actualDP = underTest.maxRevenueDP(revA, revB, travelCost);
        int actualRec = underTest.maxRevenueRecursiveMemo(revA, revB, travelCost);

        //then
        Assertions.assertThat(actualDFS)
                .isEqualTo(actualDP)
                .isEqualTo(actualRec)
                .isEqualTo(expected);
    }

    @Test
    public void shouldReturn10() {
        //given
        int[] revA = {1, 4, 1};
        int[] revB = {4, 1, 4};
        int travelCost = 1;
        int expected = 10;

        //when
        int actualDFS = underTest.maxRevenueDFS(revA, revB, travelCost);
        int actualDP = underTest.maxRevenueDP(revA, revB, travelCost);
        int actualRec = underTest.maxRevenueRecursiveMemo(revA, revB, travelCost);

        //then
        Assertions.assertThat(actualDFS)
                .isEqualTo(actualDP)
                .isEqualTo(actualRec)
                .isEqualTo(expected);;
    }
}