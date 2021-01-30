package com.acabra.gtechdevalgs.google;

import edu.emory.mathcs.backport.java.util.Arrays;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsCollectionContaining;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RandomTestGeneratorTest {
    private RandomTestGenerator underTest;

    @Before
    public void setUp() {
        underTest = new RandomTestGenerator(1234L);
    }

    @Test
    public void test1() {
        List<List<String>> wordCategories = getInputCategories1();
        int expectedSize = 4;
        List<String> actual = underTest.generateFairRandomWordList(wordCategories, expectedSize);

        MatcherAssert.assertThat(actual.size(), Is.is(expectedSize));
        MatcherAssert.assertThat(actual, Is.is(List.of("GGGG", "BBBBB", "DDDDD", "FFFFF")));
    }

    private List<List<String>> getInputCategories1() {
        List<List<String>> wordCategories = new ArrayList<>();
        wordCategories.add(new ArrayList<>(){{
            add("AAAAA");add("BBBBB");  }});
        wordCategories.add(new ArrayList<>(){{
            add("CCCC"); add("DDDDD"); add("EEEEE"); add("FFFFF"); }});
        wordCategories.add(new ArrayList<>(){{
            add("GGGG");  add("HHHH"); }});
        return wordCategories;
    }

    @Test
    public void test2() {
        List<List<String>> wordCategories = getInputCategories2();
        int expectedSize = 4;
        List<String> actual = underTest.generateFairRandomWordList(wordCategories, expectedSize);
        MatcherAssert.assertThat(actual.size(), Is.is(expectedSize));
        MatcherAssert.assertThat(actual, Is.is(List.of("FFFFF", "LLLLL", "CCCC", "KKKKKK")));
    }

    @Test
    public void test3() {
        List<List<String>> wordCategories = getInputCategories2();
        int expectedSize = 3;
        List<String> actual = underTest.generateFairRandomWordList(wordCategories, expectedSize);
        MatcherAssert.assertThat(actual.size(), Is.is(expectedSize));
        MatcherAssert.assertThat(actual, Is.is(List.of("FFFFF", "CCCC", "KKKKKK")));
    }

    @Test
    public void test4() {
        List<List<String>> wordCategories = getInputCategories2();
        int expectedSize = 1;
        List<String> actual = underTest.generateFairRandomWordList(wordCategories, expectedSize);
        MatcherAssert.assertThat(actual.size(), Is.is(expectedSize));
        MatcherAssert.assertThat(actual, Is.is(List.of("FFFFF")));
    }

    @Test
    public void test5() {
        List<List<String>> wordCategories = getInputCategories2();
        int expectedSize = 2;
        List<String> actual = underTest.generateFairRandomWordList(wordCategories, expectedSize);
        MatcherAssert.assertThat(actual.size(), Is.is(expectedSize));
        MatcherAssert.assertThat(actual, Is.is(List.of("FFFFF", "CCCC")));
    }

    @Test
    public void test6() {
        List<List<String>> wordCategories = getInputCategories2();
        int expectedSize = 6;
        List<String> actual = underTest.generateFairRandomWordList(wordCategories, expectedSize);
        MatcherAssert.assertThat(actual.size(), Is.is(expectedSize));
        MatcherAssert.assertThat(actual, Is.is(List.of("AAAAA", "IIIIIII", "JJJJJJ", "MMMMM", "FFFFF", "CCCC")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test7() {
        List<List<String>> wordCategories = getInputCategories2();
        int expectedSize = 14;
        List<String> actual = underTest.generateFairRandomWordList(wordCategories, expectedSize);
        MatcherAssert.assertThat(actual.size(), Is.is(expectedSize));
        MatcherAssert.assertThat(actual, Is.is(List.of("AAAAA", "IIIIIII", "JJJJJJ", "MMMMM", "FFFFF", "CCCC")));
    }

    @Test
    public void test8() {
        List<List<String>> wordCategories = getInputCategories2();
        int expectedSize = 13;
        List<String> actual = underTest.generateFairRandomWordList(wordCategories, expectedSize);
        MatcherAssert.assertThat(actual.size(), Is.is(expectedSize));
        MatcherAssert.assertThat(actual,
                Is.is(List.of("GGGG", "HHHH", "BBBBB", "EEEEE", "MMMMM", "AAAAA", "IIIIIII", "DDDDD", "JJJJJJ", "FFFFF", "LLLLL", "KKKKKK", "CCCC")));
    }

    @Test
    public void test9() {
        List<List<String>> wordCategories = getInputCategories2();
        int expectedSize = 0;
        List<String> actual = underTest.generateFairRandomWordList(wordCategories, expectedSize);
        MatcherAssert.assertThat(actual.size(), Is.is(expectedSize));
    }

    private List<List<String>> getInputCategories2() {
        List<List<String>> wordCategories = new ArrayList<>();
        wordCategories.add(new ArrayList<>(){{ // 3:1 proportion
            add("JJJJJJ"); add("KKKKKK"); }});
        wordCategories.add(new ArrayList<>(){{
            add("DDDDD"); add("EEEEE"); add("FFFFF"); add("GGGG"); add("HHHH"); add("IIIIIII"); }});
        wordCategories.add(new ArrayList<>(){{ // 2:1 proportion
            add("AAAAA");add("BBBBB");add("CCCC"); }});
        wordCategories.add(new ArrayList<>(){{ // 3:1 proportion
            add("LLLLL"); add("MMMMM"); }});
        return wordCategories;
    }
}