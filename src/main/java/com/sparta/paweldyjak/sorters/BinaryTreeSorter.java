package com.sparta.paweldyjak.sorters;

import com.sparta.paweldyjak.Logger.Logger;
import com.sparta.paweldyjak.sorters.BinaryTree.BinaryTree;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class BinaryTreeSorter implements Sorters {
    private BinaryTree binaryTree;
    private Long sortingTime;

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

    @Override
    public Long getSortingTime() {
        return sortingTime;
    }

    @Override
    public String getSorterName() {
        return "Binary Tree Sorter";
    }
}
