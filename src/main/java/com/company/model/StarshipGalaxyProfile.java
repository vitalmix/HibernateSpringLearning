package com.company.model;

import javax.persistence.*;

@Entity
@Table(name = "starship_galaxy_profile")
public class StarshipGalaxyProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name_of_galaxy")
    private String nameOfTheGalaxy;

    @Column(name = "count_of_destroyed_enemies")
    private int countOfDestroyedEnemies;


    public StarshipGalaxyProfile() {
    }

    public StarshipGalaxyProfile(String nameOfTheGalaxy, int countOfDestroyedEnemies) {
        this.nameOfTheGalaxy = nameOfTheGalaxy;
        this.countOfDestroyedEnemies = countOfDestroyedEnemies;
    }

    public StarshipGalaxyProfile(int id, String nameOfTheGalaxy, int countOfDestroyedEnemies) {
        this.id = id;
        this.nameOfTheGalaxy = nameOfTheGalaxy;
        this.countOfDestroyedEnemies = countOfDestroyedEnemies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfTheGalaxy() {
        return nameOfTheGalaxy;
    }

    public void setNameOfTheGalaxy(String nameOfTheGalaxy) {
        this.nameOfTheGalaxy = nameOfTheGalaxy;
    }

    public int getCountOfDestroyedEnemies() {
        return countOfDestroyedEnemies;
    }

    public void setCountOfDestroyedEnemies(int countOfDestroyedEnemies) {
        this.countOfDestroyedEnemies = countOfDestroyedEnemies;
    }
}
