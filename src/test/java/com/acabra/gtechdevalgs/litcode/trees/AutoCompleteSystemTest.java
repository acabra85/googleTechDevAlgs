package com.acabra.gtechdevalgs.litcode.trees;

import com.acabra.gtechdevalgs.TestUtils;
import java.util.Arrays;
import java.util.Collections;
import org.junit.Test;

/**
 * Describe your class
 */
public class AutoCompleteSystemTest {

    @Test
    public void should_return_size_3_test_01() {
        String[] sentences = {"i love you", "island", "iroman", "i love leetcode"};
        int[] times = {5, 3, 2, 2};
        AutoCompleteSystem autoCompleteSystem = new AutoCompleteSystem(sentences, times);
        TestUtils.assertListEquals(Arrays.asList("i love you", "island", "i love leetcode"), autoCompleteSystem.input('i'));
        TestUtils.assertListEquals(Arrays.asList("i love you", "i love leetcode"), autoCompleteSystem.input(' '));
        TestUtils.assertListEquals(Collections.emptyList(), autoCompleteSystem.input('a'));
        TestUtils.assertListEquals(Collections.emptyList(), autoCompleteSystem.input('#'));
    }
}
