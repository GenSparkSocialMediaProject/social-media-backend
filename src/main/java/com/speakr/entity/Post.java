package com.speakr.entity;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Table(name="tbl_post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private int postingUserId;

    @Column
    private String text;

    @Column
    private OffsetDateTime postTime;

    @Column
    private String upVoters;

    @Column
    private String downVoters;

    public Post(){}
    public Post(int postingUserId, String text) {
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

    public void addUpVoter(int userId) throws JsonProcessingException {
        // TODO: Write tests for this
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        List<Integer> upVoterList = Arrays.asList(1,2,3,4);

        this.upVoters = mapper.writeValueAsString(upVoterList);

    }

    public void addDownVoter(User voter) {
        // TODO: Write tests for this
    }

    public List<Integer> getUpVoters() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        List<Integer> upVoterList = mapper.readValue(this.upVoters, List.class);
        return upVoterList;
    }

    public List<User> getDownVoters() {
        Gson gson = new Gson();
        return gson.fromJson(this.downVoters,List.class);
    }

}
