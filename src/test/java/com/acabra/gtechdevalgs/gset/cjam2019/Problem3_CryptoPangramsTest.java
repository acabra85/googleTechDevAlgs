package com.acabra.gtechdevalgs.gset.cjam2019;

import org.junit.Assert;
import org.junit.Test;

public class Problem3_CryptoPangramsTest {

    @Test
    public void should_return_CJQUIZKNOWBEVYOFDPFLUXALGORITHMS() {
        String expected = "CJQUIZKNOWBEVYOFDPFLUXALGORITHMS";
        String cypherList = "217 1891 4819 2291 2987 3811 1739 2491 4717 445 65 1079 8383 5353 901 187 649 1003 697 3239 7663 291 123 779 1007 3551 1943 2117 1679 989 3053";
        Problem3_CryptoPangrams.Solution solution = new Problem3_CryptoPangrams.Solution();
        solution.solve("103", 31, cypherList);
        Assert.assertEquals(expected, solution.getPlainText());
    }

    @Test
    public void should_return_SUBDERMATOGLYPHICFJKNQVWXZ() {
        String expected = "SUBDERMATOGLYPHICFJKNQVWXZ";
        String cypherList = "3292937 175597 18779 50429 375469 1651121 2102 3722 2376497 611683 489059 2328901 3150061 829981 421301 76409 38477 291931 730241 959821 1664197 3057407 4267589 4729181 5335543";
        Problem3_CryptoPangrams.Solution solution = new Problem3_CryptoPangrams.Solution();
        solution.solve("10000", 25, cypherList);
        Assert.assertEquals(expected, solution.getPlainText());
    }

    @Test
    public void should_return_ZYXWVUTSRQPONMLKJIHGFEDCBA() {
        String expected = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        String cypherList = "9797 8633 7387 6557 5767 5183 4757 4087 3599 3127 2491 2021 1763 1517 1147 899 667 437 323 221 143 77 35 15 6";
        Problem3_CryptoPangrams.Solution solution = new Problem3_CryptoPangrams.Solution();
        solution.solve("101", 25, cypherList);
        Assert.assertEquals(expected, solution.getPlainText());
    }

    @Test
    public void should_return_ABCDEFGHIJKLMNOPQRSTUVWXYZ() {
        String expected = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String cypherList = "6 15 35 77 143 221 323 437 667 899 1147 1517 1763 2021 2491 3127 3599 4087 4757 5183 5767 6557 7387 8633 9797";
        Problem3_CryptoPangrams.Solution solution = new Problem3_CryptoPangrams.Solution();
        solution.solve("101", 25, cypherList);
        Assert.assertEquals(expected, solution.getPlainText());
    }

    @Test
    public void should_return_THEQUICKBROWNFOXJUMPSOVERTHELAZYDOG() {
        String expected = "THEQUICKBROWNFOXJUMPSOVERTHELAZYDOG";
        String cypherList = "1349 209 649 4307 1679 115 155 93 183 2867 3901 3569 559 611 4183 2581 2117 2993 2173 3551 3149 3713 869 671 4331 1349 209 407 74 202 9797 679 329 799";
        Problem3_CryptoPangrams.Solution solution = new Problem3_CryptoPangrams.Solution();
        solution.solve("101", 34, cypherList);
        Assert.assertEquals(expected, solution.getPlainText());
    }
}
