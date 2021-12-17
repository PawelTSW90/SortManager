package com.sparta.paweldyjak;
import com.sparta.paweldyjak.Logger.Logger;
import java.util.Random;
import java.util.logging.Level;

/**
 * Generates random array.
 */
public class ArrayGenerator {
    /**
     *
     * @param arraySize Size of array to generate.
     * @return Randomly generated array with size passed as a parameter.
     */
    public static int[] generateArray(int arraySize) {
        Random random = new Random();
        int[] generatedArray = new int[arraySize];
        //add random numbers to generatedArray
        for (int i = 0; i < arraySize; i++) {
            generatedArray[i] = random.nextInt(1000);
        }
        Logger.log(Level.FINE, "Random array generated");
        return generatedArray;
    }


}
