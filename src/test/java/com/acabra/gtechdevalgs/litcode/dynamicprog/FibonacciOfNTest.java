package com.acabra.gtechdevalgs.litcode.dynamicprog;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Random;
import java.util.function.Supplier;

class FibonacciOfNTest {

    private static final Random r = new Random(); // Choosing any method at random should work
    private static final FibonacciOfN.Method[] methods = FibonacciOfN.Method.values();
    private static final Supplier<FibonacciOfN.Method> m = () -> methods[r.nextInt(methods.length)];

    private static String readFileAsString(String fileName) {
        final String path = "constants/fibonacci/" + fileName;
        try (InputStream resourceAsStream = FibonacciOfN.class.getClassLoader()
                .getResourceAsStream(path)) {
            if (resourceAsStream == null) {
                throw new NullPointerException("File not found!: " + path);
            }
            return new String(resourceAsStream.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void assertWorksOnAllSupportedMethods(int n, String expectedStr) {
        BigInteger prev = null;
        BigInteger expected = new BigInteger(expectedStr);
        for (FibonacciOfN.Method m: FibonacciOfN.Method.supports(n)) {
            final BigInteger actual = new FibonacciOfN(m).get(n);
            Assertions.assertThat(actual).isEqualTo(expected);
            if (prev != null) {
                Assertions.assertThat(prev).isEqualTo(actual);
            }
            prev = actual;
        }
    }

    @Test
    public void shouldReturn196418() {
        int n = 27;
        String expected = "196418";
        assertWorksOnAllSupportedMethods(n, expected);
    }

    @Test
    public void shouldReturn1_208988DigitsLongNumber() {
        int n = 1_000_000;
        String expected = FibonacciOfNTest.readFileAsString("one_million.txt");
        assertWorksOnAllSupportedMethods(n, expected);
    }


    @Test
    public void shouldReturn1_417975DigitsLongNumber() {
        int n = 2_000_000;
        String expected = FibonacciOfNTest.readFileAsString("two_million.txt");
        assertWorksOnAllSupportedMethods(n, expected);
    }

    @Test
    public void shouldReturn_1882DigitsLongNumber() {
        int n = 9003;
        String expected = FibonacciOfNTest.readFileAsString("nine_thousand_three.txt");
        assertWorksOnAllSupportedMethods(n, expected);
    }

    @Test
    public void shouldReturn89() {
        BigInteger expected = BigInteger.valueOf(89);
        int n = 11;
        for (FibonacciOfN.Method m: FibonacciOfN.Method.values()) {
            Assertions.assertThat(new FibonacciOfN(m).get(n)).isEqualTo(expected);
        }
    }

    @Test
    public void shouldReturn610() {
        BigInteger expected = BigInteger.valueOf(610);
        int n = 15;
        for (FibonacciOfN.Method m: FibonacciOfN.Method.values()) {
            Assertions.assertThat(new FibonacciOfN(m).get(n)).isEqualTo(expected);
        }
    }

    @Test
    public void shouldReturn144() {
        BigInteger expected = BigInteger.valueOf(144);
        int n = 12;
        for (FibonacciOfN.Method m: FibonacciOfN.Method.values()) {
            Assertions.assertThat(new FibonacciOfN(m).get(n)).isEqualTo(expected);
        }
    }

    @Test
    public void shouldReturn_555565404224292694404015791808() {
        BigInteger expected = new BigInteger("555565404224292694404015791808");
        int n = 144;
        Assertions.assertThat(new FibonacciOfN(FibonacciOfN.Method.BINARY_EXPONENTIATION).get(n)).isEqualTo(expected);
    }

    @Test
    public void shouldReturn1_for0() {
        BigInteger expected = BigInteger.ZERO;
        int n = 0;
        Assertions.assertThat(new FibonacciOfN(m.get()).get(n)).isEqualTo(expected);
    }

    @Test
    public void shouldReturn1_for1() {
        BigInteger expected = BigInteger.ONE;
        int n = 1;
        Assertions.assertThat(new FibonacciOfN(m.get()).get(n)).isEqualTo(expected);
    }

    @Test
    public void shouldReturn1_for2() {
        BigInteger expected = BigInteger.ONE;
        int n = 2;
        Assertions.assertThat(new FibonacciOfN(m.get()).get(n)).isEqualTo(expected);
    }

    @Test
    public void shouldReturn2() {
        BigInteger expected = BigInteger.TWO;
        int n = 3;
        Assertions.assertThat(new FibonacciOfN(m.get()).get(n)).isEqualTo(expected);
    }

    @Test
    public void shouldReturn3() {
        BigInteger expected = BigInteger.valueOf(3);
        int n = 4;
        Assertions.assertThat(new FibonacciOfN(m.get()).get(n)).isEqualTo(expected);
    }

    @Test
    public void shouldReturn5() {
        BigInteger expected = BigInteger.valueOf(5);
        int n = 5;
        Assertions.assertThat(new FibonacciOfN(m.get()).get(n)).isEqualTo(expected);
    }

    @Test
    public void shouldReturn8() {
        BigInteger expected = BigInteger.valueOf(8);
        int n = 6;
        Assertions.assertThat(new FibonacciOfN(m.get()).get(n)).isEqualTo(expected);
    }

    @Test
    public void shouldReturn13() {
        BigInteger expected = BigInteger.valueOf(13);
        int n = 7;
        Assertions.assertThat(new FibonacciOfN(m.get()).get(n)).isEqualTo(expected);
    }

    @Test
    public void shouldReturn21() {
        BigInteger expected = BigInteger.valueOf(21);
        int n = 8;
        Assertions.assertThat(new FibonacciOfN(m.get()).get(n)).isEqualTo(expected);
    }

    @Test
    public void shouldReturn34() {
        BigInteger expected = BigInteger.valueOf(34);
        int n = 9;
        Assertions.assertThat(new FibonacciOfN(m.get()).get(n)).isEqualTo(expected);
    }

    @Test
    public void shouldReturn55() {
        BigInteger expected = BigInteger.valueOf(55);
        int n = 10;
        Assertions.assertThat(new FibonacciOfN(m.get()).get(n)).isEqualTo(expected);
    }

    @Test
    public void shouldFail_RecursiveMethodDoesNotSupportN() {
        int n = 144;
        Assertions.assertThatThrownBy(() -> new FibonacciOfN(FibonacciOfN.Method.RECURSIVE).get(n))
                .isExactlyInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    public void shouldFail_IterativeMethodDoesNotSupportN() {
        int n = 501_001;
        Assertions.assertThatThrownBy(() -> new FibonacciOfN(FibonacciOfN.Method.ITERATIVE).get(n))
                .isExactlyInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    public void shouldFail_BinaryExponentiationMethodDoesNotSupportN() {
        int n = 2_000_001;
        Assertions.assertThatThrownBy(() -> new FibonacciOfN(FibonacciOfN.Method.BINARY_EXPONENTIATION).get(n))
                .isExactlyInstanceOf(UnsupportedOperationException.class);
    }
}