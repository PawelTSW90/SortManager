package com.sparta.paweldyjak.sorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeSorter implements Sorters {
    List<int[]> unsortedArrayList = new ArrayList<>();
    private int currentIndex;


    @Override
    public int[] sort(int[] arrayToSort) {


        return new int[0];
    }
    public void splitArray(int[] arrayToSplit) {
        int arrayMiddle = arrayToSplit.length / 2;
        int[] firstArray = new int[arrayMiddle];
        int[] secondArray = new int[arrayToSplit.length - arrayMiddle];
        for (int i = 0; i <firstArray.length; i++) {
            firstArray[i] = arrayToSplit[i];

        }
        for (int i = 0; i <secondArray.length; i++) {
            secondArray[i] = arrayToSplit[arrayMiddle+i];
        }
        if(firstArray.length==1){
            unsortedArrayList.add(firstArray);
        } else{
            splitArray(firstArray);
        }
        if(secondArray.length==1){
            unsortedArrayList.add(secondArray);
        } else{
            splitArray(secondArray);
        }
    }

    public static void main(String[] args) {
        MergeSorter mergeSorter = new MergeSorter();
        mergeSorter.splitArray(new int[]{1,2,3,4,5,6,7,8,9});
    }



    @Override
    public Long getSortingTime() {
        return null;
    }

    @Override
    public String getSorterName() {
        return "Merge Sorter";
    }
}
/*    public int[] merge() {
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

    }*/