package com.sparta.paweldyjak.sorters;
import java.util.Arrays;

public class BubbleSorter {
    private Long sortingTime;

    public int[] bubbleSortNumber(int[] array){
        long startTime = System.nanoTime();
        boolean noIteration = false;
        int tmpNumber;
        //repeat iteration until there is no new iteration needed
        while (!noIteration) {
            noIteration = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i-1]) {
                    noIteration = false;
                    tmpNumber = array[i-1];
                    array[i-1] = array[i];
                    array[i] = tmpNumber;
                    i -= 1;
                }
            }
        }
        long endTime = System.nanoTime();
        sortingTime = endTime-startTime;
        return array;
    }

    public static void main(String[] args) {
        BubbleSorter bubbleSorter = new BubbleSorter();
        System.out.println(Arrays.toString(bubbleSorter.bubbleSortNumber(new int[]{5,4,3,2,1})));
    }
}
