package com.sparta.paweldyjak.sorters;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SortersTest {
    Sorters sorter = SortersFactory.getSorter(2);

    @Test
    @DisplayName("Single Value Array Sort Test")
    void singleValueArrayTest() {
        int[] array = new int[]{1};
        Assertions.assertArrayEquals(array, sorter.sort(array));

    }

    @Test
    @DisplayName("Even Array Sort Test")
    void evenArraySortTest() {
        int[] array = new int[]{9,7,4,8,6,2,10,12};
        int[] expectedArray = new int[]{2,4,6,7,8,9,10,12};
        Assertions.assertArrayEquals(expectedArray, sorter.sort(array));


    }

    @Test
    @DisplayName("Odd Array Sort Test")
    void oddArraySortTest() {
        int[] array = new int[]{19,15,13,8,4,2,0};
        int[] expectedArray = new int[]{0,2,4,8,13,15,19};
        Assertions.assertArrayEquals(expectedArray, sorter.sort(array));

    }

    @Test
    @DisplayName("Array with duplicate values Test")
    void arrayWithDuplicateValuesTest() {
        int[] array = new int[]{1,3,6,2,3,10,1};
        int[] expectedArray = new int[]{1,1,2,3,3,6,10};
        Assertions.assertArrayEquals(expectedArray, sorter.sort(array));

    }

    @Test
    @DisplayName("Large Array Test")
    void largeArrayTest() {
        int[] array = new int[]{45,567,2,3,657,3,2334,76,345,2,43,1,546,8,345,13,32,6,678,45,23,12,56,8,723};
        int[] expectedArray = new int[]{1, 2, 2, 3, 3, 6, 8, 8, 12, 13, 23, 32, 43, 45, 45, 56, 76, 345, 345, 546, 567, 657, 678, 723, 2334};
        Assertions.assertArrayEquals(expectedArray, sorter.sort(array));

    }

    @Test
    @DisplayName("Negative Values Array Test")
    void negativeValuesArrayTest() {
        int[] array = new int[]{-2,54,67,-100,23,56,-4};
        int[] expectedArray = new int[]{-100,-4,-2,23,54,56,67};
        Assertions.assertArrayEquals(expectedArray, sorter.sort(array));

    }





}
