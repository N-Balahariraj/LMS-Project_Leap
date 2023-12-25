package com.example.elms.Schema;

public class StudentTable {

    int id;
    String name;
    String mobile;
    String mail;

    public StudentTable(int id, String name, String mobile, String mail) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.mail = mail;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
