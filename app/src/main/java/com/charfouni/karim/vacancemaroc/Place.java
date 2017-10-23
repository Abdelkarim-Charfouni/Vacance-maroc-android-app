package com.charfouni.karim.vacancemaroc;

/**
 * Created by karim on 22/09/17.
 */

public class Place {
    private String name;
    private String type;
    private String description;
    private String city;
    private String address;
    private double price;
    private int imageBackground;

    public Place(String name, String type, String description, String city, String address, double price, int imageBackground) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.city = city;
        this.address = address;
        this.price = price;
        this.imageBackground = imageBackground;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getImageBackground() {
        return imageBackground;
    }

    public void setImageBackground(int imageBackground) {
        this.imageBackground = imageBackground;
    }
}
