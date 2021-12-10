package com.sparta.paweldyjak.display;

import org.junit.jupiter.api.*;

public class MessagePrinterTest {
    MessagePrinter messagePrinter;

    @BeforeEach
    void setup() {
        messagePrinter = new MessagePrinter();
    }


    @Test
    @DisplayName("Generate Start Message Test")
    void generateStartMessageTest() {
        Assertions.assertEquals("Enter the number of the sorter you wish to use:",messagePrinter.generateStartMessage());

    }

    @Test
    @DisplayName("Generate Sorters to use Test")
    void generateSortersToUseTest() {
        Assertions.assertEquals("1. BinarySorter\n2. BubbleSorter",messagePrinter.generateSortersToUseMessage());


    }
}
