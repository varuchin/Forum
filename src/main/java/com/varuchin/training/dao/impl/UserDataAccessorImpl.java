package com.varuchin.training.dao.impl;

import com.varuchin.training.SessionProvider;
import com.varuchin.training.beans.User;
import com.varuchin.training.dao.UserDataAccessor;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDataAccessorImpl implements UserDataAccessor {

    @Autowired
    private SessionProvider sessionProvider;

    @Override
    public void add(User user) {
        try (Session session = sessionProvider.openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }
    }

    @Override
    public User getById(long userId) {
        User user;
        try (Session session = sessionProvider.openSession()) {
            user = session.get(User.class, userId);
        }
        return user;
    }

    @Override
    public User getByLogin(String login) {
        User user;
        try (Session session = sessionProvider.openSession()) {
            String hqlQuery = "from User WHERE LOGIN = :login";
            user = (User) session.createQuery(hqlQuery)
                    .setParameter("login", login).uniqueResult();
        }
        return user;
    }
}
