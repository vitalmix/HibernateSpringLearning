package com.company;

import com.company.model.StarShip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Run {
    public static void main(String[] args) {

        //21 - 4

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(StarShip.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
/*
            StarShip starShip =
                    new StarShip("A441", "LaserGun", "15", 0, true);

            session.beginTransaction();

            session.save(starShip);

            session.getTransaction().commit();*/

            getShip(session,1);

        } finally {
            factory.close();
        }
    }


    public static void getShip(Session session, int id) {

        session.beginTransaction();

        StarShip starShip = session.get(StarShip.class, id);

        session.getTransaction().commit();

        System.out.println("STAR SHIP IS READY! " + starShip.toString());


    }

}
