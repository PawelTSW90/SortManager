package com.sparta.paweldyjak.sorters;

public class SortersFactory {

    public static Sorters getSorter(int numberOfSorter) {
        if (numberOfSorter == 1) {
            return new BubbleSorter();
        } else if (numberOfSorter == 2) {
            return new MergeSorter();
        } else if (numberOfSorter == 3) {
            return new BinaryTreeSorter();
        } else if(numberOfSorter == 4) {
            return new InsertionSorter();
        } else if(numberOfSorter == 5) {
            return new SelectionSorter();
        }
        return null;
    }
}
