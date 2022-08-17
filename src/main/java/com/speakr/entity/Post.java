package com.speakr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "post_tbl")
public class Post
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int post_id;

    @Column
    private String text;

    @Temporal(TemporalType.DATE)
    private Date postTime;


    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
    @JoinColumn(name="parent_id")
    private Set<Post> replies;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Post() { }
    public Post(String text, User user)
    {
        this.text = text;
        this.user = user;
        this.postTime = new Date();
    }

    public int getPost_id()
    {
        return post_id;
    }
    public void setPost_id(int post_id)
    {
        this.post_id = post_id;
    }
    public String getText()
    {
        return text;
    }
    public void setText(String text)
    {
        this.text = text;
    }
    public Date getPostTime()
    {
        return postTime;
    }
    public void setPostTime(Date postTime)
    {
        this.postTime = postTime;
    }
    public User getUser()
    {
        return user;
    }
    public void setUser(User user)
    {
        this.user = user;
    }
    public void addReply(Post post) {
        replies.add(post);
    }
    public void removeReply(Post post) {
        replies.remove(post);
    }

}
