package com.acabra.gtechdevalgs.litcode.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LargestTimeTest {

    private LargestTime underTest;

    @BeforeEach
    public void setup() {
        underTest = new LargestTime();
    }

    @Test
    public void tests() {
        //given
        TestCase[] cases = {TestCase.of(new int[]{2, 0, 7, 7}, "07:27"),
                TestCase.of(new int[]{5, 1, 0, 0}, "15:00"),
                TestCase.of(new int[]{1, 2, 3, 5}, "23:51"),
                TestCase.of(new int[]{6, 6, 6, 6}, ""),
                TestCase.of(new int[]{1, 1, 1, 1}, "11:11"),
                TestCase.of(new int[]{0, 0, 2, 0}, "20:00"),
                TestCase.of(new int[]{0, 4, 0, 0}, "04:00")
        };
        for (TestCase aCase : cases) {
            //when
            String maxTime = underTest.findMaxTime(aCase.arr);
            //then
            Assertions.assertThat(maxTime).isEqualTo(aCase.expected);
        }
    }

    public static class TestCase {
        public final int[] arr;
        public final String expected;

        public TestCase(int[] arr, String expected) {
            this.arr = arr;
            this.expected = expected;
        }

        public static TestCase of(int[] arr, String expected) {
            return new TestCase(arr, expected);
        }
    }
}