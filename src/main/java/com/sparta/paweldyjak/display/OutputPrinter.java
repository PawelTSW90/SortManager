package com.sparta.paweldyjak.display;

import java.util.Arrays;

public class OutputPrinter {

    public static void printMessage(String messageToPrint){
        System.out.println(messageToPrint);
    }

    public static String generateStartMessage(){
        return "Enter the number of the sorter you wish to use:";
    }

    public static String generateSortersToUseMessage(){
        return "1. Bubble Sorter\n2. Merge Sorter\n3. Binary Tree Sorter\n4. Insertion Sorter";
    }

    public static String generateSizeOfArrayMessage(){
        return "Please enter the size of array you wish to generate:";
    }

    public static String generateFinalMessage(String sorterName, int[] unsortedArray, int[] sortedArray, Long sortingTime){
        return "Sorting using the " + sorterName+"\n"+"Before sorting:\n" + Arrays.toString(unsortedArray)+"\n"+
                "After sorting:\n" + Arrays.toString(sortedArray) + "\n" + "Time taken: " + sortingTime + " nanoseconds";


    }


}
