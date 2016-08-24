package com.microblog.bean;

import java.io.Serializable;

public class User_group implements Serializable {

	private static final long serialVersionUID = -2952827844375545385L;
	
	private Integer id;
	private Integer uid;
	private Groups group;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Groups getGroup() {
		return group;
	}
	public void setGroup(Groups group) {
		this.group = group;
	}
	public User_group(Integer id, Integer uid, Groups group) {
		super();
		this.id = id;
		this.uid = uid;
		this.group = group;
	}
	public User_group() {
		super();
	}
	
	
	
	
}
