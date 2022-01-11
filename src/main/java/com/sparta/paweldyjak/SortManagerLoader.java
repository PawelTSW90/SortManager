package com.sparta.paweldyjak;

import com.sparta.paweldyjak.Logger.Logger;
import com.sparta.paweldyjak.input_output.OutputPrinter;
import com.sparta.paweldyjak.input_output.UserInputScanner;
import com.sparta.paweldyjak.sorters.Sorters;
import com.sparta.paweldyjak.sorters.SortersFactory;
import java.io.*;
import java.util.Arrays;
import java.util.logging.Level;

/**
 * Class responsible for managing all Sort Manager processes: printing out start message,
 * getting user input, starting array sorting and printing out final message.
 */


public class SortManagerLoader {

    /**
     * Method responsible for setting out Logger, printing out welcome messages, and running.
     * scanner to get user input.
     */

    public static void start() {
        //config Logger
        Logger.configLogger();
        Logger.log(Level.INFO, "Sort Manager application started");

        //call Output Printer to print start message and set scanner
        OutputPrinter.printMessage(OutputPrinter.generateStartMessage());
        Logger.log(Level.FINE, "Start Message printed");
        OutputPrinter.printMessage(OutputPrinter.generateSortersToUseMessageFromFile());
        UserInputScanner.getSorterNumberToUse();

    }

    /**
     * Calls generateArray to generate random array, creates new Sorters object and calls startSorting method.
     * @param sorterNumber Number of sorter chosen by user.
     * @param arraySize    Size of Array to be generated chosen by user.
     */

    public static void sorterConfig(int sorterNumber, int arraySize) {
        int[] unsortedArray = ArrayGenerator.generateArray(arraySize);
        Sorters sorter = SortersFactory.getSorter(sorterNumber);
        startSorting(sorter, unsortedArray);

    }

    /**
     * Starting sorting and receiving information about sorting time. Calls printFinalMessage.
     * @param sorter Sorter object.
     * @param unsortedArray Unsorted array to be sorted.
     */

    public static void startSorting(Sorters sorter, int[] unsortedArray) {
        int[] sortedArray = sorter.sort(Arrays.copyOf(unsortedArray, unsortedArray.length));
        Long sortingTime = sorter.getSortingTime();
        String sorterName = sorter.getSorterName();
        printFinalMessage(sorterName, unsortedArray, sortedArray, sortingTime);
    }

    /**
     *Calls and passes data to printMessage method to print out final message
     * @param sorterName - Name of sorter used.
     * @param unsortedArray - array before sorting.
     * @param sortedArray - array after sorting.
     * @param sortingTime - time taken to sort array.
     */
    public static void printFinalMessage(String sorterName, int[] unsortedArray, int[] sortedArray, Long sortingTime){
        //call method that shows final output
        OutputPrinter.printMessage(OutputPrinter.generateFinalMessage(sorterName, unsortedArray, sortedArray, sortingTime));
        Logger.log(Level.FINE, "Final message printed\nClosing application");
    }

}
