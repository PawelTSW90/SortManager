package com.sparta.paweldyjak.sorters;

import com.sparta.paweldyjak.exceptions.ChildNotFoundException;
import com.sparta.paweldyjak.sorters.BinaryTree.BinaryTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * BinaryTree test.
 */
public class BinaryTreeTest {
    private BinaryTree binaryTree;

    /**
     * getSortedTreeAsc test.
     */
    @Test
    @DisplayName("Get Sorted Tree Asc Test")
    void getSortedTreeAscTest() {
        binaryTree = new BinaryTree(10);
        binaryTree.addElements(new int[]{8, 6, 4, 7, 5, 3, 4, 2, 1});
        int[] expectedArray = new int[]{1, 2, 3, 4, 4, 5, 6, 7, 8, 10};
        Assertions.assertArrayEquals(expectedArray, binaryTree.getSortedTreeAsc());


    }

    /**
     * getSortedTreeDesc test.
     */
    @Test
    @DisplayName("Get Sorted Tree Desc Test")
    void getSortedTreeDescTest() {
        binaryTree = new BinaryTree(10);
        binaryTree.addElements(new int[]{1, 2, 3, 4, 4, 5, 6, 7, 8});
        int[] expectedArray = new int[]{10, 8, 7, 6, 5, 4, 4, 3, 2, 1};
        Assertions.assertArrayEquals(expectedArray, binaryTree.getSortedTreeDesc());

    }

    /**
     * getRootElement test.
     */
    @Test
    @DisplayName("Get Root Element Test")
    void getRootElementTest() {
        binaryTree = new BinaryTree(10);
        Assertions.assertEquals(10, binaryTree.getRootElement());

    }

    /**
     * getNumberOfElements test.
     */
    @Test
    @DisplayName("Get Number of Elements Test")
    void getNumberOfElementsTest() {
        binaryTree = new BinaryTree(10);
        binaryTree.addElements(new int[]{1,2,3,4,5,6,7,8,9,10});
        Assertions.assertEquals(11, binaryTree.getNumberOfElements());

    }

    /**
     * addElement test.
     */
    @Test
    @DisplayName("Add Element Test")
    void addElementTest() {
        binaryTree = new BinaryTree(1);
        binaryTree.addElement(8);
        Assertions.assertEquals(true, binaryTree.findElement(8));

    }

    /**
     * addElements test.
     */
    @Test
    @DisplayName("Add Elements Test")
    void addElementsTest() {
        binaryTree = new BinaryTree(10);
        binaryTree.addElements(new int[]{1,3,5});
        Assertions.assertEquals(true, binaryTree.findElement(1));
        Assertions.assertEquals(true, binaryTree.findElement(3));
        Assertions.assertEquals(true, binaryTree.findElement(5));

    }

    /**
     * getLeftChild test
     * @throws ChildNotFoundException If element haven't got left child.
     */
    @Test
    @DisplayName("Get Left Child Test")
    void getLeftChildTest() throws ChildNotFoundException {
        binaryTree = new BinaryTree(10);
        binaryTree.addElement(5);
        Assertions.assertEquals(5, binaryTree.getLeftChild(10));

    }

    /**
     * getRightChild test.
     * @throws ChildNotFoundException If element haven't got right child.
     */
    @Test
    @DisplayName("Get Right Child Test")
    void getRightChildTest() throws ChildNotFoundException {
        binaryTree = new BinaryTree(10);
        binaryTree.addElement(15);
        Assertions.assertEquals(15, binaryTree.getRightChild(10));

    }

}
