package com.jbnu.comall.model;

public class Review {
    private String from;
    private String name;
    private String review;
    private float rating;
    private int date;

    public String getFrom() {
        return from;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReview() {
        return review;
    }

    public int getDate() {
        return date;
    }

    public float getRating() {
        return rating;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
