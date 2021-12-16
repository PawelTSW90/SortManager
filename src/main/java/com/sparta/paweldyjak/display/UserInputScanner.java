package com.sparta.paweldyjak.display;

import com.sparta.paweldyjak.SortManagerLoader;
import com.sparta.paweldyjak.exceptions.SorterDoesntExistException;
import com.sparta.paweldyjak.exceptions.WrongUserInputException;

import java.util.Scanner;

public class UserInputScanner {
    static int sorterNumberToUse = 0;
    static int arraySizeToGenerate = 0;
    static Scanner userInputScanner = new Scanner(System.in);

    public static void getSorterNumberToUse() {

        while (sorterNumberToUse == 0) {
            try {
                //check uf user input has correct format
                if (!userInputScanner.hasNextInt()) {
                    userInputScanner.next();
                    throw new WrongUserInputException("Invalid user input. Please try again.");
                } else {
                    //check if sorter chosen by user exists
                    sorterNumberToUse = userInputScanner.nextInt();
                    if (!SortManagerLoader.checkIfSorterClassExists(sorterNumberToUse)) {
                        throw new SorterDoesntExistException("Sorter doesn't exist. Please try again.");
                    } else {

                        OutputPrinter.printMessage(OutputPrinter.generateSizeOfArrayMessage());
                        //call getArraySieToUse method to get array number from user
                        getArraySizeToUse();
                    }
                }
            } catch (WrongUserInputException | SorterDoesntExistException e) {
                System.out.println(e.getMessage());
                sorterNumberToUse = 0;
            }
        }

    }

    public static void getArraySizeToUse() {
        while (arraySizeToGenerate == 0) {
            try {
                if (!userInputScanner.hasNextInt()) {
                    throw new WrongUserInputException("Wrong user input exception");
                } else {
                    arraySizeToGenerate = userInputScanner.nextInt();
                    //call sorterConfig method to pass user data and run sorter
                    SortManagerLoader.sorterConfig(sorterNumberToUse, arraySizeToGenerate);
                }
            } catch (WrongUserInputException e) {
                System.out.println(e.getMessage());
                userInputScanner.next();
            }
        }

    }
}
