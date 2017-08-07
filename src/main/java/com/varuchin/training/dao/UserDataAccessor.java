package com.varuchin.training.dao;

import com.varuchin.training.beans.User;

public interface UserDataAccessor {

    void add(User user);

    User getById(long userId);

    User getByLogin(String login);
}
