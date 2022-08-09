package com.speakr.entity;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {

    private int id;

    public int getId() {
        return id;
    }

    @Autowired
    private String userName;

    @Autowired
    private String displayName;

    // TODO: Add field for join date

    @Autowired
    private String bio;

    public boolean sameIdAs(User other) {
        return false;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getBio() {
        return this.bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

}
