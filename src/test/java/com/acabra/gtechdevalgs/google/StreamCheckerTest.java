package com.acabra.gtechdevalgs.google;

import com.acabra.gtechdevalgs.TestUtils;
import java.util.Map;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class StreamCheckerTest {

    @Test
    public void test_api_small_trie() {
        StreamChecker.BRUTE_FORCE = false;
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

    @Test
    public void test_api_small_bf() {
        StreamChecker.BRUTE_FORCE = true;
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

    @Test
    public void test_api_big_bf() {
        StreamChecker.BRUTE_FORCE = true;
        Map.Entry<Map.Entry<String[], String[]>, String[]> streamCheckerInput = TestUtils.buildStreamCheckerBigTestCase();
        String[] dictionary = streamCheckerInput.getKey().getKey();
        String[] queries = streamCheckerInput.getKey().getValue();
        String[] expectedStr = streamCheckerInput.getValue();

        Assert.assertThat(queries.length, Is.is(expectedStr.length));

        StreamChecker underTest = new StreamChecker(dictionary);
        for(int i=0;i<queries.length;++i) {
            Assert.assertThat(underTest.query(queries[i].charAt(1)), Is.is(Boolean.parseBoolean(expectedStr[i])));
        }
    }

    @Test
    public void test_api_big_trie() {
        StreamChecker.BRUTE_FORCE = false;
        Map.Entry<Map.Entry<String[], String[]>, String[]> streamCheckerInput = TestUtils.buildStreamCheckerBigTestCase();
        String[] dictionary = streamCheckerInput.getKey().getKey();
        String[] queries = streamCheckerInput.getKey().getValue();
        String[] expectedStr = streamCheckerInput.getValue();

        Assert.assertThat(queries.length, Is.is(expectedStr.length));

        StreamChecker underTest = new StreamChecker(dictionary);
        for(int i=0;i<queries.length;++i) {
            Assert.assertThat(underTest.query(queries[i].charAt(1)), Is.is(Boolean.parseBoolean(expectedStr[i])));
        }
    }
}