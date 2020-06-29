package com.acabra.gtechdevalgs.litcode.arrays;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveDuplicatesTest {

    @Test
    public void should_return_ca() {
        Assert.assertThat(new RemoveDuplicates().removeDuplicates("abbaca"), Is.is("ca"));
    }
}