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

    @Test
    public void should_return_self() {
        String input = "somedirname";
        Assert.assertEquals(input, ChangeDirectory.changeDir(input));
    }

    @Test
    public void should_return_v() {
        String input = "/a/../../../../v";
        String expected = "/v";
        Assert.assertEquals(expected, ChangeDirectory.changeDir(input));
    }

    @Test
    public void should_return_root_1() {
        String input = "/a/../../../..";
        String expected = "/";
        Assert.assertEquals(expected, ChangeDirectory.changeDir(input));
    }

    @Test
    public void should_return_root_2() {
        String input = "..";
        String expected = "/";
        Assert.assertEquals(expected, ChangeDirectory.changeDir(input));
    }

    @Test
    public void should_return_root_3() {
        String input = "/../../../..";
        String expected = "/";
        Assert.assertEquals(expected, ChangeDirectory.changeDir(input));
    }

    @Test
    public void should_return_root_4() {
        String input = "../../../..";
        String expected = "/";
        Assert.assertEquals(expected, ChangeDirectory.changeDir(input));
    }

    @Test
    public void should_return_root_c_d() {
        String input = "../../../c/d/e/..";
        String expected = "/c/d";
        Assert.assertEquals(expected, ChangeDirectory.changeDir(input));
    }

    @Test
    public void should_return_root_c() {
        String input = "/../../../c/d/../e/..";
        String expected = "/c";
        Assert.assertEquals(expected, ChangeDirectory.changeDir(input));
    }

    @Test
    public void should_return_root_c_e() {
        String input = "/../../../c/d/../e";
        String expected = "/c/e";
        Assert.assertEquals(expected, ChangeDirectory.changeDir(input));
    }

    @Test
    public void should_return_root_a() {
        String input = "/a/./././.";
        String expected = "/a";
        Assert.assertEquals(expected, ChangeDirectory.changeDir(input));
    }
}
