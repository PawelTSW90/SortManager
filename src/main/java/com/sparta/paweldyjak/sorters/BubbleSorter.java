package com.sparta.paweldyjak.sorters;

import java.util.Arrays;

public class BubbleSorter implements Sorters {
    private Long sortingTime;
    private int[] unsortedArray;

    @Override
    public int[] sort(int[] array) {
        unsortedArray = array;
        int[] sortedArray;
        sortedArray = Arrays.copyOf(array, array.length);
        long startTime = System.nanoTime();
        boolean noIteration = false;
        int tmpNumber;
        //repeat iteration until there is no new iteration needed
        while (!noIteration) {
            noIteration = true;
            for (int i = 1; i < sortedArray.length; i++) {
                if (sortedArray[i] < sortedArray[i - 1]) {
                    noIteration = false;
                    tmpNumber = sortedArray[i - 1];
                    sortedArray[i - 1] = sortedArray[i];
                    sortedArray[i] = tmpNumber;
                    i -= 1;
                }
            }
        }
        long endTime = System.nanoTime();
        sortingTime = endTime - startTime;
        return array;
    }

}
