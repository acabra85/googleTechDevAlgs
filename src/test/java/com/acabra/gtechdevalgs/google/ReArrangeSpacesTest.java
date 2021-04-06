package com.acabra.gtechdevalgs.google;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReArrangeSpacesTest {

    private ReArrangeSpaces underTest;

    @BeforeEach
    public void setup() {
        underTest = new ReArrangeSpaces();
    }

    @Test
    public void test_1() {
        String text = "  jhjhjhj   plplp  a UIUIUIU ";
        String expected = "jhjhjhj   plplp   a   UIUIUIU";
        Assertions.assertEquals(expected, underTest.reorderSpaces(text));
    }

    @Test
    public void test_2() {
        String text = "  aaa  bbbbbb hyhyy   ooopop  rab a";
        String expected = "aaa  bbbbbb  hyhyy  ooopop  rab  a ";
        Assertions.assertEquals(expected, underTest.reorderSpaces(text));
    }
}