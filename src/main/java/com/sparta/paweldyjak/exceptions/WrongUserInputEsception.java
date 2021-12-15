package com.sparta.paweldyjak.exceptions;

public class WrongUserInputEsception extends Exception{

    public WrongUserInputEsception(String message){
        super(message);
    }

    public WrongUserInputEsception(){
        super("Wrong user input. Please type a number");
    }
}
