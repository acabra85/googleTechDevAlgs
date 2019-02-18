package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class PermutationSequence {

    /**
     * Use brute force: generate all permutations store them in a min_queue retrieve the k first elements from the queue
     * @param n the length of the array 1 .... n
     * @param k the position where the ordered kth permutation is
     * @return the kth permutation.
     */
    public String findKPermutation_bf(int n, int k) {
        int a[] = new int[n];
        for(int i = 0; i<n; i++) a[i] = i+1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        permutations(a, a.length, n, pq);
        Integer elm;
        for(int i = 0; i < k && !pq.isEmpty(); i++){
            elm = pq.remove();
            if(i==k-1) {
                return elm + "";
            }
        }
        return "";
    }

    private void permutations(int a[], int size, int n, PriorityQueue<Integer> pq) {
        if (size == 1) {
            StringBuilder val = new StringBuilder();
            for(int i=0;i<a.length;i++) {
                val.append(a[i]);
            }
            pq.offer(Integer.parseInt(val.toString()));
        }

        for (int i=0; i<size; i++) {
            permutations(a, size-1, n, pq);
            if (size % 2 == 1) {
                int temp = a[0];
                a[0] = a[size-1];
                a[size-1] = temp;
            } else {
                int temp = a[i];
                a[i] = a[size-1];
                a[size-1] = temp;
            }
        }
    }

    /**
     * Uses the factorial number system to retrieve calculate the kth permutation
     * 0! = 1, 1! = 1, 2! = 2, 3! = 6, 4! = 24, 5! = 120
     * Representing decimal numbers in factorial system
     * 0 -> 0 = 0*0!
     * 1 -> 10 = 1*1! + 0*0!
     * 2 -> 100 = 2*1! + 0*1! + 0*0!
     * 3 -> 110 = 2*1 + 1*1! + 0*0!
     * 4 -> 200 = 2*2! + 0*1! + 0*0!
     * @param n the length of the array, n [ 1 ... 9 ]
     * @param k the position where the ordered kth permutation is, k  [1 ... n!]
     * @return the kth permutation.
     */
    public String findKPermutation(int n, int k) {
        if (n < 1 || n > 9) throw new IllegalArgumentException("n must be between [1,9] given:" + n);
        if (k < 0) throw new IllegalArgumentException("k must be between [1,9] given:" + k);
        List<Integer> kInFactorialBase = convertToFactorialBase(k - 1, n);
        LinkedList<Character> stringToPermute = buildPermutationString(n);
        StringBuilder res = new StringBuilder();
        int i = 0;
        while (!stringToPermute.isEmpty()) {
            int index1 = kInFactorialBase.get(i);
            res.append(stringToPermute.get(index1));
            stringToPermute.remove(index1);
            i++;
        }
        return res.toString();
    }

    private LinkedList<Character> buildPermutationString(int n) {
        LinkedList<Character> linked = new LinkedList<>();
        for (int i = 49; i < n+49; i++) {
            linked.addLast((char)i);
        }
        return linked;
    }

    private List<Integer> convertToFactorialBase(int k, int n) {
        LinkedList<Integer> sb = new LinkedList<>();
        int i = 1;
        int q = k;
        while(q/i > 0) {
            sb.addFirst(q%i);
            q = q/i++;
        }
        sb.addFirst(q%i);
        while(sb.size() < n) {
            sb.addFirst(0);
        }
        return sb;
    }
}
