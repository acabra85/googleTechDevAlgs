package com.acabra.gtechdevalgs.hkrank.amzn_apr2021;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LightingCandlesTest {

    private LightingCandles underTest;

    @BeforeEach
    public void setup() {
        underTest = new LightingCandles();
    }

    /*
        1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7
              x   x x x x x
            . - - - . - - -
          . - - - . - - -
        . - - - . - - - . - - -
              . - - - . - - -
     */
    @Test
    public void shouldReturn9() {
        List<Integer> arrivals = List.of(4, 10, 9, 8, 6, 7);
        int candleLT = 3;
        int minCandles = 3;
        int expected = 9;

        int actual = underTest.buyMinimumCandles(arrivals, candleLT, minCandles);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    /*
        1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7
              x
            . - -
          . - -
        . - -
     */
    @Test
    public void shouldReturnM1() {
        List<Integer> arrivals = List.of(4, 10, 9, 8, 6, 7);
        int candleLT = 2;
        int minCandles = 3;
        int expected = -1;

        int actual = underTest.buyMinimumCandles(arrivals, candleLT, minCandles);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    /*
        1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7
              x         x
            . - - -   . - - -
          . - - -   . - - -
        . - - -   . - - -
     */
    @Test
    public void shouldReturn6() {
        List<Integer> arrivals = List.of(9, 4);
        int candleLT = 3;
        int minCandles = 3;
        int expected = 6;

        int actual = underTest.buyMinimumCandles(arrivals, candleLT, minCandles);

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}