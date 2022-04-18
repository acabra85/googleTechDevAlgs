package com.acabra.gtechdevalgs.social;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class QueriesTreeTest {

    private QueriesTree underTest;

    @BeforeEach
    void setUp() {
        underTest = new QueriesTree();
    }

    @Test
    void answerQueries() {
        Collection<QueriesTree.Query> queries = new ArrayList<>(){{
            add(new QueriesTree.Query(2, 3));
            add(new QueriesTree.Query(1, 2));
            add(new QueriesTree.Query(2, 1));
            add(new QueriesTree.Query(2, 3));
            add(new QueriesTree.Query(2, 2));
        }};
        int[] expected = {-1, 2, -1, 2};

        int[] actual = underTest.answerQueries(queries, queries.size());

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}