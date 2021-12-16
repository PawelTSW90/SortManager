package com.sparta.paweldyjak;
import com.sparta.paweldyjak.Logger.MyLogger;
import com.sparta.paweldyjak.display.OutputPrinter;
import com.sparta.paweldyjak.display.UserInputScanner;
import com.sparta.paweldyjak.sorters.Sorters;
import com.sparta.paweldyjak.sorters.SortersFactory;
import java.util.Arrays;

public class SortManagerLoader {

    public static void getUserInput() {
        //config Logger
        MyLogger.configLogger();

        //call Output Printer to print start message and set scanner
        OutputPrinter.printMessage(OutputPrinter.generateStartMessage());
        OutputPrinter.printMessage(OutputPrinter.generateSortersToUseMessageFromFile());
        UserInputScanner.getSorterNumberToUse();

    }

    public static void sorterConfig(int sorterNumber, int arraySize) {
        //generate random array
        int[] unsortedArray = ArrayGenerator.generateArray(arraySize);

        //set sorter chosen by user
        Sorters sorter = SortersFactory.getSorter(sorterNumber);

        //run sorter and get its return values
        int[] sortedArray = sorter.sort(Arrays.copyOf(unsortedArray, unsortedArray.length));
        Long sortingTime = sorter.getSortingTime();
        String sorterName = sorter.getSorterName();

        //call method that shows final output
        OutputPrinter.printMessage(OutputPrinter.generateFinalMessage(sorterName, unsortedArray, sortedArray, sortingTime));

    }






}
