package com.microblog.web.model;

import java.io.File;
import java.util.List;

import com.microblog.bean.Blog;

public class BlogModel {
	private Integer total=1;  //总记录页数
	private Integer currPage=0; //当前第几页
	private Integer sizePage=0; //每页第几条
	private List<Blog> blogs; //记录的集合
	
	private Blog blog=new Blog();
	/**
	 * 上传的文件，临时存储
	 */
	private List<File> file;
	
	private List<String> fileFileName;
	
	private List<String> fileContentType;

	public List<File> getFile() {
		return file;
	}

	public void setFile(List<File> file) {
		this.file = file;
	}

	public List<String> getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(List<String> fileFileName) {
		this.fileFileName = fileFileName;
	}

	public List<String> getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(List<String> fileContentType) {
		this.fileContentType = fileContentType;
	}

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
			sizePage=30;
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
