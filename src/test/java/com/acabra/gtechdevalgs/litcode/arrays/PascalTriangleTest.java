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
    public void shouldBuildAPascalTriangleOfHeight7() {
        final List<List<Integer>> expected = new ArrayList<>() {{
            add(new ArrayList<>(){{add(1);}}); //1
            add(new ArrayList<>(){{add(1); add(1);}}); //2
            add(new ArrayList<>(){{add(1);add(2);add(1);}}); //3
            add(new ArrayList<>(){{add(1);add(3);add(3);add(1);}}); //4
            add(new ArrayList<>(){{add(1);add(4);add(6);add(4);add(1);}}); //5
            add(new ArrayList<>(){{add(1);add(5);add(10);add(10);add(5);add(1);}}); //6
            add(new ArrayList<>(){{add(1);add(6);add(15);add(20);add(15);add(6);add(1);}}); //7
        }};
        Assertions.assertThat(underTest.buildPascalTriangleOfHeight(7)).isEqualTo(expected);
    }

    @Test
    public void shouldBuildAPascalTriangleOfHeight6() {
        final List<List<Integer>> expected = new ArrayList<>() {{
            add(new ArrayList<>(){{add(1);}});         //1
            add(new ArrayList<>(){{add(1); add(1);}}); //2
            add(new ArrayList<>(){{add(1);add(2);add(1);}}); //3
            add(new ArrayList<>(){{add(1);add(3);add(3);add(1);}}); //4
            add(new ArrayList<>(){{add(1);add(4);add(6);add(4);add(1);}}); //5
            add(new ArrayList<>(){{add(1);add(5);add(10);add(10);add(5);add(1);}}); //6
        }};
        Assertions.assertThat(underTest.buildPascalTriangleOfHeight(6)).isEqualTo(expected);
    }

    @Test
    public void shouldBuildAPascalTriangleOfHeight5() {
        final List<List<Integer>> expected = new ArrayList<>() {{
            add(new ArrayList<>(){{add(1);}}); //1
            add(new ArrayList<>(){{add(1); add(1);}}); //2
            add(new ArrayList<>(){{add(1);add(2);add(1);}}); //3
            add(new ArrayList<>(){{add(1);add(3);add(3);add(1);}}); //4
            add(new ArrayList<>(){{add(1);add(4);add(6);add(4);add(1);}}); //5
        }};
        Assertions.assertThat(underTest.buildPascalTriangleOfHeight(30)).isEqualTo(expected);
    }


}