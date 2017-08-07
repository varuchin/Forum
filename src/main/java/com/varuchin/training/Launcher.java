package com.varuchin.training;

import com.varuchin.training.dao.UserDataAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class Launcher {

    @Autowired
    private static UserDataAccessor userDataAccessor;

    public static void main(String[] args) {
//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();

        SpringApplication.run(Launcher.class, args);
        System.out.println();
    }
}
