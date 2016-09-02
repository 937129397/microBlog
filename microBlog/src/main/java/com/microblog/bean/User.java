package com.microblog.bean;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	private static final long serialVersionUID = -2295448759251506664L;
	private Integer uid;
	private String email;
	private String password;
	private String nickname;
	private String pic;
	private String telephone;
	private Integer level;
	private Integer exp;
	private Date regDate;
	private Integer sex;
	private String birthday;
	
	private Groups group;
	
	
	public User() {
	}
	public User(Integer uid, String email, String password, String nickname,
			String pic, String telephone, Integer level, Integer exp,
			Date regDate, Integer sex, String birthday, Groups group) {
		this.uid = uid;
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.pic = pic;
		this.telephone = telephone;
		this.level = level;
		this.exp = exp;
		this.regDate = regDate;
		this.sex = sex;
		this.birthday = birthday;
		this.group = group;
	}
	public Groups getGroup() {
		return group;
	}
	public void setGroup(Groups group) {
		this.group = group;
	}
	
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone= telephone;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getExp() {
		return exp;
	}
	public void setExp(Integer exp) {
		this.exp = exp;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", email=" + email + ", password="
				+ password + ", nickname=" + nickname + ", pic=" + pic
				+ ", telephone=" + telephone + ", level=" + level + ", exp="
				+ exp + ", regDate=" + regDate + ", sex=" + sex + ", birthday="
				+ birthday + "]";
	}
	
}
