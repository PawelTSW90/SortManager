package com.sparta.paweldyjak.sorters.BinaryTree;

import com.sparta.paweldyjak.exceptions.ChildNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree class with Node nested class, uses binary tree sorting and finding algorithm
 */
public class BinaryTree implements BinaryTreeI {
    private final Node rootNode;
    private final List<Integer> elementsList = new ArrayList<>();
    private final List<Integer> ascSortedTreeValues = new ArrayList<>();
    private final List<Integer> descSortedTreeValues = new ArrayList<>();


    public BinaryTree(final int element) {
        rootNode = new Node(element);
        elementsList.add(element);
    }

    /**
     * Calls sortTreeAsc method to sort given array, and returns it sorted.
     * @return Array of ascending sorted values.
     */
    @Override
    public int[] getSortedTreeAsc() {
        sortTreeAsc(getRootNode());
        return ascSortedTreeValues.stream().mapToInt(i -> i).toArray();
    }

    /**
     * Sorts array ascending by using recursion.
     * @param node Current tree node.
     */
    public void sortTreeAsc(Node node) {
        if (node != null) {
            sortTreeAsc(node.getLeftChild());
            ascSortedTreeValues.add(node.value);
            sortTreeAsc(node.getRightChild());
        }
    }
    /**
     * Calls sortTreeDesc method to sort given array, and returns it sorted.
     * @return Array of descending sorted values.
     */
    @Override
    public int[] getSortedTreeDesc() {
        sortTreeDesc(getRootNode());
        return descSortedTreeValues.stream().mapToInt(i -> i).toArray();
    }
    /**
     * Sorts array descending by using recursion.
     * @param node Current tree node.
     */
    public void sortTreeDesc(Node node) {
        if (node != null) {
            sortTreeDesc(node.getRightChild());
            descSortedTreeValues.add(node.value);
            sortTreeDesc(node.getLeftChild());
        }
    }

    /**
     * Returns List of ascending sorted values.
     * @return List of ascending sorted values.
     */
    public List<Integer> getAscSortedTreeValues() {
        return ascSortedTreeValues;
    }

    /**
     * Returns Binary Tree root node.
     * @return Binary Tree root node.
     */
    @Override
    public int getRootElement() {
        return rootNode.getValue();
    }

    /**
     * Returns number of elements in a Binary Tree.
     * @return Number of elements in a Binary Tree.
     */
    @Override
    public int getNumberOfElements() {
        return elementsList.size();

    }

    /**
     * Calls addNodeToTree to add element to Binary Tree and returns it.
     * @param element Element to be added.
     */
    @Override
    public void addElement(final int element) {
        addNodeToTree(rootNode, element);
        elementsList.add(element);
    }

    /**
     * Calls addNodeToTree to add new node with given element to Binary Tree. Adds all elements to elementList.
     * @param elements Array of elements to be added to Binary Tree.
     */
    @Override
    public void addElements(int[] elements) {
        for (int element : elements) {
            addNodeToTree(rootNode, element);
            elementsList.add(element);
        }
    }

    /**
     *
     * @param element Element to find.
     * @return A Boolean telling if element has been found in Binary Tree.
     */
    private Node findNode(int element) {
        Node node = rootNode;
        while (node != null) {
            if (element == node.getValue()) {
                return node;
            }
            if (element < node.getValue()) {
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            }
        }
        return null;
    }

    /**
     * Creates temporary node with given element, and calls findNode method to check if the same element exists in Binary Tree.
     * @param value Element to be found.
     * @return A Boolean telling if element has been found.
     */
    public boolean findElement(final int value) {
        Node node = findNode(value);
        return node != null;
    }

    /**
     * Calls findNode method to check if Node with this value exists, and if it is to check if its have left child.
     * @param element Element which left child is searched.
     * @return An Integer with value of elements left child.
     * @throws ChildNotFoundException If element hasn't got left child.
     */
    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {

        if (findNode(element).getLeftChild() == null) {
            throw new ChildNotFoundException("Child not found");
        }
        return findNode(element).getLeftChild().value;
    }

    /**
     * Calls findNode method to check if Node with this value exists, and if it is to check if its have right child.
     * @param element Element which right child is searched.
     * @return An Integer with value of elements right child.
     * @throws ChildNotFoundException If element hasn't got right child.
     */
    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        if (findNode(element).getRightChild() == null) {
            throw new ChildNotFoundException("Child not found");
        }
        return findNode(element).getRightChild().value;
    }

    /**
     * Adding given element to Binary Tree by using recursion.
     * @param node Current Binary Tree node.
     * @param element Element to be added to Binary Tree.
     */
    private void addNodeToTree(Node node, final int element) {
        if (element <= node.getValue()) {
            if (node.isLeftChildEmpty()) {
                node.setLeftChild(new Node(element));
            } else {
                addNodeToTree(node.getLeftChild(), element);
            }
        } else if (element > node.getValue()) {
            if (node.isRightChildEmpty()) {
                node.setRightChild(new Node(element));
            } else {
                addNodeToTree(node.getRightChild(), element);
            }
        }
    }

    /**
     * Returns Binary Tree root node object.
     * @return Binary Tree root node object.
     */
    public Node getRootNode() {
        return rootNode;
    }

    //Node nested class

    /**
     * Nested class which created Node objects for Binary Tree.
     */
    public static class Node {
        private final int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        /**
         * Returnd value of given Node.
         * @return Value of given Node.
         */
        public int getValue() {
            return value;
        }

        /**
         *  Returns left child of given Node.
         * @return Left child of given Node.
         */
        public Node getLeftChild() {
            return leftChild;
        }

        /**
         * Setting given Node as a left child.
         * @param leftChild Node to be set as a left child.
         */
        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }
        /**
         *  Returns right child of given Node.
         * @return Right child of given Node.
         */
        public Node getRightChild() {
            return rightChild;
        }
        /**
         * Setting given Node as a right child.
         * @param rightChild Node to be set as a right child.
         */
        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        /**
         * Checks if Node left child is empty.
         * @return A Boolean telling if Node left child is empty.
         */
        public boolean isLeftChildEmpty() {
            return leftChild == null;
        }
        /**
         * Checks if Node right child is empty.
         * @return A Boolean telling if Node right child is empty.
         */
        public boolean isRightChildEmpty() {
            return rightChild == null;
        }
    }
}
