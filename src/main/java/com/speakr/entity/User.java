package com.speakr.entity;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * Represents a user of the Speakr! social media app.
 * @author Alaciel de la Garza
 * @author Alonso del Arte
 */
@Entity
@Component
@Table(name="tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    private String user_name;

    @Column
    private String displayName;

    @Column
    private OffsetDateTime joinDate;
    
    @Column
    private String bio;
    
    @Column
    private String role;
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    @Column
    private String password;

    public User() {}

    public User(String user_name, String displayName, String bio, String password) {
        this.user_name = user_name;
        this.displayName = displayName;
        this.bio = bio;
        this.password = password;
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

    public String getUser_name() {
        return this.user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
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
    
    public void setRole(String role)
    {
        this.role = role;
    }
    
    public String getRole() {
        return this.role;
    }
    @Override
    public String toString()
    {
        return "User{" +
            "id=" + id +
            ", userName='" + user_name + '\'' +
            ", displayName='" + displayName + '\'' +
            ", joinDate=" + joinDate +
            ", bio='" + bio + '\'' +
            ", role='" + role + '\'' +
            ", password='" + password + '\'' +
            '}';
    }
}
