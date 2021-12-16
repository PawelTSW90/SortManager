package com.sparta.paweldyjak;

import com.sparta.paweldyjak.Logger.MyLogger;
import com.sparta.paweldyjak.display.OutputPrinter;
import com.sparta.paweldyjak.display.UserInputScanner;
import com.sparta.paweldyjak.sorters.Sorters;
import com.sparta.paweldyjak.sorters.SortersFactory;

import java.io.*;
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

    public static boolean checkIfSorterClassExists(int sorterNumber) {
        if(sorterNumber<1){
            return false;
        }
        int lineNumber = 1;
        StringBuilder className = new StringBuilder();
        //retrieve name of the sorter from file
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader("src/main/java/com/sparta/paweldyjak/sorters/sortersList.txt"));
            while (lineNumber != sorterNumber) {
                fileReader.readLine();
                lineNumber++;
            }
            //refactor name of the sorter to class format and check if that class exists
            className.append(fileReader.readLine());
            String classNameString = className.substring(3, className.length());
            classNameString = classNameString.replace(" ", "");
            File testFile = new File("src/main/java/com/sparta/paweldyjak/sorters/" + classNameString + ".java");
            if (testFile.exists()) {
                return true;
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
