package com.acabra.gtechdevalgs.litcode.dynamicprog;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class FibonacciOfN {
    private static final List<BigInteger> BASE = IntStream
            .of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55)
            .mapToObj(BigInteger::valueOf)
            .toList();
    public final Method method;
    FibonacciOfN(Method method) {
        this.method = method;
    }

    public BigInteger get(int n) {
        final long startTime = System.nanoTime();
        if (n < BASE.size()) {
            return BASE.get(n);
        }
        final BigInteger value = switch (this.method) {
            case BINARY_EXPONENTIATION -> this.matrixExponentiation(n);
            case RECURSIVE -> this.recursiveWithMemo(n);
            default -> this.iterative(n);
        };
        long elapsedMillis = System.nanoTime() - startTime;
        System.out.printf("N:%d, method:%s, t:%.4fms%n", n, this.method, elapsedMillis / 1_000_000.0);
        return value;
    }

    private BigInteger matrixExponentiation(int n) {
        final BigInteger[][] base = {
                {BigInteger.ZERO, BigInteger.ONE},
                {BigInteger.ONE, BigInteger.ONE}
        };
        final BigInteger[] results = multiplyMatrixVector(
                binaryMatrixExponentiation(base, n - 2), // n-2 a small optimization as not to compute further than needed
                new BigInteger[]{BigInteger.ZERO, BigInteger.ONE}
        );
        return results[0].add(results[1]);
    }

    private BigInteger iterative(int n) {
        BigInteger v1 = BASE.get(BASE.size() - 2);
        BigInteger v2 = BASE.getLast();
        BigInteger tmp;
        for (int i = BASE.size(); i < n; ++i) {
            tmp = v1.add(v2);
            v1 =  v2;
            v2 = tmp;
        }
        return v1.add(v2);
    }

    private BigInteger recursiveWithMemo(int n) {
        if (n > 100) return BigInteger.ZERO;
        Map<Integer, BigInteger> cache = new HashMap<>();
        IntStream.range(0, BASE.size()).forEach(i -> cache.put(i, BASE.get(i)));
        return doRecursive(cache, n);
    }

    private BigInteger doRecursive(Map<Integer, BigInteger> cache, int n) {
        BigInteger res = cache.get(n);
        if (res != null) {
            return res;
        }
        res = doRecursive(cache, n-1).add(doRecursive(cache, n-2));
        cache.put(n, res);
        return res;
    }

    private BigInteger[][] binaryMatrixExponentiation(BigInteger[][] a, int n) {
        BigInteger[][] result = new BigInteger[][]{
                {BigInteger.ONE, BigInteger.ZERO},
                {BigInteger.ZERO, BigInteger.ONE}
        };
        while(n > 0) {
            if ((n & 1) == 1) {
                result = multiplyMatrix(result, a);
            }
            a = multiplyMatrix(a, a);
            n = n >> 1;
        }
        return result;
    }

    private BigInteger[][] multiplyMatrix(BigInteger[][] a, BigInteger[][] b) {
        BigInteger c11 = a[0][0].multiply(b[0][0]).add(a[0][1].multiply(b[1][0]));
        BigInteger c12 = a[0][0].multiply(b[0][1]).add(a[0][1].multiply(b[1][1]));
        BigInteger c21 = a[1][0].multiply(b[0][0]).add(a[1][1].multiply(b[1][0]));
        BigInteger c22 = a[1][0].multiply(b[0][1]).add(a[1][1].multiply(b[1][1]));
        return new BigInteger[][]{{c11, c12}, {c21, c22}};
    }

    private BigInteger[] multiplyMatrixVector(BigInteger[][] m, BigInteger[] v) {
        BigInteger c1 = m[0][0].multiply(v[0]).add(m[0][1].multiply(v[1]));
        BigInteger c2 = m[1][0].multiply(v[0]).add(m[1][1].multiply(v[1]));
        return new BigInteger[]{c1, c2};
    }

    public enum Method {
        BINARY_EXPONENTIATION(1_000_000),
        RECURSIVE(100),
        ITERATIVE(1_000_000);

        private final int max;

        Method(int i) {
            this.max = i;
        }

        // recursive method has a limitation on recursion-stack size
        public static Iterable<Method> supports(int n) {
            return Arrays.stream(values()).filter(i -> i.max >= n).toList();
        }
    }
}
