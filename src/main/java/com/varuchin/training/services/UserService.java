package com.varuchin.training.services;

import com.varuchin.training.beans.User;
import com.varuchin.training.dao.UserDataAccessor;
import com.varuchin.training.exceptions.EmaiHasAlreadyRegistered;
import com.varuchin.training.utils.UserCredentialsValidator;
import com.varuchin.training.views.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class UserService {

    @Autowired
    private UserDataAccessor userDataAccessor;

    public void addAndValidateNewUser(Registration registration) throws Exception {
        if (userDataAccessor.getByLogin(registration.getLogin()) == null) {
            UserCredentialsValidator.validateNewUser(registration);
            User user = new User();
            user.setLogin(registration.getLogin());
            user.setPassword("password");
//            user.setPassword(new String(Base64.getDecoder().decode(registration.getPassword())));
            user.setName(registration.getName());
            user.setSecondName(registration.getSecondName());

            String credentials = Base64.getEncoder()
                    .encodeToString((registration.getLogin() + ":" + registration.getPassword()).getBytes());
            user.setCredentials(credentials);

            userDataAccessor.add(user);
        } else {
            throw new EmaiHasAlreadyRegistered();
        }
    }

    public User getById(long userId) {
        return userDataAccessor.getById(userId);
    }

    public User getByLogin(String login) {
        return userDataAccessor.getByLogin(login);
    }
}
