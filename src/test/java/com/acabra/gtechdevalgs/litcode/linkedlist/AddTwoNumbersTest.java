package com.acabra.gtechdevalgs.litcode.linkedlist;

import com.acabra.gtechdevalgs.TestUtils;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

public class AddTwoNumbersTest {

    @Test
    public void should_return_807_test_01() {
        ListNode num1 = TestUtils.buildNumberAsNodeReverseOrder("342");
        ListNode num2 = TestUtils.buildNumberAsNodeReverseOrder("465");
        ListNode expected = TestUtils.buildNumberAsNodeReverseOrder("807");
        MatcherAssert.assertThat(expected, Is.is(new AddTwoNumbers().add(num1, num2)));
    }

    @Test
    public void should_return_26_test_02() {
        ListNode num1 = TestUtils.buildNumberAsNodeReverseOrder("25");
        ListNode num2 = TestUtils.buildNumberAsNodeReverseOrder("1");
        ListNode expected = TestUtils.buildNumberAsNodeReverseOrder("26");
        MatcherAssert.assertThat(expected, Is.is(new AddTwoNumbers().add(num1, num2)));
    }

    @Test
    public void should_return_1000_test_03() {
        ListNode num1 = TestUtils.buildNumberAsNodeReverseOrder("999");
        ListNode num2 = TestUtils.buildNumberAsNodeReverseOrder("1");
        ListNode expected = TestUtils.buildNumberAsNodeReverseOrder("1000");
        MatcherAssert.assertThat(expected, Is.is(new AddTwoNumbers().add(num1, num2)));
    }

    @Test
    public void should_return_1000_test_04() {
        ListNode num1 = TestUtils.buildNumberAsNodeReverseOrder("1");
        ListNode num2 = TestUtils.buildNumberAsNodeReverseOrder("999");
        ListNode expected = TestUtils.buildNumberAsNodeReverseOrder("1000");
        MatcherAssert.assertThat(expected, Is.is(new AddTwoNumbers().add(num1, num2)));
    }
}
