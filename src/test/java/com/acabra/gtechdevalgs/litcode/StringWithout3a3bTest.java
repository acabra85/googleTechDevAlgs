package com.acabra.gtechdevalgs.litcode;

import com.acabra.gtechdevalgs.TestUtils;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

public class StringWithout3a3bTest {

    @Test
    public void should_return_string_aabaa() {
        int A = 4;
        int B = 1;

        MatcherAssert.assertThat("aabaa", Is.is(new StringWithout3a3b().strWithout3a3b(A, B)));
    }


    @Test
    public void should_be_true_contains_aaa() {
        TestUtils.iAssertTrue(new StringWithout3a3b().invalid("aaaaa"));
    }

    @Test
    public void should_be_true_contains_bbb() {
        TestUtils.iAssertTrue(new StringWithout3a3b().invalid("abbb"));
    }

    @Test
    public void should_be_true_contains_both() {
        TestUtils.iAssertTrue(new StringWithout3a3b().invalid("bbbaaa"));
    }
}
