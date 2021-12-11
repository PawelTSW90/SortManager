package com.sparta.paweldyjak.display;

import org.junit.jupiter.api.*;

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
}
