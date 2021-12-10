package com.sparta.paweldyjak.display;

import java.util.Scanner;

public class UserInputScanner {
    private int sorterNumberToUse;
    private int arraySizeToGenerate;

    public void getUserInput(MessagePrinter messagePrinter){
        Scanner userInputScanner = new Scanner(System.in);
        //get sorter number from user
        sorterNumberToUse = userInputScanner.nextInt();
        //print array size message
        messagePrinter.printMessage(messagePrinter.generateSizeOfArrayMessage());
        //get array size from user
        arraySizeToGenerate = userInputScanner.nextInt();
    }

}
