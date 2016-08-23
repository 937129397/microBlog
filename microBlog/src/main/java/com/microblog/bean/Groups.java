package com.microblog.bean;

import java.io.Serializable;

public class Groups implements Serializable{
	private static final long serialVersionUID = -7632719447450754628L;
	private Integer id;
	private String name; //分组名
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Groups(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Groups() {
		super();
	}
	
	

}
