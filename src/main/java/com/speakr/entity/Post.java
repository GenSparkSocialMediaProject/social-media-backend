package com.speakr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * Represents a post made by a user of the Speakr! social media app.
 * @author Alaciel de la Garza -- SQL mapping
 * @author Lexi Henson -- SQL mapping
 * @author Alonso del Arte -- initial stub
 */
@Entity
@Table(name = "post_tbl")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int postId;

    @Column
    private String text;

    @Temporal(TemporalType.DATE)
    private Date postTime;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name="parent_id")
    private Set<Post> replies;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public int getPostId() {
        return this.postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getPostTime() {
        return this.postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // TODO: Write tests for this
    public void addReply(Post post) {
        this.replies.add(post);
    }

    // TODO: Write tests for this
    public void removeReply(Post post) {
        this.replies.remove(post);
    }

    public Set<Post> getReplies() {
        return this.replies;
    }

    public Post() { }

    public Post(String text, User user) {
        this.text = text;
        this.user = user;
        this.postTime = new Date();
        this.replies = new HashSet<>();
    }

}
