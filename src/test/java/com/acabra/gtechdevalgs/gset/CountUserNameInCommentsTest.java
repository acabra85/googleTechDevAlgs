package com.acabra.gtechdevalgs.gset;

import com.acabra.gtechdevalgs.TestUtils;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

/**
 * Describe your class
 */
public class CountUserNameInCommentsTest {

    @Test
    public void test_should_return_0_test_01(){
        int expected = 0;
        String userName = "aaa";
        MyFile myFile = TestUtils.buildMyFile("google/CountUsernameInComments_test01.txt");
        MatcherAssert.assertThat(expected, Is.is(new CountUserNameInComments().countOccurrences(myFile, userName)));
    }

    @Test
    public void test_should_return_8_test_01(){
        MyFile myFile = TestUtils.buildMyFile("google/CountUsernameInComments_test02.txt");
        String userName = "@sarmiea";
        int expected = 10;
        MatcherAssert.assertThat(expected, Is.is(new CountUserNameInComments().countOccurrences(myFile, userName)));
    }
}
