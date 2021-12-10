package com.sparta.paweldyjak.display;

public class MessagePrinter {

    public void printMessage(String messageToPrint){
        System.out.println(messageToPrint);
    }


    public String generateStartMessage(){
        return "Enter the number of the sorter you wish to use:";
    }

    public String generateSortersToUse(){
        return "1. BinarySorter\n2. BubbleSorter";
    }
}
