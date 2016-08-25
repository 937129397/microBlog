package com.microblog.bean;

import java.io.Serializable;
import java.util.Date;

public class Blog implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;
	private String uid;
	private String text;
	private String pic;
	private String video;
	private Date fdate;
	private long source;

	public Blog() {
	}

	public Blog(long id, String uid, String text, String pic, String video,
			Date fdate, long source) {
		super();
		this.id = id;
		this.uid = uid;
		this.text = text;
		this.pic = pic;
		this.video = video;
		this.fdate = fdate;
		this.source = source;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
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

	@Override
	public String toString() {
		return "Blog [id=" + id + ", uid=" + uid + ", text=" + text + ", pic="
				+ pic + ", video=" + video + ", fdate=" + fdate + ", source="
				+ source + "]";
	}

}
