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

}
