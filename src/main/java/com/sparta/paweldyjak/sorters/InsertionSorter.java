package com.sparta.paweldyjak.sorters;

public class InsertionSorter implements Sorters{
    private Long sortingTime;

    @Override
    public int[] sort(int[] arrayToSort) {
        long startTime = System.nanoTime();
        int tmpValue;
        //iterate array until previous array value is bigger than current one
        for (int i = 1; i <arrayToSort.length; i++) {
            //iterate array backwards
            if(arrayToSort[i]<arrayToSort[i-1]){
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
        return arrayToSort;
    }
    /*move array values front, starting from value less than current one, ending on current value index
    than move current value to method start index*/
    public void moveArrayValuesFront(int startIndex, int endIndex, int[] array){
        int tmpNumber;
        for (int i = startIndex; i <endIndex ; i++) {
            tmpNumber = array[i+1];
            array[i+1] = array[i];
            array[i] = tmpNumber;
        }
    }

    @Override
    public Long getSortingTime() {
        return sortingTime;
    }

    @Override
    public String getSorterName() {
        return "Insertion Sorter";
    }
}
