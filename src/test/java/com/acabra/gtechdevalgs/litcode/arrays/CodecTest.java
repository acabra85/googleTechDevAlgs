package com.acabra.gtechdevalgs.litcode.arrays;

import com.acabra.gtechdevalgs.TestUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CodecTest {

    @Test
    public void test_1() {
        List<String> input = new ArrayList<String>(){{
            add("Hello");
            add("World");
        }};
        Codec codec = new Codec();
        TestUtils.AssertListEquals(input, codec.decode(codec.encode(input)));
    }

    @Test
    public void test_2() {
        List<String> input = new ArrayList<>();
        Codec codec = new Codec();
        TestUtils.AssertListEquals(input, codec.decode(codec.encode(input)));
    }

    @Test
    public void test_3() {
        List<String> input = new ArrayList<String>(){{
            add("");
        }};
        Codec codec = new Codec();
        TestUtils.AssertListEquals(input, codec.decode(codec.encode(input)));
    }

    @Test
    public void test_4() {
        List<String> input = new ArrayList<String>(){{
            add("");
            add("");
            add("");
            add("");
            add("");
            add("");
            add("");
        }};
        Codec codec = new Codec();
        TestUtils.AssertListEquals(input, codec.decode(codec.encode(input)));
    }
}
