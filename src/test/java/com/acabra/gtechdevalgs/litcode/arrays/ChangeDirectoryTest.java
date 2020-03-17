package com.acabra.gtechdevalgs.litcode.arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Java implementation of UNIX chdir (cd) command.
 */
public class ChangeDirectoryTest {

    @Test
    public void should_return_a() {
        String input = "a/b/c/../..";
        String expected = "a";
        Assert.assertEquals(expected, ChangeDirectory.changeDir(input));
    }

    @Test
    public void should_return_empty_for_empty_input() {
        String input = "";
        String expected = "";
        Assert.assertEquals(expected, ChangeDirectory.changeDir(input));
    }
}
