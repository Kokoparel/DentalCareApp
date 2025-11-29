package com.example.dentalcareapp.app.models;

public class Appointment {
    private String id;
    private String dentistId;
    private String dentistName;
    private String userId;
    private String date;
    private String time;
    private String status; // pending, confirmed, completed, cancelled
    private String notes;
    private String clinicName;

    public Appointment(String id, String dentistName, String date, String time, String status) {
        this.id = id;
        this.dentistName = dentistName;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    // Getters
    public String getId() { return id; }
    public String getDentistName() { return dentistName; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public String getStatus() { return status; }
    public String getClinicName() { return clinicName; }

    // Setters
    public void setStatus(String status) { this.status = status; }
    public void setNotes(String notes) { this.notes = notes; }
    public void setClinicName(String clinicName) { this.clinicName = clinicName; }
}
