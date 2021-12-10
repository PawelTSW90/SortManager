package com.sparta.paweldyjak.start;

import com.sparta.paweldyjak.display.MessagePrinter;
import com.sparta.paweldyjak.display.UserInputScanner;

public class LoadSortManager {

    public static void startSortManager(){
        MessagePrinter messagePrinter = new MessagePrinter();
        messagePrinter.printMessage(messagePrinter.generateStartMessage());
        messagePrinter.printMessage(messagePrinter.generateSortersToUse());
        UserInputScanner userInputScanner = new UserInputScanner();
        userInputScanner.startSorterChooseScanner();
    }
}
