package com.sparta.paweldyjak.display;

import com.sparta.paweldyjak.Logger.Logger;
import com.sparta.paweldyjak.SortManagerLoader;
import java.util.Scanner;
import java.util.logging.Level;


/**
 * Scanner class, which collects data from user.
 */
public class UserInputScanner {
    static int sorterNumberToUse = 0;
    static int arraySizeToGenerate = 0;
    static Scanner userInputScanner = new Scanner(System.in);

    /**
     * Collects sorter number from user.
     */
    public static void getSorterNumberToUse() {

        while (sorterNumberToUse == 0) {
                //check uf user input has correct format
                if (!userInputScanner.hasNextInt()) {
                    userInputScanner.next();
                    Logger.log(Level.WARNING, "Invalid user input");
                    System.out.println("Invalid user input. Please try again.");
                } else {
                    //check if sorter chosen by user exists
                    sorterNumberToUse = userInputScanner.nextInt();
                    if (!SortManagerLoader.checkIfSorterClassExists(sorterNumberToUse)) {
                        Logger.log(Level.WARNING, "Sorter not found in sortersList.txt");
                        System.out.println("Sorter not found in sortersList.txt \nPlease try again");
                        sorterNumberToUse = 0;
                    } else {
                        OutputPrinter.printMessage(OutputPrinter.generateSizeOfArrayMessage());
                        //call getArraySieToUse method to get array number from user
                        getArraySizeToGenerate();
                    }
                }

        }
    }

    /**
     * Collects array size to be generated from user.
     */
    public static void getArraySizeToGenerate() {

        while (arraySizeToGenerate == 0) {

            if (!userInputScanner.hasNextInt()) {
                userInputScanner.next();
                Logger.log(Level.WARNING, "Invalid user input.");
                System.out.println("Invalid user input. Please try again.");
            } else {
                arraySizeToGenerate = userInputScanner.nextInt();
                if (arraySizeToGenerate == 0) {
                    Logger.log(Level.WARNING, "0 input for array size. Waiting for new input");
                    System.out.println("Array size must be greater than 0. Please try again.");
                } else {
                    //call sorterConfig method to pass user data and run sorter
                    SortManagerLoader.sorterConfig(sorterNumberToUse, arraySizeToGenerate);
                }
            }
        }
    }
}
