package com.sparta.paweldyjak.exceptions;

/**
 * ChildNotFound exception used by BinaryTreeI interface
 */
public class ChildNotFoundException extends Exception {
    /**
     * ChildNotFound constructor.
     * @param message String with exception message.
     */
    public ChildNotFoundException(String message) {
        super(message);
    }
}
