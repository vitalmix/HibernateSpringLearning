package com.company;

import com.company.model.Starship;
import com.company.model.StarshipProfile;
import com.company.model.sql_connect.SessionFactoryManager;
import org.hibernate.Session;

import java.util.List;

public class Run {
    public static void main(String[] args) {


        //23 - 9
        SessionFactoryManager.createFactorySession();

        try {

            //createShip(SessionFactoryManager.getSession());

            getStarshipFromProfile(SessionFactoryManager.getSession(), 3);

            //createStarshipProfileWithStarShip(SessionFactoryManager.getSession());

            //deleteStarshipWithProfile(SessionFactoryManager.getSession(), 1);
            //createShip(SessionFactoryManager.getSession());

            //getShip(session,1);

            //addShip(SessionFactoryManager.getSession());

            //updateStarShipWeapon(SessionFactoryManager.getSession(),3,"MEGALASERGUN");

            //deleteStarShipById(SessionFactoryManager.getSession(), 15);

            //deleteStarShipByModel(SessionFactoryManager.getSession(), "A443");

            //getShipByModel(SessionFactoryManager.getSession(), "A441");

        } finally {
            SessionFactoryManager.getSession().close();
            SessionFactoryManager.closeFactory();
        }
    }

    public static void addShip(Session session) {
        Starship starShip =
                new Starship("A441",
                        "LaserGun", 25, 5, true);


        session.beginTransaction();

        for (int i = 1; i < 11; i++) {
            session.save(new Starship("A44" + i ,
                            "LaserGun", 25, 5, true));
        }


        //session.save(starShips);

        session.getTransaction().commit();
    }

    public static void createShip(Session session) {

        Starship starship = new Starship("A443", "LaserGun", 15, 0, true);

        StarshipProfile starshipProfile = new StarshipProfile(15,"A441DQS");

        starship.setStarshipProfile(starshipProfile);

        session.beginTransaction();

        session.save(starship);

        session.getTransaction().commit();

    }

    public static void getShip(Session session, int id) {

        session.beginTransaction();

        Starship starShip = session.get(Starship.class, id);

        session.getTransaction().commit();

        System.out.println("STAR SHIP IS READY! " + starShip.toString());


    }

    public static void getShipByModel(Session session, String model) {

        session.beginTransaction();
        List<Starship> starships = session
                .createQuery("from Starship")
                .list();

        /*List<StarShip> starShips = session
                .createQuery("from StarShip s where s.model = '"+ model +"' or s.model LIKE 'A4%'")
                .list();*/

        //starShips = updateStarShipModel(starShips,"qwe");

        session.getTransaction().commit();

        System.out.println("QUERY OBJECTS");
        for (Starship s: starships
        ) {
            System.out.println(s.toString());
        }
    }

    public static void updateStarShipWeapon(Session session, int id, String weapon) {

        session.beginTransaction();

        session.createQuery("update Starship s set s.weapon = '"+weapon+"' where s.id = "+id+"").executeUpdate();

        session.getTransaction().commit();

    }

    public static void deleteStarShipById(Session session, int id) {

        session.beginTransaction();

        session.delete(session.get(Starship.class, id));

        session.getTransaction().commit();
    }

    public static void deleteStarShipByModel(Session session, String model) {

        session.beginTransaction();

        session.createQuery("delete Starship s where s.model = '"+model+"'").list().get(0);

        session.getTransaction().commit();
    }

    public static List<Starship> updateStarShipModel(List<Starship> starships, String model){
        for (Starship sh :
                starships) {
            sh.setModel(model);
        }

        return starships;
    }

    public static void deleteStarshipWithProfile(Session session, int id) {

        session.beginTransaction();

        Starship starship = session.get(Starship.class, id);

        if (starship != null) {

            System.out.println("Starship: " + starship + " is deleted");
            session.delete(starship);
        }

        session.getTransaction().commit();
    }

    public static void createStarshipProfileWithStarShip(Session session) {

        StarshipProfile starshipProfile = new StarshipProfile(5,"VSQ1151");

        starshipProfile.setStarship(new Starship("A442","LaserGun", 15, 3,true));

        session.beginTransaction();

        session.save(starshipProfile);

        session.getTransaction().commit();
    }

    private static void getStarshipFromProfile(Session session, int id) {
        session.beginTransaction();

        StarshipProfile starshipProfile = session.get(StarshipProfile.class, id);

        System.out.println("Starship profile is ready: " + starshipProfile);

        System.out.println("Starship is ready: " + starshipProfile.getStarship());
    }
}
