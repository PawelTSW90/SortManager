package com.sparta.paweldyjak.exceptions;

/**
 * ChildNotFound exception used by BinaryTreeI interface
 */
public class ChildNotFoundException extends Exception {
    public ChildNotFoundException(String message) {
        super(message);
    }
}
