package com.sparta.paweldyjak.sorters;

import com.sparta.paweldyjak.sorters.BinaryTree.BinaryTree;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeSorter implements Sorters {
    private BinaryTree binaryTree;

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
        createBinaryTree(arrayToSort);
        binaryTree.sortTreeAsc(binaryTree.getRootNode());
        return binaryTree.getAscSortedTreeValues().stream().mapToInt(i -> i).toArray();
    }

    @Override
    public Long getSortingTime() {
        return binaryTree.getSortingTime();
    }

    @Override
    public String getSorterName() {
        return "Binary Tree Sorter";
    }
}
