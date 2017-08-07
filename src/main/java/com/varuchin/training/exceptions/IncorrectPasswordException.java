package com.varuchin.training.exceptions;

public class IncorrectPasswordException extends Exception {

    private static final String INCORRECT_PASSWORD = "Password is incorrect. "
            + "Password must contain at least eight chars, one digit, one lower and upper char and one char within a set of special chars (!@#$%) etc.)";

    public IncorrectPasswordException() {
        super(INCORRECT_PASSWORD);
    }
}
