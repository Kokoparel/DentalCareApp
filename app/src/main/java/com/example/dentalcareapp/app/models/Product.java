package com.example.dentalcareapp.app.models;

public class Product {
    private String id;
    private String name;
    private String category;
    private String description;
    private double price;
    private float rating;
    private String imageUrl;
    private String brand;

    public Product(String id, String name, String category, double price, float rating, String imageUrl) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.rating = rating;
        this.imageUrl = imageUrl;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public float getRating() { return rating; }
    public String getImageUrl() { return imageUrl; }
    public String getDescription() { return description; }
    public String getFormattedPrice() {
        return "Rp " + String.format("%,.0f", price);
    }

    //Setter
    public void setDescription(String description) {
        this.description = description;
    }
}