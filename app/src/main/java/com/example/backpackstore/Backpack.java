package com.example.backpackstore;

public class Backpack {
    private String id;
    private String name;
    private String description;
    private double price;
    private String imageAssetPath; // Path to the 360 image in assets

    public Backpack(String id, String name, String description, double price, String imageAssetPath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageAssetPath = imageAssetPath;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getImageAssetPath() {
        return imageAssetPath;
    }
}
