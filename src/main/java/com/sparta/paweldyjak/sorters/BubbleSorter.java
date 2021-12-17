package com.sparta.paweldyjak.sorters;

import com.sparta.paweldyjak.Logger.Logger;
import java.util.logging.Level;
/**
 * Sorts array by using Bubble sorting algorithm. Sorter repeatedly steps through the array, compares adjacent elements and swaps them if they are in
 * the wrong order. The pass through the array is repeated until the list is sorted.
 */
public class BubbleSorter implements Sorters {
    private Long sortingTime;
    /**
     * Sorts array by using Bubble sort algorithm and counts sorting time.
     * @param arrayToSort Array to sort.
     * @return Sorted array.
     */
    @Override
    public int[] sort(int[] arrayToSort) {
        Logger.log(Level.FINE, "Bubble sorter sorting started");
        long startTime = System.nanoTime();
        boolean noIteration = false;
        int tmpNumber;
        //repeat iteration until there is no new iteration needed
        while (!noIteration) {
            noIteration = true;
            for (int i = 1; i < arrayToSort.length; i++) {
                if (arrayToSort[i] < arrayToSort[i - 1]) {
                    noIteration = false;
                    tmpNumber = arrayToSort[i - 1];
                    arrayToSort[i - 1] = arrayToSort[i];
                    arrayToSort[i] = tmpNumber;
                    i -= 1;
                }
            }
        }
        long endTime = System.nanoTime();
        sortingTime = endTime - startTime;
        Logger.log(Level.FINE, "Bubble sorter sorting finished");
        return arrayToSort;
    }
    /**
     * Returns Long with Bubble Sorter sorting time.
     * @return Long with Bubble Sorter sorting time.
     */
    public Long getSortingTime() {
        return sortingTime;
    }
    /**
     * Returns String with Bubble Sorter name.
     * @return String with Bubble Sorter name.
     */
    @Override
    public String getSorterName() {
        return "Bubble Sorter";
    }
}
