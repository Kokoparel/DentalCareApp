package com.example.dentalcareapp.app.models;

import java.util.Date;

public class HabitRecord {
    private String id;
    private String userId;
    private Date date;
    private boolean morningBrush;
    private boolean nightBrush;
    private boolean flossed;
    private int points;

    public HabitRecord(String id, Date date) {
        this.id = id;
        this.date = date;
        this.morningBrush = false;
        this.nightBrush = false;
        this.flossed = false;
        this.points = 0;
    }

    // Getters
    public String getId() { return id; }
    public Date getDate() { return date; }
    public boolean isMorningBrush() { return morningBrush; }
    public boolean isNightBrush() { return nightBrush; }
    public boolean isFlossed() { return flossed; }
    public int getPoints() { return points; }

    // Setters
    public void setMorningBrush(boolean done) {
        this.morningBrush = done;
        calculatePoints();
    }

    public void setNightBrush(boolean done) {
        this.nightBrush = done;
        calculatePoints();
    }

    public void setFlossed(boolean done) {
        this.flossed = done;
        calculatePoints();
    }

    private void calculatePoints() {
        points = 0;
        if (morningBrush) points += 10;
        if (nightBrush) points += 10;
        if (flossed) points += 5;
    }

    public boolean isCompleted() {
        return morningBrush && nightBrush;
    }
}
