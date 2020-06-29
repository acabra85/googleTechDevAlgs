package com.acabra.gtechdevalgs.google;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StreamCheckerTest {

    @Test
    public void query() {
        String[] in = {"cd","f","kl"};
        StreamChecker streamChecker = new StreamChecker(in); // init the dictionary.
        Assert.assertThat(streamChecker.query('a'), Is.is(false));          // return false
        Assert.assertThat(streamChecker.query('b'), Is.is(false));
        Assert.assertThat(streamChecker.query('c'), Is.is(false));
        Assert.assertThat(streamChecker.query('d'), Is.is(true));//, because 'cd' is in the wordlist
        Assert.assertThat(streamChecker.query('e'), Is.is(false));
        Assert.assertThat(streamChecker.query('f'), Is.is(true));//, because 'f' is in the wordlist
        Assert.assertThat(streamChecker.query('g'), Is.is(false));
        Assert.assertThat(streamChecker.query('h'), Is.is(false));
        Assert.assertThat(streamChecker.query('i'), Is.is(false));
        Assert.assertThat(streamChecker.query('j'), Is.is(false));
        Assert.assertThat(streamChecker.query('k'), Is.is(false));
        Assert.assertThat(streamChecker.query('l'), Is.is(true));//, because 'kl' is in the wordlist
    }
}