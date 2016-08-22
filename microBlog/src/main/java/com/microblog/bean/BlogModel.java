package com.microblog.bean;

import java.util.List;

public class BlogModel {
	private Integer total=1;  //总记录页数
	private Integer currPage=0; //当前第几页
	private Integer sizePage=0; //每页第几条
	private List<Blog> blogs; //记录的集合
	
	private Blog blog=new Blog();

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getCurrPage() {
		if(currPage==null || currPage==0){
			currPage=1;
		}
		if(currPage>total){
			currPage=total;
		}
		return currPage;
	}

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	public Integer getSizePage() {
		if(sizePage==null || sizePage==0){
			sizePage=10;
		}
		return sizePage;
	}

	public void setSizePage(Integer sizePage) {
		this.sizePage = sizePage;
	}

	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	@Override
	public String toString() {
		return "BlogModel [total=" + total + ", currPage=" + currPage
				+ ", sizePage=" + sizePage + ", blogs=" + blogs  + "]";
	}
	
	
	
}
