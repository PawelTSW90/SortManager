package com.sparta.paweldyjak;

import com.sparta.paweldyjak.Logger.Logger;
import com.sparta.paweldyjak.display.OutputPrinter;
import com.sparta.paweldyjak.display.UserInputScanner;
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

    public static void getUserInput() {
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

    /**
     * Checks if sorter chosen by user has its sorter class
     * @param sorterNumber - Number of sorter number to check
     * @return - A boolean telling if sorter from sortersList.txt file has it class representation
     */
    public static boolean checkIfSorterClassExists(int sorterNumber) {
        if (sorterNumber < 1) {
            return false;
        }
        int lineNumber = 1;
        StringBuilder className = new StringBuilder();
        //retrieve name of the sorter from file
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader("src/main/java/com/sparta/paweldyjak/sorters/sortersList.txt"));
            while (lineNumber != sorterNumber) {
                fileReader.readLine();
                lineNumber++;
            }
            //refactor name of the sorter to class format and check if that class exists
            className.append(fileReader.readLine());
            String classNameString = className.substring(3, className.length());
            classNameString = classNameString.replace(" ", "");
            File testFile = new File("src/main/java/com/sparta/paweldyjak/sorters/" + classNameString + ".java");
            if (testFile.exists()) {
                Logger.log(Level.FINE, "Sorter found in sortersList.txt");
                return true;
            }
            fileReader.close();
        } catch (IOException e) {
            Logger.log(Level.SEVERE, "sortersList.txt file not found! Closing application.");
            System.out.println("sortersList.txt file not found! Closing application.");
            System.exit(1);
        }
        return false;
    }
}
