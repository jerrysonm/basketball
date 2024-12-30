package com.codingdojo.bballjunkie.models;

import java.sql.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message="Username Required")
	@Size(min=3, max=25, message="Username must be at least 3 characters!")
	private String username;
	@NotEmpty(message="Email Required")
	@Email(message="Please enter a valid email!")
	private String email;
	@NotEmpty(message="Password Required")
	@Size(min=8,max=255,message="Password must be At least 8 characters!")
	private String password;
	@Transient
	@NotEmpty(message="Confirm Password")
	@Size(min=8,max=255, message="Confirm password must match!")
	private String confirmPassword;
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private List<Post>posts;
	@OneToMany(mappedBy="sender", fetch=FetchType.LAZY)
	private List<DirectMessage>sentMessage;
	@OneToMany(mappedBy="receiver", fetch=FetchType.LAZY)
	private List<DirectMessage>message;
	
	
	public User(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}


	public List<DirectMessage> getSentMessage() {
		return sentMessage;
	}

	public void setSentMessage(List<DirectMessage> sentMessage) {
		this.sentMessage = sentMessage;
	}

	public List<DirectMessage> getMessage() {
		return message;
	}

	public void setMessage(List<DirectMessage> message) {
		this.message = message;
	}

	
	
	
	
}
