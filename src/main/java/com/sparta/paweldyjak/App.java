package com.sparta.paweldyjak;

import com.sparta.paweldyjak.display.MessagePrinter;

public class App {
    public static void main(String[] args) {
        MessagePrinter messagePrinter = new MessagePrinter();
        messagePrinter.printMessage(messagePrinter.generateStartMessage());
        messagePrinter.printMessage(messagePrinter.generateSortersToUse());

    }
}
