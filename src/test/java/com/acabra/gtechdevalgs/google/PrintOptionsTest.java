package com.acabra.gtechdevalgs.google;

import org.hamcrest.core.Is;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrintOptionsTest {

    @Test
    public void expand() {
        new PrintOptions().expand("{a,b}c{d,e}f");
    }

    @Test
    public void expand_should_return_abcd() {
        MatcherAssert.assertThat(new PrintOptions().expand("abcd")[0], Is.is("abcd"));
    }

    @Test
    public void expand_should_return_sorted() {
        String[] expected = {"ax", "ay", "az", "bx", "by", "bz"};
        MatcherAssert.assertThat(new PrintOptions().expand("{a,b}{z,x,y}"), Is.is(expected));
    }
}