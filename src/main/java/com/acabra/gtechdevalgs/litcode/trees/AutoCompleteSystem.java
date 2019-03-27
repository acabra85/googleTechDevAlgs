package com.acabra.gtechdevalgs.litcode.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Describe your class
 */
public class AutoCompleteSystem {

    private static final int ALPHABET_LENGTH = 26;
    private static final int MAX_RESULTS = 3;
    private static final Comparator<TrieSentence> SENTENCE_COMPARATOR = new Comparator<TrieSentence>() {
        @Override
        public int compare(TrieSentence o1, TrieSentence o2) {
            return o1.times == o2.times ? o1.sentence.compareTo(o2.sentence) : o2.times - o1.times;
        }
    };

    class TrieSentence {
        final String sentence;
        final int times;

        public TrieSentence(String sentence, int times) {
            this.sentence = sentence;
            this.times = times;
        }
    }

    class Trie {
        int times;
        Trie[] branches = new Trie[ALPHABET_LENGTH + 1];
    }

    private int charToInt(char c) {
        return c == ' ' ? 26 : c - 'a';
    }

    private void insert(Trie trie, String sentence, int times) {
        for (int i = 0; i < sentence.length(); i++) {
            int branchIndex = charToInt(sentence.charAt(i));
            if (null == trie.branches[branchIndex]) {
                trie.branches[branchIndex] = new Trie();
            }
            trie = trie.branches[branchIndex];
        }
        trie.times += times;
    }

    private void traverse(String sentence, Trie trie, PriorityQueue<TrieSentence> results) {
        if (trie.times > 0) {
            results.offer(new TrieSentence(sentence, trie.times));
        }
        for (char i = 'a'; i <= 'z'; i++) {
            int branchIndex = i - 'a';
            if (null != trie.branches[branchIndex]) {
                traverse(sentence + i, trie.branches[branchIndex], results);
            }
        }
        if (null != trie.branches[ALPHABET_LENGTH]) {
            traverse(sentence + " ", trie.branches[ALPHABET_LENGTH], results);
        }
    }

    private Queue<TrieSentence> lookup(Trie trie, String sentence) {
        PriorityQueue<TrieSentence> results = new PriorityQueue<>(SENTENCE_COMPARATOR);
        for (int i = 0; i < sentence.length(); i++) {
            int branchIndex = charToInt(sentence.charAt(i));
            if (null == trie.branches[branchIndex]) {
                return new PriorityQueue<>();
            }
            trie = trie.branches[branchIndex];
        }
        traverse(sentence, trie, results);
        return results;
    }

    private boolean isSearchCompleted(char c) {
        return '#' == c;
    }

    final Trie root;

    public AutoCompleteSystem(String[] sentences, int[] times) {
        root = new Trie();
        for (int i = 0; i < sentences.length; i++) {
            insert(root, sentences[i], times[i]);
        }
    }

    String current_sentence = "";
    public List<String> input(char c) {
        if (isSearchCompleted(c)) {
            insert(root, current_sentence, 1);
            current_sentence = "";
            return Collections.emptyList();
        }
        current_sentence += c;
        Queue<TrieSentence> pq = lookup(root, current_sentence);
        List<String> hotResults = new ArrayList<>();
        int to = Math.min(MAX_RESULTS, pq.size());
        for (int i = 0; i < to; i++) {
            hotResults.add(pq.remove().sentence);
        }
        return hotResults;
    }
}
