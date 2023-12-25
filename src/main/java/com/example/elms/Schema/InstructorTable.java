package com.example.elms.Schema;

public class InstructorTable {

    int id;

    String name;

    String domain;

    String mobile;

    String mail;

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

    public InstructorTable(int id, String name, String domain, String mobile, String mail) {
        this.id = id;
        this.name = name;
        this.domain = domain;
        this.mobile = mobile;
        this.mail = mail;
    }
}
