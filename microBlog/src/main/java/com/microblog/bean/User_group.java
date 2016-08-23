package com.microblog.bean;

import java.io.Serializable;

public class User_group implements Serializable {

	private static final long serialVersionUID = -2952827844375545385L;
	
	private Integer id;
	private Integer uid;
	private Integer group_id;
	public User_group(Integer id, Integer uid, Integer group_id) {
		super();
		this.id = id;
		this.uid = uid;
		this.group_id = group_id;
	}
	public User_group() {
		super();
	}
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
	public Integer getGroup_id() {
		return group_id;
	}
	public void setGroup_id(Integer group_id) {
		this.group_id = group_id;
	}
	
	
}
