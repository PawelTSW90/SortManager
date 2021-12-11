package com.sparta.paweldyjak;

import com.sparta.paweldyjak.display.OutputPrinter;
import com.sparta.paweldyjak.display.UserInputScanner;

public class LoadSortManager {

    public static void startSortManager(){
        OutputPrinter outputPrinter = new OutputPrinter();
        UserInputScanner userInputScanner = new UserInputScanner();
        outputPrinter.printMessage(outputPrinter.generateStartMessage());
        outputPrinter.printMessage(outputPrinter.generateSortersToUseMessage());
        userInputScanner.getUserInput(outputPrinter);
    }
}
