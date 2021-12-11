package com.sparta.paweldyjak.display;

public class OutputPrinter {

    public void printMessage(String messageToPrint){
        System.out.println(messageToPrint);
    }


    public String generateStartMessage(){
        return "Enter the number of the sorter you wish to use:";
    }

    public String generateSortersToUseMessage(){
        return "1. Insertion Sorter\n2. Bubble Sorter";
    }

    public String generateSizeOfArrayMessage(){
        return "Please enter the size of array you wish to generate:";
    }


}
