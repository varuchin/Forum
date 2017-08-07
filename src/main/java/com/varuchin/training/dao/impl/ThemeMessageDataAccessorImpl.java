package com.varuchin.training.dao.impl;

import com.varuchin.training.SessionProvider;
import com.varuchin.training.beans.ThemeMessage;
import com.varuchin.training.dao.ThemeMessageDataAccessor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ThemeMessageDataAccessorImpl implements ThemeMessageDataAccessor {

    @Autowired
    private SessionProvider sessionProvider;

    @Override
    public void add(ThemeMessage themeMessage) {
        try (Session session = sessionProvider.openSession()) {
            session.beginTransaction();
            session.save(themeMessage);
            session.getTransaction().commit();
        }
    }

    @Override
    public ThemeMessage getById(long id) {
        ThemeMessage themeMessage;
        try (Session session = sessionProvider.openSession()) {
            themeMessage = session.get(ThemeMessage.class, id);
        }
        return themeMessage;
    }

    @Override
    public List<ThemeMessage> getThemeMessages(Integer page, Integer pageSize, long themeId) {
        List<ThemeMessage> messages = new ArrayList<>();
        try (Session session = sessionProvider.openSession()) {
            String hqlQuery = "from ThemeMessage WHERE THEME = :id";
            Query query = session.createQuery(hqlQuery).setParameter("theme", themeId);

            if (page != null && pageSize != null) {
                query.setFirstResult(page);
                query.setMaxResults(pageSize);
                messages = query.list();
            }
        }

        return messages;
    }
}
