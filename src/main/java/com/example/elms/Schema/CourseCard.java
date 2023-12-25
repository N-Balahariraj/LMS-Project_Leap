package com.example.elms.Schema;

public class CourseCard {
    String ImgUrl;
    String Duration;
    String Rate;
    String Name;

    public CourseCard(String imgUrl, String duration, String rate, String name) {
        ImgUrl = imgUrl;
        Duration = duration;
        Rate = rate;
        Name = name;
    }

    public  String getImgUrl() {
        return ImgUrl;
    }

    public void setImgUrl(String imgUrl) {
        ImgUrl = imgUrl;
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
