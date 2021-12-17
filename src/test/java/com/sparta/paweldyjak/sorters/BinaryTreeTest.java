package com.sparta.paweldyjak.sorters;

import com.sparta.paweldyjak.exceptions.ChildNotFoundException;
import com.sparta.paweldyjak.sorters.BinaryTree.BinaryTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BinaryTreeTest {
    private BinaryTree binaryTree;

    @Test
    @DisplayName("Get Sorted Tree Asc Test")
    void getSortedTreeAscTest() {
        binaryTree = new BinaryTree(10);
        binaryTree.addElements(new int[]{8, 6, 4, 7, 5, 3, 4, 2, 1});
        int[] expectedArray = new int[]{1, 2, 3, 4, 4, 5, 6, 7, 8, 10};
        Assertions.assertArrayEquals(expectedArray, binaryTree.getSortedTreeAsc());


    }

    @Test
    @DisplayName("Get Sorted Tree Desc Test")
    void getSortedTreeDescTest() {
        binaryTree = new BinaryTree(10);
        binaryTree.addElements(new int[]{1, 2, 3, 4, 4, 5, 6, 7, 8});
        int[] expectedArray = new int[]{10, 8, 7, 6, 5, 4, 4, 3, 2, 1};
        Assertions.assertArrayEquals(expectedArray, binaryTree.getSortedTreeDesc());

    }

    @Test
    @DisplayName("Get Root Element Test")
    void getRootElementTest() {
        binaryTree = new BinaryTree(10);
        Assertions.assertEquals(10, binaryTree.getRootElement());

    }

    @Test
    @DisplayName("Get Number of Elements Test")
    void getNumberOfElementsTest() {
        binaryTree = new BinaryTree(10);
        binaryTree.addElements(new int[]{1,2,3,4,5,6,7,8,9,10});
        Assertions.assertEquals(11, binaryTree.getNumberOfElements());

    }

    @Test
    @DisplayName("Add Element Test")
    void addElementTest() {
        binaryTree = new BinaryTree(1);
        binaryTree.addElement(8);
        Assertions.assertEquals(true, binaryTree.findElement(8));

    }

    @Test
    @DisplayName("Add Elements Test")
    void addElementsTest() {
        binaryTree = new BinaryTree(10);
        binaryTree.addElements(new int[]{1,3,5});
        Assertions.assertEquals(true, binaryTree.findElement(1));
        Assertions.assertEquals(true, binaryTree.findElement(3));
        Assertions.assertEquals(true, binaryTree.findElement(5));

    }

    @Test
    @DisplayName("Get Left Child Test")
    void getLeftChildTest() throws ChildNotFoundException {
        binaryTree = new BinaryTree(10);
        binaryTree.addElement(5);
        Assertions.assertEquals(5, binaryTree.getLeftChild(10));

    }

    @Test
    @DisplayName("Get Right Child Test")
    void getRightChildTest() throws ChildNotFoundException {
        binaryTree = new BinaryTree(10);
        binaryTree.addElement(15);
        Assertions.assertEquals(15, binaryTree.getRightChild(10));

    }

}
