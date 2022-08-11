package com.speakr.entity;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Table(name="tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String userName;

    @Column
    private String displayName;

    @Column
    private OffsetDateTime joinDate;

    @Column
    private String bio;

    public User(){}
    public User(String userName, String displayName, String bio) {
        this.userName = userName;
        this.displayName = displayName;
        this.bio = bio;
        this.joinDate = OffsetDateTime.now();
    }

    public int getId() {
        return id;
    }

    public boolean sameIdAs(User other) {
        return this.id == other.id;
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
