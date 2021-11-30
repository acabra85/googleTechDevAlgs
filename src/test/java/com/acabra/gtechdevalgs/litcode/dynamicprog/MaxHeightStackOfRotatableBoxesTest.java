package com.acabra.gtechdevalgs.litcode.dynamicprog;

import com.acabra.gtechdevalgs.TestUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MaxHeightStackOfRotatableBoxesTest {

    private MaxHeightStackOfRotatableBoxes underTest;

    @BeforeEach
    public void setup() {
        underTest = new MaxHeightStackOfRotatableBoxes();
    }

    @Test
    public void mustReturn976() {
        //given
        String input = "[[100,75,20],[93,99,97],[84,12,7],[53,21,87],[70,100,88]," +
                "[57,32,73],[95,86,93],[86,94,59],[22,55,55],[73,77,35],[39,51,49],[50,83,52]," +
                "[10,8,56],[27,89,30],[29,82,28],[20,62,17],[36,64,51],[84,30,30],[55,34,45],[2,48,72]," +
                "[31,19,44],[26,33,26],[51,65,65],[50,69,8],[64,37,78],[54,97,100],[35,23,6],[85,9,69],[80,16,71]," +
                "[81,40,32],[97,62,33],[86,46,18],[92,67,71],[73,99,94],[63,77,4],[1,84,42],[82,90,58],[44,18,31]," +
                "[15,11,92],[62,1,37],[76,40,79],[52,36,22],[97,13,33],[51,82,29],[19,93,91],[26,92,97],[66,46,15]," +
                "[33,65,29],[98,98,89],[24,5,31],[1,76,93],[22,95,60],[18,49,7],[50,5,24],[5,21,14],[8,73,17]," +
                "[99,61,4],[90,38,3],[37,75,51],[59,92,55],[79,15,79],[83,40,1],[74,10,15],[17,42,37],[24,35,11]," +
                "[45,1,35],[48,9,37],[5,83,22],[45,34,96],[38,18,52],[59,24,7],[51,47,95],[8,90,60],[40,89,51]," +
                "[84,59,50],[54,6,71],[58,74,30],[11,57,80]]";
        int[][] cuboids = TestUtils.parseStringToIntMatrix(input, 3);
        int expected = 976;
        //when
        int actual = underTest.calculateMaxBoxesStackHeight(cuboids);
        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }


}