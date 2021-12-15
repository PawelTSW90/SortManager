package com.sparta.paweldyjak.display;

import com.sparta.paweldyjak.SortManagerLoader;
import com.sparta.paweldyjak.exceptions.WrongUserInputEsception;

import java.util.Scanner;

public class UserInputScanner {
    static int sorterNumberToUse = 0;
    static int arraySizeToGenerate = 0;
    static Scanner userInputScanner = new Scanner(System.in);

    public static void getSorterNumberToUse() {
        //get sorter number from user
        while (sorterNumberToUse == 0) {
            try {
                if (!userInputScanner.hasNextInt()) {
                    throw new WrongUserInputEsception();
                } else{
                    sorterNumberToUse = userInputScanner.nextInt();
                    OutputPrinter.printMessage(OutputPrinter.generateSizeOfArrayMessage());
                    //call getArraySieToUse method to get array number from user
                    getArraySizeToUse();
                }
            } catch (WrongUserInputEsception e) {
                System.out.println(e.getMessage());
                userInputScanner.next();
            }
        }

    }

    public static void getArraySizeToUse(){
        while (arraySizeToGenerate == 0) {
            try {
                if (!userInputScanner.hasNextInt()) {
                    throw new WrongUserInputEsception();
                } else{
                    arraySizeToGenerate = userInputScanner.nextInt();
                    //call sorterConfig method to pass user data and run sorter
                    SortManagerLoader.sorterConfig(sorterNumberToUse, arraySizeToGenerate);
                }
            } catch (WrongUserInputEsception e) {
                System.out.println(e.getMessage());
                userInputScanner.next();
            }
        }

    }
}
