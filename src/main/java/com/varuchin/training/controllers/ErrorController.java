package com.varuchin.training.controllers;

import com.varuchin.training.exceptions.AuthorizationException;
import com.varuchin.training.exceptions.EmaiHasAlreadyRegistered;
import com.varuchin.training.exceptions.EmailValidationException;
import com.varuchin.training.exceptions.IncorrectPasswordException;
import com.varuchin.training.exceptions.PasswordVerificationException;
import com.varuchin.training.views.Error;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

    private static final String UNAUTHORIZED = "Unauthorized";
    private static final String PASSWORDS_DO_NOT_MATCH = "Password verification failed. Passwords do not match";
    private static final String INCORRECT_PASSWORD = "Password is incorrect. "
            + "Password must contain at least eight chars, one digit, one lower and upper char and one char within a set of special chars (!@#$%) etc.)";
    private static final String EMAIL_HAS_ALREADY_REGISTERED = "User with such email has been already registered.";
    private static final String EMAIL_VALIDATION_FAILED = "Email is invalid.";

    @ExceptionHandler(AuthorizationException.class)
    public String handleAuthorizationException(Model model) {
        model.addAttribute("error", new Error(UNAUTHORIZED));
        return "error";
    }

    @ExceptionHandler(PasswordVerificationException.class)
    public String handlePasswordVerificationException(Model model) {
        model.addAttribute("error", new Error(PASSWORDS_DO_NOT_MATCH));
        return "error";
    }

    @ExceptionHandler(IncorrectPasswordException.class)
    public String hanleIncorrectPasswordException(Model model) {
        model.addAttribute("error", new Error(INCORRECT_PASSWORD));
        return "error";
    }

    @ExceptionHandler(EmaiHasAlreadyRegistered.class)
    public String handleEmaiHasAlreadyRegistered(Model model) {
        model.addAttribute("error", new Error(EMAIL_HAS_ALREADY_REGISTERED));
        return "error";
    }

    @ExceptionHandler(EmailValidationException.class)
    public String handleEmailValidationException(Model model) {
        model.addAttribute("error", new Error(EMAIL_VALIDATION_FAILED));
        return "error";
    }
}
