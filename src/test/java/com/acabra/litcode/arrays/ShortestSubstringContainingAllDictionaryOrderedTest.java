package com.acabra.litcode.arrays;

import org.junit.Assert;
import org.junit.Test;

public class ShortestSubstringContainingAllDictionaryOrderedTest {

    @Test
    public void should_return_false_test_0() {
        String str = null;
        char[] dict = {'a', 'b', 'c', 'd'};
        Assert.assertFalse(new ShortestSubstringContainingAllDictionaryOrdered().isOrderedDictionaryContained(str, dict));
    }

    @Test
    public void should_return_false_test_1() {
        String str = "abc";
        char[] dict = {'a', 'b', 'c', 'd'};
        Assert.assertFalse(new ShortestSubstringContainingAllDictionaryOrdered().isOrderedDictionaryContained(str, dict));
    }

    @Test
    public void should_return_true_test_1() {
        String str = "acdbcad";
        char[] dict = {'a', 'b', 'c', 'd'};
        Assert.assertTrue(new ShortestSubstringContainingAllDictionaryOrdered().isOrderedDictionaryContained(str, dict));
    }


    @Test
    public void should_return_true_test_2() {
        String str = "aaaabcd";
        char[] dict = {'a', 'b', 'c', 'd'};
        Assert.assertTrue(new ShortestSubstringContainingAllDictionaryOrdered().isOrderedDictionaryContained(str, dict));
    }

    @Test
    public void should_return_false_test_3() {
        String str = "adddbdddcccabbbd";
        char[] dict = {'a', 'b', 'c', 'd'};
        Assert.assertTrue(new ShortestSubstringContainingAllDictionaryOrdered().isOrderedDictionaryContained(str, dict));
    }

    @Test
    public void should_return_false_test_4() {
        String str = "bcdaaabc";
        char[] dict = {'a', 'b', 'c', 'd'};
        Assert.assertFalse(new ShortestSubstringContainingAllDictionaryOrdered().isOrderedDictionaryContained(str, dict));
    }

    @Test
    public void should_return_false_test_5() {
        String str = "adddbdddcccab";
        char[] dict = {'a', 'b', 'c', 'd'};
        Assert.assertFalse(new ShortestSubstringContainingAllDictionaryOrdered().isOrderedDictionaryContained(str, dict));
    }

    @Test
    public void should_return_abcbd_test_1_bf() {
        String str = "adddbdabcbdb";
        char[] dict = {'a', 'b', 'c', 'd'};
        String expected = "abcbd";
        Assert.assertEquals(expected, new ShortestSubstringContainingAllDictionaryOrdered().minimalLengthStringContainingAllCharactersInDictionary_bf(str, dict));
    }

    @Test
    public void should_return_abcbd_test_2_bf() {
        String str = "adddbdabcbdb";
        char[] dict = {'a', 'b', 'c', 'd'};
        String expected = "abcbd";
        Assert.assertEquals(expected, new ShortestSubstringContainingAllDictionaryOrdered().minimalLengthStringContainingAllCharactersInDictionary_bf(str, dict));
    }
}
