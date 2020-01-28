package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * Describe your class
 */
public class ParseIntTest {

    @Test
    public void parse_ints() {
        ParseInt s = new ParseInt();

        List<String> input = Arrays.asList("+", "1095502006p8", "-42", "    +000000000012355", "-2147483648", "2147483647", "-2147483649", "2147483648",
                "     -0000000435guygu", "      +ppppppp", "             +000000000000g", "   -0000000000001f", "    -0000002147483648",
                "    -0000002147483647p"
        );
        List<Integer> expected = Arrays.asList(0, 1095502006,
                -42, 12355, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, -435, 0, 0, -1,
                Integer.MIN_VALUE, -2147483647);
        for (int i = 0; i < input.size() ; i++) {
            int actual = s.myAtoi(input.get(i));
            String error = String.format("in[%s] got [%d] expected [%d]", input.get(i), actual, expected.get(i));
            Assert.assertEquals(error, (int)expected.get(i), actual);
        }
    }
}
