package com.company;

import com.company.model.StarShip;
import com.company.model.sql_connect.SessionFactoryManager;
import org.hibernate.Session;

import java.util.List;

public class Run {
    public static void main(String[] args) {

        //21 - 10
        SessionFactoryManager.createFactorySession();

        try {

            //getShip(session,1);

            addShip(SessionFactoryManager.getSession());

            getShipByModel(SessionFactoryManager.getSession(), "A441");

        } finally {
            SessionFactoryManager.closeFactory();
        }
    }

    public static void addShip(Session session) {
        StarShip starShip =
                new StarShip("A443",
                        "LaserGun", 25, 5, true);

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
