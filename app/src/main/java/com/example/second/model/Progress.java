package com.example.second.model;

public class Progress {

    private int percentage;
    private String title;

    public Progress(int percentage, String title) {
        this.percentage = percentage;
        this.title = title;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
