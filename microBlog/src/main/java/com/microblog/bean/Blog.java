package com.microblog.bean;

import java.util.Date;

public class Blog {
	private long id;
	private String text;
	private String pic;
	private Date fdate;
	private long source;
	private User user=new User();
	public Blog() {
	}
	public Blog(long id, String text, String pic, Date fdate, long source,
			User user) {
		super();
		this.id = id;
		this.text = text;
		this.pic = pic;
		this.fdate = fdate;
		this.source = source;
		this.user = user;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Date getFdate() {
		return fdate;
	}
	public void setFdate(Date fdate) {
		this.fdate = fdate;
	}
	public long getSource() {
		return source;
	}
	public void setSource(long source) {
		this.source = source;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Blog [id=" + id + ", text=" + text + ", pic=" + pic
				+ ", fdate=" + fdate + ", source=" + source + ", user=" + user
				+ "]";
	}
	
}
