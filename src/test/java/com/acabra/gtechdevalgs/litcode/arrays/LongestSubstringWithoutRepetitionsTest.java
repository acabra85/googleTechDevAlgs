package com.acabra.gtechdevalgs.litcode.arrays;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

public class LongestSubstringWithoutRepetitionsTest {

    @Test
    public void test() {
        MatcherAssert.assertThat(3, Is.is(LongestSubstringWithoutRepetitions.lengthOfLongestSubstring("pwwkew")));
        MatcherAssert.assertThat(4, Is.is(LongestSubstringWithoutRepetitions.lengthOfLongestSubstring("abbcbadd")));
        MatcherAssert.assertThat(4, Is.is(LongestSubstringWithoutRepetitions.lengthOfLongestSubstring("abcad")));
        MatcherAssert.assertThat(4, Is.is(LongestSubstringWithoutRepetitions.lengthOfLongestSubstring(" 5% h")));
    }

}