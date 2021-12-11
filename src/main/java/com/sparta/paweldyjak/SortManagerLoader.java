package com.sparta.paweldyjak;

import com.sparta.paweldyjak.display.OutputPrinter;
import com.sparta.paweldyjak.display.UserInputScanner;
import com.sparta.paweldyjak.sorters.ArrayGenerator;
import com.sparta.paweldyjak.sorters.Sorters;
import com.sparta.paweldyjak.sorters.SortersFactory;

import java.util.Arrays;

public class SortManagerLoader {

    public static void startSortManager() {
        OutputPrinter.printMessage(OutputPrinter.generateStartMessage());
        OutputPrinter.printMessage(OutputPrinter.generateSortersToUseMessage());
        UserInputScanner.getUserInput();

    }

    public static void runSorter(int sorterNumber, int arraySize) {
        Sorters sorter = SortersFactory.getSorter(sorterNumber);
        int[] unsortedArray = ArrayGenerator.generateArray(arraySize);
        int[] sortedArray = sorter.sort(Arrays.copyOf(unsortedArray, unsortedArray.length));
        Long sortingTime = sorter.getSortingTime();
        String sorterName = sorter.getSorterName();
        setFinalOutput(sorterName, unsortedArray, sortedArray, sortingTime);

    }
    public static void setFinalOutput(String sorterName, int[] unsortedArray, int[] sortedArray, Long sortingTime) {
        OutputPrinter.printMessage(OutputPrinter.generateFinalMessage(sorterName, unsortedArray, sortedArray, sortingTime));
    }


}
