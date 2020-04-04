package com.acabra.gtechdevalgs.litcode.dynamicprog;

import com.acabra.gtechdevalgs.TestUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class WordBreakIITest {

    private WordBreakII wb;

    @Before
    public void init() {
        this.wb = new WordBreakII();
    }

    public void tearDown() {
        this.wb = null;
    }

    @Test @Ignore
    public void test_1() {
        String s = "catsandog";
        String[] strings = {"cat", "cats", "sand", "an", "and", "dog", "dogs", "og"};
        List<String> wordDict = Arrays.asList(strings);
        String[] expectedStrings = {
                "cats an dog"
                ,"cat sand og"
                ,"cats and og"
        };
        List<String> expected = Arrays.asList(expectedStrings);
        TestUtils.assertListEquals(expected, wb.wordBreak(s, wordDict));
    }

    @Test @Ignore
    public void test_2() {
        String s = "pineapplepenapple";
        String[] strings = {"apple", "pen", "applepen", "pine", "pineapple"};
        List<String> wordDict = Arrays.asList(strings);
        String[] expectedStrings = {
                "pine apple pen apple",
                "pineapple pen apple",
                "pine applepen apple"
        };
        List<String> expected = Arrays.asList(expectedStrings);
        TestUtils.assertListEquals(expected, wb.wordBreak(s, wordDict));
    }

    @Test @Ignore
    public void test_3() {
        String s = "catsanddog";
        String[] strings = {"cat", "cats", "and", "sand", "dog"};
        List<String> wordDict = Arrays.asList(strings);
        String[] expectedStrings = {
                "cats and dog",
                "cat sand dog"
        };
        List<String> expected = Arrays.asList(expectedStrings);
        TestUtils.assertListEquals(expected, wb.wordBreak(s, wordDict));
    }
}
