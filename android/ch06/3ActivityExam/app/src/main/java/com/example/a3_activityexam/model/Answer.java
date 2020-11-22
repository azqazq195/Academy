package com.example.a3_activityexam.model;

import java.io.Serializable;

public class Answer implements Serializable {
    private String id;
    private String password;
    private String email;

    public Answer() {
    }

    public Answer(String id, String password, String email) {
        this.id = id;
        this.password = password;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}