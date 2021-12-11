package com.sparta.paweldyjak.display;

import org.junit.jupiter.api.*;

public class OutputPrinterTest {
    OutputPrinter outputPrinter;

    @BeforeEach
    void setup() {
        outputPrinter = new OutputPrinter();
    }


    @Test
    @DisplayName("Generate Start Message Test")
    void generateStartMessageTest() {
        Assertions.assertEquals("Enter the number of the sorter you wish to use:", outputPrinter.generateStartMessage());

    }

    @Test
    @DisplayName("Generate Sorters to use Test")
    void generateSortersToUseTest() {
        Assertions.assertEquals("1. Insertion Sorter\n2. Bubble Sorter", outputPrinter.generateSortersToUseMessage());


    }
}
