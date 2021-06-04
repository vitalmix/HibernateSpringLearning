package com.company;

import com.company.model.StarShip;
import com.company.model.sql_connect.SessionFactoryManager;
import org.hibernate.Session;

import java.util.List;

public class Run {
    public static void main(String[] args) {


        //21 - 15
        SessionFactoryManager.createFactorySession();

        try {

            //getShip(session,1);

            //addShip(SessionFactoryManager.getSession());

            //updateStarShipWeapon(SessionFactoryManager.getSession(),3,"MEGALASERGUN");

            //deleteStarShipById(SessionFactoryManager.getSession(), 4);

            deleteStarShipByModel(SessionFactoryManager.getSession(), "A443");

            //getShipByModel(SessionFactoryManager.getSession(), "A441");

        } finally {
            SessionFactoryManager.closeFactory();
        }
    }

    public static void addShip(Session session) {
        StarShip starShip =
                new StarShip("A441",
                        "LaserGun", 25, 5, true);


        session.beginTransaction();

        for (int i = 1; i < 11; i++) {
            session.save(new StarShip("A44" + i ,
                            "LaserGun", 25, 5, true));
        }


        //session.save(starShips);

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
                .createQuery("from StarShip")
                .list();

        /*List<StarShip> starShips = session
                .createQuery("from StarShip s where s.model = '"+ model +"' or s.model LIKE 'A4%'")
                .list();*/

        //starShips = updateStarShipModel(starShips,"qwe");

        session.getTransaction().commit();

        System.out.println("QUERY OBJECTS");
        for (StarShip s: starShips
        ) {
            System.out.println(s.toString());
        }
    }

    public static void updateStarShipWeapon(Session session, int id, String weapon) {

        session.beginTransaction();

        session.createQuery("update StarShip s set s.weapon = '"+weapon+"' where s.id = "+id+"").executeUpdate();

        session.getTransaction().commit();

    }

    public static void deleteStarShipById(Session session, int id) {

        session.beginTransaction();

        session.createQuery("delete StarShip s where s.id = "+id+"").executeUpdate();

        session.getTransaction().commit();
    }


    public static void deleteStarShipByModel(Session session, String model) {

        session.beginTransaction();

        session.createQuery("delete StarShip s where s.model = '"+model+"'").list().get(0);

        session.getTransaction().commit();
    }

    public static List<StarShip> updateStarShipModel(List<StarShip> starShips, String model){
        for (StarShip sh :
                starShips) {
            sh.setModel(model);
        }

        return starShips;
    }
}
