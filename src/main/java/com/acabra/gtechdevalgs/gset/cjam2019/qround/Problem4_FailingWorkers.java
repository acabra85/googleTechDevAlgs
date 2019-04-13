package com.acabra.gtechdevalgs.gset.cjam2019.qround;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * source: https://codingcompetitions.withgoogle.com/codejam/round/0000000000051705/00000000000881de
 * visited on: Apr 6 2019
 * Problem
 * A research consortium has built a new database system for their new data center. The database is made up of one master computer and N worker computers, which are given IDs from 0 to N-1. Each worker stores exactly one bit of information... which seems rather wasteful, but this is very important data!
 *
 * You have been hired to evaluate the following instruction for the database:
 *
 * TEST_STORE <bits>: The master reads in <bits>, which is a string of N bits, and sends the i-th bit to the i-th worker for storage. The master will then read the bits back from the workers and return them to the user, in the same order in which they were read in.
 * During normal operation, TEST_STORE should return the same string of bits that it read in, but unfortunately, B of the workers are broken!
 *
 * The broken workers are correctly able to store the bits given to them, but whenever the master tries to read from a broken worker, no bit is returned. This causes the TEST_STORE operation to return only N-B bits, which are the bits stored on the non-broken workers (in ascending order of their IDs). For example, suppose N = 5 and the 0th and 3rd workers are broken (so B = 2). Then:
 *
 * TEST_STORE 01101 returns 111.
 * TEST_STORE 00110 returns 010.
 * TEST_STORE 01010 returns 100.
 * TEST_STORE 11010 also returns 100.
 * For security reasons, the database is hidden in an underground mountain vault, so calls to TEST_STORE take a very long time. You have been tasked with working out which workers are broken using at most F calls to TEST_STORE.
 *
 * Input and output
 * This is an interactive problem. You should make sure you have read the information in the Interactive Problems section of our FAQ.
 *
 * Initially, your program should read a single line containing a single integer T indicating the number of test cases. Then, you need to process T test cases.
 *
 * For each test case, your program will first read a single line containing three integers N, B, and F, indicating the number of workers, the number of broken workers, and the number of lines you may send (as described below).
 *
 * Then you may send the judge up to F lines, each containing a string of exactly N characters, each either 0 or 1. Each time you send a line, the judge will check that you have not made more than F calls. If you have, the judge will send you a single line containing a single -1, and then finish all communication and wait for your program to finish. Otherwise, the judge will send a string of length N-B: the string returned by TEST_STORE, as described above.
 *
 * Once your program knows the index of the B broken workers, it can finish the test case by sending B space-separated integers: the IDs of the broken workers, in sorted order. This does not count as one of your F calls.
 *
 * If the B integers are not exactly the IDs of the B broken workers, you will receive a Wrong Answer verdict, and the judge will send a single line containing -1, and then no additional communication. If your answer was correct, the judge will send a single line with 1, followed by the line that begins the next test case (or exit, if that was the last test case).
 *
 * Limits
 * Time limit: 20 seconds per test set.
 * Memory limit: 1GB.
 * 1 ≤ T ≤ 100.
 * 2 ≤ N ≤ 1024.
 * 1 ≤ B ≤ min(15, N-1).
 *
 * Test set 1 (Visible)
 * F = 10.
 * Test set 2 (Hidden)
 * F = 5.
 */
public class Problem4_FailingWorkers {

    /**
     * solution available on ladderboard.
     * author: kyc
     */
    public static class Solution_kyc {

        public static void main(String[] args) throws Exception {
            Scanner input = new Scanner(System.in);
            int numCases = input.nextInt();
            for (int n = 0; n < numCases; n++) {
                int N = input.nextInt();
                int B = input.nextInt();
                int F = input.nextInt();
                int sentinel = 16 - (N % 16);

                StringBuilder sb;
                {
                    sb = new StringBuilder();
                    for (int i = 0; i < N + sentinel; i++)
                        sb.append(i % 32 < 16 ? '0' : '1');
                    System.out.println(sb.toString().substring(0, N));
                    System.out.flush();
                }

                List<Integer> numBad = new ArrayList<>();
                {
                    String line = input.next() + sb.toString().substring(N);
                    int index = 0;
                    for (int i = 0; i < (N + sentinel) / 16; i++) {
                        char c = line.charAt(index);
                        int j = line.indexOf('0' + '1' - c, index);
                        if (j == -1)
                            j = line.length();
                        numBad.add(16 - (j - index));
                        index = j;
                    }
                }

//            System.out.println("O: " + numBad);
                for (int k : new int[] { 8, 4, 2, 1 }) {
                    sb = new StringBuilder();
                    for (int i = 0; i < N + sentinel; i++)
                        sb.append(i % (2 * k) < k ? '0' : '1');
                    System.out.println(sb.toString().substring(0, N));
                    System.out.flush();

                    String line = input.next() + sb.toString().substring(N);
                    int index = 0;
                    List<Integer> newNumBad = new ArrayList<>();
                    for (int i = 0; i < numBad.size(); i++) {
                        String result = line.substring(index, index + 2 * k - numBad.get(i));
                        index += 2 * k - numBad.get(i);
                        int j = result.indexOf('1');
                        if (j == -1)
                            j = result.length();
                        newNumBad.add(k - j);
                        newNumBad.add(k - (result.length() - j));
                    }
                    numBad = newNumBad;
//                System.out.println(k + ": " + numBad);
                }

                List<Integer> bads = new ArrayList<>();
                for (int i = 0; i < numBad.size(); i++)
                    if (numBad.get(i) == 1)
                        bads.add(i);

//            System.out.printf("Case #%d: ", n + 1);
                for (int bad : bads)
                    System.out.printf("%s ", bad);
                System.out.println();

                input.nextInt();
            }
        }
    }
}
