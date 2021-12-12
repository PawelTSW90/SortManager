package com.sparta.paweldyjak.sorters;

import java.util.ArrayList;
import java.util.List;

public class MergeSorter implements Sorters {
    List<int[]> unsortedArrayList = new ArrayList<>();
    private int currentIndex;


    @Override
    public int[] sort(int[] arrayToSort) {
        if (arrayToSort.length == 1) {
            return arrayToSort;
        }
        //splitting array into two arrays and passing values
        int arrayLength = arrayToSort.length;
        int[] arrayOne = new int[arrayLength / 2];
        int[] arrayTwo = new int[arrayLength / 2];

        for (int i = 0; i < arrayLength / 2; i++) {
            arrayOne[i] = arrayToSort[i];
        }
        for (int i = arrayLength / 2; i < arrayLength; i++) {
            arrayTwo[i - arrayLength / 2] = arrayToSort[i];
        }

        //remove base array from unsortedArrayList
        if (unsortedArrayList.size() != 0) {
            unsortedArrayList.remove(currentIndex);
        }
        //add split arrays to unsortedArrayList
        unsortedArrayList.add(arrayOne);
        unsortedArrayList.add(arrayTwo);

        //use method recursion to split next array in unsortedArrayList until all arrays are split
        for (int i = 0; i < unsortedArrayList.size(); i++) {
            if (unsortedArrayList.get(i).length > 1) {
                currentIndex = i;
                sort(unsortedArrayList.get(i));
            }
        }
        return merge();
    }

    public int[] merge() {
        int firstArrayIndex = 0;
        int secondArrayIndex = 0;
        int mergePosition = 0;
        int[] mergedArray;
        //merge arrays until unsortedArrayList is empty
        while (unsortedArrayList.size() != 0) {
            mergedArray = new int[unsortedArrayList.get(0).length * 2];
            for (int i = 0; i < mergedArray.length; i++) {
                if (unsortedArrayList.get(0)[firstArrayIndex] < unsortedArrayList.get(1)[secondArrayIndex]) {
                    mergedArray[mergePosition] = unsortedArrayList.get(0)[firstArrayIndex];
                    firstArrayIndex++;
                } else {
                    mergedArray[mergePosition] = unsortedArrayList.get(1)[secondArrayIndex];
                    secondArrayIndex++;
                }
                mergePosition++;

                if (firstArrayIndex == unsortedArrayList.get(0).length || secondArrayIndex == unsortedArrayList.get(1).length) {
                    if (firstArrayIndex == unsortedArrayList.get(0).length) {
                        for (int j = mergePosition; j < mergedArray.length; j++) {
                            mergedArray[mergePosition] = unsortedArrayList.get(1)[secondArrayIndex];
                            mergePosition++;
                            secondArrayIndex++;
                        }
                    }
                    if (secondArrayIndex == unsortedArrayList.get(1).length) {
                        for (int j = mergePosition; j < mergedArray.length; j++) {
                            mergedArray[mergePosition] = unsortedArrayList.get(0)[firstArrayIndex];
                            mergePosition++;
                            firstArrayIndex++;
                        }
                    }
                    unsortedArrayList.remove(0);
                    unsortedArrayList.remove(0);
                    unsortedArrayList.add(mergedArray);
                    merge();
                }
            }
        }
        return new int[1];

    }

    @Override
    public Long getSortingTime() {
        return null;
    }

    @Override
    public String getSorterName() {
        return "Merge Sorter";
    }

    public static void main(String[] args) {
        int[] array = {6, 1, 2, 3, 5, 10, 23};
        MergeSorter mergeSorter = new MergeSorter();
        mergeSorter.sort(array);
    }
}
