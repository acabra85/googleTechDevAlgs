package com.acabra.gtechdevalgs.litcode.arrays;

import com.acabra.gtechdevalgs.TestUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * Describe your class
 */
public class RunLengthEncodingTest {

    @Test
    public void should_encode_aaabbbccc_test_01() {
        String toEncode = "aaabbbccc";
        String expectedKey = "abc";
        List<Integer> expectedEncoding = Arrays.asList(3, 3, 3);
        RunLengthEncoding rle = new RunLengthEncoding(toEncode);
        Assert.assertEquals(expectedKey, rle.key);
        TestUtils.assertListEquals(expectedEncoding, rle.encodings);
    }

    @Test
    public void should_encode_acder_test_02() {
        String toEncode = "acder";
        String expectedKey = "acder";
        List<Integer> expectedEncoding = Arrays.asList(1,1,1,1,1);
        RunLengthEncoding rle = new RunLengthEncoding(toEncode);
        Assert.assertEquals(expectedKey, rle.key);
        TestUtils.assertListEquals(expectedEncoding, rle.encodings);
    }

    @Test
    public void should_encode_acder_test_03() {
        String toEncode = "aaaaa";
        String expectedKey = "a";
        List<Integer> expectedEncoding = Arrays.asList(5);
        RunLengthEncoding rle = new RunLengthEncoding(toEncode);
        Assert.assertEquals(expectedKey, rle.key);
        TestUtils.assertListEquals(expectedEncoding, rle.encodings);
    }

    @Test
    public void should_encode_acder_test_04() {
        String toEncode = "fffkl";
        String expectedKey = "fkl";
        List<Integer> expectedEncoding = Arrays.asList(3,1,1);
        RunLengthEncoding rle = new RunLengthEncoding(toEncode);
        Assert.assertEquals(expectedKey, rle.key);
        TestUtils.assertListEquals(expectedEncoding, rle.encodings);
    }

    @Test
    public void should_encode_acder_test_05() {
        String toEncode = null;
        String expectedKey = "";
        List<Integer> expectedEncoding = Collections.emptyList();
        RunLengthEncoding rle = new RunLengthEncoding(toEncode);
        Assert.assertEquals(expectedKey, rle.key);
        TestUtils.assertListEquals(expectedEncoding, rle.encodings);
    }
}
