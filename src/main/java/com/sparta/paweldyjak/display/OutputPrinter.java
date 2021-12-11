package com.sparta.paweldyjak.display;

public class OutputPrinter {

    public static void printMessage(String messageToPrint){
        System.out.println(messageToPrint);
    }


    public static String generateStartMessage(){
        return "Enter the number of the sorter you wish to use:";
    }

    public static String generateSortersToUseMessage(){
        return "1. Bubble Sorter\n2. Insertion Sorter";
    }

    public static String generateSizeOfArrayMessage(){
        return "Please enter the size of array you wish to generate:";
    }


}
