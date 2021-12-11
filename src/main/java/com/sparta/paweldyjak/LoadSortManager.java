package com.sparta.paweldyjak;

import com.sparta.paweldyjak.display.OutputPrinter;
import com.sparta.paweldyjak.display.UserInputScanner;
import com.sparta.paweldyjak.sorters.ArrayGenerator;
import com.sparta.paweldyjak.sorters.SortersFactory;

public class LoadSortManager {

    public static void startSortManager(){
        OutputPrinter.printMessage(OutputPrinter.generateStartMessage());
        OutputPrinter.printMessage(OutputPrinter.generateSortersToUseMessage());
        UserInputScanner.getUserInput();

    }

    public static void callSorter(int sorterNumber, int arraySize){
        SortersFactory.getSorter(sorterNumber).sort(ArrayGenerator.generateArray(arraySize));
    }


}
