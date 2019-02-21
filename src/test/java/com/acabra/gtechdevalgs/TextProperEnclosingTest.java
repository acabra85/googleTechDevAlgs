package com.acabra.gtechdevalgs;

import org.junit.Assert;
import org.junit.Test;

public class TextProperEnclosingTest {

    @Test(expected = NullPointerException.class)
    public void should_fail(){
        new TextProperEnclosing().isProperlyNestedText(null);
    }

    @Test
    public void should_return_true_test_1() {
        String text = "";
        Assert.assertTrue(new TextProperEnclosing().isProperlyNestedText(text));
    }

    @Test
    public void should_return_true_test_2() {
        String text = "{ [ ] ( ) }";
        Assert.assertTrue(new TextProperEnclosing().isProperlyNestedText(text));
    }
    @Test
    public void should_return_true_test_4() {
        String text = "( \" ( \" \" ) \" )";
        Assert.assertTrue(new TextProperEnclosing().isProperlyNestedText(text));
    }

    @Test
    public void should_return_false_test_1() {
        String text = "{ [ }";
        Assert.assertFalse(new TextProperEnclosing().isProperlyNestedText(text));
    }
    @Test
    public void should_return_false_test_2() {
        String text = "\" \" \" \" \"";
        Assert.assertFalse(new TextProperEnclosing().isProperlyNestedText(text));
    }

    @Test
    public void should_return_false_test_3() {
        String text = "{ \" }* \" <";
        Assert.assertFalse(new TextProperEnclosing().isProperlyNestedText(text));
    }
}
