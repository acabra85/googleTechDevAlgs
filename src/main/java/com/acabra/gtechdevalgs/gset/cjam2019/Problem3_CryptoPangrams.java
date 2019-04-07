package com.acabra.gtechdevalgs.gset.cjam2019;

import java.io.*;
import java.util.*;
import java.math.BigInteger;

/**
 * source:https://codingcompetitions.withgoogle.com/codejam/round/0000000000051705/000000000008830b
 * visited on: Apr 6 2019
 * Problem
 * On the Code Jam team, we enjoy sending each other pangrams, which are phrases that use each letter of the English alphabet at least once. One common example of a pangram is "the quick brown fox jumps over the lazy dog". Sometimes our pangrams contain confidential information — for example, CJ QUIZ: KNOW BEVY OF DP FLUX ALGORITHMS — so we need to keep them secure.
 *
 * We looked through a cryptography textbook for a few minutes, and we learned that it is very hard to factor products of two large prime numbers, so we devised an encryption scheme based on that fact. First, we made some preparations:
 *
 * We chose 26 different prime numbers, none of which is larger than some integer N.
 * We sorted those primes in increasing order. Then, we assigned the smallest prime to the letter A, the second smallest prime to the letter B, and so on.
 * Everyone on the team memorized this list.
 * Now, whenever we want to send a pangram as a message, we first remove all spacing to form a plaintext message. Then we write down the product of the prime for the first letter of the plaintext and the prime for the second letter of the plaintext. Then we write down the product of the primes for the second and third plaintext letters, and so on, ending with the product of the primes for the next-to-last and last plaintext letters. This new list of values is our ciphertext. The number of values is one smaller than the number of characters in the plaintext message.
 *
 * For example, suppose that N = 103 and we chose to use the first 26 odd prime numbers, because we worry that it is too easy to factor even numbers. Then A = 3, B = 5, C = 7, D = 11, and so on, up to Z = 103. Also suppose that we want to encrypt the CJ QUIZ... pangram above, so our plaintext is CJQUIZKNOWBEVYOFDPFLUXALGORITHMS. Then the first value in our ciphertext is 7 (the prime for C) times 31 (the prime for J) = 217; the next value is 1891, and so on, ending with 3053.
 *
 * We will give you a ciphertext message and the value of N that we used. We will not tell you which primes we used, or how to decrypt the ciphertext. Do you think you can recover the plaintext anyway?
 *
 * Input
 * The first line of the input gives the number of test cases, T. T test cases follow; each test case consists of two lines. The first line contains two integers: N, as described above, and L, the length of the list of values in the ciphertext. The second line contains L integers: the list of values in the ciphertext.
 *
 * Output
 * For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is a string of L + 1 uppercase English alphabet letters: the plaintext.
 *
 * Limits
 * 1 ≤ T ≤ 100.
 * Time limit: 20 seconds per test set.
 * Memory limit: 1 GB.
 * 25 ≤ L ≤ 100.
 * The plaintext contains each English alphabet letter at least once.
 *
 * Test set 1 (Visible)
 * 101 ≤ N ≤ 10000.
 *
 * Test set 2 (Hidden)
 * 101 ≤ N ≤ 10100.
 */
public class Problem3_CryptoPangrams {

    static class Solution {

        private int caseN;
        private String plainText = "";

        public static void main(String... args) {
            new Solution().read();
        }

        public Solution() {
            this.caseN = 1;
        }

        private void read() {
            try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
                int testCases = toLong(bf.readLine().trim()).intValue();
                for (int i = 1; i <= testCases; i++) {
                    String[] s = bf.readLine().split("\\s+");
                    solve(s[0], toLong(s[1]).intValue(), bf.readLine());
                }
            }catch (Exception e) {

            }
        }

        public void solve(String nStr, int L, String cypherText) {
            BigInteger N = new BigInteger(nStr);
            int[] smallestIdx = {-1};
            List<BigInteger> encryptedList = buildEncryptedTextList(L, cypherText, smallestIdx);
            plainText = findPlainText(N, L, encryptedList, smallestIdx[0]);
            if (caseN == 1) {
                System.out.print(String.format("Case #%d: " + plainText, caseN++));
            } else {
                System.out.print(String.format("\nCase #%d: " + plainText, caseN++));
            }
        }

        private List<BigInteger> buildEncryptedTextList(int L, String cypherText, int[] idx) {
            StringTokenizer st = new StringTokenizer(cypherText, " ");
            List<BigInteger> encryptedList = new ArrayList<>();
            BigInteger min = new BigInteger("" + Long.MAX_VALUE);
            for (int i = 0; i < L && st.hasMoreTokens(); i++) {
                BigInteger e = new BigInteger(st.nextToken());
                encryptedList.add(e);
                if (e.compareTo(min) < 0) {
                    min = e;
                    idx[0] = i;
                }
            }
            return encryptedList;
        }

        private String findPlainText(BigInteger N, int L, List<BigInteger> encryptedList, int smallestIdx) {
            BigInteger[] originalTextAsPrimes = new BigInteger[L + 1];
            SortedSet<BigInteger> alphabetPrimes = new TreeSet<>();
            BigInteger factorA = getPrimeFactor(encryptedList.get(smallestIdx));
            if(factorA == null) return "";
            BigInteger factorB = encryptedList.get(smallestIdx).divide(factorA);
            alphabetPrimes.add(factorA);
            alphabetPrimes.add(factorB);

            if(smallestIdx == 0) {
                runForward(L, encryptedList, smallestIdx, originalTextAsPrimes, alphabetPrimes, factorA, factorB);
            } else if (smallestIdx == L - 1) {
                runBackwards(encryptedList, smallestIdx, originalTextAsPrimes, alphabetPrimes, factorA, factorB);
            } else {
                runForward(L, encryptedList, smallestIdx, originalTextAsPrimes, alphabetPrimes, factorA, factorB);
                runBackwards(encryptedList, smallestIdx, originalTextAsPrimes, alphabetPrimes, factorA, factorB);
            }
            return translatePrimesToLetters(originalTextAsPrimes, alphabetPrimes);
        }

        private void runBackwards(List<BigInteger> encryptedList, int smallestIdx, BigInteger[] originalTextAsPrimes, SortedSet<BigInteger> alphabetPrimes,
                                  BigInteger factorA, BigInteger factorB) {
            if (encryptedList.get(smallestIdx - 1).mod(factorA).equals(BigInteger.ZERO)) {
                originalTextAsPrimes[smallestIdx + 1] = factorB;
                originalTextAsPrimes[smallestIdx] = factorA;
            } else {
                originalTextAsPrimes[smallestIdx + 1] = factorA;
                originalTextAsPrimes[smallestIdx] = factorB;
                factorA = factorB;
            }
            for (int i = smallestIdx - 1; i >= 0; i--) {
                factorA = encryptedList.get(i).divide(factorA);
                originalTextAsPrimes[i] = factorA;
                alphabetPrimes.add(factorA);
            }
        }

        private void runForward(int L, List<BigInteger> encryptedList, int smallestIdx, BigInteger[] originalTextAsPrimes, SortedSet<BigInteger> alphabetPrimes,
                                BigInteger factorA, BigInteger factorB) {
            if (encryptedList.get(smallestIdx + 1).mod(factorA).equals(BigInteger.ZERO)) {
                originalTextAsPrimes[smallestIdx] = factorB;
                originalTextAsPrimes[smallestIdx + 1] = factorA;
            } else {
                originalTextAsPrimes[smallestIdx] = factorA;
                originalTextAsPrimes[smallestIdx + 1] = factorB;
                factorA = factorB;
            }
            for (int i = smallestIdx + 1; i < L; i++) {
                factorA = encryptedList.get(i).divide(factorA);
                originalTextAsPrimes[i+1] = factorA;
                alphabetPrimes.add(factorA);
            }
        }

        private String translatePrimesToLetters(BigInteger[] originalTextAsPrimes, SortedSet<BigInteger> alphabetPrimes) {
            List<BigInteger> alphabet = new ArrayList<>(alphabetPrimes);
            StringBuilder plainText = new StringBuilder();
            for (BigInteger prime: originalTextAsPrimes) {
                plainText.append((char)(alphabet.indexOf(prime) + 65));
            }
            return plainText.toString();
        }

        private BigInteger getPrimeFactor(BigInteger encryptedValue) {
            int size = encryptedValue.compareTo(new BigInteger("" + (Integer.MAX_VALUE - 5))) < 0 ? encryptedValue.intValue() : Integer.MAX_VALUE;
            BitSet primes = new AtkinSieve().run(size);
            BigInteger zero = BigInteger.ZERO;
            for (int i = 0; i < primes.size(); i++) {
                if (primes.get(i) && encryptedValue.mod(new BigInteger(i+"", 10)).equals(zero)) {
                    return new BigInteger(i+"", 10);
                }
            }
            BigInteger factor = new BigInteger(primes.size()+"", 10).add(BigInteger.ONE);
            while (factor.compareTo(encryptedValue) < 0) {
                if (encryptedValue.mod(factor).equals(zero)) return factor;
                factor = factor.add(BigInteger.ONE);
            }
            return null;
        }

        private Long toLong(String readLine) {
            try{
                return Long.parseLong(readLine);
            }catch (Exception e) {
                return -1L;
            }
        }

        public String getPlainText() {
            return this.plainText;
        }

        private static class AtkinSieve {
            /******************************************************************************
             *  Compilation:  javac AtkinSieve.java
             *  Execution:    java AtkinSieve [number] [verbose]
             *  @author: Luca F
             *
             *  % java AtkinSieve 1000
             *  Found 168 primes
             *
             *  verbose to show all results
             *  This file is intended for didactic purpose, to demonstrate how
             *  Atkin - Bernstein sieve works
             *  source: https://gist.githubusercontent.com/lucafmi/729f6516799163b1a167ea233abbb3c6/raw/d9ec7e58960602d8091cea22268b51833a816a0a/AtkinSieve.java
             *  consulted on: Apr 6 2019
             *
             *****************************************************************************@param size */

            public BitSet run(int size) {
                // Check if args[0] is specified and if it's valid
                // Create a boolean array to manage Atkin Sieve
                BitSet numbers = new BitSet(size+1);
                // Create variables for temporary equations solutions
                int z = 0;

                // Setting 2,3,5 as primes
                numbers.set(2, true);
                numbers.set(3, true);
                numbers.set(5, true);

                // instead of solving equations, we will generate results from x and y roots
                // the maximum admitted value for y is inferred by x
                // 1st equation
                for(int x=1; x<=(int)Math.sqrt(size/4);x++)
                    for(int y=1;y<=(int)Math.sqrt(size-4*x*x);y++){
                        z = 4 * x * x + y * y;
                        // First condition: if z1 modulo 60 gives one of these remainders, we flip the number status:
                        if( z % 60 == 1  ||
                                z % 60 == 13 ||
                                z % 60 == 17 ||
                                z % 60 == 29 ||
                                z % 60 == 37 ||
                                z % 60 == 41 ||
                                z % 60 == 49 ||
                                z % 60 == 53 )
                            numbers.set(z, !numbers.get(z));
                    }
                // 2nd equation
                for(int x=1; x<=(int)Math.sqrt(size/3);x++)
                    for(int y=1;y<=(int)Math.sqrt(size- 3*x*x);y++){
                        z = 3 * x * x + y * y;
                        if( z % 60 == 7  ||
                                z % 60 == 19 ||
                                z % 60 == 31 ||
                                z % 60 == 43 )
                            numbers.set(z, !numbers.get(z));
                    }
                // 3rd equation; for this one, we can assume that y must be < x, so the condition is inverted
                for(int x=1; x<=(int)Math.sqrt(size);x++)
                    for(int y=(int)Math.sqrt(3*x*x-size);y<=(int)Math.sqrt(3)*x;y++){

                        z = 3 * x * x - y * y;

                        if(z <= size){
                            if( z % 60 == 11  ||
                                    z % 60 == 23 ||
                                    z % 60 == 47 ||
                                    z % 60 == 59 )
                                numbers.set(z, !numbers.get(z));
                        }else{
                            //         System.out.println(z +" exceeds " + x + " "+y);
                        }
                    }
                // removing al square multiples
                for (int i = 5; i <= (int)Math.sqrt(size); i++)
                    for (int j = 1; j * i * i <= size; j++)
                        numbers.set(j * i * i,false);
                // We have done! Showing the result..
                return numbers;
            }
        }
    }

    /**
     * solution available on ladderboard.
     * author: kyc
     */
    public static class Solution_kyc {

        public static void main (String[] args) throws Exception {
            Scanner input = new Scanner(System.in);
            int numCases = input.nextInt();
            for (int n = 0; n < numCases; n++) {
                String N = input.next();
                int K = input.nextInt();
                BigInteger[] nums = new BigInteger[K];
                for (int i = 0; i < K; i++)
                    nums[i] = new BigInteger(input.next());

                int start = 0;
                while (nums[start].equals(nums[start + 1]))
                    start++;

                BigInteger[] ans = new BigInteger[K + 1];
                ans[start + 1] = gcd(nums[start], nums[start + 1]);
                for (int i = start; i >= 0; i--)
                    ans[i] = nums[i].divide(ans[i + 1]);
                for (int i = start + 2; i <= K; i++)
                    ans[i] = nums[i - 1].divide(ans[i - 1]);

                List<BigInteger> sorted = new ArrayList<>(new HashSet<>(Arrays.asList(ans)));
                Collections.sort(sorted);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i <= K; i++)
                    sb.append((char) (65 + sorted.indexOf(ans[i])));

                System.out.printf("Case #%d: ", n + 1);
                System.out.println(sb.toString());
            }
        }

        public static BigInteger gcd(BigInteger a, BigInteger b) {
            return b.equals(BigInteger.ZERO) ? a : gcd(b, a.mod(b));
        }
    }
}
