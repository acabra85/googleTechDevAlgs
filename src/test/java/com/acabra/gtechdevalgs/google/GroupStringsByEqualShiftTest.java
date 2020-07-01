package com.acabra.gtechdevalgs.google;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class GroupStringsByEqualShiftTest {

    private GroupStringsByEqualShift underTest;

    @Before
    public void setup() {
        underTest = new GroupStringsByEqualShift();
    }

    @Test
    public void shouldReturn3Groups() {
        String[] strings = {"abc","bcd","acef","xyz","az","ba","a","z"};
        HashSet<String> groupLength3 = new HashSet<String>() {{
            add("abc");
            add("bcd");
            add("xyz");
        }};
        HashSet<String> groupLength2 = new HashSet<String>() {{
            add("az");
            add("ba");
        }};
        HashSet<String> groupLength1 = new HashSet<String>() {{
            add("a");
            add("z");
        }};

        HashSet<String> groupLength4 = new HashSet<String>() {{
            add("acef");
        }};
        HashSet<String>[] expected = new HashSet[]{groupLength1,  groupLength2, groupLength3, groupLength4};
        List<List<String>> actual = underTest.groupStrings(strings);
        Assert.assertThat(actual.size(), Is.is(4));
        for (List<String> stringList : actual) {
            int i = stringList.get(0).length() - 1;
            for (String s : stringList) {
                Assert.assertThat(expected[i].contains(s), Is.is(true));
            }
        }
    }

    @Test
    public void shouldReturn1GroupOfSize2() {
        String[] strings = {"abc","abc"};
        List<List<String>> actual = underTest.groupStrings(strings);
        Assert.assertThat(actual.size(), Is.is(1));
        Assert.assertThat(actual.get(0).size(), Is.is(2));
        for (String act : actual.get(0)) {
            Assert.assertThat("abc".equals(act), Is.is(true));
        }
    }
}