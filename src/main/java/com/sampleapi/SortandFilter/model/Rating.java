package com.sampleapi.SortandFilter.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = RatingDeserializer.class)
public class Rating {
    private double average;
    private int reviews;
    private String note;

    public Rating() {

    }
    public Rating(double average, int reviews, String note) {
        this.average = average;
        this.reviews = reviews;
        this.note = note;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public int getReviews() {
        return reviews;
    }

    public void setReviews(int reviews) {
        this.reviews = reviews;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
