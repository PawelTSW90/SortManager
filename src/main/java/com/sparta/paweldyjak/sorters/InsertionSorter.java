package com.sparta.paweldyjak.sorters;

import com.sparta.paweldyjak.Logger.Logger;
import java.util.logging.Level;
/**
 * Sorts array by using Insertion sort algorithm. An insertion sort compares values in turn, starting with the second value in the list.
 * If this value is greater than the value to the left of it, no changes are made. Otherwise, this value is repeatedly moved left until
 * it meets a value that is less than it. The sort process then starts again with the next value and counts sorting time.
 */
public class InsertionSorter implements Sorters{
    private Long sortingTime;
    /**
     * Sorts array by using Insertion sort algorithm and counts sorting time.
     * @param arrayToSort Array to sort.
     * @return Sorted array.
     */
    @Override
    public int[] sort(int[] arrayToSort) {
        Logger.log(Level.FINE, "Insertion sorter sorting started");
        long startTime = System.nanoTime();
        int tmpValue;
        for (int i = 1; i <arrayToSort.length; i++) {
            //iterate array until previous array value is bigger than current one
            if(arrayToSort[i]<arrayToSort[i-1]){
                //iterate array backwards
                for (int j = i-1; j >=0; j--) {
                    //if previous value is first index, replace it with current one
                    if(i==1){
                        tmpValue = arrayToSort[0];
                        arrayToSort[0] = arrayToSort[1];
                        arrayToSort[1] = tmpValue;
                        i--;
                    }
                    /*else continue iteration until you find value less than current one,
                    than call moveArrayIndexesFront method*/
                    else if(arrayToSort[i]<arrayToSort[j]){
                        moveArrayValuesFront(j,i, arrayToSort);
                        i--;
                    }
                }
            }
        }
        long endTime = System.nanoTime();
        sortingTime = endTime - startTime;
        Logger.log(Level.FINE, "Insertion sorter sorting started");
        return arrayToSort;
    }


    /**
     * Part of Insertion sorting algorithm. Moves all values after startIndex front until they reach end index, then place value from end index
     * into startIndex.
     * @param startIndex Index from which all values are moved front.
     * @param endIndex Index where all values are moved to.
     * @param array Sorted array.
     */
    public void moveArrayValuesFront(int startIndex, int endIndex, int[] array){
        int tmpNumber;
        for (int i = startIndex; i <endIndex ; i++) {
            tmpNumber = array[i+1];
            array[i+1] = array[i];
            array[i] = tmpNumber;
        }
    }
    /**
     * Returns Long with Insertion Sorter sorting time.
     * @return Long with Insertion Sorter sorting time.
     */
    @Override
    public Long getSortingTime() {
        return sortingTime;
    }
    /**
     * Returns String with Insertion Sorter name.
     * @return String with Insertion Sorter name.
     */
    @Override
    public String getSorterName() {
        return "Insertion Sorter";
    }
}
