package com.varuchin.training;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Service;

@Service("sessionProvider")
public class SessionProvider {

    private static volatile SessionFactory sessionFactory = configureSessionFactory();

    private static SessionFactory configureSessionFactory() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            return new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }

        return null;
    }

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            synchronized (SessionFactory.class) {
                if (sessionFactory == null) {
                    sessionFactory = configureSessionFactory();
                }
            }
        }

        return sessionFactory;
    }

    public Session openSession() {
        return getSessionFactory().openSession();
    }
}
