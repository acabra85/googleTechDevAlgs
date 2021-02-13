package com.acabra.gtechdevalgs.litcode.arrays;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SmallestIntNotPresentInATest {

    private SmallestIntNotPresentInA underTest;

    @BeforeEach
    public void setup() {
        underTest = new SmallestIntNotPresentInA();
    }

    @Test
    public void smallSingleInteger() {
        int[] arr = {5};
        Assertions.assertEquals(1, underTest.solution(arr));
    }

    @Test
    public void smallSingleInteger2() {
        int[] arr = {1, 5};
        Assertions.assertEquals(2, underTest.solution(arr));
    }

    @Test
    public void extremeSingleInteger() {
        int[] arr = {Integer.MAX_VALUE};
        Assertions.assertEquals(1, underTest.solution(arr));
    }

    @Test
    public void extremeSingleInteger2() {
        int[] arr = {Integer.MIN_VALUE};
        Assertions.assertEquals(1, underTest.solution(arr));
    }
}