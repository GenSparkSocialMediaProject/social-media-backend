package com.speakr.entity;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Column
    private String userName;

    @Column
    private String displayName;

    @Column
    private OffsetDateTime joinDate;

    @Column
    private String bio;

    public User() {}

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

    public OffsetDateTime getJoinDate() {
        return this.joinDate;
    }

    public void setJoinDate(OffsetDateTime joinDate) {
        this.joinDate = joinDate;
    }

    public String getBio() {
        return this.bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    /**
     * This override is provided for the sake of testing.
     * @param obj The object to compare this <code>User</code> against.
     * @return True if <code>obj</code> is another <code>User</code> with the
     * same ID and username, false in any other case.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!this.getClass().equals(obj.getClass())) {
            return false;
        }
        User other = (User) obj;
        return this.id == other.id && this.userName.equals(other.userName);
    }

    /**
     * This override is provided for the sake of testing.
     * @return The same integer as the ID number.
     */
    @Override
    public int hashCode() {
        return this.id;
    }

}
