package com.sparta.paweldyjak.sorters;


import com.sparta.paweldyjak.Logger.Logger;

import java.util.logging.Level;

public class BubbleSorter implements Sorters {
    private Long sortingTime;

    @Override
    public int[] sort(int[] array) {
        Logger.log(Level.FINE, "Bubble sorter sorting started");
        long startTime = System.nanoTime();
        boolean noIteration = false;
        int tmpNumber;
        //repeat iteration until there is no new iteration needed
        while (!noIteration) {
            noIteration = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    noIteration = false;
                    tmpNumber = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = tmpNumber;
                    i -= 1;
                }
            }
        }
        long endTime = System.nanoTime();
        sortingTime = endTime - startTime;
        Logger.log(Level.FINE, "Bubble sorter sorting finished");
        return array;
    }

    public Long getSortingTime() {
        return sortingTime;
    }

    @Override
    public String getSorterName() {
        return "Bubble Sorter";
    }
}
