package com.varuchin.training.dao.impl;

import com.varuchin.training.SessionProvider;
import com.varuchin.training.beans.Theme;
import com.varuchin.training.dao.ThemeDataAccessor;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ThemeDataAccessorImpl implements ThemeDataAccessor {

    @Autowired
    private SessionProvider sessionProvider;

    @Override
    public void add(Theme theme) {
        try (Session session = sessionProvider.openSession()) {
            session.beginTransaction();
            session.save(theme);
            session.getTransaction().commit();
        }
    }

    @Override
    public Theme getById(long id) {
        Theme theme;
        try (Session session = sessionProvider.openSession()) {
            theme = session.get(Theme.class, id);
        }
        return theme;
    }

    @Override
    public Theme getByName(String name) {
        Theme theme;
        try (Session session = sessionProvider.openSession()) {
            String hqlQuery = "from Theme WHERE name = :name";
            Query query = session.createQuery(hqlQuery).setParameter("name", name);
            theme = (Theme) query.uniqueResult();
        }

        return theme;
    }

    @Override
    public List<String> getMessages(Integer page, Integer pageSize, long themeId) {
        List<String> messages = new ArrayList<>();
        try (Session session = sessionProvider.openSession()) {
            Query query = session.createQuery("from ThemeMessage WHERE themeId = :themeId");

            if (page != null && pageSize != null) {
                query.setFirstResult(page);
                query.setMaxResults(pageSize);
            }
            messages = query.list();
        }

        return messages;
    }

    @Override
    public List<Theme> getForumThemes(Integer page, Integer pageSize) {
        List<Theme> userThemes;
        try (Session session = sessionProvider.openSession()) {
            Criteria criteria = session.createCriteria(Theme.class);
            if (page != null && pageSize != null) {
                criteria.setFirstResult(page);
                criteria.setMaxResults(pageSize);
            }
            userThemes = criteria.list();
        }

        return userThemes;
    }
}
