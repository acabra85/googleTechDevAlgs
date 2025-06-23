package com.acabra.gtechdevalgs.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class DictionaryAndPatternProcess {

    private static final Set<Character> VALID = new HashSet<>(){{
        final String alphabet = "abcdefghijklmnopqrstuvwxyz";
        IntStream.range(0, alphabet.length()).mapToObj(alphabet::charAt).forEach(this::add);
        IntStream.range(0, alphabet.length()).mapToObj(alphabet.toUpperCase(Locale.ENGLISH)::charAt).forEach(this::add);
    }};
    private static Trie dict;
    public static List<String> getWordsMatchingPattern(String pattern, List<String> dictionary) {
        Trie local = DictionaryAndPatternProcess.getDict(dictionary);
        List<String> result = new ArrayList<>();
        findWordsMatchPattern(local.root, 0, pattern.toCharArray(), new StringBuilder(), result);
        return result;
    }

    private static void findWordsMatchPattern(
            TrieNode node,
            int idx,
            char[] pattern,
            StringBuilder word,
            List<String> result
    ) {
        if(pattern.length == idx) {
            if(node.isEndOfWord) {
                result.add(word.toString());
            }
            return;
        }
        char currChar = pattern[idx];
        if (currChar != '[') {
            if (node.children.containsKey(currChar)) {
                final TrieNode nextNode = node.children.get(currChar);
                if (nextNode.wordCount > 0) {
                    word.append(currChar);
                    findWordsMatchPattern(
                            nextNode,
                            idx + 1,
                            pattern,
                            word,
                            result
                    );
                    word.deleteCharAt(word.length() - 1);
                }
            }
        } else {
            final OptionsSearch charOptions = getCharOptions(pattern, idx + 1);
            List<Character> options = charOptions.opts();
            int bracketIndex = charOptions.idx;
            for (Character option : options) {
                if (node.children.containsKey(option)) {
                    TrieNode nextNode = node.children.get(option);
                    if (nextNode.wordCount > 0) {
                        word.append(option);
                        findWordsMatchPattern(
                                nextNode,
                                bracketIndex + 1,
                                pattern,
                                word,
                                result
                        );
                        word.deleteCharAt(word.length() - 1);
                    }
                }
            }
        }
    }

    private static OptionsSearch getCharOptions(char[] pattern, int startIdx) {
        List<Character> options = new ArrayList<>();
        int j = startIdx;
        for (;j < pattern.length && pattern[j] != ']'; ++j) {
            if (VALID.contains(pattern[j])) {
                options.add(pattern[j]);
            } else {
                throw new InputMismatchException("Invalid Pattern {%s} contains:%c at idx:%d".formatted(
                        String.valueOf(pattern), pattern[j], j));
            }
        }
        if (j == pattern.length) {
            throw new InputMismatchException("Invalid Pattern {%s} does not contain closing option bracket ']'"
                    .formatted(String.valueOf(pattern)));
        }
        return new OptionsSearch(j, options);
    }

    private static Trie getDict(List<String> dictionary) {
        if (dict == null) {
            Trie result = new Trie();
            result.addAll(dictionary);
            dict = result;
        }
        return dict;
    }

    private static class Trie {
        TrieNode root = new TrieNode();
        void addWord(String word) {
            TrieNode current = root;
            // Increment wordCount for the root, as every word passes through it.
            ++current.wordCount;

            for (char ch : word.toCharArray()) {
                current.children.putIfAbsent(ch, new TrieNode());
                current = current.children.get(ch);
                ++current.wordCount;
            }
            current.isEndOfWord = true;
        }

        public void addAll(List<String> dictionary) {
            dictionary.forEach(this::addWord);
        }
    }

    private static class TrieNode {
        public int wordCount;
        private boolean isEndOfWord;
        private final Map<Character, TrieNode> children;

        public TrieNode() {
            this.children = new HashMap<>();
            this.isEndOfWord = false;
            this.wordCount = 0;
        }
    }

    private record OptionsSearch(int idx, List<Character> opts) {
    }
}
