package com.acabra.gtechdevalgs.google;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordsInTypingTest {

    private WordsInTyping underTest;

    @Before
    public void setup() {
        this.underTest = new WordsInTyping();
    }

    @Test
    public void shouldReturn9() {
        String[] strings = {"a", "bcd", "e"};
        int rows = 14;
        int cols = 6;
        int expected = 9;
        Assert.assertThat(underTest.wordsTyping(strings, rows, cols), Is.is(expected));
    }

    @Test
    public void shouldReturn4() {
        String[] strings = {"h"};
        int rows = 2;
        int cols = 3;
        int expected = 4;
        Assert.assertThat(underTest.wordsTyping(strings, rows, cols), Is.is(expected));
    }

    @Test
    public void shouldReturn10() {
        String[] strings = {"a", "bcd", "e"};
        int rows = 15;
        int cols = 6;
        int expected = 10;
        Assert.assertThat(underTest.wordsTyping(strings, rows, cols), Is.is(expected));
    }

    @Test
    public void shouldReturn85100() {
        String[] strings = {"abcdef", "ghijkl", "mnop", "qrs", "tuv", "wxyz", "asdf", "ogfd", "df", "r", "abcdef", "ghijkl", "mnop", "qrs", "tuv", "wxyz", "asdf", "ogfd", "df", "r", "abcdef", "ghijkl", "mnop", "qrs", "tuv", "wxyz", "asdf", "ogfd", "df", "r", "abcdef", "ghijkl", "mnop", "qrs", "tuv", "wxyz", "asdf", "ogfd", "df", "r", "abcdef", "ghijkl", "mnop", "qrs", "tuv", "wxyz", "asdf", "ogfd", "df", "r", "abcdef", "ghijkl", "mnop", "qrs", "tuv", "wxyz", "asdf", "ogfd", "df", "r", "abcdef", "ghijkl", "mnop", "qrs", "tuv", "wxyz", "asdf", "ogfd", "df", "r", "abcdef", "ghijkl", "mnop", "qrs", "tuv", "wxyz", "asdf", "ogfd", "df", "r", "abcdef", "ghijkl", "mnop", "qrs", "tuv", "wxyz", "asdf", "ogfd", "df", "r", "abcdef", "ghijkl", "mnop", "qrs", "tuv", "wxyz", "asdf", "ogfd", "df", "r"};
        int rows = 20000;
        int cols = 20000;
        int expected = 851000;
        Assert.assertThat(underTest.wordsTyping(strings, rows, cols), Is.is(expected));
    }

    @Test
    public void shouldReturn2000000() {
        String[] strings = {"a", "b", "c", "d", "e", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y",
                "z", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
                "z", "y", "x", "w", "v", "u", "t", "s", "r", "q", "p", "o", "n", "m", "l", "k", "j", "i", "h", "g", "f", "e", "d", "c", "b", "d",
                "z", "y", "x", "w", "v", "u", "t", "s", "r", "q", "p", "o", "n", "m", "l", "k", "j", "i", "h", "g", "f", "e", "d", "c", "b"};
        int rows = 20000;
        int cols = 20000;
        int expected = 2000000;
        Assert.assertThat(underTest.wordsTyping(strings, rows, cols), Is.is(expected));
    }

    @Test
    public void shouldReturn1990000() {
        String[] strings = {"a", "b", "c", "d", "e", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y",
                "z", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
                "z", "y", "x", "w", "v", "u", "t", "s", "r", "q", "p", "o", "n", "m", "l", "kk", "j", "i", "h", "g", "f", "e", "d", "c", "b", "d",
                "z", "y", "x", "w", "v", "u", "t", "s", "r", "q", "p", "o", "n", "m", "l", "k", "j", "i", "h", "g", "f", "e", "d", "c", "b"};
        int rows = 20000;
        int cols = 20000;
        int expected = 1990000;
        Assert.assertThat(underTest.wordsTyping(strings, rows, cols), Is.is(expected));
    }

    @Test
    public void shouldReturn848587() {
        String[] strings = {"abcdef","ghijkl","mnop","qrs","tuv","wxyz","asdf","ogfd","df","r","abcdef","ghijkl","mnop","qrs","tuv","wxyz","asdf","ogfd","df","r","abcdef","ghijkl","mnop","qrs","tuv","wxyz","asdf","ogfd","df","r","abcdef","ghijkl","mnop","qrs","tuv","wxyz","asdf","ogfd","df","r","abcdef","ghijkl","mnop","qrs","tuv","wxyz","asdf","ogfd","df","r","abcdef","ghijkl","mnop","qrs","tuv","wxyz","asdf","ogfd","df","r","abcdef","ghijkl","mnop","qrs","tuv","wxyz","asdf","ogfd","df","r","abcdef","ghijkl","mnop","qrs","tuv","wxyz","asdf","ogfd","df","r","abcdef","ghijkl","mnop","qrs","tuv","wxyz","asdf","ogfd","df","r","abcdef","ghijkl","mnop","qrs","tuv","wxyz","asdf","ogfd","df","r"};
        int rows = 19948;
        int cols = 19994;
        int expected = 848587;
        Assert.assertThat(underTest.wordsTyping(strings, rows, cols), Is.is(expected));
    }

}