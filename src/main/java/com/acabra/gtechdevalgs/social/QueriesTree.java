package com.acabra.gtechdevalgs.social;

import java.util.*;

public class QueriesTree {
    private static final int SET = 1;
    private static final int GET = 2;
    private final TreeSet<Integer> treeSet = new TreeSet<>();


    /*
    Given a boolean array of size N originally all values are false.
    Every SET operation turns the value at that position to TRUE.

    A list of queries of the form [t, v] where t is type SET(1) or GET(2) and q the value
    return an array with a response for each given query fo type GET as follows:
    GET v, the smallest index within the array that is true and is greater or equal to v.
     */
    public int[] answerQueries(Collection<Query> queries, int N) {
        List<Integer> result = new ArrayList<>();
        for (Query q : queries) {
            if (q.type == SET) {
                treeSet.add(q.value);
            } else if(q.type == GET) {
                result.add(findSmallestTrueLargerOrEqualTo(q.value - 1));
            } else {
                throw new NoSuchElementException("type not recognized: "+ q.type);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    private int findSmallestTrueLargerOrEqualTo(int low) {
        Integer val = treeSet.higher(low);
        if (val != null) return val;
        return -1;
    }

    protected static class Query {
        final int type;
        final int value;

        Query(int t, int v) {
            this.type = t;
            this.value = v;
        }
    }
}
