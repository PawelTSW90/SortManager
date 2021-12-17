package com.sparta.paweldyjak.sorters;

import com.sparta.paweldyjak.Logger.Logger;
import com.sparta.paweldyjak.sorters.BinaryTree.BinaryTree;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * Sorts array by using Binary Tree sorting algorithm. It first creates a binary search tree from the elements of the input array
 * and then performs traversal on the created binary search tree to get the elements in sorted order.
 */
public class BinaryTreeSorter implements Sorters {
    private BinaryTree binaryTree;
    private Long sortingTime;

    /**
     * Creates Binary Tree and add arrayInput elements to it.
     * @param arrayInput Array to sort.
     */
    public void createBinaryTree(int[] arrayInput) {
        //convert arrayInput to treeValues list to create root node from first value, and after delete it from arrayInput
        List<Integer> treeValues = new ArrayList<>();
        for (int j : arrayInput) {
            treeValues.add(j);
        }
        binaryTree = new BinaryTree(treeValues.get(0));
        treeValues.remove(0);

        //add elements to binaryTreeSorter
        binaryTree.addElements(treeValues.stream().mapToInt(i -> i).toArray());

    }

    /**
     * Sorts array, by calling createBinaryTree and sortTreeAsc methods and counts sorting time.
     * @param arrayToSort Array to sort.
     * @return Sorted array.
     */
    @Override
    public int[] sort(int[] arrayToSort) {
        Logger.log(Level.FINE, "Binary Tree sorting started");
        Long startTime = System.nanoTime();
        createBinaryTree(arrayToSort);
        binaryTree.sortTreeAsc(binaryTree.getRootNode());
        int[] sortedArray = binaryTree.getAscSortedTreeValues().stream().mapToInt(i -> i).toArray();
        Long endTime = System.nanoTime();
        sortingTime = endTime - startTime;
        Logger.log(Level.FINE, "Binary Tree sorting finished");
        return sortedArray;
    }

    /**
     * Returns Long with Binary Tree sorting time.
     * @return Long with Binary Tree sorting time.
     */
    @Override
    public Long getSortingTime() {
        return sortingTime;
    }

    /**
     * Returns String with Binary Tree Sorter name.
     * @return String with Binary Tree Sorter name.
     */
    @Override
    public String getSorterName() {
        return "Binary Tree Sorter";
    }
}
