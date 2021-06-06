package com.company.model;

public class StarshipProfile {

    private int id;
    private int countOfVisitedGalaxies;
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
