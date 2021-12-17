package com.sparta.paweldyjak.sorters;

import com.sparta.paweldyjak.Logger.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class MergeSorter implements Sorters {
    private Long sortingTime;
    private final List<int[]> arrayListToSort = new ArrayList<>();

    @Override
    public int[] sort(int[] arrayToSort) {
        Logger.log(Level.FINE, "Merge sorter sorting started");
        Long startTime = System.nanoTime();
        if (arrayToSort.length == 1) {
            return arrayToSort;
        } else {
            splitArray(arrayToSort);
            int[] sortedArray = startArrayMerging();
            Long endTime = System.nanoTime();
            sortingTime = endTime - startTime;
            Logger.log(Level.FINE, "Merge sorter sorting finished");
            return sortedArray;
        }
    }

    public void splitArray(int[] arrayToSplit) {
        if (arrayToSplit.length == 1) {
            arrayListToSort.add(arrayToSplit);
        } else {
            int arrayMiddle = arrayToSplit.length / 2;

            //split array into two arrays and copy its values
            int[] firstArray = new int[arrayMiddle];
            int[] secondArray = new int[arrayToSplit.length - arrayMiddle];
            System.arraycopy(arrayToSplit, 0, firstArray, 0, firstArray.length);
            System.arraycopy(arrayToSplit, arrayMiddle, secondArray, 0, secondArray.length);

            //do method recursion until array is split into single elements arrays
            if (firstArray.length == 1) {
                arrayListToSort.add(firstArray);
            } else {
                splitArray(firstArray);
            }
            if (secondArray.length == 1) {
                arrayListToSort.add(secondArray);
            } else {
                splitArray(secondArray);
            }
        }
    }

    public int[] startArrayMerging(){
        while (arrayListToSort.size()>1){
        }
return new int[1];
    }
    public int[] mergeArrays(int[] firstArray, int[] secondArray) {
        int firstArrayLength = firstArray.length;
        int secondArrayLength = secondArray.length;
        int firstArrayIndex = 0, secondArrayIndex = 0, mergeIndex = 0;
        //prepare new array for two arrays merged
        int[] mergedArray = new int[firstArrayLength + secondArrayLength];

        /*if current value of first array is larger than current value of second array,
        add it to mergedArray. If not, add current value of second array*/
        for (int i = 0; i < mergedArray.length - 1; i++) {
            if (firstArray[firstArrayIndex] < secondArray[secondArrayIndex]) {
                mergedArray[mergeIndex] = firstArray[firstArrayIndex];
                firstArrayIndex++;
            } else {
                mergedArray[mergeIndex] = secondArray[secondArrayIndex];
                secondArrayIndex++;
            }
            mergeIndex++;

            /*if all values of one of the array has been added to mergedArray,
            move to mergedArray remaining values of other array */
            if (firstArrayIndex == firstArrayLength) {
                for (int j = mergeIndex; j < mergedArray.length; j++) {
                    mergedArray[mergeIndex] = secondArray[secondArrayIndex];
                    secondArrayIndex++;
                    mergeIndex++;
                    i++;
                }
                continue;
            }
            if (secondArrayIndex == secondArrayLength) {
                for (int j = mergeIndex; j < mergedArray.length; j++) {
                    mergedArray[mergeIndex] = firstArray[firstArrayIndex];
                    firstArrayIndex++;
                    mergeIndex++;
                    i++;
                }
            }
        }
        return mergedArray;
    }

    @Override
    public Long getSortingTime() {
        return sortingTime;
    }

    @Override
    public String getSorterName() {
        return "Merge Sorter";
    }
}