package com.acabra.gtechdevalgs.google;

import java.util.Arrays;

public class StreamChecker {

    final StringBuilder sb = new StringBuilder();
    TrieNode root = new TrieNode();

    public StreamChecker(String[] words) {
        for(String str: words) {
            insert(str);
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
