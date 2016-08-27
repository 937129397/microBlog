package com.microblog.bean;

import java.io.Serializable;
import java.util.Date;

public class Blog implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;
	private String text;
	private String pic;
	private String video;
	private Date fdate;
	private long source;
	private String parse;// 点赞数
	private String relay;// 转发数

	private User user = new User();




	public Blog() {
	}

	public Blog(long id, String text, String pic, Date fdate, long source,
			String parse, String relay, User user) {
			}


	public Blog(long id, String uid, String text, String pic, String video,
			Date fdate, long source,String parse,String relay) {

		this.id = id;
		this.text = text;
		this.pic = pic;
		this.video = video;
		this.fdate = fdate;
		this.source = source;
		this.parse = parse;
		this.relay = relay;
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

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getParse() {
		return parse;
	}

	public void setParse(String parse) {
		this.parse = parse;
	}
	
	
	public String getRelay() {
		return relay;
	}

	public void setRelay(String relay) {
		this.relay = relay;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", text=" + text + ", pic=" + pic
				+ ", video=" + video + ", fdate=" + fdate + ", source="
				+ source + ", parse=" + parse + ", relay=" + relay + ", user="
				+ user + "]";
	}

	
}
