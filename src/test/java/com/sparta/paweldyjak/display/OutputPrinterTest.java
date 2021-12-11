package com.sparta.paweldyjak.display;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Arrays;
import java.util.stream.Stream;

public class OutputPrinterTest {


    @Test
    @DisplayName("Generate Start Message Test")
    void generateStartMessageTest() {
        Assertions.assertEquals("Enter the number of the sorter you wish to use:", OutputPrinter.generateStartMessage());

    }

    @Test
    @DisplayName("Generate Sorters to use Test")
    void generateSortersToUseTest() {
        Assertions.assertEquals("1. Bubble Sorter\n2. Insertion Sorter", OutputPrinter.generateSortersToUseMessage());

    }

    @ParameterizedTest
    @DisplayName("Generate Final Message Test")
    @MethodSource("generateFinalOutput")
    void generateFinalMessageTest(String sorterName, int[] unsortedArray, int[] sortedArray, Long sortingTime) {
        Assertions.assertEquals("Sorting using the " + sorterName+"\n"+"Before sorting:\n" + Arrays.toString(unsortedArray)+
                "After sorting:\n" + Arrays.toString(sortedArray) + "\n" + "Time taken: " + sortingTime + " nanoseconds",
                OutputPrinter.generateFinalMessage(sorterName, unsortedArray, sortedArray, sortingTime));

    }

    static Stream<Arguments> generateFinalOutput(){
        return Stream.of(
                Arguments.arguments("Bubble Sort", new int[]{5,4,3,2,1}, new int[]{1,2,3,4,5}, 134050L),
                Arguments.arguments("Bubble Sort", new int[]{8,10,10,100,2}, new int[]{2,8,10,10,100}, 23124L),
                Arguments.arguments("Bubble Sort", new int[]{13,67,45,2,98}, new int[]{2,13,45,67,98}, 23424L),
                Arguments.arguments("Bubble Sort", new int[]{97,4,2,767,34}, new int[]{2,4,34,97,767}, 123352L)



        );
    }
}
