package com.acabra.gtechdevalgs.google;

import org.hamcrest.core.Is;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LetterBoardTest {

    private LetterBoard underTest;

    @Before
    public void setUp() {
        underTest = new LetterBoard();
    }

    @Test
    public void alphabetBoardPath() {
        MatcherAssert.assertThat(underTest.alphabetBoardPath("agustin"), Is.is("!RD!LDDD!RRRU!R!LUU!D!"));
    }
}