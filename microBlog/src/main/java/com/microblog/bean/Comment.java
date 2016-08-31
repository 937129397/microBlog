package com.microblog.bean;

import java.io.Serializable;

public class Comment implements Serializable {

	private static final long serialVersionUID = -2495648574813496337L;
	private Integer id;
	private Blog blog;
	private User user;
	private String text;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", blog=" + blog + ", user=" + user
				+ ", text=" + text + "]";
	}
	public Comment(Integer id, Blog blog, User user, String text) {
		super();
		this.id = id;
		this.blog = blog;
		this.user = user;
		this.text = text;
	}
	public Comment() {
		super();
	}
	
}
