package com.example.dentalcareapp.app.models;

public class Clinic {
    private String id;
    private String name;
    private String address;
    private String phone;
    private double latitude;
    private double longitude;
    private float rating;
    private String openHours;
    private double distance; // in km

    public Clinic(String id, String name, String address, String phone, double lat, double lng) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.latitude = lat;
        this.longitude = lng;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public float getRating() { return rating; }
    public double getDistance() { return distance; }

    // Setters
    public void setRating(float rating) { this.rating = rating; }
    public void setOpenHours(String openHours) { this.openHours = openHours; }
    public void setDistance(double distance) { this.distance = distance; }

    public String getFormattedDistance() {
        return String.format("%.1f km", distance);
    }
}
