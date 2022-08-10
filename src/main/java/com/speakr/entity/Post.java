package com.speakr.entity;

import java.time.OffsetDateTime;
import java.util.List;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Table(name="tbl_post")
public class    Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Autowired
    @Column
    private int postingUserId;

    @Autowired
    @Column
    private String text;

    @Autowired
    @Column
    private OffsetDateTime postTime;

    @Autowired
    @Column(columnDefinition = "json")
    private String upVoters;

    @Autowired
    @Column(columnDefinition = "json")
    private String downVoters;

    public Post(){}
    public Post(int id, int postingUserId, String text) {
        this.id = id;
        this.postingUserId = postingUserId;
        this.text = text;
        this.postTime = OffsetDateTime.now();
    }

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
        Gson gson = new Gson();
        return gson.fromJson(this.upVoters,List.class);
    }

    public List<User> getDownVoters() {
        Gson gson = new Gson();
        return gson.fromJson(this.downVoters,List.class);
    }

}
