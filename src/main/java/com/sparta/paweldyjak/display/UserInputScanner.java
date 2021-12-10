package com.sparta.paweldyjak.display;

import java.util.Scanner;

public class UserInputScanner {
    private Scanner userInputScanner;

    public void startSorterChooseScanner(){
        userInputScanner = new Scanner(System.in);
        String userInput = userInputScanner.nextLine();
        if(userInput.equals("1")){
            System.out.println("One");
        } else if(userInput.equals("2")){
            System.out.println("Two");
        }
    }

}
