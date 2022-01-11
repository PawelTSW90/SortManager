package com.sparta.paweldyjak;

import com.sparta.paweldyjak.Logger.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;

public class Utility {

    /**
     * Checks if sorter chosen by user has its sorter class
     * @param sorterNumber - Number of sorter number to check
     * @return - A boolean telling if sorter from sortersList.txt file has it class representation
     */
    public static boolean checkIfSorterClassExists(int sorterNumber) {
        if (sorterNumber < 1) {
            return false;
        }
        int lineNumber = 1;
        StringBuilder className = new StringBuilder();
        //retrieve name of the sorter from file
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader("src/main/resources/sortersList.txt"));
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
                Logger.log(Level.FINE, "Sorter found in sortersList.txt");
                return true;
            }
            fileReader.close();
        } catch (IOException e) {
            Logger.log(Level.SEVERE, "sortersList.txt file not found! Closing application.");
            System.out.println("sortersList.txt file not found! Closing application.");
            System.exit(1);
        }
        return false;
    }
}
