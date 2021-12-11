package com.sparta.paweldyjak;

import com.sparta.paweldyjak.display.OutputPrinter;

public class LoadSortManager {

    public static void startSortManager(){
        OutputPrinter outputPrinter = new OutputPrinter();
        outputPrinter.printMessage(outputPrinter.generateStartMessage());
        outputPrinter.printMessage(outputPrinter.generateSortersToUseMessage());

    }

    public static void callSorter(int sorterNumber, int arraySize){

    }


}
