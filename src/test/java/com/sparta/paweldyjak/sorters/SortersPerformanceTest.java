package com.sparta.paweldyjak.sorters;

import com.sparta.paweldyjak.display.OutputPrinter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Random;

/**
 * Test checks all sorters algorithms performance with random array of size 100 and prints results.
 */
public class SortersPerformanceTest {
    private static int[] unsortedArray;

    /**
     * Create random array of size 100 for tests.
     */
    @BeforeAll
    public static void setup() {
        Random random = new Random();
        unsortedArray = new int[100];
        for (int i = 0; i < unsortedArray.length; i++) {
            unsortedArray[i] = random.nextInt(1000) + 1;
        }

    }

    /**
     * Bubble Sorter test.
     */
    @Test
    @DisplayName("Bubble Sorter Test")
    void bubbleSorterTest() {
        Sorters sorter = new BubbleSorter();
        long startTime = System.nanoTime();
        int[] sortedValue = sorter.sort(unsortedArray);
        long endTime = System.nanoTime();
        OutputPrinter.printMessage(OutputPrinter.generateFinalMessage("Bubble Sorter", unsortedArray, sortedValue, endTime - startTime));
        System.out.println("\n" + "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

    }

    /**
     * Merge sorter test.
     */
    @Test
    @DisplayName("Merge Sorter Test")
    void mergeSorterTest() {
        Sorters sorter = new MergeSorter();
        long startTime = System.nanoTime();
        int[] sortedValue = sorter.sort(unsortedArray);
        long endTime = System.nanoTime();
        OutputPrinter.printMessage(OutputPrinter.generateFinalMessage("Merge Sorter", unsortedArray, sortedValue, endTime - startTime));
        System.out.println("\n" + "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

    }

    /**
     * Binary Tree Sorter test.
     */
    @Test
    @DisplayName("Binary Tree Sorter Test")
    void binaryTreeSorterTest() {
        Sorters sorter = new BinaryTreeSorter();
        long startTime = System.nanoTime();
        int[] sortedValue = sorter.sort(unsortedArray);
        long endTime = System.nanoTime();
        OutputPrinter.printMessage(OutputPrinter.generateFinalMessage("Binary Tree Sorter", unsortedArray, sortedValue, endTime - startTime));
        System.out.println("\n" + "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    }

    /**
     * Insertion Sorter test.
     */
    @Test
    @DisplayName("Insertion Sorter Test")
    void InsertionSorterTest() {
        Sorters sorter = new InsertionSorter();
        long startTime = System.nanoTime();
        int[] sortedValue = sorter.sort(unsortedArray);
        long endTime = System.nanoTime();
        OutputPrinter.printMessage(OutputPrinter.generateFinalMessage("Insertion Sorter", unsortedArray, sortedValue, endTime - startTime));
        System.out.println("\n" + "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

    }

    /**
     * Selection Sorter test.
     */
    @Test
    @DisplayName("Selection Sorter Test")
    void selectionSorterTest() {
        Sorters sorter = new InsertionSorter();
        long startTime = System.nanoTime();
        int[] sortedValue = sorter.sort(unsortedArray);
        long endTime = System.nanoTime();
        OutputPrinter.printMessage(OutputPrinter.generateFinalMessage("Selection Sorter", unsortedArray, sortedValue, endTime - startTime));
        System.out.println("\n" + "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    }
}
