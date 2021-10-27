package com.example.firebasedatabasetraining;

public class Game {
    private String id;
    private String title;
    private String producer;
    private String type;
    private String year;


    public Game(String id, String title, String producer, String type, String year) {
        this.id = id;
        this.title = title;
        this.producer = producer;
        this.type = type;
        this.year = year;
    }

    public Game() {
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

}
