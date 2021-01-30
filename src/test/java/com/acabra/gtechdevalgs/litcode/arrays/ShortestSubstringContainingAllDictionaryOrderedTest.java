package com.acabra.gtechdevalgs.litcode.arrays;

import com.acabra.gtechdevalgs.TestUtils;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

public class ShortestSubstringContainingAllDictionaryOrderedTest {

    @Test
    public void should_return_false_test_0() {
        String str = null;
        char[] dict = {'a', 'b', 'c', 'd'};
        TestUtils.iAssertFalse(new ShortestSubstringContainingAllDictionaryOrdered().isOrderedDictionaryContained(str, dict));
    }

    @Test
    public void should_return_false_test_1() {
        String str = "abc";
        char[] dict = {'a', 'b', 'c', 'd'};
        TestUtils.iAssertFalse(new ShortestSubstringContainingAllDictionaryOrdered().isOrderedDictionaryContained(str, dict));
    }

    @Test
    public void should_return_true_test_1() {
        String str = "acdbcad";
        char[] dict = {'a', 'b', 'c', 'd'};
        TestUtils.iAssertTrue(new ShortestSubstringContainingAllDictionaryOrdered().isOrderedDictionaryContained(str, dict));
    }


    @Test
    public void should_return_true_test_2() {
        String str = "aaaabcd";
        char[] dict = {'a', 'b', 'c', 'd'};
        TestUtils.iAssertTrue(new ShortestSubstringContainingAllDictionaryOrdered().isOrderedDictionaryContained(str, dict));
    }

    @Test
    public void should_return_false_test_3() {
        String str = "adddbdddcccabbbd";
        char[] dict = {'a', 'b', 'c', 'd'};
        TestUtils.iAssertTrue(new ShortestSubstringContainingAllDictionaryOrdered().isOrderedDictionaryContained(str, dict));
    }

    @Test
    public void should_return_false_test_4() {
        String str = "bcdaaabc";
        char[] dict = {'a', 'b', 'c', 'd'};
        TestUtils.iAssertFalse(new ShortestSubstringContainingAllDictionaryOrdered().isOrderedDictionaryContained(str, dict));
    }

    @Test
    public void should_return_false_test_5() {
        String str = "adddbdddcccab";
        char[] dict = {'a', 'b', 'c', 'd'};
        TestUtils.iAssertFalse(new ShortestSubstringContainingAllDictionaryOrdered().isOrderedDictionaryContained(str, dict));
    }

    @Test
    public void should_return_abcbd_bf_test_1() {
        String str = "adddbdabcbdb";
        char[] dict = {'a', 'b', 'c', 'd'};
        String expected = "abcbd";
        MatcherAssert.assertThat(expected, Is.is(new ShortestSubstringContainingAllDictionaryOrdered().minimalLengthStringContainingAllCharactersInDictionary_bf(str, dict)));
    }

    @Test
    public void should_return_abcbd_bf_test_2() {
        String str = "aabbacdabcda";
        char[] dict = {'a', 'b', 'c', 'd'};
        String expected = "abcd";
        MatcherAssert.assertThat(expected, Is.is(new ShortestSubstringContainingAllDictionaryOrdered().minimalLengthStringContainingAllCharactersInDictionary_bf(str, dict)));
    }

    @Test
    public void should_return_abcbd_bf_test_3() {
        String str = "ababcd";
        char[] dict = {'a', 'b', 'c', 'd'};
        String expected = "abcd";
        MatcherAssert.assertThat(expected, Is.is(new ShortestSubstringContainingAllDictionaryOrdered().minimalLengthStringContainingAllCharactersInDictionary_bf(str, dict)));
    }

    @Test
    public void should_return_abcbd_bf_test_4() {
        String str = "aabcdaaabbcdd";
        char[] dict = {'a', 'b', 'c', 'd'};
        String expected = "abcd";
        MatcherAssert.assertThat(expected, Is.is(new ShortestSubstringContainingAllDictionaryOrdered().minimalLengthStringContainingAllCharactersInDictionary_bf(str, dict)));
    }

    @Test
    public void should_return_abcbd_bf_test_5() {
        String str = "aaaaaaaaaabbccddbbbbccccddddabbcdddddd";
        char[] dict = {'a', 'b', 'c', 'd'};
        String expected = "abbcd";
        MatcherAssert.assertThat(expected, Is.is(new ShortestSubstringContainingAllDictionaryOrdered().minimalLengthStringContainingAllCharactersInDictionary_bf(str, dict)));
    }

    @Test
    public void should_return_abcbd_bf_test_6() {
        String str = "abababcabcabbcdabcdd";
        char[] dict = {'a', 'b', 'c', 'd'};
        String expected = "abcd";
        MatcherAssert.assertThat(expected, Is.is(new ShortestSubstringContainingAllDictionaryOrdered().minimalLengthStringContainingAllCharactersInDictionary_bf(str, dict)));
    }

    @Test
    public void should_return_abcbd_optimal_test_1() {
        String str = "adddbdabcbdb";
        char[] dict = {'a', 'b', 'c', 'd'};
        String expected = "abcbd";
        MatcherAssert.assertThat(expected, Is.is(new ShortestSubstringContainingAllDictionaryOrdered().minimalLengthStringContainingAllCharactersInDictionary(str, dict)));
    }

    @Test
    public void should_return_abcbd_optimal_test_2() {
        String str = "aabbacdabcda";
        char[] dict = {'a', 'b', 'c', 'd'};
        String expected = "abcd";
        MatcherAssert.assertThat(expected, Is.is(new ShortestSubstringContainingAllDictionaryOrdered().minimalLengthStringContainingAllCharactersInDictionary(str, dict)));
    }

    @Test
    public void should_return_abcbd_optimal_test_3() {
        String str = "ababcd";
        char[] dict = {'a', 'b', 'c', 'd'};
        String expected = "abcd";
        MatcherAssert.assertThat(expected, Is.is(new ShortestSubstringContainingAllDictionaryOrdered().minimalLengthStringContainingAllCharactersInDictionary(str, dict)));
    }

    @Test
    public void should_return_abcbd_optimal_test_4() {
        String str = "aabcdaaabbcdd";
        char[] dict = {'a', 'b', 'c', 'd'};
        String expected = "abcd";
        MatcherAssert.assertThat(expected, Is.is(new ShortestSubstringContainingAllDictionaryOrdered().minimalLengthStringContainingAllCharactersInDictionary(str, dict)));
    }

    @Test
    public void should_return_abcbd_optimal_test_5() {
        String str = "aaaaaaaaaabbccddbbbbccccddddabbcdddddd";
        char[] dict = {'a', 'b', 'c', 'd'};
        String expected = "abbcd";
        MatcherAssert.assertThat(expected, Is.is(new ShortestSubstringContainingAllDictionaryOrdered().minimalLengthStringContainingAllCharactersInDictionary(str, dict)));
    }

    @Test
    public void should_return_abcbd_optimal_test_6() {
        String str = "abababcabcabbcdabcdd";
        char[] dict = {'a', 'b', 'c', 'd'};
        String expected = "abcd";
        MatcherAssert.assertThat(expected, Is.is(new ShortestSubstringContainingAllDictionaryOrdered().minimalLengthStringContainingAllCharactersInDictionary(str, dict)));
    }
}
