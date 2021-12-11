package com.sparta.paweldyjak.display.sorters;

import com.sparta.paweldyjak.sorters.BubbleSorter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class BubbleSorterTest {
    BubbleSorter bubbleSorter;

    @BeforeEach
    void setup(){
        bubbleSorter = new BubbleSorter();
    }


    @ParameterizedTest
    @DisplayName("Bubble Sorter Test")
    @MethodSource("arraysPrinter")
    void bubbleSorterTest(int[] unsortedArray, int[] sortedArray) {
        Assertions.assertArrayEquals(sortedArray, bubbleSorter.bubbleSortNumber(unsortedArray));


    }

    static Stream<Arguments> arraysPrinter(){
return Stream.of(
        Arguments.arguments(new int[]{5,4,3,2,1}, new int[] {1,2,3,4,5}),
        Arguments.arguments(new int[]{8,9,1,5,4}, new int[] {1,4,5,8,9}),
        Arguments.arguments(new int[]{10,9,8,7,6}, new int[] {6,7,8,9,10}),
        Arguments.arguments(new int[]{100,34,29,34,500}, new int[] {29,34,34,100,500})


);
    }
}
