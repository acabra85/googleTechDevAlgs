package com.acabra.gtechdevalgs.litcode.arrays;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

/**
 * Java implementation of UNIX chdir (cd) command.
 */
public class ChangeDirectoryTest {

    @Test
    public void should_return_a() {
        String input = "a/b/c/../..";
        String expected = "a";
        MatcherAssert.assertThat(expected, Is.is(ChangeDirectory.changeDir(input)));
    }

    @Test
    public void should_return_empty_for_empty_input() {
        String input = "";
        String expected = "";
        MatcherAssert.assertThat(expected, Is.is(ChangeDirectory.changeDir(input)));
    }

    @Test
    public void should_return_self() {
        String input = "somedirname";
        MatcherAssert.assertThat(input, Is.is(ChangeDirectory.changeDir(input)));
    }

    @Test
    public void should_return_v() {
        String input = "/a/../../../../v";
        String expected = "/v";
        MatcherAssert.assertThat(expected, Is.is(ChangeDirectory.changeDir(input)));
    }

    @Test
    public void should_return_root_1() {
        String input = "/a/../../../..";
        String expected = "/";
        MatcherAssert.assertThat(expected, Is.is(ChangeDirectory.changeDir(input)));
    }

    @Test
    public void should_return_root_2() {
        String input = "..";
        String expected = "/";
        MatcherAssert.assertThat(expected, Is.is(ChangeDirectory.changeDir(input)));
    }

    @Test
    public void should_return_root_3() {
        String input = "/../../../..";
        String expected = "/";
        MatcherAssert.assertThat(expected, Is.is(ChangeDirectory.changeDir(input)));
    }

    @Test
    public void should_return_root_4() {
        String input = "../../../..";
        String expected = "/";
        MatcherAssert.assertThat(expected, Is.is(ChangeDirectory.changeDir(input)));
    }

    @Test
    public void should_return_root_c_d() {
        String input = "../../../c/d/e/..";
        String expected = "/c/d";
        MatcherAssert.assertThat(expected, Is.is(ChangeDirectory.changeDir(input)));
    }

    @Test
    public void should_return_root_c() {
        String input = "/../../../c/d/../e/..";
        String expected = "/c";
        MatcherAssert.assertThat(expected, Is.is(ChangeDirectory.changeDir(input)));
    }

    @Test
    public void should_return_root_c_e() {
        String input = "/../../../c/d/../e";
        String expected = "/c/e";
        MatcherAssert.assertThat(expected, Is.is(ChangeDirectory.changeDir(input)));
    }

    @Test
    public void should_return_root_a() {
        String input = "/a/./././.";
        String expected = "/a";
        MatcherAssert.assertThat(expected, Is.is(ChangeDirectory.changeDir(input)));
    }
}
