package com.example.elms.Schema;

public class CourseCard {
    String Url;
    String Duration;
    String Rate;
    String Name;

    public CourseCard(String url, String duration, String rate, String name) {
        Url = url;
        Duration = duration;
        Rate = rate;
        Name = name;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public String getRate() {
        return Rate;
    }

    public void setRate(String rate) {
        Rate = rate;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
