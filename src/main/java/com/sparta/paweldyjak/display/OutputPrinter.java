package com.sparta.paweldyjak.display;

import java.io.*;
import java.util.Arrays;

public class OutputPrinter {

    public static void printMessage(String messageToPrint) {
        System.out.println(messageToPrint);
    }

    public static String generateStartMessage() {
        return "Enter the number of the sorter you wish to use:";
    }

    public static String generateSortersToUseMessageFromFile() {
        StringBuilder fileString = new StringBuilder();
        String currentLine;
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader("src/main/java/com/sparta/paweldyjak/sorters/sortersList.txt"));
            currentLine = fileReader.readLine();
            while (currentLine != null) {
                fileString.append(currentLine);
                currentLine = fileReader.readLine();
                if(currentLine!=null) {
                    fileString.append("\n");
                }
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileString.toString();
    }

    public static String generateSizeOfArrayMessage() {
        return "Please enter the size of array you wish to generate:";
    }

    public static String generateFinalMessage(String sorterName, int[] unsortedArray, int[] sortedArray, Long sortingTime) {
        return "Sorting using the " + sorterName + "\n" + "Before sorting:\n" + Arrays.toString(unsortedArray) + "\n" +
                "After sorting:\n" + Arrays.toString(sortedArray) + "\n" + "Time taken: " + sortingTime + " nano seconds";


    }


}
