package com.speakr.entity;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Post {

    private int id;

    @Autowired
    private String text;

    @Autowired
    private OffsetDateTime postTime;

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

}
