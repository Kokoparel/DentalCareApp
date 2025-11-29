package com.example.dentalcareapp.app.models;

public class Dentist {
    private String id;
    private String name;
    private String specialization;
    private String education;
    private String experience;
    private float rating;
    private int reviewCount;
    private String photoUrl;
    private String availability;
    private String clinicName;

    public Dentist(String id, String name, String specialization, float rating, String photoUrl) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.rating = rating;
        this.photoUrl = photoUrl;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
    public float getRating() { return rating; }
    public String getPhotoUrl() { return photoUrl; }
    public String getClinicName() { return clinicName; }

    // Setters
    public void setExperience(String experience) { this.experience = experience; }
    public void setEducation(String education) { this.education = education; }
    public void setClinicName(String clinicName) { this.clinicName = clinicName; }
}