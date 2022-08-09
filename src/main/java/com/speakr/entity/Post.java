package com.speakr.entity;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Post {

    private int id;

    @Autowired
    private User postingUser;

    @Autowired
    private String text;

    @Autowired
    private OffsetDateTime postTime;

    @Autowired
    private List<User> upVoters;

    @Autowired
    private List<User> downVoters;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public OffsetDateTime getPostTime() {
        return postTime;
    }

    public void setPostTime(OffsetDateTime postTime) {
        this.postTime = postTime;
    }

    public void addUpVoter(User voter) {
        // TODO: Write tests for this
    }

    public void addDownVoter(User voter) {
        // TODO: Write tests for this
    }

    public List<User> getUpVoters() {
        return new ArrayList<>(this.upVoters);
    }

    public List<User> getDownVoters() {
        return new ArrayList<>(this.downVoters);
    }

}
