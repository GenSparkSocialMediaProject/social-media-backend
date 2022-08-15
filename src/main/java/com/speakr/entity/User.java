package com.speakr.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Represents a user of the Speakr! social media app.
 *
 * @author Alaciel de la Garza
 * @author Alonso del Arte
 * @author Lexi Henson
 */
@Entity
@Table(name = "tbl_user")
public class User
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	
	@Column(unique = true)
	private String user_name;
	
	@Column
	private String displayName;
	
	@Temporal(TemporalType.DATE)
	private Date joinDate;
	
	@Column
	private String bio;
	
	@Column
	private String role;
	@Column
	private String password;
	
	public User() { }
	
	public User(String user_name, String displayName, String bio, String password)
	{
		this.user_name = user_name;
		this.displayName = displayName;
		this.bio = bio;
		this.password = password;
		this.joinDate = new Date();
	}
	
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public int getUser_id()
	{
		return user_id;
	}
	
	public boolean sameIdAs(User other)
	{
		return this.user_id == other.user_id;
	}
	
	public void setUser_id(int user_id)
	{
		this.user_id = user_id;
	}
	
	public String getUser_name()
	{
		return this.user_name;
	}
	
	public void setUser_name(String user_name)
	{
		this.user_name = user_name;
	}
	
	public Date getJoinDate()
	{
		return joinDate;
	}
	public void setJoinDate(Date joinDate)
	{
		this.joinDate = joinDate;
	}
	
	public String getDisplayName()
	{
		return displayName;
	}
	
	public void setDisplayName(String displayName)
	{
		this.displayName = displayName;
	}
	
	public String getBio()
	{
		return this.bio;
	}
	
	public void setBio(String bio)
	{
		this.bio = bio;
	}
	
	public void setRole(String role)
	{
		this.role = role;
	}
	
	public String getRole()
	{
		return this.role;
	}
	
	@Override
	public String toString()
	{
		return "User{" +
			"id=" + user_id +
			", userName='" + user_name + '\'' +
			", displayName='" + displayName + '\'' +
			", joinDate=" + joinDate +
			", bio='" + bio + '\'' +
			", role='" + role + '\'' +
			", password='" + password + '\'' +
			'}';
	}
}
