package com.microblog.biz;

import com.microblog.bean.Blog;
import com.microblog.bean.User;
import com.microblog.web.model.BlogModel;

public interface BlogBiz {
	//发布微博
	public void saveBlog(Blog blog);
	//查询微博
	public BlogModel findAllBlog(BlogModel blogModel);
	//点赞
	public String parse(Long id,int uid);
	//转发
	public String relay(Long id,int uid);
	
	public BlogModel findBlogsByUid(BlogModel blogModel);

}
