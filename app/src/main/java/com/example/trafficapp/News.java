package com.example.trafficapp;

public class News {
    private int ItemImage;
    private int id;
    private String streetName;
    private String locality;
    private String condition;

    public News(int id, String streetName, String locality, String condition) {
        this.id = id;
        this.streetName = streetName;
        this.locality = locality;
        this.condition = condition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
