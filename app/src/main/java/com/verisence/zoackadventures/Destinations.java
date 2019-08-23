package com.verisence.zoackadventures;



import org.parceler.Parcel;

@Parcel
public class Destinations {
    private String name;
    private String description;
    private String photo;
    private String location;
    private String itinerary;


    public Destinations() {}

    public Destinations(String name, String description, String photo,
                  String location, String itinerary) {
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.location = location;
        this.itinerary = itinerary;
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

    public String getItinerary() {
        return itinerary;
    }

}



