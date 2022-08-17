package com.speakr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "vote_tbl")
public class Vote
{
<<<<<<< HEAD
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column
    @Min(-1)
    @Max(1)
    @NotNull private int increment;

    public com.speakr.entity.Post getPost() { return post; }
    public void setPost(com.speakr.entity.Post post) { this.post = post; }

    public Vote() { }
    public Vote(com.speakr.entity.Post post, User user, int increment)
    {
        this.post = post;
        this.user = user;
        this.increment = increment;
    }

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public User getUser()
    {
        return user;
    }
    public void setUser(User user)
    {
        this.user = user;
    }
    public int getIncrement()
    {
        return increment;
    }
    public void setIncrement(int increment)
    {
        this.increment = increment;
    }

=======
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "post_id", nullable = false)
	private Post post;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@Column
	@Min(-1)
	@Max(1)
	@NotNull private int increment;
	
	public com.speakr.entity.Post getPost() { return post; }
	public void setPost(com.speakr.entity.Post post) { this.post = post; }
	
	public Vote() { }
	public Vote(com.speakr.entity.Post post, User user, int increment)
	{
		this.post = post;
		this.user = user;
		this.increment = increment;
	}
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public User getUser()
	{
		return user;
	}
	public void setUser(User user)
	{
		this.user = user;
	}
	public int getIncrement()
	{
		return increment;
	}
	public void setIncrement(int increment)
	{
		this.increment = increment;
	}
>>>>>>> 6e1ceb4b86e938fba730f32a878253ba68fdae79
}
