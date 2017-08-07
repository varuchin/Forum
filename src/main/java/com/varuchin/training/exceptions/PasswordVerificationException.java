package com.varuchin.training.exceptions;

public class PasswordVerificationException extends Exception {

    private static final String PASSWORDS_DO_NOT_MATCH = "Password verification failed. Passwords do not match";

    public PasswordVerificationException() {
        super(PASSWORDS_DO_NOT_MATCH);
    }
}
