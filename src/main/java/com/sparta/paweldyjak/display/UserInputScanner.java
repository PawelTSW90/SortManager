package com.sparta.paweldyjak.display;

import com.sparta.paweldyjak.SortManagerLoader;

import java.util.Scanner;

public class UserInputScanner {

    public static void getUserInput(){
        Scanner userInputScanner = new Scanner(System.in);
        //get sorter number from user
        int sorterNumberToUse = userInputScanner.nextInt();
        //get array size from user
        OutputPrinter.printMessage(OutputPrinter.generateSizeOfArrayMessage());
        int arraySizeToGenerate = userInputScanner.nextInt();
        SortManagerLoader.runSorter(sorterNumberToUse, arraySizeToGenerate);
    }

}
