package com.microblog.biz;

import java.util.List;

import com.microblog.bean.Blog;
import com.microblog.bean.Comment;

public interface CommentBiz {
	
	//查询所有评论
	public List<Comment> getAllComment(Blog Blog);
	
	//添加评论
	public boolean addComment(Comment comment);
	
	//删除评论
	public boolean delComment(Integer id);
}
