package com.sparta.paweldyjak.sorters;

import com.sparta.paweldyjak.Logger.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * Sorts array by using Merge sort algorithm. Algorithm divides the unsorted array into n subarrays, each containing one element and
 * Repeatedly merge subarrays to produce new sorted subarrays until there is only one array remaining.
 */

public class MergeSorter implements Sorters {
    private Long sortingTime;
    private final List<int[]> arrayListToSort = new ArrayList<>();

    /**
     * Calls arraySplit to split array, calls arraysListToSortRefactor to start merging arrays and returns sorted array.
     * @param arrayToSort Array to sort.
     * @return Sorted array.
     */
    @Override
    public int[] sort(int[] arrayToSort) {
        Logger.log(Level.FINE, "Merge sorter sorting started");
        Long startTime = System.nanoTime();
        if (arrayToSort.length == 1) {
            return arrayToSort;
        } else {
            arraySplit(arrayToSort);
            int[] sortedArray = arraysListToSortRefactor(0);
            Long endTime = System.nanoTime();
            sortingTime = endTime - startTime;
            Logger.log(Level.FINE, "Merge sorter sorting finished");
            return sortedArray;
        }
    }

    /**
     * Split array into multiple arrays containing just one value, and saves them as arrayListToSort.
     * @param arrayToSplit Array to split.
     */
    public void arraySplit(int[] arrayToSplit) {
        if (arrayToSplit.length == 1) {
            arrayListToSort.add(arrayToSplit);
        } else {
            int arrayMiddle = arrayToSplit.length / 2;
            int[] firstArray = new int[arrayMiddle];
            int[] secondArray = new int[arrayToSplit.length - arrayMiddle];
            System.arraycopy(arrayToSplit, 0, firstArray, 0, firstArray.length);
            System.arraycopy(arrayToSplit, arrayMiddle, secondArray, 0, secondArray.length);
            if (firstArray.length == 1) {
                arrayListToSort.add(firstArray);
            } else {
                arraySplit(firstArray);
            }
            if (secondArray.length == 1) {
                arrayListToSort.add(secondArray);
            } else {
                arraySplit(secondArray);
            }
        }
    }

    /**
     * Calls mergeTwoArrays to pass index of arraysListToSort where merging should start and saves merged array into list until all subarrays are
     * merged.
     * @param firstArrayToMergeIndex Index of arrayListToSort where merge should start.
     * @return Merged array.
     */
    public int[] arraysListToSortRefactor(int firstArrayToMergeIndex) {
        while (arrayListToSort.size() > 1) {
            try {
                int[] mergedArray = mergeTwoArrays(arrayListToSort.get(firstArrayToMergeIndex),
                        arrayListToSort.get(firstArrayToMergeIndex + 1));
                arrayListToSort.set(firstArrayToMergeIndex, mergedArray);
                arrayListToSort.remove(firstArrayToMergeIndex + 1);
                firstArrayToMergeIndex++;
                //if there is odd number of arrays, skip last one ane restart merging
            } catch (IndexOutOfBoundsException e) {
                arraysListToSortRefactor(0);
            }
        }
        return arrayListToSort.get(0);

    }

    /**
     * Merges two arrays.
     * @param firstArray First array to merge.
     * @param secondArray Second array to merge.
     * @return Merged array.
     */
    public int[] mergeTwoArrays(int[] firstArray, int[] secondArray) {
        int firstArrayIndex = 0, secondArrayIndex = 0, mergeIndex = 0;
        int[] mergedArray = new int[firstArray.length + secondArray.length];

        for (int i = 0; i < mergedArray.length - 1; i++) {
            if (firstArray[firstArrayIndex] < secondArray[secondArrayIndex]) {
                mergedArray[mergeIndex] = firstArray[firstArrayIndex];
                firstArrayIndex++;
            } else {
                mergedArray[mergeIndex] = secondArray[secondArrayIndex];
                secondArrayIndex++;
            }
            mergeIndex++;

            if (firstArrayIndex == firstArray.length) {
                for (int j = mergeIndex; j < mergedArray.length; j++) {
                    mergedArray[mergeIndex] = secondArray[secondArrayIndex];
                    secondArrayIndex++;
                    mergeIndex++;
                    i++;
                }
                continue;
            }
            if (secondArrayIndex == secondArray.length) {
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

    /**
     * Returns Long with Merge Sorter sorting time.
     *
     * @return Long with Merge Sorter sorting time.
     */
    @Override
    public Long getSortingTime() {
        return sortingTime;
    }

    /**
     * Returns String with Merge Sorter name.
     *
     * @return String with Merge Sorter name.
     */
    @Override
    public String getSorterName() {
        return "Merge Sorter";
    }
}