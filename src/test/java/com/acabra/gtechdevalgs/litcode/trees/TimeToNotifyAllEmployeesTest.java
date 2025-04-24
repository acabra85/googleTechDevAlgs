package com.acabra.gtechdevalgs.litcode.trees;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
public class TimeToNotifyAllEmployeesTest {

    @Test
    public void shouldReturn0() {
        int n = 1;
        int ceoId = 0;
        int[] boss = {-1};
        int[] notifyTime = {0};
        int expected = 0;
        TimeToNotifyAllEmployeesTest.runTest(n, ceoId, boss, notifyTime, expected);
    }

    @Test
    public void shouldReturn1() {
        int n = 6;
        int ceoId = 2;
        int[] boss = {2,2,-1,2,2,2};
        int[] notifyTime = {0,0,1,0,0,0};
        int expected = 1;
        TimeToNotifyAllEmployeesTest.runTest(n, ceoId, boss, notifyTime, expected);
    }

    @Test
    public void shouldReturn21() {
        int n = 7;
        int ceoId = 6;
        int[] boss = {1,2,3,4,5,6,-1};
        int[] notifyTime = {0,6,5,4,3,2,1};
        int expected = 21;
        TimeToNotifyAllEmployeesTest.runTest(n, ceoId, boss, notifyTime, expected);
    }
    private static void runTest(int n, int ceoId, int[] boss, int[] notifyTime, int expected) {
        TimeToNotifyAllEmployees underTest = new TimeToNotifyAllEmployees();
        MatcherAssert.assertThat(underTest.timeToNotifyAll(n, ceoId, boss, notifyTime), Is.is(expected));
    }
}