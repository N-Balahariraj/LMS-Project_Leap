package com.example.elms.Schema;

public class CourseTable {

    int id;
    String name;
    String domain;
    String time;
    float ratings;

    public CourseTable(int id, String name, String domain, String time, float ratings) {
        this.id = id;
        this.name = name;
        this.domain = domain;
        this.time = time;
        this.ratings = ratings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getRatings() {
        return ratings;
    }

    public void setRatings(float ratings) {
        this.ratings = ratings;
    }

}
