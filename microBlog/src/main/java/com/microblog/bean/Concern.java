package com.microblog.bean;

import java.io.Serializable;

public class Concern implements Serializable{
	private static final long serialVersionUID = -1459210952109114925L;
	private Integer id;
	private Integer b_uid; //被关注人id
	private Integer f_uid; //关注人id
	private String note; //备注
	private Groups groups;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getB_uid() {
		return b_uid;
	}
	public void setB_uid(Integer b_uid) {
		this.b_uid = b_uid;
	}
	public Integer getF_uid() {
		return f_uid;
	}
	public void setF_uid(Integer f_uid) {
		this.f_uid = f_uid;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Groups getGroups() {
		return groups;
	}
	public void setGroups(Groups groups) {
		this.groups = groups;
	}
	public Concern(Integer id, Integer b_uid, Integer f_uid, String note,
			Groups groups) {
		this.id = id;
		this.b_uid = b_uid;
		this.f_uid = f_uid;
		this.note = note;
		this.groups = groups;
	}
	public Concern() {
	}
	
	
}
