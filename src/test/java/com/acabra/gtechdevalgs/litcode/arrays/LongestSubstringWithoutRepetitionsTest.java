package com.acabra.gtechdevalgs.litcode.arrays;

import org.junit.Assert;
import org.junit.Test;

public class LongestSubstringWithoutRepetitionsTest {

    @Test
    public void test() {
        Assert.assertEquals(3, LongestSubstringWithoutRepetitions.lengthOfLongestSubstring("pwwkew"));
        Assert.assertEquals(4, LongestSubstringWithoutRepetitions.lengthOfLongestSubstring("abbcbadd"));
        Assert.assertEquals(4, LongestSubstringWithoutRepetitions.lengthOfLongestSubstring("abcad"));
        Assert.assertEquals(4, LongestSubstringWithoutRepetitions.lengthOfLongestSubstring(" 5% h"));
    }

}