package com.microblog.biz;

import com.microblog.bean.Blog;
import com.microblog.bean.BlogModel;

public interface BlogBiz {
	public void saveBlog(Blog blog);
	
	public BlogModel findAllBlog(BlogModel blogModel);
}
