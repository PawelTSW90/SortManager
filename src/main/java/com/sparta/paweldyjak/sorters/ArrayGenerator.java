package com.sparta.paweldyjak.sorters;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayGenerator {

    public static int[] generateArray(int arraySize) {
        Random random = new Random();
        List<Integer> arraysList = new ArrayList<>();
        //add random number to arraysList, as long as it's size is less than arraySize
        while (arraysList.size()<arraySize){
            arraysList.add(random.nextInt(1000));
        }
        return arraysList.stream().mapToInt(i -> i).toArray();
    }


}
