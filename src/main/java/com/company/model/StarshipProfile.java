package com.company.model;

import javax.persistence.*;

@Entity
@Table(name = "starship_profile")
public class StarshipProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "count_of_visited_galaxies")
    private int countOfVisitedGalaxies;

    @Column(name = "licence_post_code")
    private String licencePostCode;

    public StarshipProfile() {
    }

    public StarshipProfile(int countOfVisitedGalaxies, String licencePostCode) {
        this.countOfVisitedGalaxies = countOfVisitedGalaxies;
        this.licencePostCode = licencePostCode;
    }

    public StarshipProfile(int id, int countOfVisitedGalaxies, String licencePostCode) {
        this.id = id;
        this.countOfVisitedGalaxies = countOfVisitedGalaxies;
        this.licencePostCode = licencePostCode;
    }

    @Override
    public String toString() {
        return "StarshipProfile{" +
                "id=" + id +
                ", countOfVisitedGalaxies=" + countOfVisitedGalaxies +
                ", licencePostCode='" + licencePostCode + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountOfVisitedGalaxies() {
        return countOfVisitedGalaxies;
    }

    public void setCountOfVisitedGalaxies(int countOfVisitedGalaxies) {
        this.countOfVisitedGalaxies = countOfVisitedGalaxies;
    }

    public String getLicencePostCode() {
        return licencePostCode;
    }

    public void setLicencePostCode(String licencePostCode) {
        this.licencePostCode = licencePostCode;
    }
}
