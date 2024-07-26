package com.example.kd;

import com.google.gson.annotations.SerializedName;

public class SeeAllTasks {

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("karmaPoints")
    private int karmaPoints;



    public SeeAllTasks(int karmaPoints, String name, String description) {
        this.karmaPoints = karmaPoints;
        this.name = name;
        this.description = description;
    }

    public int getKarmaPoints() {
        return karmaPoints;
    }

    public void setKarmaPoints(int karmaPoints) {
        this.karmaPoints = karmaPoints;
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
    public String print() {
        return "SeeAllTasks{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", karmaPoints=" + karmaPoints +
                '}';
    }
}
