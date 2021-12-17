package com.sparta.paweldyjak.sorters.BinaryTree;

import com.sparta.paweldyjak.exceptions.ChildNotFoundException;

/**
 *Binary Tree Interface
 */
public interface BinaryTreeI {
    /**
     * Returns Binary Tree root node.
     * @return Binary Tree root node.
     */
    int getRootElement();
    /**
     * Returns number of elements in a Binary Tree.
     * @return Number of elements in a Binary Tree.
     */
    int getNumberOfElements();
    /**
     * Calls addNodeToTree to add element to Binary Tree and returns it.
     * @param element Element to be added.
     */
    void addElement(int element);
    /**
     * Calls addNodeToTree to add new node with given element to Binary Tree. Adds all elements to elementList.
     * @param elements Array of elements to be added to Binary Tree.
     */
    void addElements(final int[] elements);
    /**
     * Creates temporary node with given element, and calls findNode method to check if the same element exists in Binary Tree.
     * @param value Element to be found.
     * @return A Boolean telling if element has been found.
     */
    boolean findElement(int value);
    /**
     * Calls findNode method to check if Node with this value exists, and if it is to check if its have left child.
     * @param element Element which left child is searched.
     * @return An Integer with value of elements left child.
     * @throws ChildNotFoundException If element haven't got left child.
     */
    int getLeftChild(int element) throws ChildNotFoundException;
    /**
     * Calls findNode method to check if Node with this value exists, and if it is to check if its have right child.
     * @param element Element which right child is searched.
     * @return An Integer with value of elements right child.
     * @throws ChildNotFoundException If element haven't got right child.
     */
    int getRightChild(int element) throws ChildNotFoundException;
    /**
     * Calls sortTreeAsc method to sort given array, and returns it sorted.
     * @return Array of ascending sorted values.
     */
    int[] getSortedTreeAsc();
    /**
     * Calls sortTreeDesc method to sort given array, and returns it sorted.
     * @return Array of descending sorted values.
     */
    int[] getSortedTreeDesc();
}