package com.sparta.paweldyjak.display;

import com.sparta.paweldyjak.LoadSortManager;

import java.util.Scanner;

public class UserInputScanner {
    private static int sorterNumberToUse;
    private static int arraySizeToGenerate;

    public static void getUserInput(){
        Scanner userInputScanner = new Scanner(System.in);
        //get sorter number from user
        sorterNumberToUse = userInputScanner.nextInt();
        //get array size from user
        arraySizeToGenerate = userInputScanner.nextInt();

        LoadSortManager.callSorter(sorterNumberToUse, arraySizeToGenerate);
    }

}
