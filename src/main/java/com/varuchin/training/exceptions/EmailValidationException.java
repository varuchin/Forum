package com.varuchin.training.exceptions;

public class EmailValidationException extends Exception {

    private static final String EMAIL_VALIDATION_FAILED = "Email is invalid.";

    public EmailValidationException() {
        super(EMAIL_VALIDATION_FAILED);
    }

}
