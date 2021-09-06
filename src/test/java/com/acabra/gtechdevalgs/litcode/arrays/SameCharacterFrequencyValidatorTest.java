package com.acabra.gtechdevalgs.litcode.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

class SameCharacterFrequencyValidatorTest {

    private SameCharacterFrequencyValidator underTest;

    @BeforeEach
    public void setup() {
        underTest = new SameCharacterFrequencyValidator();
    }

    @Test
    public void mustReturnTrue_inputIsEmptyString() {
        String input = "";
        Assertions.assertThat(underTest.validateString(input)).isTrue();
    }

    @Test
    public void mustReturnTrue_allCharactersTheSame() {
        String input = "aaaaaaaaa";

        Assertions.assertThat(underTest.validateString(input)).isTrue();
    }
    @Test
    public void mustReturnTrue_validString() {
        String input = "aabbcc";

        Assertions.assertThat(underTest.validateString(input)).isTrue();
    }

    @Test
    public void mustReturnTrue_inputHasDifferentCharacterFrequency() {
        String input = "aabbccc";

        Assertions.assertThat(underTest.validateString(input)).isTrue();
    }

    @Test
    public void mustReturnFalse_multipleCharacters() {
        String input = "aabbbccddd";

        Assertions.assertThat(underTest.validateString(input)).isFalse();
    }

    @Test
    public void mustReturnFalse_nullInput() {
        String input = null;

        Assertions.assertThat(underTest.validateString(input)).isFalse();
    }


}