package com.company;

import com.company.model.StarShip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Run {
    public static void main(String[] args) {

        //21 - 1

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(StarShip.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            StarShip starShip =
                    new StarShip("A441", "LaserGun", "15", 0, true);

            session.beginTransaction();

            session.save(starShip);

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
