package com.sparta.paweldyjak.sorters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SortersFactoryTest {

    @Test
    @DisplayName("Get Sorter Test")
    void getSorterTest() {
        Assertions.assertInstanceOf(BubbleSorter.class,SortersFactory.getSorter(1));
        Assertions.assertInstanceOf(MergeSorter.class,SortersFactory.getSorter(2));
        Assertions.assertInstanceOf(BinaryTreeSorter.class,SortersFactory.getSorter(3));
        Assertions.assertInstanceOf(InsertionSorter.class,SortersFactory.getSorter(4));
        Assertions.assertInstanceOf(SelectionSorter.class,SortersFactory.getSorter(5));

    }
}
