package com.acabra.gtechdevalgs;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmptyTextEditorTest {

    @Test
    public void tests() {
        Assert.assertThat(new EmptyTextEditor().backspaceCompare("ab#c", "ad#c"), Is.is(true));
        Assert.assertThat(new EmptyTextEditor().backspaceCompare("ab##", "c#d#"), Is.is(true));
        Assert.assertThat(new EmptyTextEditor().backspaceCompare("a##c", "#a#c"), Is.is(true));
        Assert.assertThat(new EmptyTextEditor().backspaceCompare("a#c", "b"), Is.is(false));
    }
}