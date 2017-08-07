package com.varuchin.training.security;

import com.varuchin.training.SessionProvider;
import com.varuchin.training.beans.User;
import com.varuchin.training.exceptions.AuthorizationException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Base64;

public class SecurityManager {

    @Autowired
    private static SessionProvider sessionProvider;

    public static void validateUserCredentials(String credentials) throws AuthorizationException {
        User user;
        try (Session session = sessionProvider.openSession()) {
            String hql = "from USER where credentials = " + credentials;
            Query query = session.createQuery(hql);
            user = (User) query.uniqueResult();
            if (user == null) {
                throw new AuthorizationException();
            }
        }
    }

    public static void validateUserCredentials(String email, String password) throws AuthorizationException {
        String userCredentials = Base64.getEncoder()
                .encodeToString(Base64.getDecoder().decode((email + ":" + password)));
        validateUserCredentials(userCredentials);
    }
}
