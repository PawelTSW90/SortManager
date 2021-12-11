package com.sparta.paweldyjak.sorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BubbleSorter {

    public Integer[] bubbleSortNumber(Integer[] arrayToSort){
        long startTime = System.nanoTime();
        boolean noIteration = false;
        ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(arrayToSort));

        //repeat iteration until there is no new iteration needed
        while (!noIteration) {
            noIteration = true;
            for (int i = 1; i < numbersList.size(); i++) {
                if (numbersList.get(i) < numbersList.get(i-1)) {
                    noIteration = false;
                    Collections.swap(numbersList, i, i-1);
                    i -= 1;
                }
            }
        }
        long endTime = System.nanoTime();
        System.out.println("Time: "+(endTime - startTime)+" nanoseconds");
        return numbersList.toArray(new Integer[0]);
    }
}
