package com.sparta.paweldyjak.sorters.BinaryTree;

import com.sparta.paweldyjak.exceptions.ChildNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree implements BinaryTreeI {
    private final Node rootNode;
    private final List<Integer> elementsList = new ArrayList<>();
    private final List<Integer> ascSortedTreeValues = new ArrayList<>();
    private final List<Integer> descSortedTreeValues = new ArrayList<>();


    public BinaryTree(final int element) {
        rootNode = new Node(element);
        elementsList.add(element);
    }

    @Override
    public int[] getSortedTreeAsc() {
        sortTreeAsc(getRootNode());
        return ascSortedTreeValues.stream().mapToInt(i -> i).toArray();
    }

    public void sortTreeAsc(Node node) {
        if (node != null) {
            sortTreeAsc(node.getLeftChild());
            ascSortedTreeValues.add(node.value);
            sortTreeAsc(node.getRightChild());
        }
    }

    @Override
    public int[] getSortedTreeDesc() {
        sortTreeDesc(getRootNode());
        return descSortedTreeValues.stream().mapToInt(i -> i).toArray();
    }

    public void sortTreeDesc(Node node){
        if (node != null) {
            sortTreeDesc(node.getRightChild());
            descSortedTreeValues.add(node.value);
            sortTreeDesc(node.getLeftChild());
        }
    }

    public List<Integer> getAscSortedTreeValues() {
        return ascSortedTreeValues;
    }

    @Override
    public int getRootElement() {
        return rootNode.getValue();
    }

    @Override
    public int getNumberOfElements() {
        return elementsList.size();

    }

    @Override
    public void addElement(final int element) {
        addNodeToTree(rootNode, element);
        elementsList.add(element);
    }

    @Override
    public void addElements(int[] elements) {
        for (int element : elements) {
            addNodeToTree(rootNode, element);
            elementsList.add(element);
        }
    }

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

    public boolean findElement(final int value) {
        Node node = findNode(value);
        return node != null;
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        return 0;
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        return 0;
    }

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

    public Node getRootNode() {
        return rootNode;
    }

    //Node nested class
    public static class Node {
        private final int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        public boolean isLeftChildEmpty() {
            return leftChild == null;
        }

        public boolean isRightChildEmpty() {
            return rightChild == null;
        }
    }
}
