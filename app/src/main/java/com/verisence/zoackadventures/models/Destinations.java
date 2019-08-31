package com.verisence.zoackadventures.models;



import org.parceler.Parcel;

@Parcel
public class Destinations {
     String name;
     String description;
     String photo;
     String location;
     String itenary;


    public Destinations() {}

    public Destinations(String name, String description, String photo,
                  String location, String itenary) {
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.location = location;
        this.itenary = itenary;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPhoto() {
        return photo;
    }

    public String getLocation() {
        return location;
    }

    public String getItenary() {
        return itenary;
    }

}



