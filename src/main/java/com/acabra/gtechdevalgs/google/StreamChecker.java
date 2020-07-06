package com.acabra.gtechdevalgs.google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StreamChecker {

    static boolean BRUTE_FORCE = true;


    final StringBuilder sb = new StringBuilder();

    //Trie needed objects
    TrieNode root;
    //BF needed objects
    Map<Integer, Set<String>> wordLenToWordSet;
    Set<Integer> wordsLengthSet = null;

    public StreamChecker(String[] words) {
        if (BRUTE_FORCE) {
            wordLenToWordSet = new HashMap<>();
        } else {
            root = new TrieNode();
        }
        for(String str: words) {
            if (BRUTE_FORCE) {
                Set<String> tmp = wordLenToWordSet.get(str.length());
                if (null == tmp) {
                    wordLenToWordSet.put(str.length(), new HashSet<String>(){{add(str);}});
                } else {
                    tmp.add(str);
                }
                this.wordsLengthSet = wordLenToWordSet.keySet();
            } else {
                insert(str);
            }
        }
    }

    private void insert(String str) {
        TrieNode node = root;
        for (int i = str.length() - 1; i >= 0 ; --i) {
            char c = str.charAt(i);
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }


    public boolean query(char letter) {
        sb.append(letter);
        if (BRUTE_FORCE) {
            String tmp = sb.toString();
            for(Integer in: this.wordsLengthSet) {
                if (tmp.length() >= in) {
                    for(String word: wordLenToWordSet.get(in)) {
                        if (tmp.endsWith(word)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return check();
    }

    private boolean check() {
        TrieNode node = this.root;
        for (int i = sb.length() -1 ; i >= 0; --i) {
            char c = sb.charAt(i);
            if (node.children[c-'a'] == null) {
                return false;
            }
            if (node.children[c-'a'].isWord) {
                return true;
            }
            node = node.children[c-'a'];
        }
        return false;
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;

        public TrieNode() {
            this.isWord = false;
            Arrays.fill(children, null);
        }
    }


}
