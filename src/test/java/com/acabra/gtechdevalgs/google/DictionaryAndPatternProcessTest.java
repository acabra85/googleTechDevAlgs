package com.acabra.gtechdevalgs.google;

import com.acabra.gtechdevalgs.google.DictionaryAndPatternProcess;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;

public class DictionaryAndPatternProcessTest {

    @Test
    public void getWordsMatchingPattern() {
        final List<String> dictionary = List.of(
                "Telephones",
                "Telephonis",
                "Telephonas",
                "Telechonas",
                "Telephonus",
                "Telechonus",
                "Telemonous",
                "Telechonos",
                "peter",
                "perez",
                "Trance",
                "France",
                "Fralce",
                "assFanl"
        );
        List<TestCase> testCases =  List.of(
                new TestCase("ass[FTranl", Collections.emptyList(), true),
                new TestCase("Tele[pc]hon[eia]s",
                        List.of("Telephones", "Telephonis", "Telephonas", "Telechonas"), false),
                new TestCase("pe[tfr]e[rz]", List.of("perez", "peter"), false),
                new TestCase("[FT]ra[nl]ce", List.of("Fralce", "France", "Trance"), false),
                new TestCase("some[od]ne", Collections.emptyList(), false),
                new TestCase("[FTra[nl]ce", Collections.emptyList(), true)

        );

        for (TestCase testCase : testCases) {
            try {
                List<String> actual = DictionaryAndPatternProcess.getWordsMatchingPattern(testCase.pattern, dictionary);
                Assertions.assertThat(actual).hasSize(testCase.expectedValues.size());
                Assertions.assertThat(actual).containsAll(testCase.expectedValues);
                Assertions.assertThat(testCase.isException).isFalse();
            } catch (Exception e) {
                Assertions.assertThat(testCase.isException).isTrue();
                Assertions.assertThat(e).isInstanceOf(InputMismatchException.class);
            }
        }
    }

    private record TestCase(String pattern, List<String> expectedValues, boolean isException){};
}