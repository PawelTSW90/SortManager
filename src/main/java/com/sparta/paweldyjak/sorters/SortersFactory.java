package com.sparta.paweldyjak.sorters;

import com.sparta.paweldyjak.Logger.Logger;

import java.util.logging.Level;

public class SortersFactory {

    public static Sorters getSorter(int numberOfSorter) {
        if (numberOfSorter == 1) {
            Logger.log(Level.FINE, "Bubble Sorter object created");
            return new BubbleSorter();
        } else if (numberOfSorter == 2) {
            Logger.log(Level.FINE, "Merge Sorter object created");
            return new MergeSorter();
        } else if (numberOfSorter == 3) {
            Logger.log(Level.FINE, "Binary Tree object created");
            return new BinaryTreeSorter();
        } else if(numberOfSorter == 4) {
            Logger.log(Level.FINE, "Insertion Sorter object created");
            return new InsertionSorter();
        } else if(numberOfSorter == 5) {
            Logger.log(Level.FINE, "Selection Sorter object created");
            return new SelectionSorter();
        }
        return null;
    }
}
