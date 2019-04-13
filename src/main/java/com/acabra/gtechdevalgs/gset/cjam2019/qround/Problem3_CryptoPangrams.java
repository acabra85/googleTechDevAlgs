package com.acabra.gtechdevalgs.gset.cjam2019.qround;

import java.io.*;
import java.util.*;
import java.math.BigInteger;

/**
 * source:https://codingcompetitions.withgoogle.com/codejam/round/0000000000051705/000000000008830b
 * visited on: Apr 6 2019
 * Problem
 * On the Code Jam team, we enjoy sending each other pangrams, which are phrases that use each letter of the English alphabet at least once. One common example of a pangram is "the quick brown fox jumps over the lazy dog". Sometimes our pangrams contain confidential information — for example, CJ QUIZ: KNOW BEVY OF DP FLUX ALGORITHMS — so we need to keep them secure.
 * <p>
 * We looked through a cryptography textbook for a few minutes, and we learned that it is very hard to factor products of two large prime numbers, so we devised an encryption scheme based on that fact. First, we made some preparations:
 * <p>
 * We chose 26 different prime numbers, none of which is larger than some integer N.
 * We sorted those primes in increasing order. Then, we assigned the smallest prime to the letter A, the second smallest prime to the letter B, and so on.
 * Everyone on the team memorized this list.
 * Now, whenever we want to send a pangram as a message, we first remove all spacing to form a plaintext message. Then we write down the product of the prime for the first letter of the plaintext and the prime for the second letter of the plaintext. Then we write down the product of the primes for the second and third plaintext letters, and so on, ending with the product of the primes for the next-to-last and last plaintext letters. This new list of values is our ciphertext. The number of values is one smaller than the number of characters in the plaintext message.
 * <p>
 * For example, suppose that N = 103 and we chose to use the first 26 odd prime numbers, because we worry that it is too easy to factor even numbers. Then A = 3, B = 5, C = 7, D = 11, and so on, up to Z = 103. Also suppose that we want to encrypt the CJ QUIZ... pangram above, so our plaintext is CJQUIZKNOWBEVYOFDPFLUXALGORITHMS. Then the first value in our ciphertext is 7 (the prime for C) times 31 (the prime for J) = 217; the next value is 1891, and so on, ending with 3053.
 * <p>
 * We will give you a ciphertext message and the value of N that we used. We will not tell you which primes we used, or how to decrypt the ciphertext. Do you think you can recover the plaintext anyway?
 * <p>
 * Input
 * The first line of the input gives the number of test cases, T. T test cases follow; each test case consists of two lines. The first line contains two integers: N, as described above, and L, the length of the list of values in the ciphertext. The second line contains L integers: the list of values in the ciphertext.
 * <p>
 * Output
 * For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is a string of L + 1 uppercase English alphabet letters: the plaintext.
 * <p>
 * Limits
 * 1 ≤ T ≤ 100.
 * Time limit: 20 seconds per test set.
 * Memory limit: 1 GB.
 * 25 ≤ L ≤ 100.
 * The plaintext contains each English alphabet letter at least once.
 * <p>
 * Test set 1 (Visible)
 * 101 ≤ N ≤ 10000.
 * <p>
 * Test set 2 (Hidden)
 * 101 ≤ N ≤ 10100.
 */
public class Problem3_CryptoPangrams {

    static class Solution {
        protected final Help help;

        public static Solution ofConsole() {
            return new Solution(System.in, new OutputStreamWriter(System.out));
        }

        public static Solution ofTestFile(String fileName) {
            InputStream resourceAsStream = Solution.class.getClassLoader().getResourceAsStream(fileName);
            return new Solution(resourceAsStream, new OutputStreamWriter(System.out));
        }

        static class Help {
            final BufferedReader bf;
            final PrintWriter out;
            StringTokenizer tokenizer;

            public Help(BufferedReader bf, PrintWriter out) {
                this.bf = bf;
                this.out = out;
            }

            public int nInt() throws IOException {
                return Integer.parseInt(next());
            }

            public long nLong() throws IOException {
                return Long.parseLong(next());
            }

            public double nDouble() throws IOException {
                return Double.parseDouble(next());
            }

            String next() throws IOException {
                while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                    tokenizer = new StringTokenizer(bf.readLine());
                }
                return tokenizer.nextToken();
            }

            public void close() throws IOException {
                bf.close();
                out.flush();
            }

            public void printf(String s, Object... args) {
                out.printf(s, args);
                out.flush();
            }
        }

        public Solution(InputStream in, OutputStreamWriter iOut) {
            this.help = new Help(new BufferedReader(new InputStreamReader(in)), new PrintWriter(iOut));
        }

        public static void main(String... args) throws Exception {
            new Solution(System.in, new OutputStreamWriter(System.out)).read();
        }

        void read() throws IOException {
            int testCases = help.nInt();
            for (int i = 1; i <= testCases; i++) {
                String N = help.next();
                int L = help.nInt();
                help.printf("%sCase #%d: " + solve(N, L), i == 1 ? "" : "\n", i);
            }
            help.close();
        }

        public String solve(String nStr, int L) throws IOException {
            BigInteger N = new BigInteger(nStr);
            List<BigInteger> encryptedList = buildEncryptedTextList(L);
            return findPlainText(N, L, encryptedList);
        }

        private List<BigInteger> buildEncryptedTextList(int L) throws IOException {
            List<BigInteger> encryptedList = new ArrayList<>();
            for (int i = 0; i < L; i++) {
                BigInteger e = new BigInteger(help.next());
                encryptedList.add(e);
            }
            return encryptedList;
        }

        String findPlainText(BigInteger N, int L, List<BigInteger> encryptedList) {
            BigInteger[] originalTextAsPrimes = new BigInteger[L + 1];
            SortedSet<BigInteger> alphabetPrimes = new TreeSet<>();
            BigInteger factorA = gcd(encryptedList.get(0), encryptedList.get(1));
            if (factorA == null) return "";
            BigInteger factorB = encryptedList.get(0).divide(factorA);
            alphabetPrimes.add(factorA);
            alphabetPrimes.add(factorB);

            runForward(L, encryptedList, originalTextAsPrimes, alphabetPrimes, factorA, factorB);
            return translatePrimesToLetters(originalTextAsPrimes, alphabetPrimes);
        }

        private void runForward(int L, List<BigInteger> encryptedList, BigInteger[] originalTextAsPrimes, SortedSet<BigInteger> alphabetPrimes,
                                BigInteger factorA, BigInteger factorB) {
            if (encryptedList.get(1).mod(factorA).equals(BigInteger.ZERO)) {
                originalTextAsPrimes[0] = factorB;
                originalTextAsPrimes[1] = factorA;
            } else {
                originalTextAsPrimes[0] = factorA;
                originalTextAsPrimes[1] = factorB;
                factorA = factorB;
            }
            for (int i = 1; i < L; i++) {
                factorA = encryptedList.get(i).divide(factorA);
                originalTextAsPrimes[i + 1] = factorA;
                alphabetPrimes.add(factorA);
            }
        }

        private String translatePrimesToLetters(BigInteger[] originalTextAsPrimes, SortedSet<BigInteger> alphabetPrimes) {
            List<BigInteger> alphabet = new ArrayList<>(alphabetPrimes);
            StringBuilder plainText = new StringBuilder();
            for (BigInteger prime : originalTextAsPrimes) {
                plainText.append((char) (alphabet.indexOf(prime) + 65));
            }
            return plainText.toString();
        }

        public static BigInteger gcd(BigInteger a, BigInteger b) {
            return b.equals(BigInteger.ZERO) ? a : gcd(b, a.mod(b));
        }
    }
}
