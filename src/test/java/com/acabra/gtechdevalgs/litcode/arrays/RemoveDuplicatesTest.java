package com.acabra.gtechdevalgs.litcode.arrays;

import org.hamcrest.core.Is;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveDuplicatesTest {

    @Test
    public void should_return_ca() {
        MatcherAssert.assertThat(new RemoveDuplicates().removeDuplicates("abbaca"), Is.is("ca"));
    }
}