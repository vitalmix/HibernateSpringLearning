package com.company;

import com.company.model.StarShip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Run {
    public static void main(String[] args) {

        //21 - 10

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(StarShip.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            //getShip(session,1);

            addShip(session);
            session = factory.getCurrentSession();
            getShipByModel(session, "A441");

        } finally {
            factory.close();
        }
    }

    public static void addShip(Session session) {
        StarShip starShip =
                new StarShip("A442",
                        "LaserGun", 25, 0, true);

        session.beginTransaction();

        session.save(starShip);

        session.getTransaction().commit();
    }

    public static void getShip(Session session, int id) {

        session.beginTransaction();

        StarShip starShip = session.get(StarShip.class, id);

        session.getTransaction().commit();

        System.out.println("STAR SHIP IS READY! " + starShip.toString());


    }

    public static void getShipByModel(Session session, String model) {

        session.beginTransaction();

        List<StarShip> starShips = session
                .createQuery("from StarShip s where s.model = '"+ model +"'")
                .list();

        System.out.println("QUERY OBJECTS");
        for (StarShip s: starShips
        ) {
            System.out.println(s.toString());
        }
    }
}
