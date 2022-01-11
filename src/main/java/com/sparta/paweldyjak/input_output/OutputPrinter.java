package com.sparta.paweldyjak.input_output;

import com.sparta.paweldyjak.Logger.Logger;
import java.io.*;
import java.util.Arrays;
import java.util.logging.Level;

/**
 * Printing out messages to user.
 */
public class OutputPrinter {
    /**
     * Accepts String with a message and printing it out.
     * @param messageToPrint String with message to print out.
     */
    public static void printMessage(String messageToPrint) {
        System.out.println(messageToPrint);
    }

    /**
     *Returns String with message to enter sorter number.
     * @return A String with message to enter sorter number.
     */
    public static String generateStartMessage() {
        return "Enter the number of the sorter you wish to use:";
    }

    /**
     *Returns String with sorters list retrieved from sortersList.txt file.
     * @return A String with sorters list retrieved from sortersList.txt file.
     */
    public static String generateSortersToUseMessageFromFile() {
        StringBuilder fileString = new StringBuilder();
        String currentLine;
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader("src/main/resources/sortersList.txt"));
            currentLine = fileReader.readLine();
            while (currentLine != null) {
                fileString.append(currentLine);
                currentLine = fileReader.readLine();
                if(currentLine!=null) {
                    fileString.append("\n");
                }
            }
            fileReader.close();
            Logger.log(Level.INFO, "Sorters list printed out from file");
        } catch (IOException e) {
            Logger.log(Level.SEVERE, "sortersList.txt file not found! Closing application.");
            System.out.println("sortersList.txt file not found! Closing application");
            System.exit(1);
        }
        return fileString.toString();
    }

    /**
     * Returns String with message to enter size of array to be generated.
     * @return A String with message to enter size of array to be generated.
     */
    public static String generateSizeOfArrayMessage() {
        return "Please enter the size of array you wish to generate:";
    }

    /**
     * Returns a String with final message, containing sorter name, array before and after sorting and sorting time.
     * @param sorterName Name of sorter used.
     * @param unsortedArray Array before sorting.
     * @param sortedArray Array after sorting.
     * @param sortingTime Time taken to sort array.
     * @return A String with final message, containing sorter name, array before and after sorting and sorting time.
     */
    public static String generateFinalMessage(String sorterName, int[] unsortedArray, int[] sortedArray, Long sortingTime) {
        return "Sorting using the " + sorterName + "\n" + "Before sorting:\n" + Arrays.toString(unsortedArray) + "\n" +
                "After sorting:\n" + Arrays.toString(sortedArray) + "\n" + "Time taken: " + sortingTime + " nano seconds";


    }


}
