package com.sparta.paweldyjak.sorters;

import com.sparta.paweldyjak.Logger.Logger;

import java.util.logging.Level;

/**
 * Class creates and returns chosen Sorters object.
 */
public class SortersFactory {
    /**
     * Creates and returns chosen Sorters object.
     * @param numberOfSorter Number of sorter to create.
     * @return Sorters object.
     */
    public static Sorters getSorter(int numberOfSorter) {
        if (numberOfSorter == 1) {
            Logger.log(Level.INFO, "Bubble Sorter object created");
            return new BubbleSorter();
        } else if (numberOfSorter == 2) {
            Logger.log(Level.INFO, "Merge Sorter object created");
            return new MergeSorter();
        } else if (numberOfSorter == 3) {
            Logger.log(Level.INFO, "Binary Tree object created");
            return new BinaryTreeSorter();
        } else if(numberOfSorter == 4) {
            Logger.log(Level.INFO, "Insertion Sorter object created");
            return new InsertionSorter();
        } else if(numberOfSorter == 5) {
            Logger.log(Level.INFO, "Selection Sorter object created");
            return new SelectionSorter();
        }
        return null;
    }
}
