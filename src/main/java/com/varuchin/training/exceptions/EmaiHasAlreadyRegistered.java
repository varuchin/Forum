package com.varuchin.training.exceptions;

public class EmaiHasAlreadyRegistered extends Exception {

    private static final String EMAIL_VALIDATION_FAILED = "User with such email has been already registered.";

    public EmaiHasAlreadyRegistered() {
        super(EMAIL_VALIDATION_FAILED);
    }
}
