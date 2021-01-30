package com.acabra.gtechdevalgs.litcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

public class LicenseKeyFormattingTest {

    /**
     *  The string S has been split into two parts, each part has 4 characters.
     * Note that the two extra dashes are not needed and can be removed.
     */
    @Test
    public void test_1() {
        String S = "5F3Z-2e-9-w";
        int K = 4;
        String expected = "5F3Z-2E9W";
        MatcherAssert.assertThat(expected, Is.is(new LicenseKeyFormatting().formatLicense(S, K)));
    }

    /**
     * Explanation: The string S has been split into three parts, each part has 2 characters except the first part as it could be shorter as mentioned above.
     */
    @Test
    public void test_2() {
        String S = "2-5g-3-J";
        int K = 2;
        String expected = "2-5G-3J";
        MatcherAssert.assertThat(expected, Is.is(new LicenseKeyFormatting().formatLicense(S, K)));
    }
}
