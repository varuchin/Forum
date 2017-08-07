package com.varuchin.training.exceptions;

public class AuthorizationException extends Exception {

    private static final String UNAUTHORIZED = "Unauthorized";

    public AuthorizationException() {
        super(UNAUTHORIZED);
    }
}
