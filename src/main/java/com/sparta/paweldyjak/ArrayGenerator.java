package com.sparta.paweldyjak;
import java.util.Random;

public class ArrayGenerator {

    public static int[] generateArray(int arraySize) {
        Random random = new Random();
        int[] generatedArray = new int[arraySize];
        //add random numbers to generatedArray
        for (int i = 0; i < arraySize; i++) {
            generatedArray[i] = random.nextInt(1000);
        }
        return generatedArray;
    }


}
