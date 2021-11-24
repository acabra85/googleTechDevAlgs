package com.acabra.gtechdevalgs.litcode.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PascalTriangleTest {

    private PascalTriangle underTest;

    @BeforeEach
    public void setup() {
        underTest = new PascalTriangle();
    }

    @Test
    public void shouldBuildAPascalTriangleOfHeight5() {
        final List<List<Integer>> expected = new ArrayList<>() {{
            add(new ArrayList<>(){{add(1);}});
            add(new ArrayList<>(){{add(1); add(1);}});
            add(new ArrayList<>(){{add(1);add(2);add(1);}});
            add(new ArrayList<>(){{add(1);add(3);add(3);add(1);}});
            add(new ArrayList<>(){{add(1);add(4);add(6);add(4);add(1);}});
        }};
        Assertions.assertThat(underTest.buildPascalTriangleOfHeight(5)).isEqualTo(expected);
    }


}