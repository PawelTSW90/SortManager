package com.sparta.paweldyjak.sorters;

public class SortersFactory {

    public static Sorters getSorter(int numberOfSorter) {
        if (numberOfSorter == 1) {
            return new BubbleSorter();
        }
        return null;
    }
}
