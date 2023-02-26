package com.acabra.gtechdevalgs.gset.cjam2022.round1C;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class P1_LetterTowersTest {

    private P1_LetterTowers underTest;

    @Test
    public void test() throws Exception {
        List<String> l1 = List.of("CODE JAM MIC EEL ZZZZZ".split(" "));
        List<String> l2 = List.of("CODE JAM MIC EEL ZZZZZ EEK".split(" "));
        List<String> l3 = List.of("OY YO".split(" "));
        List<String> l4 = List.of("HASH CODE".split(" "));
        List<String> l5 = List.of("A AA BB A BA BB".split(" "));
        List<String> l6 = List.of("CAT TAX".split(" "));
        Assertions.assertThat(P1_LetterTowers.Solution.solve(l1))
                .isEqualTo("ZZZZZJAMMICCODEEEL");
        Assertions.assertThat(P1_LetterTowers.Solution.solve(l2))
                .isEqualTo(P1_LetterTowers.Solution.IMPOSSIBLE);
        Assertions.assertThat(P1_LetterTowers.Solution.solve(l3))
                .isEqualTo(P1_LetterTowers.Solution.IMPOSSIBLE);
        Assertions.assertThat(P1_LetterTowers.Solution.solve(l4))
                .isEqualTo(P1_LetterTowers.Solution.IMPOSSIBLE);
        Assertions.assertThat(P1_LetterTowers.Solution.solve(l5))
                .isEqualTo("BBBBBAAAAA");
        Assertions.assertThat(P1_LetterTowers.Solution.solve(l6))
                .isEqualTo(P1_LetterTowers.Solution.IMPOSSIBLE);
    }

    @Test
    public void testFromFile() throws IOException {
        P1_LetterTowers.Solution.ofTestFile("cjam2022/round1C/p1_1.txt").read();
    }

    @Test
    public void testValidString() {
        Assertions.assertThat(P1_LetterTowers.Solution.isValid("HASH")).isEqualTo(false);
        Assertions.assertThat(P1_LetterTowers.Solution.isValid("CODE")).isEqualTo(true);
    }
}
