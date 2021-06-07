package com.company.model;

import javax.persistence.*;

@Entity
@Table(name = "starship")
public class Starship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "model")
    private String model;

    @Column(name = "weapon")
    private String weapon;

    @Column(name = "num_of_modules")
    private int numOfModules;

    @Column(name = "num_of_passengers")
    private int numOfPassengers;

    @Column(name = "hyperdrive")
    private boolean hyperDrive;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "starship_profile_id")
    private StarshipProfile starshipProfile;

    public Starship() {

    }

    public Starship(String model, String weapon, int numOfModules, int numOfPassengers, boolean hyperDrive) {
        this.model = model;
        this.weapon = weapon;
        this.numOfModules = numOfModules;
        this.numOfPassengers = numOfPassengers;
        this.hyperDrive = hyperDrive;
    }

    public Starship(int id, String model, int numOfModules, int numOfPassengers, boolean hyperDrive) {
        this.id = id;
        this.model = model;
        this.numOfModules = numOfModules;
        this.numOfPassengers = numOfPassengers;
        this.hyperDrive = hyperDrive;
    }

    public Starship(int id, String model, String weapon, int numOfModules, int numOfPassengers, boolean hyperDrive) {
        this.id = id;
        this.model = model;
        this.weapon = weapon;
        this.numOfModules = numOfModules;
        this.numOfPassengers = numOfPassengers;
        this.hyperDrive = hyperDrive;
    }

    @Override
    public String toString() {
        return "StarShip{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", weapon='" + weapon + '\'' +
                ", modules='" + numOfModules + '\'' +
                ", numOfPassengers=" + numOfPassengers +
                ", hyperDrive=" + hyperDrive +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getNumOfModules() {
        return numOfModules;
    }

    public void setNumOfModules(int numOfModules) {
        this.numOfModules = numOfModules;
    }

    public int getNumOfPassengers() {
        return numOfPassengers;
    }

    public void setNumOfPassengers(int numOfPassengers) {
        this.numOfPassengers = numOfPassengers;
    }

    public boolean isHyperDrive() {
        return hyperDrive;
    }

    public void setHyperDrive(boolean hyperDrive) {
        this.hyperDrive = hyperDrive;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public StarshipProfile getStarshipProfile() {
        return starshipProfile;
    }

    public void setStarshipProfile(StarshipProfile starshipProfile) {
        this.starshipProfile = starshipProfile;
    }
}
