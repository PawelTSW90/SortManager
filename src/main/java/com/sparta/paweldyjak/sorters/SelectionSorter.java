package com.sparta.paweldyjak.sorters;

import com.sparta.paweldyjak.Logger.Logger;

import java.util.logging.Level;

public class SelectionSorter implements Sorters {
    private long sortingTime;

    @Override
    public int[] sort(int[] arrayToSort) {
        Logger.log(Level.FINE, "Selection sorter sorting started");
        long startTime = System.nanoTime();
        int firstUnsortedNumberIndex = 0;
        int tmpNumber;
        int currentSmallestNumberIndex = 0;
        for (int i = 0; i < arrayToSort.length; i++) {
            //if current value is smaller than currentSmallestNumberIndex set is to currentSmallestNumberIndex
            if (arrayToSort[i] < arrayToSort[currentSmallestNumberIndex]) {
                currentSmallestNumberIndex = i;
            }
            //if first value of iteration was the smallest one, continue sorting from next value
            if (i == arrayToSort.length - 1) {
                 if(firstUnsortedNumberIndex ==currentSmallestNumberIndex) {
                    firstUnsortedNumberIndex++;
                    currentSmallestNumberIndex++;
                    i = firstUnsortedNumberIndex - 1;
                }
                 //replace currentSmallestValue with firstUnsortedValue and continue sorting from next value
                else {
                    tmpNumber = arrayToSort[firstUnsortedNumberIndex];
                    arrayToSort[firstUnsortedNumberIndex] = arrayToSort[currentSmallestNumberIndex];
                    arrayToSort[currentSmallestNumberIndex] = tmpNumber;
                    firstUnsortedNumberIndex++;
                    i = firstUnsortedNumberIndex - 1;
                    currentSmallestNumberIndex = firstUnsortedNumberIndex;
                }
            }
        }
        long endTime = System.nanoTime();
        sortingTime = endTime - startTime;
        Logger.log(Level.FINE, "Selection sorter sorting finished");
        return arrayToSort;
    }

    @Override
    public Long getSortingTime() {
        return sortingTime;
    }

    @Override
    public String getSorterName() {
        return "Selection Sorter";
    }

}
