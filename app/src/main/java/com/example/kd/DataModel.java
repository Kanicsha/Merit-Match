package com.example.kd;

public class DataModel {


    int karmaPoints,owner_id;
    String name,description;

    String created_at;

    public DataModel(int karmaPoints, int owner_id, String name, String description, String created_at) {
        this.karmaPoints = karmaPoints;
        this.owner_id = owner_id;
        this.name = name;
        this.description = description;
        this.created_at = created_at;
    }

    public int getKarmaPoints() {
        return karmaPoints;
    }

    public void setKarmaPoints(int karmaPoints) {
        this.karmaPoints = karmaPoints;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}


