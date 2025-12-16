package com.example.demo.model;

public class User {
    private long id;
    private String email;
    private String Password;
    public User(long id, String email, String password) {
        this.id = id;
        this.email = email;
        Password = password;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
    }
    
}
