package com.sparta.paweldyjak;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class ArrayGeneratorTest {

    @ParameterizedTest
    @DisplayName("generateArrayTest")
    @MethodSource("numbersCreator")
    void generateArrayTest(int arraySize) {
        int[]generatedArray = ArrayGenerator.generateArray(arraySize);
        Assertions.assertEquals(arraySize, generatedArray.length);

    }
    static Stream<Integer> numbersCreator() {
        return Stream.of(
                10,
                30,
                44,
                82,
                37


        );
    }
}
