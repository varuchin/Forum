package com.varuchin.training.utils;

import com.varuchin.training.exceptions.EmailValidationException;
import com.varuchin.training.exceptions.IncorrectPasswordException;
import com.varuchin.training.exceptions.PasswordVerificationException;
import com.varuchin.training.views.Registration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserCredentialsValidator {

    private static Pattern emailPattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    private static Pattern passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
    private static Matcher matcher;

    public static void validateNewUser(Registration registration) throws Exception {
//        validateEmail(registration.getLogin());
//        validatePassword(registration.getPassword());
//        validatePasswordVerification(registration.getPassword(), registration.getVerifyPassword());
    }

    private static void validateEmail(String email) throws EmailValidationException {
        matcher = emailPattern.matcher(email);
        if (!matcher.matches()) {
            throw new EmailValidationException();
        }
    }

    private static void validatePassword(String password) throws IncorrectPasswordException {
        matcher = passwordPattern.matcher(password);
        if (!matcher.matches()) {
            throw new IncorrectPasswordException();
        }
    }

    private static void validatePasswordVerification(String password, String verifyPassword) throws PasswordVerificationException {
        if (password == null || verifyPassword == null || !password.equals(verifyPassword)) {
            throw new PasswordVerificationException();
        }
    }
}
