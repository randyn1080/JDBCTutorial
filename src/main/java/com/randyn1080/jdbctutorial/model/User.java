package com.randyn1080.jdbctutorial.model;

import java.time.ZonedDateTime;

public class User {
    private int userId;
    private String username;
    private String email;
    private ZonedDateTime dateRegistered;

    public User(int userId, String username, String email, ZonedDateTime dateRegistered) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.dateRegistered = dateRegistered;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ZonedDateTime getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(ZonedDateTime dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", dateRegistered=" + dateRegistered +
                '}';
    }
}
