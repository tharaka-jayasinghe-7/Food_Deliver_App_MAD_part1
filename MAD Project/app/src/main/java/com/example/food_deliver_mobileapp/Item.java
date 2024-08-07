package com.example.food_deliver_mobileapp;

public class Item {
    private String name;
    private String description;
    private float rating;
    private float price;
    private byte[] image;
    private String category;

    public Item(String name, String description, float rating, float price, byte[] image, String category) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.price = price;
        this.image = image;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getRating() {
        return rating;
    }

    public float getPrice() {
        return price;
    }

    public byte[] getImage() {
        return image;
    }

    public String getCategory() {
        return category;
    }
}
