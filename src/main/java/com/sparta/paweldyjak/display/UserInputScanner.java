package com.sparta.paweldyjak.display;

import java.util.Scanner;

public class UserInputScanner {
    private int sorterNumberToUse;
    private int arraySizeToGenerate;

    public void getUserInput(OutputPrinter outputPrinter){
        Scanner userInputScanner = new Scanner(System.in);
        //get sorter number from user
        sorterNumberToUse = userInputScanner.nextInt();
        //print array size message
        outputPrinter.printMessage(outputPrinter.generateSizeOfArrayMessage());
        //get array size from user
        arraySizeToGenerate = userInputScanner.nextInt();
    }

}
