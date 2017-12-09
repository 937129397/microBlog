package com.microblog.web.model;

import com.microblog.bean.User;

public class UserModel {

	private Integer blogCount;
	private Integer fanCount;
	private Integer concernCount;
	
	private User user;

	public Integer getBlogCount() {
		return blogCount;
	}

	public void setBlogCount(Integer blogCount) {
		this.blogCount = blogCount;
	}

	public Integer getFanCount() {
		return fanCount;
	}

	public void setFanCount(Integer fanCount) {
		this.fanCount = fanCount;
	}

	public Integer getConcernCount() {
		return concernCount;
	}

	public void setConcernCount(Integer concernCount) {
		this.concernCount = concernCount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
