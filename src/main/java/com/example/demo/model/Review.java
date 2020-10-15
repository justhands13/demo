package com.example.demo.model;

public class Review {

    private String name;

    private String criticScore;

    private String audienceScore;

    public Review() {}

    public Review(String name, String criticScore, String audienceScore) {
        super();
        this.name = name;
        this.criticScore = criticScore;
        this.audienceScore = audienceScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCriticScore() {
        return criticScore;
    }

    public void setCriticScore(String criticScore) {
        this.criticScore = criticScore;
    }

    public String getAudienceScore() {
        return audienceScore;
    }

    public void setAudienceScore(String audienceScore) {
        this.audienceScore = audienceScore;
    }

    public String toString(Review review){
        StringBuilder stringBuilder = null;
        stringBuilder.append("Name:  " + review.name
                              + "Critic: " + review.criticScore
                              + "Audience: " + review.audienceScore);
        return stringBuilder.toString();

    }
}
