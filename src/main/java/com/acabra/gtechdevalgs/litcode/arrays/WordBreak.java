package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.*;

public class WordBreak {

    private HashSet<String> dict;

    /**
     * Use dynamic programing to compute all the answers up to the length of the string
     * @param s a string where the possible words are searched
     * @param wordDict dictionary containing non-duplicate words
     * @return true if the s string can be broken into with multiple spaces forming a phrase with only dictionary words
     * e.g.
     *    wordDict = {"hello", "world"}
     *    s = "hellohelloworld"
     *    return true.
     */
    public boolean wordBreak_dynamicProgramming(String s, List<String> wordDict) {
        Set<String> dictSet = getDict(wordDict);
        boolean[] memo = new boolean[s.length() + 1];
        memo[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (memo[j] && dictSet.contains(s.substring(j, i))) {
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[s.length()];
    }

    /**
     * The words within the string represent nodes up to the certain index 'i'
     * @param s a string where the possible words are searched
     * @param wordDict dictionary containing non-duplicate words
     * @return true if the s string can be broken into with multiple spaces forming a phrase with only dictionary words
     */
    public boolean wordBreak_bfs(String s, List<String> wordDict) {
        Set<String> dict = getDict(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        queue.add(0);
        while (queue.size() > 0) {
            int start = queue.remove();
            if (!visited[start]) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (dict.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = true;
            }
        }
        return false;
    }

    public Set<String> getDict(List<String> wordDict) {
        if (dict == null) {
            dict = new HashSet<>(wordDict);
        }
        return dict;
    }


}
