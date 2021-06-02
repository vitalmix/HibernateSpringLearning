package com.company.model.sql_connect;

import com.company.model.StarShip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryManager {

    private static SessionFactory factory;

    public static void createFactorySession() {
        factory = new Configuration()
                .configure()
                .addAnnotatedClass(StarShip.class)
                .buildSessionFactory();
    }

    public static Session getSession() {
        Session session = factory.getCurrentSession();;
        return session;
    }

    public static void closeFactory() {
        factory.close();
    }
}
