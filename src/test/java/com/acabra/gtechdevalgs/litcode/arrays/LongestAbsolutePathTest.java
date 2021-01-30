package com.acabra.gtechdevalgs.litcode.arrays;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

public class LongestAbsolutePathTest {

    @Test
    public void should_return_20_test_1() {
        String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        int expected = "dir/subdir2/file.ext".length();
        MatcherAssert.assertThat(expected, Is.is(new LongestAbsolutePath().lengthLongestPath(input)));
    }

    @Test
    public void should_return_32_test_2() {
        String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        int expected = "dir/subdir2/subsubdir2/file2.ext".length();
        MatcherAssert.assertThat(expected, Is.is(new LongestAbsolutePath().lengthLongestPath(input)));
    }
}
