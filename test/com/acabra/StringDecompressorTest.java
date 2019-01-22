package com.acabra;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Agustin on 1/22/2019.
 */
public class StringDecompressorTest {

    @Test
    public void must_decompress_test_1() {
        String input = "3[abc]4[ab]c";
        String expectedOutput = "abcabcabcababababc";
        Assert.assertEquals(expectedOutput, StringDecompressor.decompress(input));
    }

    @Test
    public void must_decompress_test_2() {
        String input = "10[a]";
        String expectedOutput = "aaaaaaaaaa";
        Assert.assertEquals(expectedOutput, StringDecompressor.decompress(input));
    }

    @Test
    public void must_decompress_test_3() {
        String input = "2[3[a]b]";
        String expectedOutput = "aaabaaab";
        Assert.assertEquals(expectedOutput, StringDecompressor.decompress(input));
    }

    @Test
    public void must_decompress_test_4() {
        String input = "2[aabc]d";
        String expectedOutput = "aabcaabcd";
        Assert.assertEquals(expectedOutput, StringDecompressor.decompress(input));
    }

    @Test
    public void must_decompress_test_5() {
        String input = "2[2[abbb]c]";
        String expectedOutput = "abbbabbbcabbbabbbc";
        Assert.assertEquals(expectedOutput, StringDecompressor.decompress(input));
    }
}
